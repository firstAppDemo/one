package com.mycompany.myfirstapp.entity;

import com.mycompany.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */

public class UserInfoDb {
    public static List<UserInfo> getUserInfo(){
        List<UserInfo> list = new ArrayList<UserInfo>();
        final String[] sex = new String[] { "男", "女", "妖" ,"男", "女", "妖","男", "女", "妖","男", "女", "妖"};
        final String[] remark = new String[] {
                "张国荣[1]，1956年9月12日生于香港，歌手、演员、音乐人；影视歌多栖发展的代表之一。1977年正式出道。1983年以《风继续吹》成名。1984年演唱的《Monica》是香港歌坛第一支同获十大中文金曲、十大劲歌金曲的舞曲 。 1986年、1987年获劲歌金曲金奖",
                "张学友，歌手、演员，1961年7月10日出生于香港，1984年获得香港首届十八区业余歌唱大赛冠军，正式出道，1993年发行的国语唱片《吻别》年度销量超过400万张，1995年、1996年连续两年获得世界音乐大奖全球销量最高亚洲流行乐歌手奖",
                "谭咏麟，1950年8月23日出生于香港，籍贯广东新会，中国香港男歌手、音乐人、演员。[1]20世纪60年代末为Loosers乐队成员。1973年任温拿乐队主音歌手。1975年参演首部电影《大家乐》。1978年温拿乐队宣布解散，谭咏麟以个人身份发展。1979年赴台湾发展事业，推出首张个人专辑《反斗星》"
        , "人生若只如初见，何事秋风悲画扇。"
                ,"曾经沧海难为水，除却巫山不是云。"
                ,"明月几时有？把酒问青天。"
                ,"恰同学少年，风华正茂。"
                ,"夜来风雨声，花落知多少。"
                ,"忽如一夜春风来，千树万树梨花开。"
                ,"寂寞空庭春欲晚，梨花满地不开门."
                ,"行到水穷处，坐看云起时。"
                ,"海内存知己，天涯若比邻"
        };
        final int[] photo = new int[] { R.drawable.head_2,
                R.drawable.head_4,
                R.drawable.head_6,
                R.drawable.head_4,
                R.drawable.head_3,
                R.drawable.head_6,
                R.drawable.head_7,
                R.drawable.head_5,
                R.drawable.head_4,
                R.drawable.head_3,
                R.drawable.head_2};
        final String[] hobby = new String[] { "上网、", "打球、", "看电影、","跑步、","游泳、","约会、" , "打游戏、", "做家务、", "唱歌、","溜溜球、","相亲、","喝酒、"};

        for (int i = 0; i<10; i++) {
            //UserInfo userInfo = new UserInfo(0,0,"","","","","");
            UserInfo userInfo = new UserInfo();
            userInfo.setIds(i);
            userInfo.setHobby(hobby[i]+hobby[i+1]);
            userInfo.setImg(photo[i]);
            userInfo.setRemark(remark[i]);
            userInfo.setSex(sex[i]);
            list.add(userInfo);
        }

        return list;
    }
}
