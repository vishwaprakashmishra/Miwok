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

    /**
     * returns if the Words object has an image associated with it or not
     * @return a boolean true if has an image else false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
