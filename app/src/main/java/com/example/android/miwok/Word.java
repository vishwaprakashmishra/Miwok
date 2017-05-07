package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation = null;
    private String mMiwokTranslation = null;

    public Word(String defaultTranslation, String miwokTranslation)
    {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    // getter function for getting default Translation '
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){

        return mMiwokTranslation;
    }
}
