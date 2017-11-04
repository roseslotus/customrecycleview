
package com.lotus.recycleview.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;


import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recyclerlibrary.callback.SuperRecycleListener;
import com.lotus.recyclerlibrary.presenter.RecyclerPresenter;
import com.lotus.recyclerlibrary.recycleview.swipemenu.SuperSwipeMenuRecyclerView;
import com.lotus.recycleview.R;
import com.lotus.recycleview.adapter.SwipeMenuAdapter;
import com.lotus.recycleview.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super南仔 on 07/28/16. blog: http://supercwn.github.io/ GitHub:
 * https://github.com/supercwn
 */
public class SwipeMenuActivity extends Activity
        implements SuperRecycleListener, SuperBaseAdapter.OnItemClickListener {

    private SuperSwipeMenuRecyclerView superSwipeMenuRecyclerView;
    private SwipeMenuAdapter swipeMenuAdapter;


    private RecyclerPresenter recyclerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipemenu_layout);


        initView();
        recyclerPresenter=new RecyclerPresenter(superSwipeMenuRecyclerView,null,this);

        initAdapter();
    }

    private void initView() {
        superSwipeMenuRecyclerView = (SuperSwipeMenuRecyclerView) findViewById(
                R.id.super_swipemenu_recycle_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        superSwipeMenuRecyclerView.setLayoutManager(layoutManager);
//        superSwipeMenuRecyclerView.setRefreshEnabled(true);
//        superSwipeMenuRecyclerView.setLoadMoreEnabled(true);
//        superSwipeMenuRecyclerView.setLoadingListener(this);
//        superSwipeMenuRecyclerView.setSwipeDirection(SuperSwipeMenuRecyclerView.DIRECTION_LEFT);// 左滑（默认）
        // superSwipeMenuRecyclerView.setSwipeDirection(SuperSwipeMenuRecyclerView.DIRECTION_LEFT);//右滑
    }

    private void initAdapter() {
        recyclerPresenter.addListData(true,initData());
        swipeMenuAdapter = new SwipeMenuAdapter(this, recyclerPresenter.getData());
        swipeMenuAdapter.setOnItemClickListener(this);
        swipeMenuAdapter.setOnItemChildClickListener(
                new SuperBaseAdapter.OnRecyclerViewItemChildClickListener() {
                    @Override
                    public void onItemChildClick(SuperBaseAdapter adapter, View view,
                            int position) {
                        switch (view.getId()) {
                            case R.id.btOpen:
                                Toast.makeText(SwipeMenuActivity.this, "show open",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btDelete:
                                Toast.makeText(SwipeMenuActivity.this, "show delete",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btFavorite:
                                Toast.makeText(SwipeMenuActivity.this, "show Favorite",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btGood:
                                Toast.makeText(SwipeMenuActivity.this, "show good",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.image_iv:
                                Toast.makeText(SwipeMenuActivity.this, "show image",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
        superSwipeMenuRecyclerView.setAdapter(swipeMenuAdapter);
    }

    private List<TestBean> initData() {
        List<TestBean> testBeens=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testBeens.add(new TestBean("Test"+i));
        }
        return testBeens;
    }


    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onRefreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                recyclerPresenter.addListData(true,initData());
                superSwipeMenuRecyclerView.completeRefresh();
                swipeMenuAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }

    @Override
    public void onLoadMoreData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                recyclerPresenter.addListData(false,initData());
                superSwipeMenuRecyclerView.completeRefresh();
                swipeMenuAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}
