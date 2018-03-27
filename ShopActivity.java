package pocket.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Tuhlu on 19.3.2018.
 */

public class ShopActivity extends AppCompatActivity {

    int coins = 50;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Button menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        ImageButton item = findViewById(R.id.buyButton1);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coins > 0)
                {
                    coins = coins - 5;
                    TextView coin = (TextView) findViewById(R.id.textCoins);
                    coin.setText("" + coins);
                }
            }
        });

        ImageButton item2 = findViewById(R.id.buyButton2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coins >= 30)
                {
                    coins = coins - 30;
                    TextView coin = (TextView) findViewById(R.id.textCoins);
                    coin.setText("" + coins);
                }
            }
        });
    }
}