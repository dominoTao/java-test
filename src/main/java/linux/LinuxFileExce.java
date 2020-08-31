package linux;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class LinuxFileExce {
    private ChannelSftp sftp = null;
    private Session sshSession = null;

    private String username;
    private String password;
    private String host;
    private int port;

    private static final Logger logger = LoggerFactory.getLogger(LinuxFileExce.class);

    public LinuxFileExce(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public ChannelSftp connect() {
        JSch jSch = new JSch();
        try {
            logger.info("链接开始");
            Session session = jSch.getSession(username, host, port);
            session.setPassword(password);
            Properties properties = new Properties(  );
            properties.put("StrictHostKeyChecking", "no");
            session.connect();;
            Channel channel = session.openChannel("sftp");
            sftp.connect();
            ChannelSftp sftp = (ChannelSftp)channel;
            logger.info("链接成功");
        } catch (JSchException e) {
            e.printStackTrace( );
        }
        return sftp;
    }

    public static void main(String[] args) {
    }
}
