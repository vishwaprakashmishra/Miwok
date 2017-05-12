package com.example.android.miwok;

import android.os.NetworkOnMainThreadException;

import static android.os.Build.VERSION_CODES.N;

public class Word {
    // providing default translation
    private String mDefaultTranslation = null;
    // providing miwok word
    private String mMiwokTranslation = null;
    // providing image resource id
    private int mImageResourceId = Word.NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mSoundResourceId = Word.NO_SOUND_PROVIDED;
    private static final int NO_SOUND_PROVIDED = -1;
    /**
     *
     * @param defaultTranslation default translation of the miwok word
     * @param miwokTranslation miwok word
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    /**
     *
     * @param defaultTranslation default translation of miwok word
     * @param miwokTranslation miwok word
     * @param imageResourceId image resource id
     */
    public Word(String defaultTranslation , String miwokTranslation, int imageResourceId )
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation ;
        mImageResourceId = imageResourceId;
    }

    /**
     * constructor for all the parameter
     * @param defaultTranslation default Translation value
     * @param miwokTranslation miwok translation word/phrase
     * @param imageResourceId image resource id  which is and integer URI
     * @param soundResourceId sound Resource id which is URI for sound an integer
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId ){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId ;
        mSoundResourceId = soundResourceId;
    }

    /**
     * overloaded constructor for providing miwok, default and sound only careful of the syntax
     * @param defaultTranslation default translation
     * @param soundResourceId sound resource id
     * @param miwokTranslation miwok word
     */
    public Word(String defaultTranslation  , int soundResourceId, String miwokTranslation)
    {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mSoundResourceId = soundResourceId;
    }

    // getter function for getting default Translation '
    public String getDefaultTranslation() {

        return mDefaultTranslation;
    }
    // getter function for getting miwok Translation
    public String getMiwokTranslation() {

        return mMiwokTranslation;
    }
    // getter method for getting image resource id
    public int getmImageResourceId() {

        return mImageResourceId;
    }
    // getter method for getting sound resource id
    public int getSoundResourceId(){
        return mSoundResourceId;
    }

    /**
     * returns if the Words object has an image associated with it or not
     * @return a boolean true if has an image else false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * returns true if there is a sound resource id
     * @return true if sound present else false
     */
    public boolean hasSound(){ return mSoundResourceId != NO_SOUND_PROVIDED; }
}
