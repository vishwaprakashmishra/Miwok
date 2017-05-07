package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vishwa on 6/5/17.
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide teh layout for each list
 * based on a data source, which is list of {@link ArrayList} objects.
 */

public class WordAdapter extends ArrayAdapter<Word> {
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
        // Return the whole list item layout (containging 2 TextView)
        // so that it can be shown in the ListView
        return listItemView;

    }

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context, Used to inflate the layout file.
     * @param word  A list of ArrayList<Word> object to display in a list
     */
    WordAdapter(Activity context, ArrayList<Word> word){
        // Here , we ititialize the ArrayAdapter's internal storage for the context and the list
        // the second argument is used when the ArrayAdapter is  populating a single TextView.
        // Because this is a custom adapter for two TextView , the adapter is
        // going to use this second argument, so it can be any value. Here , we used 0.
        super(context, 0, word);
    }
}
