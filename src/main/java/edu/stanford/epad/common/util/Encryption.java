package edu.stanford.epad.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryption
{
    private String encryptionKey;
    byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    
    IvParameterSpec ivspec = new IvParameterSpec(iv);
    
    public Encryption(String encryptionKey)
    {
    	if (encryptionKey.length() > 32)
    		encryptionKey = encryptionKey.substring(0, 32);
    	else if (encryptionKey.length() > 24)
    		encryptionKey = encryptionKey.substring(0, 24);
    	else if (encryptionKey.length() > 16)
    		encryptionKey = encryptionKey.substring(0, 16);
        this.encryptionKey = encryptionKey;
    }

    public String encrypt(String plainText) throws Exception
    {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        return Base64.encodeBase64String(encryptedBytes);
    }

    public String decrypt(String encrypted) throws Exception
    {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(encrypted));

        return new String(plainBytes);
    }

    private Cipher getCipher(int cipherMode)
            throws Exception
    {
        SecretKeySpec keySpecification = new SecretKeySpec(
                encryptionKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(cipherMode, keySpecification, ivspec);

        return cipher;
    }
}