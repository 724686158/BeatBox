package com.example.beatbox;

import android.content.Intent;

/**
 * Created by 离子态狍子 on 2016/10/2.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public Sound(String assetPath)
    {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filenames = components[components.length - 1];
        mName = filenames.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
