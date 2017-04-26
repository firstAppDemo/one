/*
package com.mycompany.myfirstapp.utils;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.author;

*/
/**
 * Created by Administrator on 2017/4/25.
 *//*


public class RegularUtils {




   */
/* 基本数据验证
    @author Administrator
    附 ： 常用的正则表达式：
    匹配特定数字：
            ^[1-9]d$　 　 匹配正整数
    ^-[1-9]d$ 　 匹配负整数
    ^-[1-9]d$　　 匹配整数
    ^[1-9]d0$　 匹配非负整数（正整数 + 0）
            ^-[1-9]d0$　　 匹配非正整数（负整数 + 0）
            ^[1-9]d.d0.d[1-9]d$　　 匹配正浮点数
    ^-([1-9]d.d0.d[1-9]d)$　 匹配负浮点数
    ^-([1-9]d.d0.d[1-9]d0.0+0)$　 匹配浮点数
    ^[1-9]d.d0.d[1-9]d0.0+0$　　 匹配非负浮点数（正浮点数 + 0）
            ^(-([1-9]d.d0.d[1-9]d))0.0+0$　　匹配非正浮点数（负浮点数 + 0）
    评注：处理大量数据时有用，具体应用时注意修正

    匹配特定字符串：
            ^[A-Za-z]+$　　匹配由26个英文字母组成的字符串
    ^[A-Z]+$　　匹配由26个英文字母的大写组成的字符串
    ^[a-z]+$　　匹配由26个英文字母的小写组成的字符串
    ^[A-Za-z0-9]+$　　匹配由数字和26个英文字母组成的字符串
    ^w+$　　匹配由数字、26个英文字母或者下划线组成的字符串

            在使用RegularExpressionValidator验证控件时的验证功能及其验证表达式介绍如下

    只能输入数字：“^[0-9]$”
    只能输入n位的数字：“^d{n}$”
    只能输入至少n位数字：“^d{n,}$”
    只能输入m-n位的数字：“^d{m,n}$”
    只能输入零和非零开头的数字：“^(0[1-9][0-9])$”
    只能输入有两位小数的正实数：“^[0-9]+(.[0-9]{2})$”
    只能输入有1-3位小数的正实数：“^[0-9]+(.[0-9]{1,3})$”
    只能输入非零的正整数：“^+[1-9][0-9]$”
    只能输入非零的负整数：“^-[1-9][0-9]$”
    只能输入长度为3的字符：“^.{3}$”
    只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$”
    只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$”
    只能输入由26个小写英文字母组成的字符串：“^[a-z]+$”
    只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$”
    只能输入由数字、26个英文字母或者下划线组成的字符串：“^w+$”
    验证用户密码“^[a-zA-Z]w{5,17}$”正确格式为：以字母开头，长度在6-18之间，

    只能包含字符、数字和下划线。
    验证是否含有^%&’,;=$”等字符：“[^%&’,;=$x22]+”
    只能输入汉字：“^[u4e00-u9fa5],{0,}$”
    验证Email地址：“^w+[-+.]w+)@w+([-.]w+).w+([-.]w+)$”
    验证InternetURL：“^http([w-]+.)+[w-]+([w-.%&=])$”
    验证电话号码：“^((d{3,4})d{3,4}-)d{7,8}$”

    正确格式为：“XXXX-XXXXXXX”，“XXXX-XXXXXXXX”，“XXX-XXXXXXX”，

            “XXX-XXXXXXXX”，“XXXXXXX”，“XXXXXXXX”。
    验证身份证号（15位或18位数字）：“^d{15}d{}18$”
    验证一年的12个月：“^(0[1-9]1[0-2])$”正确格式为：“01”-“09”和“1”“12”
    验证一个月的31天：“^((0[1-9])((12)[0-9])3031)$” 正确格式为：“01”“09”和“1”“31”。

    匹配中文字符的正则表达式： [u4e00-u9fa5]
    匹配双字节字符(包括汉字在内)：[^x00-xff]
    匹配空行的正则表达式：n[s ]r
    匹配HTML标记的正则表达式： (.). (.)
    匹配首尾空格的正则表达式：(^s)(s$)
    匹配Email地址的正则表达式：w+([-+.]w+)@w+([-.]w+).w+([-.]w+)
    匹配网址URL的正则表达式：^http([w-]+.)+[w-]+([w-.%&=])$
*//*

        */
