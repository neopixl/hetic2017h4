package fr.hetic.g2.myapplication.item;

import android.view.View;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import fr.hetic.g2.myapplication.R;
import fr.hetic.g2.myapplication.viewholder.ContactViewHolder;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class ContactItem extends AbstractItem<ContactItem, ContactViewHolder> {

    public String name;

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_contact;
    }

    @Override
    public ContactViewHolder getViewHolder(View v) {
        ContactViewHolder holder = new ContactViewHolder(v);
        return holder;
    }

    @Override
    public void bindView(ContactViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        holder.setName(this.name);
        holder.setIsSelected(this.isSelected());
    }
}
