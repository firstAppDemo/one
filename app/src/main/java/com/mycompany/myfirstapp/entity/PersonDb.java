package com.mycompany.myfirstapp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class PersonDb {

    /**
     * 测试ListView使用
     * 模拟数据库读取List集合数据
     * @return  List数据
     */
    public static List<Person> getListPerson(){
        List<Person> list = new ArrayList<Person>();
        String[] str = {"赵","李","王","孙","金","齐","石","钱","钟","陈"};
        String[] strs = {"花","满","楼","月","笑","武","儿","狗蛋","狗剩","钢镚"};
        int[] ages = {18,19,20,23,21,22,24,25,26,27};
        for (int i = 0; i<10; i++) {
                        Person p = new Person();
                        p.setId(i);
                        p.setName(str[i] + strs[i]);
                        p.setAge(ages[i]);
                        list.add(p);
                }
        return list;
    }

}
