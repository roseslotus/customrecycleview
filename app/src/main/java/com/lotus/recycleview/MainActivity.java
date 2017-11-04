
package com.lotus.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;


import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recyclerlibrary.recycleview.SuperRecyclerView;
import com.lotus.recycleview.adapter.MainAdapter;
import com.lotus.recycleview.ui.AnimationActivity;
import com.lotus.recycleview.ui.DragActivity;
import com.lotus.recycleview.ui.GradualChangeActivity;
import com.lotus.recycleview.ui.HeaderAndFooterActivity;
import com.lotus.recycleview.ui.ItemClickActivity;
import com.lotus.recycleview.ui.LayoutManagerActivity;
import com.lotus.recycleview.ui.MultiItemActivity;
import com.lotus.recycleview.ui.RefreshAndLoadMoreActivity;
import com.lotus.recycleview.ui.SideBarActivity;
import com.lotus.recycleview.ui.SwipeMenuActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super南仔 on 07/28/16. blog: http://supercwn.github.io/ GitHub:
 * https://github.com/supercwn
 */
public class MainActivity extends AppCompatActivity
        implements SuperBaseAdapter.OnItemClickListener {

    private static final String[] titles = {
            "AnimationActivity", "HeaderViewAndFooterView", "RefreshAndLoadMoreActivity",
            "Gradual change", "MultiItemActivity", "ItemClickActivity", "SwipeMenuActivity",
            "DragActivity", "LayoutManagerActivity", "SideBarActivity"
    };
    private static final Class<?>[] ACTIVITY = {
            AnimationActivity.class, HeaderAndFooterActivity.class,
            RefreshAndLoadMoreActivity.class, GradualChangeActivity.class, MultiItemActivity.class,
            ItemClickActivity.class, SwipeMenuActivity.class, DragActivity.class,
            LayoutManagerActivity.class, SideBarActivity.class
    };
    private List<String> dataList = new ArrayList<>();

    private SuperRecyclerView superRecyclerView;

    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        initAdapter();
    }

    private void initView() {
        superRecyclerView = (SuperRecyclerView) findViewById(R.id.super_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(false);
        superRecyclerView.setLoadMoreEnabled(false);
    }

    private void initAdapter() {
        mAdapter = new MainAdapter(this, dataList);
        mAdapter.setOnItemClickListener(this);
        superRecyclerView.setAdapter(mAdapter);
    }

    private void initDatas() {
        for (int i = 0; i < titles.length; i++) {
            dataList.add(titles[i]);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, ACTIVITY[position - 1]);
        startActivity(intent);
    }
}
