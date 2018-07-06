package com.surplus.data.entity;

public class LoginEntity {


    /**
     * response : {"content":{"access_id":"087181d9fd11d5440fe8f6d1c668ad81","access_key":"OTAwMGFiZjRmZDVmYWQ5OTNlMGViYjNhZjg3ZjMyZWM=","address_exists":"2","addtime":1529645222,"app_litpic":"","bank_status":0,"card_id":null,"card_type":"QYBQUA","des_key":"A268C4C7","email":null,"email_status":null,"first_tender_time":"0","insign_flg":"2","insign_time":"","is_birthday_remind":0,"is_lazy_tender":0,"is_lender":0,"is_payment_password":2,"litpic":"","logintime":781,"nick_name":null,"paypwd_status":0,"phone":"13554755002","phone_status":"1","real_status":0,"realname":null,"redis_key":"a01650352dbd46c8b4a9b61dafd97bf16dbf06ede3807eed","sina_status":0,"trackid":"android","user_id":307,"username":"13554755002","withhold":0},"info":{"access_id":"uyujf20171110170798bg0644A3bvg95","code":"100000","maintain_endtime":"0","maintain_starttime":"0","msg":"成功","serversion":"1.0"}}
     */

    private ResponseBean response;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * content : {"access_id":"087181d9fd11d5440fe8f6d1c668ad81","access_key":"OTAwMGFiZjRmZDVmYWQ5OTNlMGViYjNhZjg3ZjMyZWM=","address_exists":"2","addtime":1529645222,"app_litpic":"","bank_status":0,"card_id":null,"card_type":"QYBQUA","des_key":"A268C4C7","email":null,"email_status":null,"first_tender_time":"0","insign_flg":"2","insign_time":"","is_birthday_remind":0,"is_lazy_tender":0,"is_lender":0,"is_payment_password":2,"litpic":"","logintime":781,"nick_name":null,"paypwd_status":0,"phone":"13554755002","phone_status":"1","real_status":0,"realname":null,"redis_key":"a01650352dbd46c8b4a9b61dafd97bf16dbf06ede3807eed","sina_status":0,"trackid":"android","user_id":307,"username":"13554755002","withhold":0}
         * info : {"access_id":"uyujf20171110170798bg0644A3bvg95","code":"100000","maintain_endtime":"0","maintain_starttime":"0","msg":"成功","serversion":"1.0"}
         */

