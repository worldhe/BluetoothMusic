package com.world.music.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.world.music.MusicActivity;
import com.world.music.R;
import com.world.music.entity.Music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String TAG = "MusicFragment";
    private List<Music> musicList;
    private ListView lv;
    private ArrayAdapter musicAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_music, container, false);
        Log.d(TAG, "onCreateView: ");
        getAllAudio();
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    private void initView(View view){
        lv = (ListView) view.findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
        musicAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, musicList);
        lv.setAdapter(musicAdapter);
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

        musicList = new ArrayList<Music>();
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
                musicList.add(music);
            }while (cursor.moveToNext());

            for(Music music : musicList){
                Log.d(TAG, music.toString());
            }

        }
    }

    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick position:"+position);
        Music music = musicList.get(position);
        String url = music.getUrl();
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
