package fr.hetic.g1.myapplication.viewholder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.hetic.g1.myapplication.R;

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

    public void setSelected(boolean selected) {
        // Change la couleur du texte en fonction de la selection
        Context context = nameTextView.getContext();

        int color = 0;
        if (selected) {
            color = ContextCompat.getColor(context, R.color.green);
        } else {
            color = ContextCompat.getColor(context, R.color.black);
        }

        this.nameTextView.setTextColor(color);
    }
}
