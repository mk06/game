package com.example.user.tictactoe;

import java.util.Random;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
public class TicTacToeextends AppCompatActivity {
intc[][];
inti, j, k = 0;
    Button b[][];
TextViewtextView;
    AI ai;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_tic_tac_toe);
setBoard();    }
@Override
public booleanonCreateOptionsMenu(Menu menu) {
super.onCreateOptionsMenu(menu);
MenuItem item = menu.add("New Game");
return true;    }
public booleanonOptionsItemSelected(MenuItem item) {
setBoard();
return true;    }
// Set up the game board.
private void setBoard() {
ai= new AI();
b = new Button[4][4];
c = new int[4][4];
textView= (TextView) findViewById(R.id.dialogue);
b[1][3] = (Button) findViewById(R.id.one);
b[1][2] = (Button) findViewById(R.id.two);
b[1][1] = (Button) findViewById(R.id.three);
b[2][3] = (Button) findViewById(R.id.four);
b[2][2] = (Button) findViewById(R.id.five);
b[2][1] = (Button) findViewById(R.id.six);


b[3][3] = (Button) findViewById(R.id.seven);
b[3][2] = (Button) findViewById(R.id.eight);
b[3][1] = (Button) findViewById(R.id.nine);
for (i= 1; i<= 3; i++) {
for (j = 1; j <= 3; j++)
c[i][j] = 2;       }
textView.setText("Click a button to start.");
// add the click listeners for each button
for (i= 1; i<= 3; i++) {
for (j = 1; j <= 3; j++) {
b[i][j].setOnClickListener(new MyClickListener(i, j));
if(!b[i][j].isEnabled()) {
b[i][j].setText(" ");
b[i][j].setEnabled(true);
                }           }      }   }
class MyClickListenerimplements View.OnClickListener {
intx; inty;
public MyClickListener(intx, inty) {
this.x= x;
this.y= y;       }
public void onClick(View view) {
if (b[x][y].isEnabled()) {
b[x][y].setEnabled(false);
b[x][y].setText("O");
c[x][y] = 0;
textView.setText("");
if (!checkBoard()) {
ai.takeTurn();
                }    } }  }
private class AI {
public void takeTurn() {
if(c[1][1]==2 &&
                    ((c[1][2]==0 &&c[1][3]==0) ||
                            (c[2][2]==0 &&c[3][3]==0) ||
                            (c[2][1]==0 &&c[3][1]==0))) {
markSquare(1,1);
            } else if (c[1][2]==2 &&
                    ((c[2][2]==0 &&c[3][2]==0) ||
                            (c[1][1]==0 &&c[1][3]==0))) {
markSquare(1,2);
            } else if(c[1][3]==2 &&
                    ((c[1][1]==0 &&c[1][2]==0) ||
                            (c[3][1]==0 &&c[2][2]==0) ||
                            (c[2][3]==0 &&c[3][3]==0))) {
markSquare(1,3);
            } else if(c[2][1]==2 &&
                    ((c[2][2]==0 &&c[2][3]==0) ||
                            (c[1][1]==0 &&c[3][1]==0))){
markSquare(2,1);
            } else if(c[2][2]==2 &&
                    ((c[1][1]==0 &&c[3][3]==0) ||
                            (c[1][2]==0 &&c[3][2]==0) ||
                            (c[3][1]==0 &&c[1][3]==0) ||
                            (c[2][1]==0 &&c[2][3]==0))) {
markSquare(2,2);
            } else if(c[2][3]==2 &&
                    ((c[2][1]==0 &&c[2][2]==0) ||
                            (c[1][3]==0 &&c[3][3]==0))) {
markSquare(2,3);
            } else if(c[3][1]==2 &&
                    ((c[1][1]==0 &&c[2][1]==0) ||
                            (c[3][2]==0 &&c[3][3]==0) ||
                            (c[2][2]==0 &&c[1][3]==0))){
markSquare(3,1);
            } else if(c[3][2]==2 &&
                    ((c[1][2]==0 &&c[2][2]==0) ||
                            (c[3][1]==0 &&c[3][3]==0))) {
markSquare(3,2);
            }else if( c[3][3]==2 &&
                    ((c[1][1]==0 &&c[2][2]==0) ||
                            (c[1][3]==0 &&c[2][3]==0) ||
                            (c[3][1]==0 &&c[3][2]==0))) {
markSquare(3,3);
            } else {
                Random rand = new Random();

inta = rand.nextInt(4);
intb = rand.nextInt(4);
while(a==0 || b==0 || c[a][b]!=2) {
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);  
markSquare(a,b); }}
private void markSquare(intx, inty) {
b[x][y].setEnabled(false);
b[x][y].setText("X");
c[x][y] = 1;
checkBoard();}   }
// check the board to see if someone has won
private booleancheckBoard() {
booleangameOver = false;
if ((c[1][1] == 0 &&c[2][2] == 0 &&c[3][3] == 0)
                || (c[1][3] == 0 &&c[2][2] == 0 &&c[3][1] == 0)
                || (c[1][2] == 0 &&c[2][2] == 0 &&c[3][2] == 0)
                || (c[1][3] == 0 &&c[2][3] == 0 &&c[3][3] == 0)
                || (c[1][1] == 0 &&c[1][2] == 0 &&c[1][3] == 0)
                || (c[2][1] == 0 &&c[2][2] == 0 &&c[2][3] == 0)
                || (c[3][1] == 0 &&c[3][2] == 0 &&c[3][3] == 0)
                || (c[1][1] == 0 &&c[2][1] == 0 &&c[3][1] == 0)) {
textView.setText("Game over. You win!");
gameOver = true;
        } else if ((c[1][1] == 1 &&c[2][2] == 1 &&c[3][3] == 1)
                || (c[1][3] == 1 &&c[2][2] == 1 &&c[3][1] == 1)
                || (c[1][2] == 1 &&c[2][2] == 1 &&c[3][2] == 1)
                || (c[1][3] == 1 &&c[2][3] == 1 &&c[3][3] == 1)
                || (c[1][1] == 1 &&c[1][2] == 1 &&c[1][3] == 1)
                || (c[2][1] == 1 &&c[2][2] == 1 &&c[2][3] == 1)
                || (c[3][1] == 1 &&c[3][2] == 1 &&c[3][3] == 1)
                || (c[1][1] == 1 &&c[2][1] == 1 &&c[3][1] == 1)) {
textView.setText("Game over. You lost!");
gameOver = true;
        } else {
booleanempty = false;
for(i=1; i<=3; i++) {
for(j=1; j<=3; j++) {
if(c[i][j]==2) {
                        empty = true;
break;  } } }
if(!empty) {
gameOver = true;
textView.setText("Game over. It's a draw!");
}  }
return gameOver;
    }}
