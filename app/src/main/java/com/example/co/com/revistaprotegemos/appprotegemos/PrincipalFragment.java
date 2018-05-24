package com.example.co.com.revistaprotegemos.appprotegemos;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.FragmentEdicionesRevista;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.InicioAppFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.ZonasFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    private ImageView logo;
    private Toolbar toolbar;
    public PrincipalFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_principal, container, false);


        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);

        toolbar = (Toolbar) contenedor.findViewById(R.id.toolbaarr);
        appBar.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tabs = new TabLayout(getActivity());
        appBar.addView(tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        //Permite centrar los tabs
        tabs.setTabGravity(TabLayout.MODE_SCROLLABLE);

        int icons[] = {R.drawable.ic_iconhouse, R.drawable.ic_iconhouse};
        tabs.getTabAt(0).setIcon(icons[0]);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }

    public static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        String[] tirulotabs = {"", "PLANES", "REVISTAS","ZONAS"};

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:

                    return new InicioAppFragment();

                case 1:
                    return new PlanesFragment();
                case 2:
                    return new FragmentEdicionesRevista();
                case 3:
                    return new ZonasFragment();
            }
            return null;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 4;
        }

        /**
         * This method may be called by the ViewPager to obtain a title string
         * to describe the specified page. This method may return null
         * indicating no title for this page. The default implementation returns
         * null.
         *
         * @param position The position of the title requested
         * @return A title for the requested page
         */
        @Override
        public CharSequence getPageTitle(int position) {


            return tirulotabs[position];

        }

    }


}
