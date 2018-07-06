package com.surplus.util;


import java.io.FileInputStream;
import java.security.MessageDigest;


public class MD5Util {
	
	public static final String ALGORITHM = "MD5" ;
	public static final String CHARSET = "UTF-8" ;
	
	public static MD5Util getInstance(){
		return new MD5Util();
	}
	
	public String getMD5(String value){
		try {
			return getMD5(value.getBytes(CHARSET));
		} catch (Exception e) {
			return "" ;
		}
	}
	
	public String getMD5File(String filename){
		try {
			return getMD5(IOStreamUtil.getInstance().readInputStream(new FileInputStream(filename), true));
		} catch (Exception e) {
			return "";
		}
    }
	
	public String getMD5(byte[] bytes){
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM);
			byte[] md5Bytes = md.digest(bytes);
		//	md.update(bytes, 0, bytes.length) ;
		//	byte[] md5Bytes = md.digest();
	        return ByteUtil.getInstance().ByteToHexString(md5Bytes);
		} catch (Exception e) {
			return "";
		}      
    }
}
