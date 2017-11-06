package fr.hetic.g1.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

    @BindView(R.id.validationButton)
    Button myButtonValidation;

    @BindView(R.id.editTextEmail) EditText emailEditText;
    @BindView(R.id.editTextPassword) EditText passwordEditText;

    @BindView(R.id.textValidation)
    TextView validationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.validationButton)
    void onValidationClick() {
        Log.d("LOL", "J'ai cliquer");


        String monEmail = emailEditText.getText().toString(); // Recupere mon Email
        String monPassword = passwordEditText.getText().toString(); // Recupere mon Password

        if (monEmail.equals("florian@neopixl.com")
                && monPassword.equals("flori4n")) {
            validationText.setText("Youpie c'est moi");

            Intent newIntent = new Intent(this, LoggedActivity.class);
            //startActivity(newIntent);

            startActivityForResult(newIntent, 15);






        } else {
            validationText.setText("Ah zut, c'est pas moi");

            InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);


            AlertDialog alertDialog = new AlertDialog
                    .Builder(this)
                    .setMessage("Coucou")
                    .setTitle("Mon title")
                    .setCancelable(false)
                    .setPositiveButton("Mon button", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("LOL", "J'ai cliquer sur mon bouton");
                        }
                    })
                    .create();

            alertDialog.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 15
                && resultCode == Activity.RESULT_CANCELED) {

            validationText.setText("Alalal, tu as annuler");
        } else if (requestCode == 15
                && resultCode == Activity.RESULT_OK) {

            validationText.setText("YOupie, tu as accepter les conditions generales");

        }
    }
}
