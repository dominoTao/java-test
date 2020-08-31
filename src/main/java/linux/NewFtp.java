package linux;
import java.io.IOException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class NewFtp {
    public static void main(String[] args)
    {
        String hostname = "39.105.149.183";
        int port = 22;//22 usually the default port
        String username = "root";
        String password = "Liuyaozong123";
        //指明连接主机的IP地址
        Connection conn = new Connection(hostname,port);
        Session ssh = null;
        try
        {
            //连接到主机
            conn.connect();
            //使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn)
            {
                System.out.println("用户名称或者是密码不正确");
            }
            else
            {
                System.out.println("已经连接OK");

                //以下是linux的示例
                //将本地conf/server_start.sh传输到远程主机的/opt/pg944/目录下
                SCPClient clt = conn.createSCPClient();

                clt.put("classpath:kafka.properties", 4096, "/opt/pg944/", null);

                //执行命令
                ssh = conn.openSession();
                ssh.execCommand("sh /root/hello.sh");
                //ssh.execCommand("perl /root/hello.pl");
                //只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常.
                //使用多个命令用分号隔开
                //ssh.execCommand("cd /root; sh hello.sh");

	        /* 执行windows系统命令的示例
	        Session sess = conn.openSession();
                sess.execCommand("ipconfig");
                */

                //将Terminal屏幕上的文字全部打印出来
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true)
                {
                    String line = brs.readLine();
                    if (line == null)
                    {
                        break;
                    }
                    System.out.println(line);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            //连接的Session和Connection对象都需要关闭
            if(ssh!=null)
            {
                ssh.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
        }
    }
}
