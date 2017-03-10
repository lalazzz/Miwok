package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);

        //Creating Arraylist to an color object type for both translation
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red","weṭeṭṭi"));
        words.add(new Word("Green","chokokki"));
        words.add(new Word("Brown","ṭakaakki"));
        words.add(new Word("Gray","ṭopoppi"));
        words.add(new Word("Black","kululli"));
        words.add(new Word("White","kelelli"));
        words.add(new Word("Dusty Yellow","ṭopiisә"));
        words.add(new Word("Mustard Yellow","chiwiiṭә"));

        //Custom of arrayadapter but only one list ( this, layout , List) This only take in an array list where there is miwork and default in our case
        //Therefore, an word object class is needed to be created replacing list<t> , which is <T> object type.
        //updating the arraystring to the adapter. In this case now we have two strings under word class : object into <t> type
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this,R.layout.contentview, words);
        WordAdapter wadapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // listViewlayoutml layout file.
        GridView listView = (GridView) findViewById(R.id.gridview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(wadapter);

    }
}
