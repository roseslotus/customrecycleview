
package com.lotus.recycleview.adapter.sidebar;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.sidebar.WeChatBean;

import java.util.List;

/**
 * Created by super南仔 on 2017-05-09. 类备注： 需要传入的参数:
 */
public class MeiTuanAdapter1 extends SuperBaseAdapter<WeChatBean> {

    public MeiTuanAdapter1(Context context, List<WeChatBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WeChatBean item, int position) {
        holder.setText(R.id.super_tv_name, item.getName());
    }

    @Override
    protected int getItemViewLayoutId(int position, WeChatBean item) {
        return R.layout.adapter_wechat_layout;
    }
}
