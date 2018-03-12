package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.BackgroundWorker;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.insertar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactenosFragment extends Fragment {

    private EditText nombre, correo, celular, mensaje;
    private String nomb,corre,celu,mens;
    public ContactenosFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contactenos, container, false);
        nombre = (EditText) view.findViewById(R.id.ednomm);
        correo = (EditText) view.findViewById(R.id.edcorreoo);
        celular = (EditText) view.findViewById(R.id.edcelularr);
        mensaje = (EditText) view.findViewById(R.id.edmensajee);
        return view;
    }

    public void saveInfo(View v) {
        nomb = nombre.getText().toString();
        corre = correo.getText().toString();
        celu = celular.getText().toString();
        mens = mensaje.getText().toString();
        String type="registro";
        BackgroundWorker backgroundTask= new BackgroundWorker(this);
        backgroundTask.execute(type,nomb,corre,celu,mens);
    }

    public class BackgroundWorker extends AsyncTask<String,Void,String>{

        ContactenosFragment context;
        AlertDialog alertDialog;
        BackgroundWorker(ContactenosFragment ctx)
        {
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type=params[0];
            String regis_url="http://192.168.0.17/registro.php";
            if(type.equals("registro"))
            {
                try{
                    String nombr=params[1];
                    String corre=params[2];
                    String celul=params[3];
                    String msg=params[4];
                    URL url= new URL(regis_url);
                    HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String post_data= URLEncoder.encode("nombre","UTF-8")+"="+URLEncoder.encode(nombr,"UTF-8")+"&"
                            +URLEncoder.encode("correo","UTF-8")+"="+URLEncoder.encode(corre,"UTF-8")+"&"
                            + URLEncoder.encode("celular","UTF-8")+"="+URLEncoder.encode(celul,"UTF-8")+"&"
                            + URLEncoder.encode("mensaje","UTF-8")+"="+URLEncoder.encode(msg,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while ((line=bufferedReader.readLine())!=null)
                    {
                        result +=line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;

                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}