/*验证IP地址

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b*//*


        public static boolean isIP(String str) {
            String num = (25[0-5]2[0-4]d[0-1]d{2}[1-9]d);
            String regex = ^ + num + . + num + . + num + . + num + $;
            return match(regex, str);
        }


       // 验证网址Url

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsUrl(String str) {
            String regex = http(s)([w-]+.)+[w-]+([w- .%&=]);
            return match(regex, str);
        }


        验证电话号码

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsTelephone(String str) {
            String regex = ^(httpwww.cnblogs.comyaojianadminfiled%7b3,4%7d-)d{6,8}$;
            return match(regex, str);
        }


        验证输入密码条件(字符与数据同时出现)

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsPassword(String str) {
            String regex = [A-Za-z]+[0-9];
            return match(regex, str);
        }


        验证输入密码长度 (6-18位)

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsPasswLength(String str) {
            String regex = ^d{6,18}$;
            return match(regex, str);
        }


        验证输入邮政编号

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsPostalcode(String str) {
            String regex = ^d{6}$;
            return match(regex, str);
        }


        验证输入手机号码

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsHandset(String str) {
            String regex = ^[1]+[3,5,7,8]+d{9}$;
            return match(regex, str);
        }


        验证输入身份证号

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsIDcard(String str) {
            String regex = (^d{18}$)(^d{15}$);
            return match(regex, str);
        }


        验证输入两位小数

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsDecimal(String str) {
            String regex = ^[0-9]+(.[0-9]{2})$;
            return match(regex, str);
        }


        验证输入一年的12个月

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsMonth(String str) {
            String regex = ^(0[[1-9]1[0-2])$;
            return match(regex, str);
        }


        验证输入一个月的31天

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsDay(String str) {
            String regex = ^((0[1-9])((12)[0-9])3031)$;
            return match(regex, str);
        }


        验证日期时间

        @param 待验证的字符串
        @return 如果是符合网址格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean isDate(String str) {
            严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
            [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
            String regex =
            ^((((1920)(([02468][048])([13579][26]))-02-29))((20[0-9][0-9])(19[0-9][0-9]))-((((0[1-9])(1[0-2]))-((0[1-9])(1d)(2[0-8])))((((0[13578])(1[02]))-31)(((01,3-9])(1[0-2]))-(2930)))))$;
            没加时间验证的YYYY-MM-DD
            String regex =
            ^((((1[6-9][2-9]d)d{2})-(0[13578]1[02])-(0[1-9][12]d3[01]))(((1[6-9][2-9]d)d{2})-(0[13456789]1[012])-(0[1-9][12]d30))(((1[6-9][2-9]d)d{2})-02-(0[1-9]1d2[0-8]))(((1[6-9][2-9]d)(0[48][2468][048][13579][26])((16[2468][048][3579][26])00))-02-29-))$;
            加了时间验证的YYYY-MM-DD 000000
            String regex = ^((((1[6-9][2-9]d)d{2})-(0[13578]1[02])-(0[1-9][12]d3[01]))(((1[6-9][2-9]d)d{2})-(0[13456789]1[012])-(0[1-9][12]d30))(((1[6-9][2-9]d)d{2})-02-(0[1-9]1d2[0-8]))(((1[6-9][2-9]d)(0[48][2468][048][13579][26])((16[2468][048][3579][26])00))-02-29-)) (20212223[0-1]d)[0-5]d[0-5]d$;
            return match(regex, str);
        }

        日期不带时间的验证

        @param 待验证的字符串
        @return 如果是符合网址格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean isBirthday(String str) {
            严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
            [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
            String regex =
            ^((((1920)(([02468][048])([13579][26]))-02-29))((20[0-9][0-9])(19[0-9][0-9]))-((((0[1-9])(1[0-2]))-((0[1-9])(1d)(2[0-8])))((((0[13578])(1[02]))-31)(((01,3-9])(1[0-2]))-(2930)))))$;
            没加时间验证的YYYY-MM-DD
            String regex =
            ^((((1[6-9][2-9]d)d{2})-(0[13578]1[02])-(0[1-9][12]d3[01]))(((1[6-9][2-9]d)d{2})-(0[13456789]1[012])-(0[1-9][12]d30))(((1[6-9][2-9]d)d{2})-02-(0[1-9]1d2[0-8]))(((1[6-9][2-9]d)(0[48][2468][048][13579][26])((16[2468][048][3579][26])00))-02-29-))$;
            加了时间验证的YYYY-MM-DD 000000
            String regex = ^((((1[6-9][2-9]d)d{2})-(0[13578]1[02])-(0[1-9][12]d3[01]))(((1[6-9][2-9]d)d{2})-(0[13456789]1[012])-(0[1-9][12]d30))(((1[6-9][2-9]d)d{2})-02-(0[1-9]1d2[0-8]))(((1[6-9][2-9]d)(0[48][2468][048][13579][26])((16[2468][048][3579][26])00))-02-29-))$;
            ^((((1[6-9][2-9]d)d{2})-(0[13578]1[02])-(0[1-9][12]d3[01]))(((1[6-9][2-9]d)d{2})-(0[13456789]1[012])-(0[1-9][12]d30))(((1[6-9][2-9]d)d{2})-02-(0[1-9]1d2[0-8]))(((1[6-9][2-9]d)(0[48][2468][048][13579][26])((16[2468][048][3579][26])00))-02-29-)) (20212223[0-1]d)[0-5]d[0-5]d$;
            return match(regex, str);
        }

        验证数字输入

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsNumber(String str) {
            String regex = ^[0-9]$;
            return match(regex, str);
        }


        验证非零的正整数

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsIntNumber(String str) {
            String regex = ^+[1-9][0-9]$;
            return match(regex, str);
        }


        验证大写字母

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsUpChar(String str) {
            String regex = ^[A-Z]+$;
            return match(regex, str);
        }


        验证小写字母

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsLowChar(String str) {
            String regex = ^[a-z]+$;
            return match(regex, str);
        }


        验证输入字母

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsLetter(String str) {
            String regex = ^[A-Za-z]+$;
            return match(regex, str);
        }


        验证输入汉字

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsChinese(String str) {
            String regex = ^[u4e00-u9fa5],{0,}$;
            return match(regex, str);
        }


        验证输入字符串

        @param 待验证的字符串
        @return 如果是符合格式的字符串,返回 btrue b,否则为 bfalse b

        public static boolean IsLength(String str) {
            String regex = ^.{8,}$;
            return match(regex, str);
        }


        匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。

        @param str
        @return
        @author jiqinlin

        public final static boolean isPwd(String str) {
            return match(str, ^[a-zA-Z]w{6,12}$);
        }


        验证字符，只能包含中文、英文、数字、下划线等字符。

        @param str
        @return
        @author jiqinlin

        public final static boolean stringCheck(String str) {
            return match(str, ^[a-zA-Z0-9u4e00-u9fa5-_]+$);
        }


        匹配Email地址

        @param str
        @return
        @author jiqinlin

        public final static boolean isEmail(String str) {
            return match(str, ^w+([-+.]w+)@w+([-.]w+).w+([-.]w+)$);
        }


        匹配非负整数（正整数+0）

        @param str
        @return
        @author jiqinlin

        public final static boolean isInteger(String str) {
            return match(str, ^[+]d+$);
        }


        判断数值类型，包括整数和浮点数

        @param str
        @return
        @author jiqinlin

        public final static boolean isNumeric(String str) {
            if(isFloat(str)  isInteger(str)) return true;
            return false;
        }


        只能输入数字

        @param str
        @return
        @author jiqinlin

        public final static boolean isDigits(String str) {
            return match(str, ^[0-9]$);
        }


        匹配正浮点数

        @param str
        @return
        @author jiqinlin

        public final static boolean isFloat(String str) {
            return match(str, ^[-+]d+(.d+)$);
        }


        联系电话(手机电话皆可)验证

        @param text
        @return
        @author jiqinlin

        public final static boolean isTel(String text){
            if(isMobile(text)isPhone(text)) return true;
            return false;
        }


        电话号码验证

        @param text
        @return
        @author jiqinlin

        public final static boolean isPhone(String text){
            return match(text, ^(d{3,4}-)d{7,9}$);
        }


        手机号码验证

        @param text
        @return
        @author jiqinlin

        public final static boolean isMobile(String text){
            if(text.length()!=11) return false;
            return match(text, ^(((13[0-9]{1})(15[0-9]{1})(18[0-9]{1}))+d{8})$);
        }


        身份证号码验证

        @param text
        @return
        @author jiqinlin

        public final static boolean isIdCardNo(String text){
            return match(text, ^[1-9]d{7}((0d)(1[0-2]))(([012]d)3[0-1])d{3}$^[1-9]d{5}[1-9]d{3}((0d)(1[0-2]))(([012]d)3[0-1])d{3}([0-9]X)$);
        }


        邮政编码验证

        @param text
        @return
        @author jiqinlin

        public final static boolean isZipCode(String text){
            return match(text, ^[0-9]{6}$);
        }


        判断整数num是否等于0

        @param num
        @return
        @author jiqinlin

        public final static boolean isIntEqZero(int num){
            return num==0;
        }


        判断整数num是否大于0

        @param num
        @return
        @author jiqinlin

        public final static boolean isIntGtZero(int num){
            return num0;
        }


        判断整数num是否大于或等于0

        @param num
        @return
        @author jiqinlin

        public final static boolean isIntGteZero(int num){
            return num=0;
        }


        判断浮点数num是否等于0

        @param num 浮点数
        @return
        @author jiqinlin

        public final static boolean isFloatEqZero(float num){
            return num==0f;
        }


        判断浮点数num是否大于0

        @param num 浮点数
        @return
        @author jiqinlin

        public final static boolean isFloatGtZero(float num){
            return num0f;
        }


        判断浮点数num是否大于或等于0

        @param num 浮点数
        @return
        @author jiqinlin

        public final static boolean isFloatGteZero(float num){
            return num=0f;
        }


        判断是否为合法字符(a-zA-Z0-9-_)

        @param text
        @return
        @author jiqinlin

        public final static boolean isRightfulString(String text){
            return match(text, ^[A-Za-z0-9_-]+$);
        }


        判断英文字符(a-zA-Z)

        @param text
        @return
        @author jiqinlin

        public final static boolean isEnglish(String text){
            return match(text, ^[A-Za-z]+$);
        }


        判断中文字符(包括汉字和符号)

        @param text
        @return
        @author jiqinlin

        public final static boolean isChineseChar(String text){
            return match(text, ^[u0391-uFFE5]+$);
        }


        匹配汉字

        @param text
        @return
        @author jiqinlin

        public final static boolean isChinese(String text){
            return match(text, ^[u4e00-u9fa5]+$);
        }


        是否包含中英文特殊字符，除英文-_字符外

        @param str
        @return

        public static boolean isContainsSpecialChar(String text) {
            if(StringUtils.isBlank(text)) return false;
            String[] chars={[,`,~,!,@,#,$,%,^,&,,(,),+,=,,{,},',
            ,;,',,,[,],.,,,,,~,！,@,#,￥,%,…,&,,（,）,
            —,+,,{,},【,】,‘,；,：,”,“,’,。,，,、,？,]};
            for(String ch  chars){
                if(text.contains(ch)) return false;
            }
            return true;
        }

        规范输入地址 可以输入(),-_中文英文
        @param text
        @return

        public static boolean isAddress(String text) {
            if(StringUtils.isBlank(text)) return false;
            String[] chars={[,`,~,!,@,#,$,%,^,&,,+,=,,{,},',
            ,;,',[,],.,,,,,~,！,@,#,￥,%,…,&,,
            —,+,,{,},【,】,‘,；,：,”,“,’,。,、,？,]};
            for(String ch  chars){
                if(text.contains(ch)) return false;
            }
            return true;
        }


        @param regex
                正则表达式字符串
        @param str
                要匹配的字符串
        @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;

        private static boolean match(String regex, String str) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }


    }

}
*/
