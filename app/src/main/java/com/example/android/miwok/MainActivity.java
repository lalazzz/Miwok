/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        //Setting a number click function to a text view by onclick method
        // NumbersClickListener clickListener = new NumbersClickListener();

        //Finding the text res that we want for the number onclick listener
        TextView numbers =  (TextView) findViewById(R.id.numbers);
        //Set the click listener to the specify text view and a abstract way to generalise the click listener
        numbers.setOnClickListener(new NumbersClickListener(){
            @Override
                public void onClick(View view ){
                Toast.makeText(view.getContext(),"List of numbers shown.",Toast.LENGTH_SHORT).show();
                //Put Mainactivity. this to indicate that we are refering to this activity to the new number activity
                //Intent optnumbers = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(new Intent(MainActivity.this,NumbersActivity.class));

            }
        });

        TextView family =  (TextView) findViewById(R.id.family);
        family.setOnClickListener(new NumbersClickListener(){
            @Override
            public void onClick(View view ){
                Toast.makeText(view.getContext(),"List of family shown.",Toast.LENGTH_SHORT).show();
                Intent optFamily = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(optFamily);
            }
        });

        TextView colors =  (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new NumbersClickListener(){
            @Override
            public void onClick(View view ){
                Toast.makeText(view.getContext(),"List of colors shown.",Toast.LENGTH_SHORT).show();
                Intent optColors= new Intent(MainActivity.this, ColorActivity.class);
                startActivity(optColors);
            }
        });

        TextView phrases =  (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new NumbersClickListener(){
            @Override
            public void onClick(View view ){
                Toast.makeText(view.getContext(),"List of phrases shown.",Toast.LENGTH_SHORT).show();
                Intent optPhrases= new Intent(MainActivity.this, PhraseActivity.class);
                startActivity(optPhrases);
            }
        });
    }
    // Intent way if there is a specific id when android:onclick = "operatingFamily" function is added in activity main xml layout.
    //    public void operatingFamily(View view) {
    //        Intent optFamily = new Intent(this, FamilyActivity.class);
    //        startActivity(optFamily);
    //        Toast.makeText(view.getContext(),"Family activity",Toast.LENGTH_SHORT).show();}
    //    public void operatingColors(View view) {
    //        Intent optColors = new Intent(this, ColorActivity.class);
    //        startActivity(optColors);}
    //    public void operatingPhrases(View view) {
    //        Intent optPhrases = new Intent(this, PhraseActivity.class);
    //        startActivity(optPhrases);}

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
