package cos.timetable.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentPagerDaysAdapter extends FragmentPagerAdapter {

    private static final String MONDAY = "Понедельник",
            TUESDAY = "Вторник",
            WEDNESDAY = "Среда",
            THURSDAY = "Четверг",
            FRIDAY = "Пятница",
            SATURDAY = "Суббота";

    List<Fragment> listFragments;

    public FragmentPagerDaysAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return MONDAY;
            case 1:
                return TUESDAY;
            case 2:
                return WEDNESDAY;
            case 3:
                return THURSDAY;
            case 4:
                return FRIDAY;
            case 5:
                return SATURDAY;
        }
        return null;
    }
}
