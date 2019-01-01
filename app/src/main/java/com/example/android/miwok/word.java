package com.example.android.miwok;

import android.media.MediaPlayer;

/**
 * Created by Ghaidaa on 28/02/2018.
 */

public class word {
    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    private int mImageResourceId;

    private boolean  checkId;

    int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        checkId=false;
        mAudioResourceId=audioResourceId;

    }
    public word (String defaultTranslation,String miwokTranslation, int imageresorceid, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId  = imageresorceid;
        checkId  =true;
        mAudioResourceId=audioResourceId;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId ()  {return mImageResourceId;}

    public boolean getCheckId  () {return checkId;}

    public int  getAudioResourceId  (){return mAudioResourceId;}


}
