package todo.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by Juzer on 2/28/14.
 */
public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int sec = 1000;
        setContentView(R.layout.splash_screen);
        new Thread(new Runnable() {
            public void run()
            {
                try {
                    Thread.sleep(sec);
                    Intent i = new Intent(SplashScreen.this, NewItem.class);
                    startActivity(i);
                    finish();
                }
                catch(Exception e) {
            }
            }
        }).start();
    }
}
