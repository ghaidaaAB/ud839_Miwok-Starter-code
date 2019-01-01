        package com.example.android.miwok;

        import android.media.AudioManager;
        import android.media.MediaPlayer;
        import android.net.sip.SipSession;
        import android.support.v4.app.NavUtils;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;

        public class NumberActivity extends AppCompatActivity {


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_category);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new NumbersFragment())
                        .commit();
            }
            }





         

