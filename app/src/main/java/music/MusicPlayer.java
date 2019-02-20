package music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.garethlye.fyreandruination.R;

/**
 * Created by garethlye on 10/03/2017.
 */

public class MusicPlayer extends Service {
    private String tag = "AUDIO PLAYER";
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.widows_peak_odetta_hartman);
        mp.setLooping(false);
    }
    public void onDestroy()
    {
        mp.stop();
    }
    public void onStart(Intent intent, int startid){

        Log.d(tag, "On start.....");
        mp.start();
    }

}
