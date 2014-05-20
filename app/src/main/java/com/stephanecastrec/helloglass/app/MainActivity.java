package com.stephanecastrec.helloglass.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.glass.app.Card;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardScrollView;
import com.stephanecastrec.helloglass.app.adapter.MyCardScrollAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        MyCardScrollAdapter adapter = new MyCardScrollAdapter(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tappedCard();
            }
        });
    }

    /**
     * Create cards to display.
     */
    private void createCards() {
        mCards = new ArrayList<Card>();

        Card card;

        card = new Card(this);
        card.setText("Welcome to bootcamp");
        card.setFootnote("swipe to see next cards");
        mCards.add(card);

        card = new Card(this);
        card.setText("Do you like this?");
        card.setFootnote("swipe again!");
        card.setImageLayout(Card.ImageLayout.FULL);
        card.addImage(R.drawable.android_logo_small);
        mCards.add(card);

        card = new Card(this);
        card.setText("This card has a mosaic of puppies.");
        card.setFootnote("you can go back in your swipe!!");
        card.setImageLayout(Card.ImageLayout.LEFT);
        card.addImage(R.drawable.ic_launcher);
        card.addImage(R.drawable.android_logo_small);
        mCards.add(card);
    }

    /**
     * Action to do when you have a card tapped.
     */
    private void tappedCard() {
        int i = mCardScrollView.getSelectedItemPosition();
        Toast.makeText(this, this.getString(R.string.card_tapped) + i, Toast.LENGTH_SHORT).show();
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
