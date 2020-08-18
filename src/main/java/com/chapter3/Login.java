package com.chapter3;

import java.io.*;

public class Login implements Serializable {
    private static final long serialVersionUID = 181569760561269743L;

    private String userName;
    private transient String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public Login clone()  {
        Login login = null;
        ByteArrayOutputStream  byteArrayOutputStream = new ByteArrayOutputStream(  );
        try {
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace( );
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            login = (Login)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }
        return login;
    }
}
