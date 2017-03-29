package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);

        //Creating Arraylist to an color object type for both translation
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word(" My name is..."," oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        //Custom of arrayadapter but only one list ( this, layout , List)
        WordAdapter wadapter = new WordAdapter(this, words,R.color.category_phrases);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) findViewById(R.id.listview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        listView.setAdapter(wadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PhraseActivity.this,"Playing..",Toast.LENGTH_SHORT).show();
               // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                // Create and setup the {@link MediaPlayer} for the audio resource associated with the current word
                MediaPlayer mediaplayer = MediaPlayer.create(PhraseActivity.this, word.getAudioResID());
                // Start the audio file
                mediaplayer.start();
            }
        });

    }
}