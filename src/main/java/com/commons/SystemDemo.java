package com.commons;

import java.io.Console;
import java.util.Arrays;

/**
 * 系统类的使用
 */
public class SystemDemo {
    public static void main(String[] args) {
        String[] properties = {"java.runtime.name","sun.boot.library.path","sun.cpu.isalist","java.version",
                "java.home","java.vm.version","java.vm.name","java.class.path","os.name","os.arch","os.version",
                "file.separator","path.separator","line.separator","user.name","user.home","user.dir"};
//        for (int i = 0; i < properties.length; i++) {
//            String property = System.getProperty(properties[i]);
//            System.out.println(properties[i] +"\t"+property );
//        }
//        java.runtime.name	Java(TM) SE Runtime Environment
//        sun.boot.library.path	C:\Java\jdk-14.0.2\bin
//        sun.cpu.isalist	amd64
//        java.version	14.0.2
//        java.home	C:\Java\jdk-14.0.2
//        java.vm.version	14.0.2+12-46
//        java.vm.name	Java HotSpot(TM) 64-Bit Server VM
//        java.class.path	L:\spring\java-test\target\classes;C:\Users\Administrator\.m2\repository\junit\junit\4.12\junit-4.12.jar;C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\Administrator\.m2\repository\com\alibaba\fastjson\1.2.73\fastjson-1.2.73.jar;C:\Users\Administrator\.m2\repository\javax\servlet\javax.servlet-api\4.0.1\javax.servlet-api-4.0.1.jar;C:\Users\Administrator\.m2\repository\commons-io\commons-io\2.6\commons-io-2.6.jar;C:\Users\Administrator\.m2\repository\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;C:\Users\Administrator\.m2\repository\xml-apis\xml-apis\1.0.b2\xml-apis-1.0.b2.jar;C:\Users\Administrator\.m2\repository\redis\clients\jedis\3.3.0\jedis-3.3.0.jar;C:\Users\Administrator\.m2\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-pool2\2.6.2\commons-pool2-2.6.2.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-lang3\3.11\commons-lang3-3.11.jar;C:\Users\Administrator\.m2\repository\commons-collections\commons-collections\3.2.2\commons-collections-3.2.2.jar
//        os.name	Windows 10
//        os.arch	amd64
//        os.version	10.0
//        file.separator	\
//        path.separator	;
//        line.separator
//        user.name	Administrator
//        user.home	C:\Users\Administrator
//        user.dir	L:\spring\java-test

        // 重定向标准输出
//        System.setOut();
//        System.setErr();
//        System.setIn();
        
        // 从控制台输入密码
//        Console console = System.console();
//        String name = console.readLine("请输入用户名： ");
//        char[] chars = console.readPassword("请输入密码： ");
//        System.out.println("用户名："+name );
//        System.out.println("密码：" );
//        for(char c : chars) {
//            System.out.print(c );
//        }
//        Arrays.fill(chars,'a');

//        Math.sin(30);


    }
}
