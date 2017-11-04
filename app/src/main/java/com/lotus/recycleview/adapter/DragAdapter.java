package com.lotus.recycleview.adapter;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseDragAdapter;
import com.lotus.recycleview.R;

import java.util.List;

/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class DragAdapter extends SuperBaseDragAdapter<String> {
    public DragAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.tv,item);
    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.adapter_draggable_layout;
    }
}
