
package com.lotus.recycleview.adapter.sidebar;

import android.content.Context;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recyclerlibrary.recycleview.swipemenu.SuperSwipeMenuLayout;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.sidebar.WeChatBean;

import java.util.List;


/**
 * Created by super南仔 on 2017-05-04. 类备注： 需要传入的参数:
 */
public class SlideSwipeAdapter extends SuperBaseAdapter<WeChatBean> {

    public SlideSwipeAdapter(Context context, List<WeChatBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WeChatBean item, int position) {
        holder.setIsRecyclable(false);// 关闭Adapter的复用
        final SuperSwipeMenuLayout superSwipeMenuLayout = (SuperSwipeMenuLayout) holder.itemView;
        superSwipeMenuLayout.setSwipeEnable(true);// 设置是否可以侧滑
        holder.setText(R.id.super_tv_name, item.getName()).setOnClickListener(R.id.btnDel,
                new OnItemChildClickListener());
    }

    @Override
    protected int getItemViewLayoutId(int position, WeChatBean item) {
        return R.layout.adapter_slide_swipe_menu_layout;
    }
}
