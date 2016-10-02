package com.example.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 离子态狍子 on 2016/10/2.
 */

public class BeatBox {
    /**
     * 常量
     */
    private static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";
    public static final int MAX_SOUNDS = 5;


    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();
    static private SoundPool mSoundPool;




    public List<Sound> getSounds() {
        return mSounds;
    }
    public BeatBox(Context context)
    {
        mAssetManager = context.getAssets();
        //This old constructor is deprecated, but we need it for compatibility.
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    /**
     * 加载Asset中的全部音频文件
     */
    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found" + soundNames.length + " sounds");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            e.printStackTrace();
            return;
        }
        for (String filename : soundNames)
        {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            try {
                load(sound);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "loadSounds: Cound not load sound" + filename, e);
            }
            mSounds.add(sound);
        }
    }

    /**
     *加载音频
     */
    private void load(Sound sound) throws IOException{
        AssetFileDescriptor assetFileDescriptor = mAssetManager.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(assetFileDescriptor, 1);
        sound.setSoundId(soundId);
    }

    /**
     * 播放音频
     * @param sound
     */
    public static void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null)
        {
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }
    public static void release(){
        mSoundPool.release();
    }


}
