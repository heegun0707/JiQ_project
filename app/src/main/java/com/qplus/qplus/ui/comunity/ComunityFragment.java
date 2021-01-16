package com.qplus.qplus.ui.comunity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.qplus.qplus.R;
import com.google.android.material.tabs.TabLayout;

public class ComunityFragment extends Fragment {

    ViewPager vp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_comunity, container, false);

        vp = root.findViewById(R.id.view_pager);
        CommnunityTabAdapter commnunityTabAdapter = new CommnunityTabAdapter(getChildFragmentManager());
        vp.setAdapter(commnunityTabAdapter);
        vp.setOffscreenPageLimit(2);
        vp.setSaveEnabled(false);

        TabLayout tabLayout = root.findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#24B651"));
        tabLayout.addTab(tabLayout.newTab().setText("뉴스레터"),0,true);
        tabLayout.addTab(tabLayout.newTab().setText("봉사활동"),1);
        tabLayout.addTab(tabLayout.newTab().setText("가정캠페인"),2);

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return root;
    }

    public void communityrefresh(){
        Log.d("fragment","refresh");
        assert getFragmentManager() != null;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
