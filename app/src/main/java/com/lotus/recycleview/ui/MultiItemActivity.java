
package com.lotus.recycleview.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recyclerlibrary.recycleview.SuperRecyclerView;
import com.lotus.recycleview.R;
import com.lotus.recycleview.adapter.MultiItemAdapter;
import com.lotus.recycleview.bean.MultipleItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super南仔 on 07/28/16. blog: http://supercwn.github.io/ GitHub:
 * https://github.com/supercwn
 */
public class MultiItemActivity extends Activity
        implements SuperRecyclerView.LoadingListener, SuperBaseAdapter.OnItemClickListener {

    private SuperRecyclerView superRecyclerView;
    private MultiItemAdapter mAdapter;
    private List<MultipleItemBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item_layout);
        initView();
        initAdapter();
    }

    private void initView() {
        superRecyclerView = (SuperRecyclerView) findViewById(R.id.super_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(true);
        superRecyclerView.setLoadMoreEnabled(true);
        superRecyclerView.setLoadingListener(this);
    }

    private void initAdapter() {
        mDatas = getMultipleItemData();
        mAdapter = new MultiItemAdapter(this, mDatas);
        mAdapter.setOnItemClickListener(this);
        superRecyclerView.setAdapter(mAdapter);
    }

    // 初始化数据
    public static List<MultipleItemBean> getMultipleItemData() {
        List<MultipleItemBean> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            MultipleItemBean multipleItem = new MultipleItemBean();
            int type = i % 3;
            multipleItem.setName("item" + i);
            multipleItem.setType(type);
            multipleItem.setInfo("备注" + i);
            list.add(multipleItem);
        }
        return list;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MultiItemActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                superRecyclerView.completeRefresh();
            }
        }, 3000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MultiItemActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                superRecyclerView.completeLoadMore();
                superRecyclerView.setNoMore(true);
            }
        }, 3000);
    }

    @Override
    public void onItemClick(View view, int position) {
        MultipleItemBean multipleItemBean = mDatas.get(position - 1);
        if (multipleItemBean.getType() == 0) {
            Toast.makeText(this, "name:" + multipleItemBean.getName(), Toast.LENGTH_SHORT).show();
        } else if ((multipleItemBean.getType() == 1)) {
            Toast.makeText(this,
                    "name:" + multipleItemBean.getName() + "info:" + multipleItemBean.getInfo(),
                    Toast.LENGTH_SHORT).show();
        } else {
            return;
        }
    }
}
