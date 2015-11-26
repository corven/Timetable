package cos.timetable.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cos.timetable.R;
import cos.timetable.adapters.FragmentPagerDaysAdapter;
import cos.timetable.fragments.FragmentFriday;
import cos.timetable.fragments.FragmentMonday;
import cos.timetable.fragments.FragmentSaturday;
import cos.timetable.fragments.FragmentThursday;
import cos.timetable.fragments.FragmentTuesday;
import cos.timetable.fragments.FragmentWednesday;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FragmentPagerDaysAdapter fragmentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        viewPager = (ViewPager)findViewById(R.id.pagerDays);

        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new FragmentMonday());
        listFragments.add(new FragmentTuesday());
        listFragments.add(new FragmentWednesday());
        listFragments.add(new FragmentThursday());
        listFragments.add(new FragmentFriday());
        listFragments.add(new FragmentSaturday());


        fragmentPager = new FragmentPagerDaysAdapter(
                getSupportFragmentManager(), listFragments);

        fragmentPager = new FragmentPagerDaysAdapter(getSupportFragmentManager(), listFragments);
        viewPager.setAdapter(fragmentPager);
    }

}
