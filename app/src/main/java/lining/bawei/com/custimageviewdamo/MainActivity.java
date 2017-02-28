package lining.bawei.com.custimageviewdamo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int SUCCESS = 0;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SUCCESS:

                    break;
            }
        }
    };
    private CustomImageView customImageView;
    private int progress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customImageView = (CustomImageView) findViewById(R.id.cust);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(progress == 100){
                        handler.sendEmptyMessage(SUCCESS);
                        return;
                    }
                    progress ++;
                    customImageView.setProgress(progress);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }
}
