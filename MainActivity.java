package ga.me;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Light = (Button)findViewById(R.id.Light);
        Light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView man = (ImageView)findViewById(R.id.player);
                man.setImageResource(R.drawable.lpunch);
                AnimationDrawable lpunch = (AnimationDrawable) man.getDrawable();
                lpunch.start();
            }
        });

        Button Heavy = (Button)findViewById(R.id.Heavy);
        Heavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView man = (ImageView)findViewById(R.id.player);
                man.setImageResource(R.drawable.hpunch);
                AnimationDrawable hpunch = (AnimationDrawable) man.getDrawable();
                hpunch.start();
            }
        });

        final Button Forward = (Button)findViewById(R.id.Forward);
        final ImageView player = findViewById(R.id.player);
        Forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView man = (ImageView)findViewById(R.id.player);
                man.setImageResource(R.drawable.moveright);
                AnimationDrawable moveright = (AnimationDrawable) man.getDrawable();
                moveright.start();
                RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams)
                        player.getLayoutParams();
                mParams.leftMargin += 20;
                player.setLayoutParams(mParams);

            }
        });

        final Button Backward = (Button)findViewById(R.id.Backward);
        Backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView man = (ImageView)findViewById(R.id.player);
                man.setImageResource(R.drawable.backwards);
                AnimationDrawable backwards = (AnimationDrawable) man.getDrawable();
                backwards.start();
                RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams)
                        player.getLayoutParams();
                mParams.leftMargin -= 20;
                player.setLayoutParams(mParams);
            }
        });



        Button button = findViewById(R.id.blank);
        final ImageView image = findViewById(R.id.player);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin += 1;
                image.requestLayout();
            }
        });


    }}
