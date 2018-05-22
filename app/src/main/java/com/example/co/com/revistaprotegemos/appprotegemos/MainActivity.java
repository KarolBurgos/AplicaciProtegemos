package com.example.co.com.revistaprotegemos.appprotegemos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.ChatProtegemos.ChatProtegemos;
import com.example.co.com.revistaprotegemos.appprotegemos.MapaProtegemos.MapsActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.FragmentEdicionesRevista;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.ContactenosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.AdapterPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    private TextView mTextMessage;
    MaterialSearchView searchView;
    String[] list;
    private final static int PHONE_CALL_CODE = 100;
    int check = 0;
    FloatingActionButton fab, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotareBackward;
    boolean isOpen = false;
    ContactenosFragment fragment_two = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaarr);
        list = new String[]{"Clipcodes", "Android", "Plan platino", "Plan vip", "Plan auxilio", "Plan familiar", "Plan unipersonal",
                "Revista protegemos", "revista protegemos", "Taller para papá", "Suscribete", "nuestra empresas", "contactenos", "suscritos",
                "ubicacion", "Ediciones impresas", "Ediciones digitales", "Ubicacion"};
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotareBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                animateFab();
                Intent intent = new Intent(getApplicationContext(), ChatProtegemos.class);
                startActivity(intent);
                animateFab();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = "0327313100";
                if (phoneNumber != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);

                    } else {
                        OlderVersions(phoneNumber);
                    }
                }

                animateFab();
            }

            private void OlderVersions(String phoneNumber) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {

                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(intentCall);
                } else {
                    Toast.makeText(MainActivity.this, "Acceso denegado", Toast.LENGTH_SHORT).show();
                }

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = null;

        Class fragmentClass = PrincipalFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

        setSearchView();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PHONE_CALL_CODE:

                String permission = permissions[0];
                int result = grantResults[0];
                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //Comprobar si ha sido aceptado o edngada la petiion de permisons
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                        String phoneNumber = "0327313100";
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        }
                        startActivity(intentCall);
                        //Acepto el permiso
                    }
                    else{
                        //No acepto el permiso
                        Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    break;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private boolean CheckPermission(String permission)
    {
        int result = this.checkCallingOrSelfPermission(permission);
        return result ==PackageManager.PERMISSION_GRANTED;
    }
    private void animateFab()
    {
        if(isOpen)
        {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }
        else
        {
            fab.startAnimation(rotareBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }

    @Override
    public void onBackPressed() {
        switch (check) {
            case 0:
                Fragment fragment = null;

                Class fragmentClass= PrincipalFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();

                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                break;
            case 1:
                //fragment_two.onBackPressed();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.search);
        searchView.setMenuItem(item);

        return true;

    }

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.llamar)
        {

        }
        else if (id == R.id.nues) {

            Intent intent=new Intent (this,NuestraEmpresaActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.horario) {
            AlertDialog.Builder uBuilder2 = new AlertDialog.Builder(this);
            View aView2 = getLayoutInflater().inflate(R.layout.fragment_horas_atencion, null);
            uBuilder2.setView(aView2);
            final AlertDialog dialog2 = uBuilder2.create();
            dialog2.show();
            Button close = (Button) aView2.findViewById(R.id.close);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog2.cancel();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment=null;
        Class fragmentClass=PrincipalFragment.class;

        if (id == R.id.suscriptores) {
            fragmentClass=SuscritosFragment.class;
        } else if (id == R.id.nav_planes) {
            fragmentClass=PlanesFragment.class;
        } else if (id == R.id.nav_susc) {

            fragmentClass=SuscribeteFragment.class;

        } else if (id == R.id.nav_cont) {
            fragmentClass=ContactenosFragment.class;

        }

        else if (id == R.id.revistpro) {

            fragmentClass=FragmentEdicionesRevista.class;
        }
        else if (id == R.id.ubic) {

            Intent intent=new Intent (this,MapsActivity.class);
            startActivity(intent);

        }
        try{
            fragment =(Fragment)fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContentt,fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return  false;
    }


    public void setSearchView()
    {
        searchView=(MaterialSearchView)findViewById(R.id.searchview);
        Intent intent =getIntent();

        searchView.closeSearch();
        searchView.setSuggestions(list);
        //searchView.setEllipsize(false);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(String query) {

                if(query.equals("planes")||query.equals("planes protegemos")||query.equals("platino")||query.equals("Platino")||query.equals("Plan platino")
                        ||query.equals("PLAN PLATINO")||query.equals("PLATINO")||query.equals("plan platino")
                        ||query.equals("vip")||query.equals("Vip")||query.equals("Plan vip")
                        ||query.equals("PLAN VIP")||query.equals("VIP")||query.equals("plan vip")
                        ||query.equals("auxilio")||query.equals("Auxilio")
                        ||query.equals("PLAN FAMILIAR")||query.equals("FAMILIAR")||query.equals("plan platino")
                        ||query.equals("familiar")||query.equals("Familiar")||query.equals("Plan familiar")
                        ||query.equals("PLAN FAMILIAR")||query.equals("FAMILIAR")||query.equals("plan familiar")
                        ||query.equals("PLAN UNIPERSONAL")||query.equals("UNIPERSONAL")||query.equals("plan unipersonal")
                        ||query.equals("unipersonal")||query.equals("Unipersonal")||query.equals("Plan unipersonal")
                        )
                {
                    Fragment fragment = null;

                    Class fragmentClass = PlanesFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                }

                else if(query.equals("suscribete")||query.equals("Suscribete"))
                {
                    Intent intent1=new Intent (getApplicationContext(),SuscribeteActivity.class);
                    startActivity(intent1);
                }
                else if(query.equals("nuestra empresa")||query.equals("Nuestra empresa"))
                {
                    Intent intent1=new Intent (getApplicationContext(),NuestraEmpresaActivity.class);
                    startActivity(intent1);
                }


                else if(query.equals("suscritos")||query.equals("Suscritos"))
                {
                    Fragment fragment = null;

                    Class fragmentClass = SuscritosFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                }
                else if(query.equals("contactenos")||query.equals("Contactenos"))
                {
                    Fragment fragment = null;

                    Class fragmentClass = ContactenosFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                }
                else if(query.equals("ubicacion")||query.equals("ubicacion"))
                {
                    Fragment fragment = null;

                    Class fragmentClass = ContactenosFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                }

                else if(query.equals("Ediciones impresas")||query.equals("ediciones impresas")||
                        query.equals("Ediciones digitales")|| query.equals("ediciones digitales")||
                        query.equals("revista protegemos")||query.equals("Taller para papá")||query.equals("Revista Protegemos")||
                        query.equals("Revista protegemos"))
                {
                    Fragment fragment = null;

                    Class fragmentClass = FragmentEdicionesRevista.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
    }





}