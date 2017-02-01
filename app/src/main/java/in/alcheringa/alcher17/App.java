package in.alcheringa.alcher17;

import android.app.Application;
import android.content.Context;

import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;



/**
 * Created by hariharan on 8/12/15.
 */
public class App extends Application {
    static Context context;
    static PrimaryDrawerItem item1,item2,item3,item4,item5,item6,item7;
    @Override
    public void onCreate() {
        super.onCreate();
        item1 = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.home);
        item2 = new PrimaryDrawerItem().withName("Schedule").withIcon(R.drawable.schedule);
        item3 = new PrimaryDrawerItem().withName("Map").withIcon(R.drawable.map);
        item4 = new PrimaryDrawerItem().withName("Registration").withIcon(R.drawable.registration);
        item5 = new PrimaryDrawerItem().withName("Sponsors").withIcon(R.drawable.about);
        item6 = new PrimaryDrawerItem().withName("Contact Us").withIcon(R.drawable.contactus);

    }
}
