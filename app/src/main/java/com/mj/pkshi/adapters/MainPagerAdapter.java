package com.mj.pkshi.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.mj.pkshi.R;
import com.mj.pkshi.databinding.ItemCustomeviewBinding;
import com.mj.pkshi.fragments.FoundFragment;
import com.mj.pkshi.fragments.IndexFragment;
import com.mj.pkshi.fragments.MineFragment;
import com.mj.pkshi.fragments.TuijianFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {
    private AppCompatActivity context;
    private String[] tab_titls = {"首页", "推荐", "发现", "我的"};
    private int[] ress = {R.drawable.selector_index, R.drawable.selector_tuijian, R.drawable.selector_faxian, R.drawable.selector_mine};

    public MainPagerAdapter(AppCompatActivity context) {
        super(context.getSupportFragmentManager());
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IndexFragment.getInstant();
            case 1:
                return TuijianFragment.getInstant();
            case 2:
                return FoundFragment.getInstant();
            case 3:
                return MineFragment.getInstant();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    public View getView(int position) {
        ItemCustomeviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_customeview, null, false);
        binding.tvTabTitle.setText(tab_titls[position]);
        binding.imTab.setImageResource(ress[position]);
        return binding.getRoot();
    }


    public void addView(TabLayout layout) {
        for (int i = 0; i < 4; i++) {
            TabLayout.Tab tab = layout.getTabAt(i);
            tab.setCustomView(getView(i));
        }
    }
}
