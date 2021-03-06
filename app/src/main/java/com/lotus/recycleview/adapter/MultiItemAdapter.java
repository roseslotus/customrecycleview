package com.lotus.recycleview.adapter;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.MultipleItemBean;

import java.util.List;


/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class MultiItemAdapter extends SuperBaseAdapter<MultipleItemBean> {

    public MultiItemAdapter(Context context, List<MultipleItemBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultipleItemBean item, int position) {
        if(item.getType() == 0){
            holder.setText(R.id.name_tv,item.getName());
        } else if(item.getType() == 1){
            holder.setText(R.id.name_tv,item.getName())
            .setText(R.id.info_tv,item.getInfo());
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, MultipleItemBean item) {
        if(item.getType() == 0){
            return R.layout.adapter_multi_item1_layout;
        } else if(item.getType() == 1){
            return R.layout.adapter_multi_item2_layout;
        } else{
            return R.layout.adapter_multi_item3_layout;
        }
    }
}
