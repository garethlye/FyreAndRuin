package music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.garethlye.fyreandruination.R;

/**
 * Created by garethlye on 09/03/2017.
 */

public class AudioPlayer extends Service {

    private String LOGCAT = "AUDIO PLAYER";
    MediaPlayer objPlayer;

    public void onCreate() {
        super.onCreate();
        objPlayer = MediaPlayer.create(this, R.raw.widows_peak_odetta_hartman);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        objPlayer.start();
        Log.d(LOGCAT, "Media Player started!");
        if(!objPlayer.isLooping()){
            Log.d(LOGCAT, "Problem in Playing Audio");
        }
        return Service.START_NOT_STICKY;        ///.......THIS IS PROBABLY WRONG, PLEASE REFER TO THIS IF THERE IS A SONG ERROR. I SIMPLY ADDED IT IN.
    }

    public void onStop(){
        objPlayer.stop();
        objPlayer.release();
    }

    public void onPause(){
        objPlayer.stop();
        objPlayer.release();
    }

    public void onDestroy(){
        objPlayer.stop();
        objPlayer.release();
    }


    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }
}
