package thompson.bernard.bernardthompsonca1.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thompson.bernard.bernardthompsonca1.Activities.MainActivity;
import thompson.bernard.bernardthompsonca1.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }

        };
        splashThread.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
