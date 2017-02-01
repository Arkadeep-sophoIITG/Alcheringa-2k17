package in.alcheringa.alcher17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class ProNight extends AppCompatActivity {
    private String type;
    TextView tv1,tv2,tv3;
    private String name;
    private String[] SArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name=getIntent().getExtras().getString("name");
        setContentView(R.layout.activity_pro_night);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Information");
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

        switch (name)
        {
            case "saaz":
                SArray=getResources().getStringArray(R.array.saaz);
                break;
            case "blitz":
                SArray=getResources().getStringArray(R.array.blitz);
                break;
            case "crescendo":
                SArray=getResources().getStringArray(R.array.crescendo);
                break;
            case "juggernaut":
                SArray=getResources().getStringArray(R.array.juggernaut);
                break;
            case "juggernaut2":
                SArray=getResources().getStringArray(R.array.juggernaut2);
                break;
            case "mad":
                SArray=getResources().getStringArray(R.array.mad);
                break;
            case "echo":
                SArray=getResources().getStringArray(R.array.echo);
                break;
            case "nuno":
                SArray=getResources().getStringArray(R.array.nuno);
                break;
            case "hip":
                SArray=getResources().getStringArray(R.array.hip);
                break;
            case "raymond":
                SArray=getResources().getStringArray(R.array.raymond);
                break;
            case "color_ne":
                SArray=getResources().getStringArray(R.array.color_ne);
                break;
            case "fails":
                SArray=getResources().getStringArray(R.array.fails);
                break;
            case "soul":
                SArray=getResources().getStringArray(R.array.soul);
                break;

            case "Blind Dating":
                SArray=getResources().getStringArray(R.array.blind_date);
                break;
            case "hungergames":
                SArray=getResources().getStringArray(R.array.hungergames);
                break;
            case "Crush":
                SArray=getResources().getStringArray(R.array.crush);
                break;
            case "mysterypong":
                SArray=getResources().getStringArray(R.array.mysterypong);
                break;
            case "balloonomia":
                SArray=getResources().getStringArray(R.array.balloonomia);
                break;
            case "gamingarena":
                SArray=getResources().getStringArray(R.array.gamingarena);
                break;
            case "speeddating":
                SArray=getResources().getStringArray(R.array.speeddating);
                break;


        }

        tv1=(TextView) findViewById(R.id.pro_night_desc);
        tv2=(TextView) findViewById(R.id.pro_night_venue);
        tv3=(TextView) findViewById(R.id.pro_night_time);
        tv1.setText(SArray[0].toString());
        tv2.setText(SArray[1].toString());
        tv3.setText(SArray[2].toString());



    }

}
