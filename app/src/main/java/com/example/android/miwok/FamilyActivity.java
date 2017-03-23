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
        words.add(new Word("Father","әpә",R.drawable.family_father));
        words.add(new Word("Mother","әṭa",R.drawable.family_mother));
        words.add(new Word("Son","angsi",R.drawable.family_son));
        words.add(new Word("Daughter","tune",R.drawable.family_daughter));
        words.add(new Word("Older Brother","taachi",R.drawable.family_older_brother));
        words.add(new Word("Younger Brother","chalitti",R.drawable.family_younger_brother));
        words.add(new Word("Older Sister","teṭe",R.drawable.family_older_sister));
        words.add(new Word("Younger Sister","kolliti",R.drawable.family_younger_sister));
        words.add(new Word("Grandmother","ama",R.drawable.family_grandmother));
        words.add(new Word("Grandfather","paapa",R.drawable.family_grandfather));

            //Custom of arrayadapter but only one list ( this, layout , List)
        WordAdapter wadapter = new WordAdapter(this, words,R.color.category_family);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        GridView listView = (GridView) findViewById(R.id.gridview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        listView.setAdapter(wadapter);

    }
}