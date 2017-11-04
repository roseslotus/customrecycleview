
package com.lotus.recycleview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.lotus.recyclerlibrary.callback.SuperRecycleListener;
import com.lotus.recyclerlibrary.presenter.RecyclerPresenter;
import com.lotus.recyclerlibrary.recycleview.SuperRecyclerView;
import com.lotus.recycleview.R;
import com.lotus.recycleview.adapter.RefreshAndLoadMoreAdapter;
import com.lotus.recycleview.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super南仔 on 07/28/16. blog: http://supercwn.github.io/ GitHub:
 * https://github.com/supercwn
 */
public class RefreshAndLoadMoreActivity extends AppCompatActivity
        implements SuperRecycleListener {

    private SuperRecyclerView superRecyclerView;
    private RefreshAndLoadMoreAdapter mAdapter;

    private RecyclerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_load_layout);
        initView();
        presenter=new RecyclerPresenter(this,superRecyclerView,null,this);

        initAdapter();
    }

    private void initView() {
        superRecyclerView = (SuperRecyclerView) findViewById(R.id.super_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    private List<TestBean> initData() {
        List<TestBean> testBeens=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testBeens.add(new TestBean("Test"+i));
        }
        return testBeens;
    }

    private void initAdapter() {
        mAdapter = new RefreshAndLoadMoreAdapter(this, presenter.getData());
        superRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.addListData(true,initData());
                superRecyclerView.completeRefresh();
                mAdapter.notifyDataSetChanged();
            }
        }, 1500);
    }

    @Override
    public void onLoadMoreData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.addListData(false,initData());
                superRecyclerView.completeRefresh();
                mAdapter.notifyDataSetChanged();
            }
        }, 1500);
    }
}
