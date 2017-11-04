
package com.lotus.recycleview.adapter;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.TestBean;

import java.util.List;

/**
 * Created by super南仔 on 07/28/16. blog: http://supercwn.github.io/ GitHub:
 * https://github.com/supercwn
 */
public class RefreshAndLoadMoreAdapter extends SuperBaseAdapter<TestBean> {

    public RefreshAndLoadMoreAdapter(Context context, List<TestBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, TestBean item, int position) {
        holder.setText(R.id.info_text, item.getName());
    }

    @Override
    protected int getItemViewLayoutId(int position, TestBean item) {
        return R.layout.adapter_refresh_load_layout;
    }
}
