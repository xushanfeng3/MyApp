package com.example.sudo.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by xushanfeng on 16/4/2.
 */
public class myVIew extends View{
    private float width;
    private float height;
    private Game game = new Game();

    public myVIew(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.width = w/9;
        this.height = h/9;
        super.onSizeChanged(w, h, oldw, oldh);

    }

    //    public int width()
    @Override
    protected void onDraw(Canvas canvas) {
        Paint backgroundPaint = new Paint();
        backgroundPaint.setColor(getResources().getColor(R.color.sudo_background));
        canvas.drawRect(0, 0, getWidth(), getHeight(), backgroundPaint);

        Paint darkPaint = new Paint();
        darkPaint.setColor(getResources().getColor(R.color.sudo_dark));

        Paint hilitePaint = new Paint();
        hilitePaint.setColor(getResources().getColor(R.color.sudo_hilite));

        Paint lightPaint = new Paint();
        lightPaint.setColor(getResources().getColor(R.color.sudo_light));


        for (int i=0;i<9;i++){
            canvas.drawLine(0,i*height,getWidth(),i*height,lightPaint);
            canvas.drawLine(0,i*height+1,getWidth(),i*height+1,hilitePaint);
            canvas.drawLine(i*width,0,i*width,getHeight(),lightPaint);
            canvas.drawLine(i*width+1,0,i*width+1,getHeight(),hilitePaint);
        }

        for (int j=0;j<9;j++){
            if(j%3!=0){
                continue;
            }
            canvas.drawLine(0,j*height,getWidth(),j*height,darkPaint);
            canvas.drawLine(0,j*height+1,getWidth(),j*height+1,hilitePaint);
            canvas.drawLine(j*width,0,j*width,getHeight(),darkPaint);
            canvas.drawLine(j*width+1,0,j*width+1,getHeight(),hilitePaint);
        }

        Paint numPaint = new Paint();
        numPaint.setColor(Color.BLUE);
        numPaint.setStyle(Paint.Style.STROKE);
        numPaint.setTextSize(height * 0.75f);
        numPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fm = numPaint.getFontMetrics();


        float x = width/2;
        float y = height/2-(fm.ascent+fm.descent)/2;

        for(int i = 0;i<9;i++){
            for (int j=0;j<9;j++){
                canvas.drawText(game.getTileString(i,j),i*width+x,j*height+y,numPaint);
            }
        }
        super.onDraw(canvas);


    }
}
