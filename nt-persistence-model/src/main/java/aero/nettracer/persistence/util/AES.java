package aero.nettracer.persistence.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class AES {

    //DO NOT CHANGE THE PASSPHRASE, SALT, KEYSIZE
    private static String passphrase = "8K74gb1dV5Vb";
    private static String salt = "AbfYANREq73p";
    private static int keySize = 256;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AES.class);
    private static byte[] encodedKeyWithPadding;

    static {
        try {
            encodedKeyWithPadding = AES.genKeyWithPadding(passphrase.toCharArray(), keySize).getEncoded();
        }catch (Exception e) {
            logger.error("Failed to generate key with padding", e);
        }

    }


    public static String encrypt(String value) {
        String returnString = value;
        try {
            return encrypt(value, passphrase);
        }catch(Exception e) {
            logger.error("Failed to encrypt value", e);
        }
        return returnString;
    }

    public static String encrypt(String value, String passphrase) throws InvalidKeyException, ShortBufferException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeySpecException, UnsupportedEncodingException{
        if(value == null || passphrase == null){
            return null;
        }
        byte[]b = AES.encrypt(value.getBytes("UTF-8"), encodedKeyWithPadding);
        return getHex(b);
    }


    public static String decrypt(String value) {
        String returnString = value;
        try {
            returnString = decrypt(value, passphrase);
        }catch(Exception e) {
            logger.error("Failed to decrypt value", e);
        }
        return returnString;
    }

    public static String decrypt(String value, String passphrase) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException{
        if(value == null){
            return null;
        }
        return new String(AES.decrypt(AES.getRaw(value), encodedKeyWithPadding));
    }

    public byte[] encrypt(byte [] value) throws InvalidKeyException, ShortBufferException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, UnsupportedEncodingException{
        return encrypt(value, AES.genKeyWithPadding(passphrase.toCharArray(), keySize).getEncoded());
    }

    public static byte[] encrypt(byte [] value, byte [] key) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException{

        SecretKeySpec skey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skey);

        byte[] cipherText = new byte[cipher.getOutputSize(value.length)];
        int ctLength = cipher.update(value, 0, value.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return cipherText;
    }

    public static byte[] decrypt (byte [] value) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, ShortBufferException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException{
        return decrypt(value, AES.genKeyWithPadding(passphrase.toCharArray(), keySize).getEncoded());
    }

    public static byte[] decrypt (byte [] value, byte [] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException{

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE,skey);
        byte [] ret = new byte[cipher.getOutputSize(value.length)];
        int ctLength = cipher.update(value, 0, value.length, ret, 0);
        ctLength += cipher.doFinal(ret, ctLength);
        return Arrays.copyOf(ret, ctLength);
    }

    public static SecretKey genKeyWithPadding(char[] key, int keylen) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException{
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(key, salt.getBytes("UTF-8"), 1024, keylen);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
    }

    public static String getHex( byte [] raw ) {
        String HEXES = "0123456789ABCDEF";
        if ( raw == null ) {
            return null;
        }
        final StringBuilder hex = new StringBuilder( 2 * raw.length );
        for ( final byte b : raw ) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

    public static byte[] getRaw(String s) throws UnsupportedEncodingException{
        String HEXES = "0123456789ABCDEF";
        if ( s == null ) {
            return null;
        }
        byte [] ret = new byte [s.length()/2];

        byte[] b = s.getBytes("UTF-8");
        for(int i = 0; i < b.length; i+=2){
            ret[i/2] = (byte) ((byte)(HEXES.indexOf((b[i])) << 4) + HEXES.indexOf(b[i+1]));
        }
        return ret;
    }
}
