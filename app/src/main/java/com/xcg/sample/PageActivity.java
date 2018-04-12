package com.xcg.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongchengguang on 2018/4/12.
 */

public class PageActivity extends AppCompatActivity {

    private int mMaxCount = 0;
    private ViewPager mViewPager;
    private DataPageAdapter mAdapter;
    private int mPageCount;
    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        init();
    }

    private void init() {
        mMaxCount = getIntent().getIntExtra(Constant.MAX_COUNT, 0);
        mViewPager = findViewById(R.id.view_pager);
        if (mMaxCount % 9 == 0) {
            mPageCount = mMaxCount / 9;
        } else {
            mPageCount = mMaxCount / 9 + 1;
        }

        for (int i = 0; i < mPageCount; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.page_item, null);
            initGrid(view, i);
            viewList.add(view);
        }
        mAdapter = new DataPageAdapter(viewList);
        mViewPager.setAdapter(mAdapter);
    }

    private void initGrid(View view, int i) {
        GridView gridView = view.findViewById(R.id.gridview);
        List<String> strings = new ArrayList<>();
        int j = i * 9;
        do {
            strings.add(String.valueOf(j + 1));
            j++;
            if (j >= mMaxCount) {
                break;
            }
        } while (j % 9 != 0);
        GridAdapter gridAdapter = new GridAdapter(strings);
        gridView.setAdapter(gridAdapter);
    }

}
