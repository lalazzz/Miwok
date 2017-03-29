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
    /** Images resource ID for the word. similaily like an mailingaddress of the house rather than the whole house */
    private int mImagesResID = noImageShown;
    //Create an initial no image shown = -1 when there is no image retreived
    private static final int noImageShown = -1;
    //Audio Resource ID variable for the word
    private int mAudioResID;

    //Step2: Create a mvarible state for public to access the state.
    // This public constructor enable the activity outside to retrieve the method from and public need to pass in two required inputs.
    // Word(Input 1 : String defaultTranslation, Input 2: String miwokTranslation)
    // Create a new Word object.@param defaultTranslation is the word in a language that the user is already familiar with(such as English)@param miwokTranslation is the word in the Miwok language
    public Word(String defaultTranslation, String miwokTranslation,int audioResID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResID = audioResID;
      }

    public Word(String defaultTranslation, String miwokTranslation,int ImagesResID, int audioResID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImagesResID =ImagesResID;
        mAudioResID = audioResID;
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
        //Get the Images of the word.
        public int getImagesResID(){
            return mImagesResID;
    }
        //Get the Audio of the word and return it
        public  int getAudioResID(){return mAudioResID;}
    //if the images is -1 means is it false, therefore in this case we want true
    //therefore, by not equal to -1 it means there is image.
    //Checking methods of the image is imply in word class as wordadapter just getting info of hasimage or not.
        public boolean hasImage(){
            return mImagesResID != noImageShown;
        }

}
