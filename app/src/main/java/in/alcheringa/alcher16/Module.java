package in.alcheringa.alcher16;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class Module extends AppCompatActivity {
    private int tabposition;
    SlidingTabLayout tabs;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        tabposition = getIntent().getExtras().getInt("position");
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs=(SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        viewPager.setCurrentItem(tabposition);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                switch (position) {
                    case 0:
                    return getResources().getColor(R.color.tab1);
                    case 1:
                        return getResources().getColor(R.color.tab2);
                    case 2:
                        return getResources().getColor(R.color.tab3);
                    case 3:
                        return getResources().getColor(R.color.tab4);
                    case 4:
                        return getResources().getColor(R.color.tab5);
                    case 5:
                        return getResources().getColor(R.color.tab6);
                    case 6:
                        return getResources().getColor(R.color.tab7);
                    case 7:
                        return getResources().getColor(R.color.tab8);
                    case 8:
                        return getResources().getColor(R.color.tab9);
                    default:
                        return getResources().getColor(R.color.tab9);

                }
            }

        });

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
        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
            tabNames=getResources().getStringArray(R.array.tab_names);
        }

        @Override
        public Fragment getItem(int position) {

            return MyFragment.getInstance(position);
        }
        @Override
        public CharSequence getPageTitle(int position)
        {
            return tabNames[position];
        }

        @Override
        public int getCount() {
            return 9;
        }
    }
    public static class MyFragment extends Fragment{

        private ListView listView;
        private ImageView imageView;
        private int tabposition;

        public static MyFragment getInstance(int position){
            MyFragment myFragment=new MyFragment();
            Bundle args=new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);
            return myFragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
        {
            String[] listStrings;
            View layout = inflater.inflate(R.layout.tab_page,container,false);
            listView=(ListView) layout.findViewById(R.id.list);
            Bundle bundle=getArguments();
            if(bundle!=null)
            {
                tabposition=bundle.getInt("position");
            }
            switch (tabposition)
            {
                case 0:
                    listStrings=getResources().getStringArray(R.array.music);
                    break;
                case 1:
                    listStrings=getResources().getStringArray(R.array.dance);
                    break;
                case 2:
                    listStrings=getResources().getStringArray(R.array.classapart);
                    break;
                case 3:
                    listStrings=getResources().getStringArray(R.array.digitalarts);
                    break;
                case 4:
                    listStrings=getResources().getStringArray(R.array.finearts);
                    break;
                case 5:
                    listStrings=getResources().getStringArray(R.array.performingarts);
                    break;
                case 6:
                    listStrings=getResources().getStringArray(R.array.literary);
                    break;
                case 7:
                    listStrings=getResources().getStringArray(R.array.sports);
                    break;
                case 8:
                    listStrings=getResources().getStringArray(R.array.quiz);
                    break;
                default:
                    listStrings=getResources().getStringArray(R.array.quiz);
                    break;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.module_list_item, R.id.list_item_text, listStrings);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    String  itemValue    = (String) listView.getItemAtPosition(position);
                    Intent mIntent = new Intent(getActivity().getApplicationContext(), Event.class);
                    mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mIntent.putExtra("eventname", itemValue);
                    getActivity().getApplicationContext().startActivity(mIntent);
                }

            });

            return layout;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_module, menu);
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
