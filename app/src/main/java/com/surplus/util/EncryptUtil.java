package com.surplus.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtil {

    public static final String DESKEY = "!@#$%6&*";

    private static byte[] iv1 = {(byte) 0x12, (byte) 0x34, (byte) 0x56,
            (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};

    private static String padding = "DES/CBC/PKCS5Padding";

    private static String mode = "DES";

    public static String encrypt(String content, String desKey) {
        try {
            if (content == null || content.equals(""))
                return "";
            byte[] plainText = content.getBytes("UTF-8");
            IvParameterSpec iv = new IvParameterSpec(iv1);
            DESKeySpec dks = new DESKeySpec(desKey.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(mode);
            SecretKey key = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(padding);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte encryptedData[] = cipher.doFinal(plainText);
            return byte2hex(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String byte2hex(byte[] b) { // 一个字节的数，
        try {
            // 转成16进制字符串
            String hs = "";
            String tmp = "";
            for (int n = 0; n < b.length; n++) {
                // 整数转成十六进制表示
                tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
                if (tmp.length() == 1) {
                    hs = hs + "0" + tmp;
                } else {
                    hs = hs + tmp;
                }
            }
            tmp = null;
            return hs.toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }
}
