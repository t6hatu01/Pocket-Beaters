package ga.me;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Heavy = (Button)findViewById(R.id.Heavy);
        Heavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView man = (ImageView)findViewById(R.id.player);
                man.setImageResource(R.drawable.lpunch);
                AnimationDrawable hpunch = (AnimationDrawable) man.getDrawable();
                hpunch.start();
            }
        });
        Button button = findViewById(R.id.Right);
        final ImageView image = findViewById(R.id.player);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin += 1;
                image.requestLayout();
            }
        });

    }
}
