package com.ddlab.rnd.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocaList {
    private List<String> list;

    public ThreadLocaList(List<String> list) {
        this.list = list;
    }

    private ThreadLocal<List<String>> tLocal = new ThreadLocal() {
        protected List<String> initialValue() {
            return new ArrayList(list);
        }
    };

    public List<String> getList() {
        return tLocal.get();
    }
}
