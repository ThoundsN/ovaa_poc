package oversecured.plugin.assassin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class UNPROTECTED_CREDENTIALS_DATA_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            Log.d("evil", "Payload: " + intent.getExtras().get("payload"));
    }
}
