package com.example.yash.tictactoe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Yash on 10/7/2017.
 */

public class TictacToeView extends View  {
    Paint paint = new Paint();
    Board tboard;
    boolean init = false;
    boolean player1 = true;

    ArrayList<ShapeFigure> drawShapes = new ArrayList<ShapeFigure>();
    private void init() {
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);
    }

    public TictacToeView(Context context) {
        super(context);
        init();
    }

    public TictacToeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TictacToeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        Log.e("error", "painting occurring1");


        if(!init)
        {
            init = true;
            tboard = new Board();
            drawShapes.add(tboard.getTable());
        }

        for(int i = 0; i < drawShapes.size(); i++)
        {
            drawShapes.get(i).drawShapeFigure(canvas, paint);
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        Log.e("error", "touch occurred");
        int eventAction = event.getAction();

        // you may need the x/y location
        int x_coord = (int)event.getX();
        int y_coord = (int)event.getY();

        boolean touched = tboard.getTable().isOnboard(x_coord,y_coord);

        if(touched && (eventAction == MotionEvent.ACTION_DOWN))
        {
            int [] gridcoord = tboard.getTable().getGridcoordinates(x_coord, y_coord);

            if(player1)
            {
                Log.e("error", "cross");
                drawShapes.add(new Cross(gridcoord[0], gridcoord[1], gridcoord[2], gridcoord[3]));
                player1 = false;
            }

            else
            {
                Log.e("error", "oval");
                drawShapes.add(new Oval(gridcoord[0], gridcoord[1], gridcoord[2], gridcoord[3]));
                player1 = true;
            }

        }
        // tell the View to redraw the Canvas
        invalidate();

       // tell the View that we handled the event
        return true;

    }
}
