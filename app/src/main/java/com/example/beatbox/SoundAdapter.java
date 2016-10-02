package com.example.beatbox;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 离子态狍子 on 2016/10/2.
 */

public class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

    private BeatBoxFragment.Callbacks mCallbacks;
    private FragmentActivity mFragmentActivity;
    private List<Sound> mSounds;

    public SoundAdapter(FragmentActivity fragmentActivity, List<Sound> sounds, BeatBoxFragment.Callbacks callbacks){
        mFragmentActivity = fragmentActivity;
        mSounds = sounds;
        mCallbacks = callbacks;

    }
    @Override
    public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mFragmentActivity);
        return new SoundHolder(inflater, parent, mCallbacks);
    }

    @Override
    public void onBindViewHolder(SoundHolder holder, int position) {
        Sound sound = mSounds.get(position);
        holder.bindSound(sound);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }
}
