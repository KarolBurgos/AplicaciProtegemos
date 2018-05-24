package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactenosFragment extends Fragment {

    private AppBarLayout appBar;

    private EditText nombre, correo, celular, mensaje;
    private String nomb,corre,celu,mens;
    private Button b1,ubi;
    private String correo2, contraseña;
    private FragmentActivity myContext;
    private Session session;
    TextView t1,t2,t3,t4;
    private Typeface letras;

    public ContactenosFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contactenos, container, false);
        View contenedor = (View) container.getParent();
        nombre = (EditText) view.findViewById(R.id.ednomm);
        correo = (EditText) view.findViewById(R.id.edcorreoo);
        celular = (EditText) view.findViewById(R.id.edcelularr);
        mensaje = (EditText) view.findViewById(R.id.edmensajee);
        //ubi=(Button)view.findViewById(R.id.buttonubi);
        b1=(Button)view.findViewById(R.id.buttenvia);
        correo2="protegemossistemas@gmail.com";
        contraseña="sistemasprotegemos123";
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);
        appBar.removeView(view);
        appBar.setBackgroundColor(Color.parseColor("#FFCE6E98"));


        return view;
    }


   @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                saveInfo();

            }
        });
    }

    public void saveInfo() {
        nomb = nombre.getText().toString();
        corre = correo.getText().toString();
        celu = celular.getText().toString();
        mens = mensaje.getText().toString();
        if(nomb.equals("")&&corre.equals("")&&celu.equals("")&&mens.equals(""))
        {
            Toast toast1 =Toast.makeText(getActivity().getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if(nomb.equals("")||corre.equals("")||celu.equals("")||mens.equals(""))
        {
            Toast toast1 =Toast.makeText(getActivity().getApplicationContext(),"Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        else {

            String type = "registro";
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
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("karburgos@umariana.edu.co"));
                    message.setContent("Nombre: " + nombre.getText().toString() + "\n" + "Correo:  " + correo.getText().toString() + "\n" + "Celular:  " + celular.getText().toString() + "\n" + "Mensaje:  " + mensaje.getText().toString(), "text/html; charset=utf-8");
                    Transport.send(message);
                    Toast toast1 = Toast.makeText(getActivity().getApplicationContext(), "Correo Enviado", Toast.LENGTH_SHORT);
                    toast1.show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





}



