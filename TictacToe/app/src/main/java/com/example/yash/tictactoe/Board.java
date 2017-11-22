package com.example.yash.tictactoe;

/**
 * Created by Yash on 10/7/2017.
 */

public class Board {

    private Table table;
    public static int move_counter = 0;

    int [] [] player_moves;

    private boolean win_status;

    public Board()
    {
        table = new Table();
        player_moves = new int [3] [3];

        for(int i = 0; i < player_moves.length; i++)
        {
            for(int j = 0; j < player_moves.length; j++)
            {
                player_moves[i][j] = -1;
            }
        }

        win_status = false;
    }

    public boolean moveMade(int [] coords)
    {
        int x = coords[0];
        int y = coords[1];

        if(player_moves[x][y] == -1)
        {
            return false;
        }

        else
        {
            return true;
        }
    }

    public void setMove(int [] coords, boolean player1)
    {
        int x = coords[0];
        int y = coords[1];

        if(player1)
        {
            player_moves[x][y] = 1;
        }

        else
        {
            player_moves[x][y] = 2;
        }
    }

    public Table getTable()
    {
        return table;
    }

    //ret 1 if player 1 won, 2 if player 2 won, and -1 if no player has won yet
    public int checkWin()
    {
        int result = -1;
        //check horizontal
        for(int i = 0; i < player_moves[0].length; i++)
        {
            if(player_moves[i][0] == player_moves[i][1])
            {
                if(player_moves[i][0] == player_moves[i][2])
                {
                    if(player_moves[i][0] != -1) {
                        return player_moves[i][0];
                    }
                }
            }
        }

        //check vertical
        for(int i = 0; i < player_moves.length; i++)
        {
            if(player_moves[0][i] == player_moves[1][i])
            {
                if(player_moves[0][i] == player_moves[2][i])
                {
                    if(player_moves[0][i] != -1) {
                        return player_moves[0][i];
                    }
                }
            }
        }

        //check diagonal 1
        if(player_moves[0][0] == player_moves[1][1])
        {
            if(player_moves[0][0] == player_moves[2][2])
            {
                if(player_moves[0][0] != -1) {
                    return player_moves[0][0];
                }
            }
        }

        //check diagonal 2

        if(player_moves[0][2] == player_moves [1][1])
        {
            if(player_moves[0][2] == player_moves[2][0])
            {
                if(player_moves[0][2] != -1) {
                    return player_moves[0][2];
                }
            }
        }

        return -1;

    }

    public boolean getWinstatus()
    {
        return win_status;
    }

    public void setWinstatus(boolean input)
    {
        win_status = input;
    }

}
