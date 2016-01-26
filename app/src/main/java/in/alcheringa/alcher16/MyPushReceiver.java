package in.alcheringa.alcher16;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hariharan on 26/1/16.
 */
public class MyPushReceiver extends ParsePushBroadcastReceiver {
    String push;
    @Override
    protected void onPushReceive(Context context, Intent intent) {
        super.onPushReceive(context, intent);
        String pushDataStr = intent.getStringExtra("com.parse.Data");
        Log.d("Push Received",pushDataStr);
        try {
            JSONObject jsonResult = new JSONObject(pushDataStr);
            push=jsonResult.getString("alert");
            Log.d("Parsed Push",push);
            LogPush(push);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void LogPush(String text) {
        File file = new File(Environment.getExternalStorageDirectory()+ "/alcheringa/pushlog.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(file, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
