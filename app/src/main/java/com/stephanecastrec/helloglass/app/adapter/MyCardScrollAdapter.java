package com.stephanecastrec.helloglass.app.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

/**
 * Adapter in charge of displaying cards.
 * @author SCA
 * @date 20/05/2014.
 */
public class MyCardScrollAdapter extends CardScrollAdapter {

    private ArrayList<Card> mCards = null;

    public MyCardScrollAdapter(final ArrayList<Card> cards){
        this.mCards = cards;
    }

    @Override
    public int getPosition(Object item) {
        return mCards.indexOf(item);
    }

    @Override
    public int getCount() {
        if(mCards == null)
            return 0;
        return mCards.size();
    }

    @Override
    public Object getItem(int position) {
        return mCards.get(position);
    }

    /**
     * Returns the amount of view types.
     */
    @Override
    public int getViewTypeCount() {
        return Card.getViewTypeCount();
    }

    /**
     * Returns the view type of this card so the system can figure out
     * if it can be recycled.
     */
    @Override
    public int getItemViewType(int position){
        return mCards.get(position).getItemViewType();
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        return  mCards.get(position).getView(convertView, parent);
    }
}
