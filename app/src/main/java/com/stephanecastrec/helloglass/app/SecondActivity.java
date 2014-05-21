package com.stephanecastrec.helloglass.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;
import com.stephanecastrec.helloglass.app.adapter.CustomScrollAdapter;
import com.stephanecastrec.helloglass.app.adapter.MyCardScrollAdapter;
import com.stephanecastrec.helloglass.app.view.CustomCard;

import java.util.ArrayList;


public class SecondActivity extends Activity {

    private ArrayList<CustomCard> mCards;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    /**
     * Create cards to display.
     */
    private void createCards() {
        mCards = new ArrayList<CustomCard>();

        mCards.add(new CustomCard(this, R.drawable.cantine, R.string.sponsor_cantine));
        mCards.add(new CustomCard(this, R.drawable.arkea, R.string.sponsor_arkea));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
