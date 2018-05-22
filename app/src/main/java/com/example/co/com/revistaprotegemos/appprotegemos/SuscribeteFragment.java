package com.example.co.com.revistaprotegemos.appprotegemos;


import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;

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
public class SuscribeteFragment extends Fragment {

    private AppBarLayout appBar;

    private EditText nombre,identificacion,ciudad,barrio,direccion,telefono,correo;
    private String nomb,iden,ciud,barr,dirr,tele,corr;
    private Button b1, ubi;
    private String correo2, contraseña;
    private FragmentActivity myContext;
    private Session session;
    TextView t1, t2, t3, t4;

    public SuscribeteFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suscribete, container, false);
        View contenedor = (View) container.getParent();
        nombre = (EditText) view.findViewById(R.id.edno);
        identificacion=(EditText)view.findViewById(R.id.ide);
        ciudad =(EditText)view.findViewById(R.id.ci);
        barrio = (EditText)view.findViewById(R.id.barr);
        direccion= (EditText)view.findViewById(R.id.di);
        telefono = (EditText)view.findViewById(R.id.telef);
        correo = (EditText) view.findViewById(R.id.edco);

        //ubi=(Button)view.findViewById(R.id.buttonubi);
        b1 = (Button) view.findViewById(R.id.buttenviasus);
        correo2 = "protegemossistemas@gmail.com";
        contraseña = "sistemasprotegemos123";
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
        iden=identificacion.getText().toString();
        ciud =ciudad.getText().toString();
        barr=barrio.getText().toString();
        tele=telefono.getText().toString();
        corr=correo.getText().toString();
        if (nomb.equals("") && iden.equals("") && ciud.equals("") && barr.equals("") && tele.equals("") && corr.equals("")) {
            Toast toast1 = Toast.makeText(getActivity().getApplicationContext(), "Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if (nomb.equals("") && iden.equals("") && ciud.equals("") && barr.equals("") && tele.equals("") && corr.equals("")) {
            Toast toast1 = Toast.makeText(getActivity().getApplicationContext(), "Completar campos vacios", Toast.LENGTH_SHORT);
            toast1.show();
        } else {

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
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(corr));
                    message.setContent("Nombre: " + nombre.getText().toString() + "\n" + "Correo:  " + correo.getText().toString() + "\n" + "Identificacion:  " + identificacion.getText().toString() + "\n" + "Ciudad:  " + ciudad.getText().toString()+ "Barrio:  " + barrio.getText().toString()+ "Telefono:  " + telefono.getText().toString(), "text/html; charset=utf-8");
                    Transport.send(message);
                    Toast toast1 = Toast.makeText(getActivity().getApplicationContext(), "Registrado", Toast.LENGTH_SHORT);
                    toast1.show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
