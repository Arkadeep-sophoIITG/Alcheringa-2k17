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

public class Informals extends AppCompatActivity {

    private List<ConcertItem> concertItem;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informals);

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
        LinearLayoutManager llm = new LinearLayoutManager(Informals.this);
        rv.setLayoutManager(llm);
        initializeData();
        initializeAdapter();
    }
    private void initializeData(){
        concertItem = new ArrayList<>();
        concertItem.add(new ConcertItem("Blind Dating",  R.drawable.info1));
        concertItem.add(new ConcertItem("hungergames", R.drawable.info2));
        concertItem.add(new ConcertItem("Crush", R.drawable.info3));
        concertItem.add(new ConcertItem("mysterypong", R.drawable.info4));
        concertItem.add(new ConcertItem("balloonomia", R.drawable.info5));
        concertItem.add(new ConcertItem("gamingarena", R.drawable.info7));
        concertItem.add(new ConcertItem("speeddating", R.drawable.info6));
    }

    private void initializeAdapter(){
        RVAdapterInformals adapter = new RVAdapterInformals(concertItem);
        rv.setAdapter(adapter);
    }


}
