package com.world.music.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.world.music.MusicActivity;
import com.world.music.R;
import com.world.music.entity.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    private static final String TAG = "MusicFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_music, container, false);
        getAllAudio();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void getAllAudio(){
        MusicActivity musicActivity = (MusicActivity) getActivity();
        ContentResolver contentResolver = musicActivity.getContentResolver();
        if(contentResolver == null){
            return;
        }

        Cursor cursor = contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor == null){
            return;
        }

        List<Music> list = new ArrayList<Music>();
        if (cursor.moveToFirst()){
            do {
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
                int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                String _dispaly_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                String mime_type = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE));

                Music music = new Music(title, singer, album, size, duration, url, _dispaly_name, mime_type);
                list.add(music);
            }while (cursor.moveToNext());

            for(Music music : list){
                Log.d(TAG, music.toString());
            }

        }
    }
}
