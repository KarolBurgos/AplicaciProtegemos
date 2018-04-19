package com.example.co.com.revistaprotegemos.appprotegemos;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.ContactenosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.revistaProtegemos.RevistaProtegemos;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscribirseFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.DataAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    ArrayList<Pautas> listaPautas;
    DataAdapterr recyclerAdaptador;
    MaterialSearchView searchView;
    String[] list;
    int check = 0;
    ContactenosFragment fragment_two = null;
    //List<DataItem> lstData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        list = new String[]{"Clipcodes", "Android"};
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Fragment fragment = null;

                Class fragmentClass = PrincipalFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
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
                fragment_two.onBackPressed();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            if (id == R.id.llamar)
            {
            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 0327313100)));
            }catch(Exception e){
                e.printStackTrace();
            }
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

         fragmentClass=SuscribirseFragment.class;

        } else if (id == R.id.nav_cont) {
            fragmentClass=ContactenosFragment.class;
        }
        else if (id == R.id.nav_nuemp) {

            fragmentClass=NuestraEmpresaFragment.class;
        }
        else if (id == R.id.revistpro) {

            fragmentClass=RevistaProtegemos.class;
        }
        else if (id == R.id.ubic) {

            fragmentClass=MapsActivity.class;
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
        searchView.closeSearch();
        searchView.setSuggestions(list);
        searchView.setEllipsize(true);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
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