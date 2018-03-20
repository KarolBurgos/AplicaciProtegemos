package com.example.co.com.revistaprotegemos.appprotegemos;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.ContactenosFragment;

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

/**
 * Created by ASPIRE VX15 on 2/03/2018.
 */

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    public BackgroundWorker(Context context) {
        this.context = context;
    }

    public BackgroundWorker(ContactenosFragment contactenosFragment) {
    }

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String register_url="http://192.168.0.42/registro.php";
        if(type.equals("registro"))
        {
            try
            {
                String nombr=params[1];
                String corre=params[2];
                String celul=params[3];
                String msg=params[4];
                URL url= new URL(register_url);
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
