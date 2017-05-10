package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vishwa on 6/5/17.
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide teh layout for each list
 * based on a data source, which is list of {@link ArrayList} objects.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId ;
    /**
     * Provides a view for an AdapterView (ListView , Gridview, etc.)
     *
     * @param position The Position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent  The parent ViewGroup that is used for inlation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }
        // Get the {@link word} object at this position in the list
        Word currentWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // get the default translation from the current word object and
        // set the Text on the nameTextView
        nameTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item with layout id of miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //Get the miwok translation from the current word object
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item with layout id of image
        ImageView miwokImage = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image from the current word object
        // set this if it is not zero
        if(currentWord.hasImage()) {
            miwokImage.setImageResource(currentWord.getmImageResourceId());
            // Make the View visible
            miwokImage.setVisibility(View.VISIBLE);
        } else {
            // otherwise hide the iMageView (set visibility to GONE)
            miwokImage.setVisibility(View.GONE);
        }

        // Getting the parent of TextView which contain texts
        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containging 2 TextView)
        // so that it can be shown in the ListView
        return listItemView;

    }

    /**
     * constructor for providing extra color
     * @param context current context , used to inflate the layout file.
     * @param word A List of ArrayList<Word> object to display in a list
     * @param colorResourceId A color resource id for list_item
     */
    WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId )
    {
        super(context, 0 , word);
        // assigning the color resource id as colorResourceId
        mColorResourceId = colorResourceId;

    }
}
