package com.example.yash.tictactoe;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Yash on 10/14/2017.
 */

public class Cross implements ShapeFigure {

    private int [] diagonal1;
    private int [] diagonal2;

    public Cross()
    {
        diagonal1 = new int[] {300, 500, 600, 700};
        diagonal2 = new int[] {600,500, 300, 700};
    }

    public Cross(int xmin, int xmax, int ymin, int ymax )
    {
        diagonal1 = new int [] {xmin, ymin, xmax, ymax};
        diagonal2 = new int [] {xmax, ymin, xmin, ymax};
    }
    public void drawShapeFigure(Canvas canvas, Paint paint)
    {
        canvas.drawLine(diagonal1[0], diagonal1[1], diagonal1[2], diagonal1[3], paint);
        canvas.drawLine(diagonal2[0], diagonal2[1], diagonal2[2], diagonal2[3], paint);
    }
}
