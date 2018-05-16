package com.example.co.com.revistaprotegemos.appprotegemos.Suscribete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

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
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SuscribeteActivity extends AppCompatActivity {
    private EditText nombre,identificacion,ciudad,barrio,direccion,telefono,correo;
    private String nomb,iden,ciud,barr,direc,telef,correoo;
    private Button b1;
    private String correo2, contraseña;
    private Session session;
    TextView t1,t2,t3;
    private Typeface Nuestrosplanes,Aurella;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_suscribete);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

        nombre = (EditText) findViewById(R.id.nom);
        identificacion = (EditText) findViewById(R.id.iden);
        ciudad = (EditText) findViewById(R.id.ciu);
        barrio = (EditText) findViewById(R.id.bar);
        direccion = (EditText) findViewById(R.id.dire);
        telefono = (EditText) findViewById(R.id.tel);
        correo = (EditText) findViewById(R.id.corre);



        nombre.setTypeface(Nuestrosplanes);
        identificacion.setTypeface(Nuestrosplanes);
        ciudad.setTypeface(Nuestrosplanes);
        barrio.setTypeface(Nuestrosplanes);
        direccion.setTypeface(Nuestrosplanes);
        telefono.setTypeface(Nuestrosplanes);
        correo.setTypeface(Nuestrosplanes);

        b1=(Button)findViewById(R.id.env2);
        correo2="protegemossistemas@gmail.com";
        contraseña="sistemasprotegemos123";

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                saveInfo(v);

            }
        });
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_suscribete);
    }

    public void saveInfo(View v) {
        nomb = nombre.getText().toString();
        iden = identificacion.getText().toString();
        ciud = ciudad.getText().toString();
        barr = barrio.getText().toString();
        direc = direccion.getText().toString();
        telef = telefono.getText().toString();
        correoo = correo.getText().toString();

        if(nomb.equals("")&&iden.equals("")&&ciud.equals("")&&barr.equals("")&&direc.equals("")&&telef.equals("")&&correoo.equals(""))
        {
            Toast toast1 =Toast.makeText(getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if(nomb.equals("")||iden.equals("")||ciud.equals("")||barr.equals("")||direc.equals("")||telef.equals("")||correoo.equals(""))
        {
            Toast toast1 =Toast.makeText(getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        else {

            String type = "registro";
            BackgroundWorker backgroundTask=new BackgroundWorker(this);
            backgroundTask.execute(type, nomb, iden, ciud, barr, direc, telef, correoo);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.googlemail.com");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "465");


            try {
                session = Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correo2, contraseña);
                    }
                });

                if (session != null) {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(correo2));
                    message.setSubject("Protegemos");
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoo));
                    message.setContent("Nombre: " + nombre.getText().toString() + "\n" + "Identificacion:  " + identificacion.getText().toString() +
                            "\n" + "Ciudad:  " + ciudad.getText().toString() + "\n" + "Barrio:  " +
                            barrio.getText().toString() + "\n" + "Direccion:  " + direccion.getText().toString() +
                            "\n" + "Telefono:  " + telefono.getText().toString() + "\n" + "Correo:  " + correo.getText().toString(), "text/html; charset=utf-8");
                    Transport.send(message);
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_SHORT);
                    toast1.show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public class BackgroundWorker extends AsyncTask<String,Void,String> {

        Context context;

        AlertDialog alertDialog;
        BackgroundWorker(Context ctx)
        {
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type=params[0];
            String regis_url="192.168.0.17/aplicacionprotegemos/registrosuscribirse.php";
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
