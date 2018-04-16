package pocket.beaters;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game);

            Button menu = findViewById(R.id.menuButton);
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

            Button Heavy = (Button) findViewById(R.id.Heavy);
            Heavy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ImageView man = (ImageView) findViewById(R.id.player);
                    man.setImageResource(R.drawable.lpunch);
                    AnimationDrawable hpunch = (AnimationDrawable) man.getDrawable();
                    hpunch.start();
                }
            });

            Button right = findViewById(R.id.Right);
            final ImageView player = findViewById(R.id.player);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* ((ViewGroup.MarginLayoutParams) image.getLayoutParams()).topMargin += 1;
                    image.requestLayout();*/
                    RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams)
                            player.getLayoutParams();
                    mParams.leftMargin += 20;
                    player.setLayoutParams(mParams);

                }
            });

        Button left = findViewById(R.id.Left);
        //final ImageView player = findViewById(R.id.player);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams)
                        player.getLayoutParams();
                mParams.leftMargin -= 20;
                player.setLayoutParams(mParams);

            }
        });
        }
    }

