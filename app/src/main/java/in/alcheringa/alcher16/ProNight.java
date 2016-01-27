package in.alcheringa.alcher16;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
                        Intent mIntent;
                        switch (position)
                        {
                            case 0:
                                mIntent = new Intent(getApplicationContext(), MainActivity.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 1:
                                mIntent = new Intent(getApplicationContext(), ScavengerHunt.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 2:
                                mIntent = new Intent(getApplicationContext(), Schedule.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 3:
                                mIntent = new Intent(getApplicationContext(), Map.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 4:
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.alcheringa.in/registrations"));
                                startActivity(browserIntent);
                                break;
                            case 5:
                                mIntent = new Intent(getApplicationContext(), Sponsors.class);
                                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getApplicationContext().startActivity(mIntent);
                                break;
                            case 6:
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
            case "ijp":
                SArray=getResources().getStringArray(R.array.ijp);
                break;
            case "ouzo":
                SArray=getResources().getStringArray(R.array.ouzo);
                break;
            case "tropicgreen":
                SArray=getResources().getStringArray(R.array.tropicgreen);
                break;
            case "fasta":
                SArray=getResources().getStringArray(R.array.fasta);
                break;
            case "metastasis":
                SArray=getResources().getStringArray(R.array.metastasis);
                break;
            case "omarmusa":
                SArray=getResources().getStringArray(R.array.omarmusa);
                break;
            case "tugofwar":
                SArray=getResources().getStringArray(R.array.tugofwar);
                break;
            case "snakes":
                SArray=getResources().getStringArray(R.array.snakes);
                break;
            case "penfight":
                SArray=getResources().getStringArray(R.array.penfight);
                break;
            case "gadhamaar":
                SArray=getResources().getStringArray(R.array.gadhamaar);
                break;

        }

        tv1=(TextView) findViewById(R.id.pro_night_desc);
        tv2=(TextView) findViewById(R.id.pro_night_venue);
        tv3=(TextView) findViewById(R.id.pro_night_time);
        tv1.setText(SArray[0].toString());
        tv2.setText(SArray[1].toString());
        tv3.setText(SArray[2].toString());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
