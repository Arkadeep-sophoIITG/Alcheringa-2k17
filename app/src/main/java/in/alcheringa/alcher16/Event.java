package in.alcheringa.alcher16;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class Event extends AppCompatActivity {
    public String event_name;
    SlidingTabLayout tabs;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        event_name=getIntent().getExtras().getString("eventname");
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(event_name);

        viewPager=(ViewPager) findViewById(R.id.viewpager_event);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),event_name));
        tabs=(SlidingTabLayout) findViewById(R.id.tabs_event);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);
        viewPager.setCurrentItem(0);


        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(App.item1, App.item2,App.item3,App.item4,App.item5,App.item6,App.item7)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        return true;
                    }
                })
                .build();
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] tabNames;
        String eventName;
        public MyPagerAdapter(FragmentManager fm,String event)
        {
            super(fm);
            tabNames=getResources().getStringArray(R.array.tab_names_event);
            eventName=event;
        }

        @Override
        public Fragment getItem(int position) {

            return MyFragment.getInstance(position,eventName);
        }
        @Override
        public CharSequence getPageTitle(int position)
        {
            return tabNames[position];
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
    public static class MyFragment extends Fragment{

        private ListView listView;
        private int tabposition;
        private String name;

        public static MyFragment getInstance(int position,String eventName){
            MyFragment myFragment=new MyFragment();
            Bundle args=new Bundle();
            args.putInt("position",position);
            args.putString("eventname", eventName);
            myFragment.setArguments(args);
            return myFragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
        {
            String[] listStrings;
            View layout;
            Bundle bundle=getArguments();
            if(bundle!=null)
            {
                tabposition=bundle.getInt("position");
                name=bundle.getString("eventname");
            }

            switch (tabposition)
            {
                case 0:
                    listStrings=getResources().getStringArray(R.array.ragahigh);
                    layout = inflater.inflate(R.layout.event_tab1, container, false);
                    TextView tvTag=(TextView) layout.findViewById(R.id.event_tagline);
                    TextView tvDesc=(TextView) layout.findViewById(R.id.event_desc);
                    tvTag.setText(listStrings[0]);
                    tvDesc.setText(listStrings[1]);
                    break;
                case 1:
                    listStrings=getResources().getStringArray(R.array.ragahigh);
                    layout = inflater.inflate(R.layout.event_tab2, container, false);
                    TextView tvRules=(TextView) layout.findViewById(R.id.event_rules);
                    tvRules.setText(listStrings[2]);
                    break;
                default:
                    listStrings=getResources().getStringArray(R.array.quiz);
                    layout = inflater.inflate(R.layout.event_tab2,container,false);
                    break;
            }


            return layout;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
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
}
