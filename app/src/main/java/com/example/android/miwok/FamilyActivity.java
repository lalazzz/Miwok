package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);

        //Creating Arraylist to an color object type for both translation
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father","әpә"));
        words.add(new Word("Mother","әṭa"));
        words.add(new Word("Son","angsi"));
        words.add(new Word("Daughter","tune"));
        words.add(new Word("Older Brother","taachi"));
        words.add(new Word("Younger Brother","chalitti"));
        words.add(new Word("Older Sister","teṭe"));
        words.add(new Word("Younger Sister","kolliti"));
        words.add(new Word("Grandmother","ama"));
        words.add(new Word("Grandfather","paapa"));

            //Custom of arrayadapter but only one list ( this, layout , List)
        WordAdapter wadapter = new WordAdapter(this, words);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        GridView listView = (GridView) findViewById(R.id.gridview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        listView.setAdapter(wadapter);

    }
}