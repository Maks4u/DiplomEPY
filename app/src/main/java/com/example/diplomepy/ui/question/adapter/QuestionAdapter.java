package com.example.diplomepy.ui.question.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.diplomepy.ui.question.adapterViewFragment.ArrayListFragment;

public class QuestionAdapter extends FragmentStateAdapter {

   private int countPage = 0;

    public QuestionAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public  void setCount(int countPage){
        this.countPage = countPage;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ArrayListFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return countPage;
    }
}
