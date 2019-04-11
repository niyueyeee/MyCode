package com.itheima.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FuZaDemo {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<Object,Object> myMap;
    private Properties properties;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<Object, Object> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
