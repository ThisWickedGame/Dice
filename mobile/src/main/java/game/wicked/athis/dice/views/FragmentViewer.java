package game.wicked.athis.dice.views;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import game.wicked.athis.dice.R;

public class FragmentViewer extends FragmentPagerAdapter {
    private Context mContext;

    public FragmentViewer(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BattleFragment();
        } else if (position == 1){
            return new SkillsFragment();
        } else if (position == 2){
            return new DiceFragment();
        } else {
            return null;
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Battle";
            case 1:
                return "Skills";
            case 2:
                return "Dice";
            default:
                return null;
        }
    }
}
