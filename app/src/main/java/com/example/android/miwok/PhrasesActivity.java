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

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?",R.raw.phrase_where_are_you_going,"minto wuksus"));
        words.add(new Word("What is your name?",R.raw.phrase_what_is_your_name,"tinnә oyaase'nә"));
        words.add(new Word("My name is...", R.raw.phrase_my_name_is,"oyaaset..."));
        words.add(new Word("How are you feeling?",R.raw.phrase_how_are_you_feeling,"michәksәs?"));
        words.add(new Word("I’m feeling good.",R.raw.phrase_im_feeling_good,"kuchi achit"));
        words.add(new Word("Are you coming?", R.raw.phrase_are_you_coming,"әәnәs'aa?"));
        words.add(new Word("Yes, I’m coming.",R.raw.phrase_yes_im_coming,"hәә’ әәnәm"));
        words.add(new Word("I’m coming.", R.raw.phrase_im_coming, "әәnәm"));
        words.add(new Word("Let’s go.", R.raw.phrase_lets_go,"yoowutis"));
        words.add(new Word("Come here.", R.raw.phrase_come_here, "әnni'nem"));

// ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this,
// android.R.layout.simple_list_item_1, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PhrasesActivity.this, words.get(position).getMiwokTranslation(), Toast.LENGTH_SHORT).show();

                // playing the media
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getSoundResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
