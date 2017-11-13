package fr.hetic.g1.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.containerTop)
    FrameLayout containerTop;

    @BindView(R.id.containerBottom)
    FrameLayout containerBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        FragmentManager fragmentManager = getSupportFragmentManager();

        MessageFragment messageFragment = new MessageFragment();
        fragmentManager.beginTransaction()
                .add(R.id.containerTop, messageFragment)
                .commit();


        LoginFragment loginFragment = new LoginFragment();
        loginFragment.messageFragment = messageFragment;
        fragmentManager.beginTransaction()
                .add(R.id.containerBottom, loginFragment)
                .commit();













        //Drawable monIcone =
        //        ContextCompat.getDrawable(this,
        //                R.drawable.ic_launcher_foreground);

        int rouge = 2;
        int rougeRessourceIdentifier = R.color.colorAccent;
        int rougeRessource = ContextCompat.getColor(this,
                R.color.colorAccent);
        Log.d("ads", "asda");
    }

    @OnClick(R.id.goNext)
    public void goNext() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 15
                && resultCode == Activity.RESULT_CANCELED) {

            //validationText.setText("Alalal, tu as annuler");
        } else if (requestCode == 15
                && resultCode == Activity.RESULT_OK) {

            //validationText.setText("YOupie, tu as accepter les conditions generales");

        }
    }
}
