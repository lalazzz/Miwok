package com.example.android.miwok;

/**
 * Created by Michelle Tan on 6/3/2017.
 *
 * Public word class therefore number activity can access.
 */

public class Word {

    //Step 1: Defining the private(access variable only access from this class) state of the class : Default and Miwok Private class ensure that the information
    //taken from the public is in the same data type eg of string in this case. this is to allow the class to check before running on application
    //if wrong data is associate with it, it might crash the application.
    /** Default translation for the word */ //Gather and settle method for the member variable that access only in private class.
    private String mDefaultTranslation;
    /** Miwok translation for the word */
    private String mMiwokTranslation;


    //Step2: Create a mvarible state for public to access the state.
    // This public constructor enable the activity outside to retrieve the method from and public need to pass in two required inputs.
    // Word(Input 1 : String defaultTranslation, Input 2: String miwokTranslation)
    // Create a new Word object.@param defaultTranslation is the word in a language that the user is already familiar with(such as English)@param miwokTranslation is the word in the Miwok language
    public Word(String defaultTranslation, String miwokTranslation) {
         mDefaultTranslation = defaultTranslation;
         mMiwokTranslation = miwokTranslation;
      }

      //Step 3: Assign the methods for the state which in this case is the get. method
     //Get the default translation of the word. adn return the string.
      public String getDefaultTranslation() {
         return mDefaultTranslation;
      }
    //Get the Miwok translation of the word.
        public String getMiwokTranslation() {
         return mMiwokTranslation;
       }
}
