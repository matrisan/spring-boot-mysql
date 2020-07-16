//package com.github.mysql;
//
//import org.jasypt.util.text.BasicTextEncryptor;
//
///**
// * @author 石少东
// * @date 2020-07-15 16:02
// * @since 1.0
// */
//
//
//public class EncryptConfigUtil {
//    public static void main(String[] args) {
//        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//        //加密所需的salt(盐)
//        textEncryptor.setPassword("G0CvDz7oJn6");
//        //要加密的数据（数据库的用户名或密码） //ENC(o9uLVKcJV4C7SkdF9sZJzQ==)
//        String username = textEncryptor.encrypt("root");
//        String password = textEncryptor.encrypt("123456");
//        System.out.println("ENC(" + username + ")");
//        System.out.println("ENC(" + password + ")");
//    }
//}
