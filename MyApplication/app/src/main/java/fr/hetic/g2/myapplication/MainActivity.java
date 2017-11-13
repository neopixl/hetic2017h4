package fr.hetic.g2.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    FrameLayout monContainer;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        MainFragment mainFragment = new MainFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(null)
        .commit();

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainFragment.REQUEST_CODE_CGU && resultCode == Activity.RESULT_OK) {
            //title.setText("Tu as accepté conditions");
        } else if (requestCode == MainFragment.REQUEST_CODE_CGU && resultCode == Activity.RESULT_CANCELED) {
            //title.setText("Tu as annule");
        }
    }

}
