package fr.hetic.g1.myapplication;

import android.view.View;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

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
        return new ContactViewHolder(v);
    }

    @Override
    public void bindView(ContactViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        holder.setName(this.name);
        holder.setSelected(this.isSelected());
    }
}
