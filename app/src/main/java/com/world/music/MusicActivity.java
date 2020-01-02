package com.world.music;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.world.music.fragment.CallRecordsFragment;
import com.world.music.fragment.MusicFragment;
import com.world.music.fragment.PhoneBookFragment;
import com.world.music.fragment.SettingsFragment;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bt_phone_book, btn_bt_call_records,
            btn_bt_settings, btn_bt_music;
    private FrameLayout fl;
    private Fragment PhoneBookFragment;
    private Fragment CallRecordsFragment;
    private Fragment SettingsFragment;
    private Fragment MusicFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initView();
        initFragment();
    }

    private void initView(){
        btn_bt_phone_book = (Button) findViewById(R.id.btn_bt_phone_book);
        btn_bt_call_records = (Button) findViewById(R.id.btn_bt_call_records);
        btn_bt_settings = (Button) findViewById(R.id.btn_bt_settings);
        btn_bt_music = (Button) findViewById(R.id.btn_bt_music);
        btn_bt_phone_book.setOnClickListener(this);
        btn_bt_call_records.setOnClickListener(this);
        btn_bt_settings.setOnClickListener(this);
        btn_bt_music.setOnClickListener(this);
    }

    private void initFragment(){
        PhoneBookFragment = new PhoneBookFragment();
        CallRecordsFragment = new CallRecordsFragment();
        SettingsFragment = new SettingsFragment();
        MusicFragment = new MusicFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_back);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_bt_phone_book:
                switchFragment(PhoneBookFragment);
                break;
            case R.id.btn_bt_call_records:
                switchFragment(CallRecordsFragment);
                break;
            case R.id.btn_bt_settings:
                switchFragment(SettingsFragment);
                break;
            case R.id.btn_bt_music:
                switchFragment(MusicFragment);
                break;
            default:
                break;
        }
    }

    private void switchFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl, fragment);
        transaction.commit();
    }
}
