package com.huixin.framework.wx.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*des加密工具*/
public class DESUtil {


	/**
	 * 加密
	 * @param data	加密数据
	 * @param key	密钥
     * @return
     */
	public static byte[] encryptDES(byte[] data, String key) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			return cipher.doFinal(data);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * @param data	解密数据
	 * @param key	密钥
	 * @return
	 * @throws Exception
     */
	public static byte[] decryptDES(byte[] data, String key) throws Exception {
		SecureRandom random = new SecureRandom();
		DESKeySpec desKey = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(desKey);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		return cipher.doFinal(data);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(new String(encryptDES("haidong".getBytes(), "12345678")));
		System.out.println(new String(Base64Util.encryptBASE64(encryptDES("123456".getBytes(), "12345678"))));
		System.out.println(new String (Base64Util.decryptBASE64("ED5wLgc3Mnw=")));
		System.out.println(new String (decryptDES(Base64Util.decryptBASE64("ED5wLgc3Mnw="),"12345678")));
		
		
	}
	
}
