package com.lotus.recycleview.adapter;

import android.content.Context;
import android.view.View;

import com.lotus.recyclerlibrary.adapter.BaseViewHolder;
import com.lotus.recyclerlibrary.adapter.SuperBaseAdapter;
import com.lotus.recyclerlibrary.recycleview.swipemenu.SuperSwipeMenuLayout;
import com.lotus.recycleview.R;
import com.lotus.recycleview.bean.TestBean;

import java.util.List;

/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class SwipeMenuAdapter extends SuperBaseAdapter<TestBean> {

    public SwipeMenuAdapter(Context context, List<TestBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, TestBean item, int position) {

        final SuperSwipeMenuLayout superSwipeMenuLayout =(SuperSwipeMenuLayout)holder.itemView.findViewById(R.id.swipe_listview); //(LinearLayout) holder.itemView;
        superSwipeMenuLayout.setSwipeEnable(true);//设置是否可以侧滑

           if(position%3==0){
               holder.setText(R.id.name_tv,item.getName())
                       .setOnClickListener(R.id.btFavorite,new OnItemChildClickListener())
                       .setOnClickListener(R.id.btGood,new OnItemChildClickListener())
                       .setOnClickListener(R.id.image_iv,new OnItemChildClickListener());
           } else {
               holder.setText(R.id.name_tv,item.getName()).setOnClickListener(R.id.btOpen,new OnItemChildClickListener())
                       .setOnClickListener(R.id.btDelete,new OnItemChildClickListener())
                       .setOnClickListener(R.id.image_iv,new OnItemChildClickListener());
               /**
                * 设置可以非滑动触发的开启菜单
                */
               holder.getView(R.id.image_iv).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(superSwipeMenuLayout.isOpen()) {
                           superSwipeMenuLayout.closeMenu();
                       } else {
                           superSwipeMenuLayout.openMenu();
                       }
                   }
               });
           }

    }
    @Override
    protected int getItemViewLayoutId(int position, TestBean item) {
        if(position%3==0){
            return R.layout.adapter_swipemenu1_layout;
        } else {
            return R.layout.adapter_swipemenu_layout;
        }
    }
}
