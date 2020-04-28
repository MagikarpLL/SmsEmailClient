package cn.magikarpll.smsemailclient.common.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;

public class PasswordEncyptUtils {

    /**
     * salt 值为默认密码
     */
    private static final String MY_SALT = "leizhen1996";

    public static String encryptPassword(){
        StringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
        String name = stringEncryptor.encrypt("leizhen1996");
        System.out.println("加密结果："+name);//解密
        return name;
    }


}
