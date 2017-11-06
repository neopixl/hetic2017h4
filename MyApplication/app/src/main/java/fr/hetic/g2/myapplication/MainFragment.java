package fr.hetic.g2.myapplication;


import android.app.Activity;
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
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    static int REQUEST_CODE_CGU = 15;

    @BindView(R.id.validationButton)
    Button validationButton;
    @BindView(R.id.editTextEmail)
    EditText emailEditText;
    @BindView(R.id.editTextPassword)
    EditText passwordEditText;
    @BindView(R.id.textViewTitle)
    TextView title;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @OnClick(R.id.validationButton)
    void didClickOnTheValidationButton() {
        Log.d("LOL", "J'ai cliquer");


        String email = emailEditText.getText().toString(); // Email taper
        String password = passwordEditText.getText().toString(); // password taper

        if (email.equals("florian@neopixl.com")
                && password.equals("flori4n")) {
            title.setText("YOUPIE !!!");


            Intent newIntent = new Intent(getContext(), LoggedActivity.class);
            startActivityForResult(newIntent, REQUEST_CODE_CGU);

        } else {
            title.setText("YOU SHALL NOT PASS !!");
        }

        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);


        AlertDialog alertDialog = new AlertDialog
                .Builder(getContext())
                .setTitle("Titre")
                .setMessage("Youpie tu as essayé de te connecter")
                .setCancelable(false)
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("Peut-etre", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();

        //alertDialog.show();

        //alertDialog.dismiss();
        //alertDialog.cancel();
    }

}
