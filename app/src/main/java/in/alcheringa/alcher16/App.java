package in.alcheringa.alcher16;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by hariharan on 8/12/15.
 */
public class App extends Application {
    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "NkTjvnwS5vAucnRCjzLk1nOr5h7VaEepqvMFDEXA", "FJOvVhNswwJo3CcU5F9mbMsVRZycgpMMvDiFkgi6");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
