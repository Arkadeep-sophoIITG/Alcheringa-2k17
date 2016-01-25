package in.alcheringa.alcher16;

import android.app.Application;
import android.content.Context;

import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by hariharan on 8/12/15.
 */
public class App extends Application {
    static Context context;
    static PrimaryDrawerItem item1,item2,item3,item4,item5,item6,item7;
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "KMJ2j4Re9BRHVB8EsoRBoUv7YIMl0xANgWSU8aVx", "29jNOfMaIxo9Tp0Cm9Tn67SaqE0WsOlxBdqyW7jZ");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        item1 = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.home);
        item2 = new PrimaryDrawerItem().withName("About Us").withIcon(R.drawable.about);
        item3 = new PrimaryDrawerItem().withName("Games").withIcon(R.drawable.games);
        item4 = new PrimaryDrawerItem().withName("Schedule").withIcon(R.drawable.schedule);
        item5 = new PrimaryDrawerItem().withName("Map").withIcon(R.drawable.map);
        item6 = new PrimaryDrawerItem().withName("Registration").withIcon(R.drawable.registration);
        item7 = new PrimaryDrawerItem().withName("Contact Us").withIcon(R.drawable.contactus);
    }
}