        private ContentBean content;
        private InfoBean info;

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class ContentBean {
            /**
             * access_id : 087181d9fd11d5440fe8f6d1c668ad81
             * access_key : OTAwMGFiZjRmZDVmYWQ5OTNlMGViYjNhZjg3ZjMyZWM=
             * address_exists : 2
             * addtime : 1529645222
             * app_litpic :
             * bank_status : 0
             * card_id : null
             * card_type : QYBQUA
             * des_key : A268C4C7
             * email : null
             * email_status : null
             * first_tender_time : 0
             * insign_flg : 2
             * insign_time :
             * is_birthday_remind : 0
             * is_lazy_tender : 0
             * is_lender : 0
             * is_payment_password : 2
             * litpic :
             * logintime : 781
             * nick_name : null
             * paypwd_status : 0
             * phone : 13554755002
             * phone_status : 1
             * real_status : 0
             * realname : null
             * redis_key : a01650352dbd46c8b4a9b61dafd97bf16dbf06ede3807eed
             * sina_status : 0
             * trackid : android
             * user_id : 307
             * username : 13554755002
             * withhold : 0
             */

            private String access_id;
            private String access_key;
            private String address_exists;
            private int addtime;
            private String app_litpic;
            private int bank_status;
            private Object card_id;
            private String card_type;
            private String des_key;
            private Object email;
            private Object email_status;
            private String first_tender_time;
            private String insign_flg;
            private String insign_time;
            private int is_birthday_remind;
            private int is_lazy_tender;
            private int is_lender;
            private int is_payment_password;
            private String litpic;
            private int logintime;
            private Object nick_name;
            private int paypwd_status;
            private String phone;
            private String phone_status;
            private int real_status;
            private Object realname;
            private String redis_key;
            private int sina_status;
            private String trackid;
            private int user_id;
            private String username;
            private int withhold;

            public String getAccess_id() {
                return access_id;
            }

            public void setAccess_id(String access_id) {
                this.access_id = access_id;
            }

            public String getAccess_key() {
                return access_key;
            }

            public void setAccess_key(String access_key) {
                this.access_key = access_key;
            }

            public String getAddress_exists() {
                return address_exists;
            }

            public void setAddress_exists(String address_exists) {
                this.address_exists = address_exists;
            }

            public int getAddtime() {
                return addtime;
            }

            public void setAddtime(int addtime) {
                this.addtime = addtime;
            }

            public String getApp_litpic() {
                return app_litpic;
            }

            public void setApp_litpic(String app_litpic) {
                this.app_litpic = app_litpic;
            }

            public int getBank_status() {
                return bank_status;
            }

            public void setBank_status(int bank_status) {
                this.bank_status = bank_status;
            }

            public Object getCard_id() {
                return card_id;
            }

            public void setCard_id(Object card_id) {
                this.card_id = card_id;
            }

            public String getCard_type() {
                return card_type;
            }

            public void setCard_type(String card_type) {
                this.card_type = card_type;
            }

            public String getDes_key() {
                return des_key;
            }

            public void setDes_key(String des_key) {
                this.des_key = des_key;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getEmail_status() {
                return email_status;
            }

            public void setEmail_status(Object email_status) {
                this.email_status = email_status;
            }

            public String getFirst_tender_time() {
                return first_tender_time;
            }

            public void setFirst_tender_time(String first_tender_time) {
                this.first_tender_time = first_tender_time;
            }

            public String getInsign_flg() {
                return insign_flg;
            }

            public void setInsign_flg(String insign_flg) {
                this.insign_flg = insign_flg;
            }

            public String getInsign_time() {
                return insign_time;
            }

            public void setInsign_time(String insign_time) {
                this.insign_time = insign_time;
            }

            public int getIs_birthday_remind() {
                return is_birthday_remind;
            }

            public void setIs_birthday_remind(int is_birthday_remind) {
                this.is_birthday_remind = is_birthday_remind;
            }

            public int getIs_lazy_tender() {
                return is_lazy_tender;
            }

            public void setIs_lazy_tender(int is_lazy_tender) {
                this.is_lazy_tender = is_lazy_tender;
            }

            public int getIs_lender() {
                return is_lender;
            }

            public void setIs_lender(int is_lender) {
                this.is_lender = is_lender;
            }

            public int getIs_payment_password() {
                return is_payment_password;
            }

            public void setIs_payment_password(int is_payment_password) {
                this.is_payment_password = is_payment_password;
            }

            public String getLitpic() {
                return litpic;
            }

            public void setLitpic(String litpic) {
                this.litpic = litpic;
            }

            public int getLogintime() {
                return logintime;
            }

            public void setLogintime(int logintime) {
                this.logintime = logintime;
            }

            public Object getNick_name() {
                return nick_name;
            }

            public void setNick_name(Object nick_name) {
                this.nick_name = nick_name;
            }

            public int getPaypwd_status() {
                return paypwd_status;
            }

            public void setPaypwd_status(int paypwd_status) {
                this.paypwd_status = paypwd_status;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhone_status() {
                return phone_status;
            }

            public void setPhone_status(String phone_status) {
                this.phone_status = phone_status;
            }

            public int getReal_status() {
                return real_status;
            }

            public void setReal_status(int real_status) {
                this.real_status = real_status;
            }

            public Object getRealname() {
                return realname;
            }

            public void setRealname(Object realname) {
                this.realname = realname;
            }

            public String getRedis_key() {
                return redis_key;
            }

            public void setRedis_key(String redis_key) {
                this.redis_key = redis_key;
            }

            public int getSina_status() {
                return sina_status;
            }

            public void setSina_status(int sina_status) {
                this.sina_status = sina_status;
            }

            public String getTrackid() {
                return trackid;
            }

            public void setTrackid(String trackid) {
                this.trackid = trackid;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getWithhold() {
                return withhold;
            }

            public void setWithhold(int withhold) {
                this.withhold = withhold;
            }
        }

        public static class InfoBean {
            /**
             * access_id : uyujf20171110170798bg0644A3bvg95
             * code : 100000
             * maintain_endtime : 0
             * maintain_starttime : 0
             * msg : 成功
             * serversion : 1.0
             */

            private String access_id;
            private String code;
            private String maintain_endtime;
            private String maintain_starttime;
            private String msg;
            private String serversion;

            public String getAccess_id() {
                return access_id;
            }

            public void setAccess_id(String access_id) {
                this.access_id = access_id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMaintain_endtime() {
                return maintain_endtime;
            }

            public void setMaintain_endtime(String maintain_endtime) {
                this.maintain_endtime = maintain_endtime;
            }

            public String getMaintain_starttime() {
                return maintain_starttime;
            }

            public void setMaintain_starttime(String maintain_starttime) {
                this.maintain_starttime = maintain_starttime;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getServersion() {
                return serversion;
            }

            public void setServersion(String serversion) {
                this.serversion = serversion;
            }
        }
    }
}
