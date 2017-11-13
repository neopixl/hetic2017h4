package fr.hetic.g1.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.validationButton)
    Button myButtonValidation;

    @BindView(R.id.editTextEmail)
    EditText emailEditText;
    @BindView(R.id.editTextPassword)
    EditText passwordEditText;

    @BindView(R.id.distantImageView)
    ImageView imageView;

    MessageFragment messageFragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);

        Glide.with(this)
                .load("https://www.placecage.com/50/50")
                .into(imageView);

        return root;
    }


    @OnClick(R.id.validationButton)
    void onValidationClick() {
        Log.d("LOL", "J'ai cliquer");


        InputMethodManager manager = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(),0);


        String monEmail = emailEditText.getText().toString(); // Recupere mon Email
        String monPassword = passwordEditText.getText().toString(); // Recupere mon Password

        String messageFinal = "";

        if (monEmail.equals("florian@neopixl.com")
                && monPassword.equals("flori4n")) {
            messageFinal = "Youpie c'est moi";
        } else {
            messageFinal = "Ah zut, c'est pas moi";
        }

        if (messageFragment != null) {
            messageFragment.setMessage(messageFinal);
        }




        //Intent newIntent = new Intent(this, LoggedActivity.class);
        //startActivity(newIntent);

        //startActivityForResult(newIntent, 15);



        //AlertDialog alertDialog = new AlertDialog
        //        .Builder(this)
        //        .setMessage("Coucou")
        //        .setTitle("Mon title")
        //        .setCancelable(false)
        //        .setPositiveButton("Mon button", new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialogInterface, int i) {
        //                Log.d("LOL", "J'ai cliquer sur mon bouton");
        //            }
        //        })
        //       .create();

        //alertDialog.show();
    }

}
