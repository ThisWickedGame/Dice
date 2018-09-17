package game.wicked.athis.dice.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import game.wicked.athis.dice.R;

public class BattleFragment extends Fragment {

    public BattleFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.battle_screen, container, false);
            return rootView;
        }
}
