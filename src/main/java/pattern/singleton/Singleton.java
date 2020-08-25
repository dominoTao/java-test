package pattern.singleton;

public enum Singleton {
    INSTANCE("0000","我是一个实例"),
    ERROR("1030","缺失必要参数:%s"),
    MISSING_PARAMETER("9999","系统异常");
    private String code;
    private String msg;

    Singleton(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg(Object... orgs) {
        if(msg==null){
            return msg;
        }
        return String.format(msg, orgs);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
