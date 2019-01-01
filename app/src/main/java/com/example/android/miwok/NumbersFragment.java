package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {



    private MediaPlayer mMediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if((i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)||(i== AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if(i==AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }else if(i==AudioManager.AUDIOFOCUS_LOSS){
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }


        }
    };

    private MediaPlayer.OnCompletionListener mcompletionListener  =  new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();
        }
    };


    public NumbersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        super.onCreate(savedInstanceState);

        audioManager  = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new word("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new word("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        words.add(new word("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        words.add(new word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new word("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        words.add(new word("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        words.add(new word("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("nine", "wo’e", R.drawable.number_nine,R.raw.number_nine));
        words.add(new word("ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        //test
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                 @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                releaseMediaPlayer();

                word currentWord  = (word) (listView.getItemAtPosition(i));
                int result= audioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getActivity(), currentWord.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mcompletionListener);

                }}

        });



        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);


        }

    }


    }
