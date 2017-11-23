package com.example.yash.tictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
/**
 * Created by Yash on 10/14/2017.
 */

public class Table implements ShapeFigure {

    private int [] hline1;
    private int [] hline2;
    private int [] vline1;
    private int [] vline2;
    private boolean init;
    public Table()
    {
        init = false;
        hline1 = new int [4];
        hline2 = new int [4];
        vline1 = new int [4];
        vline2 = new int [4];
    }

    public int[] getTabledimensions()
    {
        int xmin = hline1[0];
        int xmax = hline1[2];

        int ymin = vline1[1];
        int ymax = vline1[3];

        int[] output = new int[] {xmin, xmax, ymin, ymax};
        return output;
    }

    public void drawShapeFigure(Canvas canvas, Paint paint)
    {
        int x;
        int y;
        if(!init)
        {
            x = canvas.getWidth();
            y = canvas.getWidth();

            hline1 = new int[]{x / 4, y / 2, 3 * x / 4, y / 2};
            hline2 = new int[]{x / 4, (y / 2) + (x / 6), 3 * (x / 4), (y / 2) + (x / 6)};
            vline1 = new int []{(x/4) + (x/6), (y/2) - (x/6), (x/4) + (x/6), (y/2) + (x/3)};
            vline2 = new int []{(x/4 + x/3), (y/2)- (x/6), (x/4) + (x/3), (y/2) + (x/3)};

            Paint p2 = new Paint();
            p2.setTextSize(100);
            p2.setColor(Color.BLACK);
            p2.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Player X wins",x/2, 3*(canvas.getHeight())/4 , p2);
        }

        canvas.drawLine(hline1[0], hline1[1], hline1[2], hline1[3], paint);
        canvas.drawLine(hline2[0], hline2[1], hline2[2], hline2[3], paint);
        canvas.drawLine(vline1[0], vline1[1], vline1[2], vline1[3], paint);
        canvas.drawLine(vline2[0], vline2[1], vline2[2], vline2[3], paint);


    }

    public boolean isOnboard(int x, int y)
    {
        int [] range = getTabledimensions();

        if(x < range[0] || x > range[1])
        {
            return false;
        }

        if(y < range[2] || y > range[3])
        {
            return false;
        }

        return true;
    }

    //returns the locations of a square on the
    //tic tac toe grid where an object should be drawn
    //ideally should only be called when isOnboard returns true
    public int[] getGridcoordinates(int x, int y)
    {
        int [] base = new int [] {0, 0, 0, 0};
        if (y < hline1[1])
        {
            if(x < vline1[0])
            {
                int [] coord = new int[]{hline1[0], vline1[0], vline1[1], hline1[1]};
                return coord;
            }

            else if (x < vline2[0])
            {
                int [] coord = new int [] {vline1[0], vline2[0], vline1[1], hline1[1]};
                return coord;
            }

            else if(x < hline1[2])
            {
                int [] coord = new int [] {vline2[0], hline1[2], vline2[1], hline1[1]};
                return coord;
            }
        }

        else if(y < hline2[1])
        {
            if(x < vline1[0])
            {
                int [] coord = new int [] {hline1[0], vline1[0], hline1[1], hline2[1]};
                return coord;
            }

            else if(x < vline2[0])
            {
                int [] coord = new int [] {vline1[0], vline2[0], hline1[1], hline2[1]};
                return coord;
            }

            else if(x < hline1[2])
            {
                int [] coord = new int [] {vline2[0], hline1[2], hline1[1], hline2[1]};
                return coord;
            }
        }

        else if(y < vline1[3])
        {
            if(x < vline1[0])
            {
                int [] coord = new int [] {hline1[0], vline1[0], hline2[1], vline1[3]};
                return coord;
            }

            else if(x < vline2[0])
            {
                int [] coord = new int [] {vline1[0], vline2[0], hline2[1], vline1[3]};
                return coord;
            }

            else if(x < hline1[2])
            {
                int [] coord = new int [] {vline2[0], hline2[2], hline2[1], vline2[3]};
                return coord;
            }
        }

        return base;
    }

    //converts the grid coordinates of the object to the corresponding
    //array indices in the the board array
    public int[] grid_coord_to_array_coord(int [] input)
    {

        int row_index = 0;
        int col_index = 0;

        int x = input[0];
        int y = input[2];
        if(x == hline1[0])
        {
            col_index = 0;
        }

        else if(x == vline1[0])
        {
            col_index = 1;
        }

        else
        {
            col_index = 2;
        }

        if(y == vline1[1])
        {
            row_index = 0;
        }

        else if(y == hline1[1])
        {
            row_index = 1;
        }

        else
        {
            row_index = 2;
        }

        int [] result = {row_index, col_index};

        return result;
    }
}
