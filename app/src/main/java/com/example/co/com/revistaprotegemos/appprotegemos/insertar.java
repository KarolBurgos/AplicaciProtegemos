package com.example.co.com.revistaprotegemos.appprotegemos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class insertar extends AppCompatActivity {
    private EditText nombre, correo, celular, mensaje;

    private String correo2, contraseña;
    //private EditText mensaje2;
    private Button enviar;
    private String nomb,corre,celu,mens;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        // Inflate the layout for this fragment
        nombre = (EditText) findViewById(R.id.ednom);
        correo = (EditText) findViewById(R.id.edcorreo);
        celular = (EditText) findViewById(R.id.edcelular);
        mensaje = (EditText) findViewById(R.id.edmensaje);

        correo2="karburgos@umariana.edu.co";
        contraseña="narvaezburgos";
        Button b1=(Button)findViewById(R.id.envia);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveInfo(v);

            }
        });

}


    public void saveInfo(View v) {
        nomb = nombre.getText().toString();
        corre = correo.getText().toString();
        celu = celular.getText().toString();
        mens = mensaje.getText().toString();

        if(nomb.equals("")&&corre.equals("")&&celu.equals("")&&mens.equals(""))
        {
            Toast toast1 =Toast.makeText(getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if(nomb.equals("")||corre.equals("")||celu.equals("")||mens.equals(""))
        {
            Toast toast1 =Toast.makeText(getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        else
        {
            String type="registro";
            BackgroundWorker backgroundTask=new BackgroundWorker(this);
            backgroundTask.execute(type,nomb,corre,celu,mens);


            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Properties properties=new Properties();
            properties.put("mail.smtp.host","smtp.googlemail.com");
            properties.put("mail.smtp.socketFactory.port","465");
            properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.port","465");


            try {
                session=Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correo2,contraseña);
                    }
                });

                if (session!=null)
                {
                  Message message=new MimeMessage(session);
                  message.setFrom(new InternetAddress(correo2));
                  message.setSubject("Protegemos");
                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("burgosnarvaezkarol@gmail.com"));
                  message.setContent("Nombre: "+nombre.getText().toString()+"\n"+"Correo:  "+correo.getText().toString()+"\n"+"Celular:  "+celular.getText().toString()+"\n"+"Mensaje:  "+mensaje.getText().toString(),"text/html; charset=utf-8");
                  Transport.send(message);
                    Toast toast1 =Toast.makeText(getApplicationContext(),"Registrado", Toast.LENGTH_SHORT);
                    toast1.show();

                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }




    public void sal(View view)
    {
        finish();
    }
    public class BackgroundWorker extends AsyncTask<String,Void,String>{

        Context context;
        AlertDialog alertDialog;
        BackgroundWorker(Context ctx)
        {
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type=params[0];
            String regis_url="http://192.168.0.42/registro.php";
            if(type.equals("registro"))
                try {
                    String nombr = params[1];
                    String corre = params[2];
                    String celul = params[3];
                    String msg = params[4];
                    URL url = new URL(regis_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(nombr, "UTF-8") + "&"
                            + URLEncoder.encode("correo", "UTF-8") + "=" + URLEncoder.encode(corre, "UTF-8") + "&"
                            + URLEncoder.encode("celular", "UTF-8") + "=" + URLEncoder.encode(celul, "UTF-8") + "&"
                            + URLEncoder.encode("mensaje", "UTF-8") + "=" + URLEncoder.encode(msg, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;


                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return null;
            //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }

    }
        }


