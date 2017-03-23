package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);


        //Input of the array of words here
//        String[] words = new String [10];
//        words[0]= "One";
//        words[1]= "Two";
//        words[2]="Three";
//        words[3]="Four";
//        words[4]="Five";
//        words[5]="Six";
//        words[6]="Seven";
//        words[7]="Eight";
//        words[8]="Nine";
//        words[9]="Ten";
//        Log.v("NumbersActivity","Words at index 0 " + words[0]);
//        Log.v("NumbersActivity","Words at index 1 " + words[1]);

        //Input of the ARRAYLIST of words here
//        ArrayList<String> words = new ArrayList<String>();
//        words.add("One");
//        words.add("Two");
//        words.add("Three");
//        words.add("Four");
//        words.add("Five");
//        words.add("Six");
//        words.add("Seven");
//        words.add("Eight");
//        words.add("Nine");
//        words.add("Ten");
//        words.add("Eleven");

        //Creating Arraylist to an object type for both translation
        ArrayList<Word> words = new ArrayList<Word>();
        //word w = new word ("one", "lutti")); which is Word(String defaultTranslation, String miwokTranslation) in this case.
        //words.add(w); combine into the line below.
        words.add(new Word("One","lutti",R.drawable.number_one));
        words.add(new Word("Two","otiiko",R.drawable.number_two));
        words.add(new Word("Three","tolookosu",R.drawable.number_three));
        words.add(new Word("Four","oyyisa",R.drawable.number_four));
        words.add(new Word("Five","massokka",R.drawable.number_five));
        words.add(new Word("Six","temmokka",R.drawable.number_six));
        words.add(new Word("Seven","kenekaku",R.drawable.number_seven));
        words.add(new Word("Eight","kawinta",R.drawable.number_eight));
        words.add(new Word("Nine","wo'e",R.drawable.number_nine));
        words.add(new Word("Ten","na'aacha",R.drawable.number_ten));

        Log.v("NumbersActivity", "Words at index 0 " + words.get(0));
        Log.v("NumbersActivity", "Words at index 1 " + words.get(1));
        Log.v("NumbersActivity", "Words at index 2 " + words.get(2));
        Log.v("NumbersActivity", "Words at index 2 " + words.get(3));
        Log.v("NumbersActivity", "Words at index size: " + words.size());

        //Finding the root view of the whole layout
        //LinearLayout activity_numbersrootView = (LinearLayout) findViewById(R.id.activity_numbersrootView);
        //     int index = 0;
//
//        while (index < words.size()) {
//            TextView activity_numberswordView = new TextView(this);
//            activity_numberswordView.setText(words.get(index));
//            activity_numbersrootView.addView(activity_numberswordView);
//            index++; // equal to index = index +1;
//            Log.v("NumbersActivity", "Words at index size: " + index);
//        }

//        for(int index = 0 ; index < words.size(); index ++){
//            TextView activity_numberswordView = new TextView(this);
//            activity_numberswordView.setText(words.get(index));
//            activity_numbersrootView.addView(activity_numberswordView);
//            Log.v("NumbersActivity", "Words at index size: " + index);
//        }

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        //ArrayAdapter<String> itemsAdapter new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

        //Custom of arrayadapter but only one list ( this, layout , List) This only take in an array list where there is miwork and default in our case
        //Therefore, an word object class is needed to be created replacing list<t> , which is <T> object type.
        //updating the arraystring to the adapter. In this case now we have two strings under word class : object into <t> type
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this,R.layout.contentview, words);
        WordAdapter wadapter = new WordAdapter(this, words , R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // listviewlayout.xmlayout file.
        ListView listView = (ListView) findViewById(R.id.listview0);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(wadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NumbersActivity.this,"Playing..",Toast.LENGTH_SHORT).show();
                MediaPlayer mediaPlayer = MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
                mediaPlayer.start();
            }
        });

    }
}
