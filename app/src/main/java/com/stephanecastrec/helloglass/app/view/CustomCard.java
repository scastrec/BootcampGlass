package com.stephanecastrec.helloglass.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stephanecastrec.helloglass.app.R;

/**
 * @author SCA
 * @date 21/05/2014.
 */
public class CustomCard extends FrameLayout {


    public CustomCard(Context context) {
        super(context);
    }

    /**
     *  Ctor
     */
    public CustomCard (final Context context, int img, int text){
        super(context);
        initView(context, img, text);

    }

    private void initView(final Context context, int img, int text){
        View view = LayoutInflater.from(context).inflate(R.layout.view_custom_card, null);
        ((ImageView)view.findViewById(R.id.sponsor_img)).setImageResource(img);
        ((TextView)view.findViewById(R.id.sponsor_name)).setText(context.getString(text));
        this.addView(view);
    }
}
