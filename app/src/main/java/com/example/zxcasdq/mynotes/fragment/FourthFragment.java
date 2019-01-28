package com.example.zxcasdq.mynotes.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zxcasdq.mynotes.R;
import com.example.zxcasdq.mynotes.my.MySignActivity;


public class FourthFragment  extends Fragment {
    TextView myName;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tab4,container,false);
        myName=(TextView)view.findViewById(R.id.sign_text);
        myName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), MySignActivity.class);
                startActivityForResult(intent,0); //标记
            }
        });
        return view;
    }

    public void onActivatyResult( int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if((requestCode==0)&&(resultCode==1)){
            String result=data.getStringExtra("editView");
            myName.setText(result);
        }
    }

}
