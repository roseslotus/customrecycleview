package com.lotus.recycleview.bean;


import com.lotus.recyclerlibrary.sidebar.bean.BaseListBean;

/**
 * Created by thl on 2017/11/4.
 */

public class TestBean implements BaseListBean {
    public TestBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


}
