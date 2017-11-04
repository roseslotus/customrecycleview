package com.lotus.recyclerlibrary.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lotus.recyclerlibrary.callback.SuperRecycleListener;
import com.lotus.recyclerlibrary.recycleview.ProgressStyle;
import com.lotus.recyclerlibrary.recycleview.SuperRecyclerView;
import com.lotus.recyclerlibrary.sidebar.bean.BaseListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thl on 2017/11/4.
 */

public class RecyclerPresenter<T extends BaseListBean> implements SuperRecyclerView.LoadingListener {

  private List<T> listBeens;
  private SuperRecyclerView superRecyclerView;
  private View noDataView;
  SuperRecycleListener superRecycleListener;

  public int pageIndex=1;
  //小于10条不允许加载更多
  private int minSum=10;
  Context context;

  public RecyclerPresenter(Context context, SuperRecyclerView superRecyclerView, View noDataView, LinearLayoutManager layoutManager, SuperRecycleListener superRecycleListener){

    this.superRecyclerView=superRecyclerView;
    this.noDataView=noDataView;
    this.context=context;
    this.superRecycleListener=superRecycleListener;
    listBeens=new ArrayList<>();
    initRecyclerView(layoutManager);
  }

  public RecyclerPresenter(Context context,SuperRecyclerView superRecyclerView, View noDataView, SuperRecycleListener superRecycleListener){
    this(null,superRecyclerView,noDataView,null,superRecycleListener);
  }

  private void initRecyclerView(LinearLayoutManager layoutManager) {
    if (layoutManager==null){
      LinearLayoutManager layoutMan = new LinearLayoutManager(context);
      layoutMan.setOrientation(LinearLayoutManager.VERTICAL);
      superRecyclerView.setLayoutManager(layoutMan);
    }else {
      superRecyclerView.setLayoutManager(layoutManager);
    }


    superRecyclerView.setRefreshEnabled(true);// 可以定制是否开启下拉刷新
    superRecyclerView.setLoadMoreEnabled(false);// 可以定制是否开启加载更多
    superRecyclerView.setLoadingListener(this);// 下拉刷新，上拉加载的监听
    superRecyclerView.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);// 下拉刷新的样式
    superRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);// 上拉加载的样式
//    superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);// 设置下拉箭头
  }

  public void autoRefresh(){
    superRecyclerView.setRefreshing(true);
  }


  private void checkData() {
    if (noDataView!=null){
      boolean isNoData = listBeens.size() == 0;
      noDataView.setVisibility(isNoData ? View.VISIBLE : View.GONE);
    }
  }

  public void addListData(boolean isRefresh, List<T> result) {
    if (isRefresh) {
      this.listBeens.clear();
      this.listBeens.addAll(result);
      if (this.listBeens.size()<minSum){
        superRecyclerView.setLoadMoreEnabled(false);
      }else {
        superRecyclerView.setLoadMoreEnabled(true);
      }
    } else {
      this.listBeens.addAll(result);
    }
  }

  public void setLoadMoreMinSumEnable(int sum){
    this.minSum=sum;
  }

  public void onCompleteRefresh() {
    superRecyclerView.completeRefresh();
    superRecyclerView.completeLoadMore();
//    superRecyclerView.setRefreshTime(getTime());
    checkData();
  }

  public void onCompleteFailure() {
    superRecyclerView.completeRefresh();
    superRecyclerView.completeLoadMore();
    pageIndex=pageIndex-1;
    if (pageIndex<=0){
      pageIndex=1;
    }
    checkData();
  }

  @Override
  public void onRefresh() {
    pageIndex=1;
    if (superRecycleListener!=null){
      superRecycleListener.onRefreshData();
    }
  }

  @Override
  public void onLoadMore() {
    pageIndex=pageIndex+1;
    if (superRecycleListener!=null){
      superRecycleListener.onLoadMoreData();
    }
  }

  public List<T> getData(){
    return listBeens;
  }

}
