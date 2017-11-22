package com.example.yash.tictactoe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Yash on 10/14/2017.
 */

public class Oval implements ShapeFigure{
    private int [] circle1;
    public Oval()
    {
        circle1 = new int[] {500, 500, 800, 800};
    }

    public Oval(int xmin, int xmax, int ymin, int ymax)
    {
        circle1 = new int []{xmin, ymin, xmax, ymax};
    }

    public void drawShapeFigure(Canvas canvas, Paint paint)
    {
        RectF r = new RectF(circle1[0], circle1[1], circle1[2], circle1[3]);
        canvas.drawOval(r, paint);
    }
}
