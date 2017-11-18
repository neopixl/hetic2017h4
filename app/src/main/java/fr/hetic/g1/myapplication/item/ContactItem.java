package fr.hetic.g1.myapplication.item;

import android.view.View;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import fr.hetic.g1.myapplication.viewholder.ContactViewHolder;
import fr.hetic.g1.myapplication.R;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class ContactItem extends AbstractItem<ContactItem, ContactViewHolder> {

    public String name;

    @Override
    public int getType() {
        // Type de la cellule, ici on as que 1 type donc tous le temps zero
        return 0;
    }

    @Override
    public int getLayoutRes() {
        // Design de la cellule
        return R.layout.row_contact;
    }

    @Override
    public ContactViewHolder getViewHolder(View v) {
        // Crée un view hodler vierge
        return new ContactViewHolder(v);
    }

    @Override
    public void bindView(ContactViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        // Cette fonction est appeller quand la recycler view affiche une cellule en particulier
        // Donc il faut definir les valeurs
        holder.setName(this.name);
        holder.setSelected(this.isSelected());
    }
}
