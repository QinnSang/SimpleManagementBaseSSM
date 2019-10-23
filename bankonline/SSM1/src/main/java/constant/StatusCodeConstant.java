package constant;

/**
 * 状态常量定义表
 */
public class StatusCodeConstant {

    /**
     * 账号存在
     */
    public static final int Exists=2000;
    public static final String Exists_MSG="账号存在";

    /**
     * 账号不存在
     */
    public static final int Not_Exists=2001;
    public static final String Not_Exists_MSG="账号不存在";
    /**
     * 账号已被冻结
     */
    public static final int Account_flozen=2002;
    public static final String Account_flozen_MSG="账号已被冻结";
    /**
     * 余额不足
     */
    public static final int LackMoney=2003;
    public static final String LackMoney_MSG="余额不足";

    /**
     * 转账成功
     */
    public static final int Success=1999;
    public static final String Success_MSG="转账成功";

}
