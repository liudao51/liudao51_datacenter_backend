package com.liudao51.datacenter.core.util;


import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUtil {

    public static final String ALGORITHM_NAME = "MD5"; //散列算法,这里使用MD5算法
    public static final int HASH_ITERATIONS = 1024;    //散列次数, 如:散列两次(相当于md5(md5("")))

    public static String getRandomSalt() {
        String model = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer salt = new StringBuffer();
        char[] m = model.toCharArray();

        for (int i = 0; i < 6; i++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            // if (randomcode.contains(String.valueOf(c))) {
            // i--;
            // continue;
            // }
            salt = salt.append(c);
        }

        return salt.toString();
    }

    public static String encryptPassword(String val, String salt) {
        Hash simpleHash = new SimpleHash(ALGORITHM_NAME, val, ByteSource.Util.bytes(salt), HASH_ITERATIONS);

        return simpleHash.toHex();
    }
}
