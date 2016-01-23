package in.alcheringa.alcher16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

public class Competitions extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView main,i0,i1,i2,i3,i4,i5,i6,i7,i8;
    private int iterator=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        main =(ImageView) findViewById(R.id.image_comp_main);
        main.setImageResource(R.drawable.a);
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

        i0.setImageResource(R.drawable.a);
        i1.setImageResource(R.drawable.b);
        i2.setImageResource(R.drawable.c);
        i3.setImageResource(R.drawable.c);
        i4.setImageResource(R.drawable.b);
        i5.setImageResource(R.drawable.a);
        i6.setImageResource(R.drawable.a);
        i7.setImageResource(R.drawable.b);
        i8.setImageResource(R.drawable.c);

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
        getMenuInflater().inflate(R.menu.menu_competitions, menu);
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
