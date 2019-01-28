package com.example.zxcasdq.mynotes.methods;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImage extends android.support.v7.widget.AppCompatImageView{
    private Paint paint;
    public RoundImage(Context context) {
        super(context);
    }

    public RoundImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Bitmap scaleBitmap (Bitmap bitmap){
        int width=getWidth();
        float scale=(float)width/(float)bitmap.getWidth();
        Matrix matrix=new Matrix();
        matrix.postScale(scale,scale);
        return Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
    }
    private Bitmap dealRawBitmap(Bitmap bitmap){
        int width=bitmap.getWidth();
        int height=bitmap.getHeight();
        int minWidth=(width>height)?height:width;
        int leftTopX=(width-minWidth)/2;
        int leftTopY=(height-minWidth)/2;
        Bitmap newBitmap=Bitmap.createBitmap(bitmap,leftTopX,leftTopY,minWidth,minWidth,null,false);
        return scaleBitmap(newBitmap);
    }
    protected  void  onDraw(Canvas canvas){
        Drawable drawable=getDrawable();
        if(null!=drawable){
            Bitmap rawBitmap=((BitmapDrawable)drawable).getBitmap();
            Bitmap newBitmap=dealRawBitmap(rawBitmap);
            Bitmap circleBitmap=toRoundCorner(newBitmap,14);

            final Rect rect=new Rect(0,0,circleBitmap.getWidth(),circleBitmap.getHeight());
            paint.reset();
            canvas.drawBitmap(circleBitmap,rect,rect,paint);
        }else{
            super.onDraw(canvas);
        }
    }
    private Bitmap toRoundCorner(Bitmap bitmap,int pixels){
        Bitmap output=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(output);
        int color=0xff424242;
        final Rect rect=new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        paint.setColor(color);
        int x= bitmap.getWidth();
        canvas.drawCircle(x/2,x/2,x/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,rect,rect,paint);

        return output;
    }

}
