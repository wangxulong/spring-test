package com.wang.util;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wxl on 2015/10/2.
 */
public class PasswordHelper {
    private final static String algorithmName ="md5";
    private final static int hashIterations=2;
    public static String encryptPassword(String password,String salt){
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
    public static String encryptPassword(String algorithmName,String password,String salt){
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
    public static String getSalt(){
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }

}
