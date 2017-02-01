package in.alcheringa.alcher17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

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

        int[] images = new int[]{
                R.drawable.sch1,
                R.drawable.sch2,
                R.drawable.sch3,
                R.drawable.sch4,
                R.drawable.sch5
        };
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<5;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("flag", Integer.toString(images[i]) );
            aList.add(hm);
        }
        // Keys used in Hashmap
        String[] from = { "flag"};

        // Ids of views in listview_layout
        int[] to = { R.id.list_item_image};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.sponsors_list_item, from, to);
        ListView listView=(ListView) findViewById(R.id.list_schedule);
        listView.setAdapter(adapter);

    }


}
