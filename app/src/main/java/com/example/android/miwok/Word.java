package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation = null;
    private String mMiwokTranslation = null;
    private int mImageResourceId;

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
}
