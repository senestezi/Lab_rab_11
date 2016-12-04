package com.example.thecasp1k.lab11;

import android.content.Context;
import android.graphics.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawingView dv = new DrawingView(this);
        setContentView(dv);
    }

    class DrawingView extends View {

        Paint p;
        int myWidth = 0, myHeight = 0;
        Bitmap image;
        double scale;

        public DrawingView(Context context) {
            super(context);
            p = new Paint();
            image = BitmapFactory.decodeResource(getResources(), R.drawable.ui);
            scale = image.getWidth() / 1024.0;
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            myWidth = w;
            myHeight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Rect R1 = new Rect((int)(466 * scale), (int)(1 * scale), (int)(620 * scale), (int)(231 * scale));
            Rect R2 = new Rect(myWidth / 2 - R1.width() / 2, myHeight / 2 - R1.height() / 2, myWidth / 2 + R1.width() / 2, myHeight / 2 + R1.height() / 2);
            canvas.drawBitmap(image, R1, R2, p);
            R1 = new Rect((int)(202 * scale), (int)(294 * scale), (int)(306 * scale), (int)(394 * scale));
            R2 = new Rect(R2.left - R1.width() / 2, myHeight / 2 - R1.height() / 2 - 40, R2.left  + R1.width() / 2, myHeight / 2 + R1.height() / 2 - 40);
            canvas.drawBitmap(image, R1, R2, p);
        }

    }

}
