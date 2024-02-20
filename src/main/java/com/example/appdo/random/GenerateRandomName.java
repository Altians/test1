package com.example.appdo.random;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandomName {

    public static void main(String[] args) {
        System.out.println(generateUserName());
    }

    //自动生成名字（中文）
    public static String getRandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 8;
    private static final int MAX_ATTEMPTS = 1000;
    private static Set<String> existingNames = new HashSet<>();

    public static String generateUserName() {
        Random random = new Random();
        String userName;
        int attempts = 0;

        do {
            StringBuilder sb = new StringBuilder("用户");
            for (int i = 0; i < NAME_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            userName = sb.toString();
            attempts++;
        } while (existingNames.contains(userName) && attempts < MAX_ATTEMPTS);

        if (attempts == MAX_ATTEMPTS) {
            throw new RuntimeException("Failed to generate a unique username after " + attempts + " attempts.");
        }
        existingNames.add(userName);
        return userName;
    }


}
