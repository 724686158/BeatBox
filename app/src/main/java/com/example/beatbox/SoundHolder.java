package com.example.beatbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 离子态狍子 on 2016/10/2.
 */

public class SoundHolder extends RecyclerView.ViewHolder {
    private Sound mSound;
    private Button mButton;
    private BeatBoxFragment.Callbacks mCallbacks;

    public SoundHolder(LayoutInflater inflater, ViewGroup container, BeatBoxFragment.Callbacks callbacks) {
        super(inflater.inflate(R.layout.list_item_sound, container, false));
        mCallbacks = callbacks;
        mButton = (Button) itemView.findViewById(R.id.list_item_sound_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClickButton(v);
            }
        });
    }

    private void doClickButton(View view) {
        mCallbacks.onSoundSelected(mSound);

    }

    public void bindSound(Sound sound)
    {
        mSound = sound;
        mButton.setText(mSound.getName());
    }
}
