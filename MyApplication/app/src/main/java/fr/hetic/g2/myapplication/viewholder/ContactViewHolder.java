package fr.hetic.g2.myapplication.viewholder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.hetic.g2.myapplication.R;

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

    public void setName(String newName) {
        this.nameTextView.setText(newName);
    }

    public void setIsSelected(boolean selected) {
        Context context = nameTextView.getContext();
        int color = 0;
        if (selected) {
            color = ContextCompat.getColor(context, R.color.red);
        } else {
            color = ContextCompat.getColor(context, R.color.black);
        }

        nameTextView.setTextColor(color);
    }
}
