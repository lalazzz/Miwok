package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    // Insert after mediaplayer.start () new MediaPlayer.OnCompletionListener() is created new object each time it is being called.
    // Therefore, make this into a global variable for the on new complete listener as mCompleteListener.
    private MediaPlayer.OnCompletionListener mCompletionListener= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(ColorActivity.this, "I'm Finished", Toast.LENGTH_SHORT).show();
            //Firstly the method is created below as private void. then include this method after the audio has finished playing.
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT|| focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
               mediaPlayer.seekTo(0);
                mediaPlayer.pause();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS ) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);
        // Create and setup the {@link AudioManager} to request audio focus
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Creating Arraylist to an color object type for both translation
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("Green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("Brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("Gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("Black","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("White","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("Dusty Yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("Mustard Yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        //Custom of arrayadapter but only one list ( this, layout , List) This only take in an array list where there is miwork and default in our case
        //Therefore, an word object class is needed to be created replacing list<t> , which is <T> object type.
        //updating the arraystring to the adapter. In this case now we have two strings under word class : object into <t> type
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this,R.layout.contentview, words);
        WordAdapter wadapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // listViewlayoutml layout file.
        GridView listView = (GridView) findViewById(R.id.gridview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(wadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ColorActivity.this,"Playing..",Toast.LENGTH_SHORT).show();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                releaseMediaPlayer();
                Log.v("ColorActivity", "Current word: " + word);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now. Therefore time to get the audioRes
                    mediaPlayer = MediaPlayer.create(ColorActivity.this, word.getAudioResID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
                else {
                    // FAILED
                    Log.e("MainActivity",">>>>>>>>>>>>> FAILED TO GET AUDIO FOCUS <<<<<<<<<<<<<<<<<<<<<<<<");
                }
            }
        });
        mediaPlayer =null;
        // Regardless of whether or not we were granted audio focus, abandon it. This also
        // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
        audioManager.abandonAudioFocus(afChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "onStop");
        //When activities is stop, release the media player resource so that it will stop playing once it stop.
        //This helps to efficently utilise the device memory
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}