
package com.lotus.recycleview.adapter.sidebar;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recycleview.R;

import java.util.List;

/**
 * Created by super南仔 on 2017-05-09. 类备注： 需要传入的参数:
 */
public class HeaderAdapter extends SuperBaseAdapter<String> {

    public HeaderAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.tvName, item);
    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.adapter_meituan_header_layout;
    }
}
