package fr.hetic.g1.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.nameTextView)
    TextView nameTextView;

    public ContactViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setName(String name) {
        this.nameTextView.setText(name);
    }
}
