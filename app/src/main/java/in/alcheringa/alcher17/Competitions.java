package in.alcheringa.alcher17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class Competitions extends AppCompatActivity {
    private ImageView main,i0,i1,i2,i3,i4,i5,i6,i7,i8;
    private int iterator=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

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

        main =(ImageView) findViewById(R.id.image_comp_main);
        main.setImageResource(R.drawable.comp);
        main.setScaleType(ImageView.ScaleType.FIT_XY);

        i0 = (ImageView) findViewById(R.id.comp_grid_iv1);
        i1 = (ImageView) findViewById(R.id.comp_grid_iv2);
        i2 = (ImageView) findViewById(R.id.comp_grid_iv3);
        i3 = (ImageView) findViewById(R.id.comp_grid_iv4);
        i4 = (ImageView) findViewById(R.id.comp_grid_iv5);
        i5 = (ImageView) findViewById(R.id.comp_grid_iv6);
        i6 = (ImageView) findViewById(R.id.comp_grid_iv7);
        i7 = (ImageView) findViewById(R.id.comp_grid_iv8);
        i8 = (ImageView) findViewById(R.id.comp_grid_iv9);

        i0.setImageResource(R.drawable.music);
        i1.setImageResource(R.drawable.dance);
        i2.setImageResource(R.drawable.classapart);
        i3.setImageResource(R.drawable.digital);
        i4.setImageResource(R.drawable.fine);
        i5.setImageResource(R.drawable.perfor);
        i6.setImageResource(R.drawable.lit);
        i7.setImageResource(R.drawable.sports);
        i8.setImageResource(R.drawable.quiz);

        i0.setScaleType(ImageView.ScaleType.FIT_XY);
        i1.setScaleType(ImageView.ScaleType.FIT_XY);
        i2.setScaleType(ImageView.ScaleType.FIT_XY);
        i3.setScaleType(ImageView.ScaleType.FIT_XY);
        i4.setScaleType(ImageView.ScaleType.FIT_XY);
        i5.setScaleType(ImageView.ScaleType.FIT_XY);
        i6.setScaleType(ImageView.ScaleType.FIT_XY);
        i7.setScaleType(ImageView.ScaleType.FIT_XY);
        i8.setScaleType(ImageView.ScaleType.FIT_XY);



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick1(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 0);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick2(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 1);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick3(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 2);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick4(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position",3);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick5(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 4);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick6(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 5);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick7(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 6);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick8(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 7);
        Competitions.this.startActivity(mIntent);
    }
    public void onClick9(View view) {
        Intent mIntent = new Intent(this, Module.class);
        mIntent.putExtra("position", 8);
        Competitions.this.startActivity(mIntent);
    }
}
