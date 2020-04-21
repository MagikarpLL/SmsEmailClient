package cn.magikarpll.smsemailclient.common.exception;

public enum BusinessCodeEnum implements BaseErrorInfoInterface{

    PARAMETER_INVALID("PARAMETER_INVALID", "INVALID PARAMETER!");


    /** 错误码 */
    private String resultCode;

    /** 错误描述 */
    private String resultMsg;

    BusinessCodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
