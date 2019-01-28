package com.example.zxcasdq.mynotes;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.zxcasdq.mynotes.fragment.FirstFragment;
import com.example.zxcasdq.mynotes.fragment.FourthFragment;
import com.example.zxcasdq.mynotes.fragment.SecondFragment;
import com.example.zxcasdq.mynotes.fragment.ThirdFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Map<String,View> tabspecViews=new HashMap<>();
    private Map<String,ImageView> imageViewMap=new HashMap<>();

    private View getTabSpecView(String name,int imageId,String tag){
        LayoutInflater layoutInflater=getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.fragment_tabspec_layout,null);

        ImageView imageView=view.findViewById(R.id.image);
        imageView.setImageResource(imageId);

        TextView textView=view.findViewById(R.id.textView);
        textView.setText(name);

        tabspecViews.put(tag,view);
        imageViewMap.put(tag,imageView);

        return view;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTabHost fragmentTabHost =findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabhost);

        TabHost.TabSpec tabSpec1=fragmentTabHost.newTabSpec("tab1")
                .setIndicator(getTabSpecView("图库",R.drawable.fragment_images0,"tab1"));
        fragmentTabHost.addTab(tabSpec1, FirstFragment.class,null);


        TabHost.TabSpec tabSpec2=fragmentTabHost.newTabSpec("tab2")
                .setIndicator(getTabSpecView("便条",R.drawable.fragment_note0,"tab2"));
        fragmentTabHost.addTab(tabSpec2, SecondFragment.class,null);


        TabHost.TabSpec tabSpec3=fragmentTabHost.newTabSpec("tab3")
                .setIndicator(getTabSpecView("发现",R.drawable.fragment_find0,"tab3"));
        fragmentTabHost.addTab(tabSpec3,ThirdFragment.class,null);


        final TabHost.TabSpec tabSpec4=fragmentTabHost.newTabSpec("tab4")
                .setIndicator(getTabSpecView("我的",R.drawable.fragment_my0,"tab4"));
        fragmentTabHost.addTab(tabSpec4,FourthFragment.class,null);

        fragmentTabHost.setCurrentTab(0);
        final  ImageView imageView=imageViewMap.get("tab3");
        imageView.setImageResource(R.drawable.fragment_my1);


        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Set<String> keys=tabspecViews.keySet();
                for(String str:keys){
                    View view=tabspecViews.get(str);
                    ImageView imageView1=imageViewMap.get("tab1");
                    ImageView imageView2=imageViewMap.get("tab2");
                    ImageView imageView3=imageViewMap.get("tab3");
                    ImageView imageView4=imageViewMap.get("tab4");


                    if (tabId.equals("tab1")){
                        imageView1.setImageResource(R.drawable.fragment_images1);
                        imageView2.setImageResource(R.drawable.fragment_note0);
                        imageView3.setImageResource(R.drawable.fragment_find0);
                        imageView4.setImageResource(R.drawable.fragment_my0);
                    }else if(tabId.equals("tab2")){
                        imageView1.setImageResource(R.drawable.fragment_images0);
                        imageView2.setImageResource(R.drawable.fragment_note1);
                        imageView3.setImageResource(R.drawable.fragment_find0);
                        imageView4.setImageResource(R.drawable.fragment_my0);
                    }else if (tabId.equals("tab3")){
                        imageView1.setImageResource(R.drawable.fragment_images0);
                        imageView2.setImageResource(R.drawable.fragment_note0);
                        imageView3.setImageResource(R.drawable.fragment_find1);
                        imageView4.setImageResource(R.drawable.fragment_my0);
                    }else if(tabId.equals("tab4")){
                        imageView1.setImageResource(R.drawable.fragment_images0);
                        imageView2.setImageResource(R.drawable.fragment_note0);
                        imageView3.setImageResource(R.drawable.fragment_find0);
                        imageView4.setImageResource(R.drawable.fragment_my1);
                    }
                }
            }
        });





























    }
}
