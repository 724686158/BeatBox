package com.example.beatbox;

import android.support.v4.app.Fragment;

/**
 * Created by 离子态狍子 on 2016/10/2.
 */

public class BeatBoxActivity extends SingleFragmentActivity implements BeatBoxFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }

    @Override
    public void onSoundSelected(Sound sound) {
        BeatBox.play(sound);

    }
}
