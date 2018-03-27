package pocket.game;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton playb;
    private ImageButton shopb;
    private ImageButton settb;
    private ImageButton credb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        playb = findViewById(R.id.playButton);
        playb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

        shopb = findViewById(R.id.shopButton);
        shopb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop();
            }
        });

        settb = findViewById(R.id.setButton);
        settb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings();
            }
        });

        credb = findViewById(R.id.credButton);
        credb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credits();
            }
        });
    }
    public void play(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void shop(){
        Intent intent2 = new Intent(this, ShopActivity.class);
        startActivity(intent2);
    }

    public void settings(){
        Intent intent3 = new Intent(this, SettingsActivity.class);
        startActivity(intent3);
    }

    public void credits(){
        Intent intent4 = new Intent(this, CreditActivity.class);
        startActivity(intent4);
    }

}
