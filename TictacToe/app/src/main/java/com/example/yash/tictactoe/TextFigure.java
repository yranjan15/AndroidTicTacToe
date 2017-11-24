package com.example.yash.tictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import org.w3c.dom.Text;

/**
 * Created by yash on 11/23/2017.
 */

public class TextFigure implements ShapeFigure {

    private String text;

    public TextFigure(String newtext)
    {
        text = newtext;
    }

    public void drawShapeFigure(Canvas canvas, Paint paint)
    {
        int x;
        int y;
        x = canvas.getWidth();
        y = canvas.getHeight();

        Paint p2 = new Paint();
        p2.setTextSize(100);
        p2.setColor(Color.BLACK);
        p2.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text,x/2, 3*(canvas.getHeight())/4 , p2);
    }
}
