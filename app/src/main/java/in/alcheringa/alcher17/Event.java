package in.alcheringa.alcher17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//        Drawer drawer = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withTranslucentStatusBar(false)
//                .withActionBarDrawerToggle(true)
//                .withActionBarDrawerToggleAnimated(true)
//                .addDrawerItems(App.item1, App.item2,App.item3,App.item4,App.item5,App.item6,App.item7)
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        Intent mIntent;
//                        switch (position)
//                        {
//                            case 0:
//                                mIntent = new Intent(getApplicationContext(), MainActivity.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                            case 1:
//                                mIntent = new Intent(getApplicationContext(), ScavengerHunt.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                            case 2:
//                                mIntent = new Intent(getApplicationContext(), Schedule.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                            case 3:
//                                mIntent = new Intent(getApplicationContext(), Map.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                            case 4:
//                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.alcheringa.in/registrations"));
//                                startActivity(browserIntent);
//                                break;
//                            case 5:
//                                mIntent = new Intent(getApplicationContext(), Sponsors.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                            case 6:
//                                mIntent = new Intent(getApplicationContext(), ContactUs.class);
//                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                getApplicationContext().startActivity(mIntent);
//                                break;
//                        }
//                        return true;
//                    }
//                })
//                .build();

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(App.item1,App.item2,App.item3,App.item4,App.item5,App.item6)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Intent mIntent;
                        switch (position)
                        {
                            case 0:
                                mIntent = new Intent(getApplicationContext(), MainActivity.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 1:
                                mIntent = new Intent(getApplicationContext(), Schedule.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 2:
                                mIntent = new Intent(getApplicationContext(), Map.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 3:
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.alcheringa.in/registrations"));
                                startActivity(browserIntent);
                                break;
                            case 4:
                                mIntent = new Intent(getApplicationContext(), Sponsors.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 5:
                                mIntent = new Intent(getApplicationContext(), ContactUs.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                        }
                        return true;
                    }
                })
                .build();



        viewPager=(ViewPager) findViewById(R.id.viewpager_event);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),event_name));
        tabs=(SlidingTabLayout) findViewById(R.id.tabs_event);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);
        viewPager.setCurrentItem(0);

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
            return 1;
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

            switch (name)
            {
                case "Raga High":
                    listStrings=getResources().getStringArray(R.array.ragahigh);
                    break;
                case "Voice Of Alcheringa":
                    listStrings=getResources().getStringArray(R.array.voiceofalcheringa);
                    break;
                case "Unplugged":
                    listStrings=getResources().getStringArray(R.array.unplugged);
                    break;
                case "Electric Heels":
                    listStrings=getResources().getStringArray(R.array.electricheels);
                    break;
                case "Step Up":
                    listStrings=getResources().getStringArray(R.array.stepup);
                    break;
                case "So You Think You Can Dance":
                    listStrings=getResources().getStringArray(R.array.soyouthinkyoucandance);
                    break;
                case "Nach Baliye":
                    listStrings=getResources().getStringArray(R.array.nachbaliye);
                    break;
                case "Navras":
                    listStrings=getResources().getStringArray(R.array.navras);
                    break;

                case "Rock-o-Phonix":
                    listStrings=getResources().getStringArray(R.array.rockophonix);
                    break;
                case "Haute Couture":
                    listStrings=getResources().getStringArray(R.array.hautecouture);
                    break;
                case "Mr and Miss Alcheringa":
                    listStrings=getResources().getStringArray(R.array.mrandmissalcheringa);
                    break;
                case "Crossfade":
                    listStrings=getResources().getStringArray(R.array.crossfade);
                    break;
                case "Roadiez":
                    listStrings=getResources().getStringArray(R.array.roadiez);
                    break;
                case "Custom Brush":
                    listStrings=getResources().getStringArray(R.array.custombrush);
                    break;
                case "Minimal Poster":
                    listStrings=getResources().getStringArray(R.array.minimalposter);
                    break;
                case "Alcher Diva/Hunk":
                    listStrings=getResources().getStringArray(R.array.alcherdivahunk);
                    break;
                case "Snapthrillz":
                    listStrings=getResources().getStringArray(R.array.snapthrillz);
                    break;
                case "Director/'s Cut":
                    listStrings=getResources().getStringArray(R.array.directorscut);
                    break;
                case "Doodle Pad":
                    listStrings=getResources().getStringArray(R.array.doodlepad);
                    break;
                case "The Big Picture":
                    listStrings=getResources().getStringArray(R.array.thebigpicture);
                    break;
                case "Ink The Tee":
                    listStrings=getResources().getStringArray(R.array.inkthetee);
                    break;
                case "Comic Con":
                    listStrings=getResources().getStringArray(R.array.comiccon);
                    break;
                case "Rangoli":
                    listStrings=getResources().getStringArray(R.array.rangoli);
                    break;
                case "Your Face My Canvas":
                    listStrings=getResources().getStringArray(R.array.faceless);
                    break;
                case "Theatrix":
                    listStrings=getResources().getStringArray(R.array.theatrix);
                    break;
                case "Halla Bol":
                    listStrings=getResources().getStringArray(R.array.hallabol);
                    break;
                case "Mute":
                    listStrings=getResources().getStringArray(R.array.mute);
                    break;
                case "Just A Minute":
                    listStrings=getResources().getStringArray(R.array.justaminute);
                    break;
                case "Poetry Slam":
                    listStrings=getResources().getStringArray(R.array.poetryslam);
                    break;
                case "Parliamentary Debate":
                    listStrings=getResources().getStringArray(R.array.parlimentarydebate);
                    break;
                case "Zephyr":
                    listStrings=getResources().getStringArray(R.array.zephyr);
                    break;
                case "MUN":
                    listStrings=getResources().getStringArray(R.array.mun);
                    break;
                case "3 v 3 Basketball":
                    listStrings=getResources().getStringArray(R.array.basketball);
                    break;
                case "Arm Wrestling":
                    listStrings=getResources().getStringArray(R.array.armwrestling);
                    break;
                case "Gully Cricket":
                    listStrings=getResources().getStringArray(R.array.gullycricket);
                    break;
                case "5 on 5 Football":
                    listStrings=getResources().getStringArray(R.array.football);
                    break;
                case "MELA Quiz":
                    listStrings=getResources().getStringArray(R.array.melaquiz);
                    break;
                default:
                    listStrings=getResources().getStringArray(R.array.melaquiz);
            }

            switch (tabposition)
            {
                case 0:
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
                    layout = inflater.inflate(R.layout.event_tab1,container,false);
                    break;
            }


            return layout;
        }
    }

}
