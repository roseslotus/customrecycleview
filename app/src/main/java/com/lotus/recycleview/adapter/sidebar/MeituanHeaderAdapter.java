
package com.lotus.recycleview.adapter.sidebar;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperHeaderAndFooterAdapter;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.sidebar.MeituanHeaderBean;

/**
 * Created by zhangxutong . Date: 16/08/28
 */

public class MeituanHeaderAdapter extends SuperHeaderAndFooterAdapter {
    private Context mContext;

    public MeituanHeaderAdapter(RecyclerView.Adapter mInnerAdapter, Context mContext) {
        super(mContext, mInnerAdapter);
        this.mContext = mContext;
    }

    @Override
    protected void onBindHeaderHolder(BaseViewHolder holder, int headerPos, int layoutId,
                                      Object o) {
        switch (layoutId) {
            case R.layout.view_meituan_header_layout:
                final MeituanHeaderBean meituanHeaderBean = (MeituanHeaderBean) o;
                // 网格
                RecyclerView recyclerView = holder.getView(R.id.header_location_recycleview);
                recyclerView
                        .setAdapter(new HeaderAdapter(mContext, meituanHeaderBean.getCityList()));
                recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                break;
            // case R.layout.meituan_item_header_top:
            // MeituanTopHeaderBean meituanTopHeaderBean =
            // (MeituanTopHeaderBean) o;
            // holder.setText(R.id.tvCurrent, meituanTopHeaderBean.getTxt());
            // break;
            default:
                break;
        }
    }
}
