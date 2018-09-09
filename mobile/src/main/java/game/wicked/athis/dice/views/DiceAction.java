package game.wicked.athis.dice.views;

import android.support.v7.app.AppCompatActivity;
import game.wicked.athis.dice.Events.RollingEvent;
import game.wicked.athis.dice.Events.StraightRollEvent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import game.wicked.athis.dice.R;
import game.wicked.athis.dice.enums.DiceType;
import game.wicked.athis.dice.utils.StringCleaner;

public class DiceAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.straight_dice_screen);

        final Button d2Button = findViewById(R.id.D2_Button);
        d2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d2);
            }
        });

        final Button d4Button = findViewById(R.id.D4_Button);
        d4Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d4);
            }
        });

        final Button d6Button = findViewById(R.id.D6_Button);
        d6Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d6);
            }
        });

        final Button d8Button = findViewById(R.id.D8_Button);
        d8Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d8);
            }
        });

        final Button d10Button = findViewById(R.id.D10_Button);
        d10Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d10);
            }
        });

        final Button d12Button = findViewById(R.id.D12_Button);
        d12Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d12);
            }
        });

        final Button d20Button = findViewById(R.id.D20_Button);
        d20Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d20);
            }
        });

        final Button d100Button = findViewById(R.id.D100_Button);
        d100Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAStraightDiceRoll(DiceType.d100);
            }
        });
    }

    private void doAStraightDiceRoll(DiceType diceType) {
        RollingEvent diceRoll = new StraightRollEvent(diceType, 1);
        onButtonShowPopupWindowClick(StringCleaner.youRolledA(diceRoll.roll()));
    }

    private void onButtonShowPopupWindowClick(String text) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
        ((TextView) popupWindow.getContentView().findViewById(R.id.Popup_Text)).setText(text);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
