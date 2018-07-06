package com.surplus.data;

public class UserFacade {

    private static UserFacade instance =new UserFacade();
    private String  access_id;
    private String access_key;
    private UserFacade(){

    }

    public static UserFacade getIns() {
        return instance;
    }


    /**
     * 获取用户的 ACCESSID
     *
     * @return String 未登录：返回默认的 ACCESSID、已登录：返回登录后的 ACCESSID
     */
    public String getAccessId() {
        if (access_id == null || access_id.equals("")){
            return "uyujf20171110170798bg0644A3bvg95";
        }
        return access_id;
    }

    /**
     * 设置用户的 ACCESSID
     *
     *
     */
    public void setAccessId(String accessId){
       this.access_id = accessId;
    }


    /**
     * 获取用户的 ACCESSKEY
     *
     * @return String 未登录：返回 默认的 ACCESSKEY 、已登录：返回登录后新生成的 ACCESSKEY
     */
    public String getAccessKey() {
        if (access_key == null || access_key.equals(""))
            return "uyujf2017111017240BjkRkOwMmP1OwB3NjTxOGNmMnZ";
        return access_key;
    }


    /**
     * 设置用户的 ACCESSID
     *
     *
     */
    public void setAccessKey(String accessId){
        this.access_key = accessId;
    }
}
