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

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    // Insert after mediaplayer.start () new MediaPlayer.OnCompletionListener() is created new object each time it is being called.
    // Therefore, make this into a global variable for the on new complete listener as mCompleteListener.
    private MediaPlayer.OnCompletionListener mCompletionListener= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(FamilyActivity.this, "I'm Finished", Toast.LENGTH_SHORT).show();
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
        words.add(new Word("Father","әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("Mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("Son","angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("Daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("Older Brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("Younger Brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("Older Sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("Younger Sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("Grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("Grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

            //Custom of arrayadapter but only one list ( this, layout , List)
        WordAdapter wadapter = new WordAdapter(this, words,R.color.category_family);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        GridView listView = (GridView) findViewById(R.id.gridview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        listView.setAdapter(wadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FamilyActivity.this,"Playing..",Toast.LENGTH_SHORT).show();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                releaseMediaPlayer();
                Log.v("FamilyActivity", "Current word: " + word);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now. Therefore time to get the audioRes
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
                else {
                    // FAILED
                    Log.e("MainActivity",">>>>>>>>>>>>> FAILED TO GET AUDIO FOCUS <<<<<<<<<<<<<<<<<<<<<<<<");
                }
            }
        });
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