package com.devleoperyogi.tictactoe;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private Button resetButton;
    private TextView scoreBoard;
    private int flag;
    private int count;
    private int scoreX;
    private int scoreO;

    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        buttons = new Button[]{
                findViewById(R.id.btn1), findViewById(R.id.btn2), findViewById(R.id.btn3),
                findViewById(R.id.btn4), findViewById(R.id.btn5), findViewById(R.id.btn6),
                findViewById(R.id.btn7), findViewById(R.id.btn8), findViewById(R.id.btn9)
        };

        resetButton = findViewById(R.id.btnReset);
        scoreBoard = findViewById(R.id.scoreBoard);

        updateScoreBoard();

        for (Button button : buttons) {
            button.setOnClickListener(this::check);
        }

        resetButton.setOnClickListener(v -> newGame());
    }

    public void check(View view) {
        Button btnCurrent = (Button) view;

        if (btnCurrent.getText().toString().isEmpty()) {
            count++;
            btnCurrent.setText(flag == 0 ? "X" : "O");
            btnCurrent.setTextColor(getResources().getColor(flag == 0 ? R.color.textColorX : R.color.textColorO));
            btnCurrent.setTypeface(null, Typeface.BOLD);
            flag = 1 - flag;

            if (count >= 5 && checkWin()) return;

            if (count == 9) {
                Toast.makeText(this, "Game is Drawn!", Toast.LENGTH_SHORT).show();
                newGame();
            }
        }
    }

    private boolean checkWin() {
        for (int[] condition : winConditions) {
            String a = buttons[condition[0]].getText().toString();
            String b = buttons[condition[1]].getText().toString();
            String c = buttons[condition[2]].getText().toString();

            if (!a.isEmpty() && a.equals(b) && b.equals(c)) {
                highlightWinningCombination(condition, a); // Pass the winner to highlightWinningCombination
                Toast.makeText(this, "Winner is " + a, Toast.LENGTH_SHORT).show();
                updateScore(a);

                // Delay resetting the game slightly to avoid crashing
                buttons[0].postDelayed(this::newGame, 1000);
                return true;
            }
        }
        return false;
    }

    // Method to highlight the winning combination and change background color
    private void highlightWinningCombination(int[] condition, String winner) {
        for (int index : condition) {
            buttons[index].setBackgroundColor(getResources().getColor(R.color.highlightColor));
        }

        // Change background color based on winner
        if (winner.equals("X")) {
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.winXColor));
        } else {
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.winOColor));
        }
    }

    private void updateScore(String winner) {
        if (winner.equals("X")) scoreX++;
        else scoreO++;

        updateScoreBoard();
    }

    private void updateScoreBoard() {
        scoreBoard.setText(String.format("X: %d | O: %d", scoreX, scoreO));
    }

    // Reset background color during a new game
    public void newGame() {
        for (Button button : buttons) {
            button.setText("");
            button.setBackgroundResource(R.drawable.circular_button); // Reset to default circular style
        }
        count = 0;
        flag = 0;

        // Reset background color
        findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.backgroundColor));
    }
}
