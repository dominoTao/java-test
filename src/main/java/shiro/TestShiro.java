package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestShiro {
    @Test
    public void testHelloWorld(){
        // 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory( "classpath:shiro-realm.ini" );
        // 得到SecurityManager实例，并且绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject以及创建用户名、密码身份验证Token（用户身份、凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken( "zhang", "123" );
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace( );
        }
        // 断言 用户已经登录了
        Assert.assertEquals(true, subject.isAuthenticated() );
        subject.logout();
    }
//    org.apache.shiro.realm.Realm
}
