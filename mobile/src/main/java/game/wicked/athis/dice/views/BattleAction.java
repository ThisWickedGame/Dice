package game.wicked.athis.dice.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import game.wicked.athis.dice.Events.AbilityEvent;
import game.wicked.athis.dice.Events.DamageEvent;
import game.wicked.athis.dice.Events.RollingEvent;
import game.wicked.athis.dice.R;
import game.wicked.athis.dice.enums.Ability;
import game.wicked.athis.dice.enums.AdvDis;
import game.wicked.athis.dice.enums.DamageType;
import game.wicked.athis.dice.enums.DiceType;
import game.wicked.athis.dice.utils.StringCleaner;

public class BattleAction extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.battle_screen);

        final Button rapierAttackButton = findViewById(R.id.Rapier_Attack_Button);
        rapierAttackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doAnAttackDiceRoll(Ability.DEXTERITY, 8, AdvDis.NORMAL);
            }
        });

        final Button rapierDamageButton = findViewById(R.id.Rapier_Damage_Button);
        rapierDamageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doADamageDiceRoll(DiceType.d8, 1, Ability.DEXTERITY, 5, DamageType.PIERCING);
            }
        });
    }

    private void doAnAttackDiceRoll(Ability abilityType, int modifier, AdvDis advDis) {
        RollingEvent diceRoll = new AbilityEvent(abilityType, modifier, advDis);
        new ShowPopUp().onButtonShowPopupWindowClick(StringCleaner.youRolledA(diceRoll.roll()));
    }

    private void doADamageDiceRoll(DiceType diceType, int diceCount, Ability abilityType, int modifier,
                                   DamageType damageType) {
        RollingEvent diceRoll = new DamageEvent(diceType, diceCount, abilityType, modifier, damageType);
        //new ShowPopUp().onButtonShowPopupWindowClick(StringCleaner.youRolledA(diceRoll.roll()));
        onButtonShowPopupWindowClick(StringCleaner.youRolledA(diceRoll.roll()));
    }

    private void doASaveDiceRoll(Ability abilityType, int modifier, AdvDis advDis) {
        RollingEvent diceRoll = new AbilityEvent(abilityType, modifier, advDis);
        new ShowPopUp().onButtonShowPopupWindowClick(StringCleaner.youRolledA(diceRoll.roll()));
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
