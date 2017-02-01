package in.alcheringa.alcher17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class Proshows extends AppCompatActivity {

    private List<ConcertItem> concertItem;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshows);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

//
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

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(Proshows.this);
        rv.setLayoutManager(llm);
        initializeData();
        initializeAdapter();
    }
    private void initializeData(){
        concertItem = new ArrayList<>();
        concertItem.add(new ConcertItem("nuno", R.drawable.p2));
        concertItem.add(new ConcertItem("echo",R.drawable.p1));
        concertItem.add(new ConcertItem("raymond", R.drawable.p5));
        concertItem.add(new ConcertItem("hip", R.drawable.p3));
        concertItem.add(new ConcertItem("mad", R.drawable.madhatter));
        concertItem.add(new ConcertItem("color_ne",  R.drawable.p6));
        concertItem.add(new ConcertItem("fails",R.drawable.p7));
        concertItem.add(new ConcertItem("soul",R.drawable.p8));
    }

    private void initializeAdapter(){
        RVAdapterProshows adapter = new RVAdapterProshows(concertItem);
        rv.setAdapter(adapter);
    }

}
