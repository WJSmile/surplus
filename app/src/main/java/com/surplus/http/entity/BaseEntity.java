package com.surplus.http.entity;

public class BaseEntity {

    /**
     * request : {"common":{"device_port":"android","ip":"127.0.0.1","reqtime":1530671774,"trackid":"Android","version":"1.0.6","action":"user_login"},"content":{"device_id":"356420091550772","device_mark":"device","device_name":"SM-G9650","login_type":"1","password":"420f07406bb38e7e","user_name":"13554755002","accessid":"uyujf20171110170798bg0644A3bvg95"}}
     */

    private RequestBean request;

    public RequestBean getRequest() {
        return request;
    }


    public void setRequest(RequestBean request) {
        this.request = request;
    }

    public static class RequestBean {

        public RequestBean(CommonBean common, Object content) {
            this.common = common;
            this.content = content;
        }

        /**
         * common : {"device_port":"android","ip":"127.0.0.1","reqtime":1530671774,"trackid":"Android","version":"1.0.6","action":"user_login"}
         * content : {"device_id":"356420091550772","device_mark":"device","device_name":"SM-G9650","login_type":"1","password":"420f07406bb38e7e","user_name":"13554755002","accessid":"uyujf20171110170798bg0644A3bvg95"}
         */

        private CommonBean common;
        private Object content;

        public CommonBean getCommon() {
            return common;
        }

        public void setCommon(CommonBean common) {
            this.common = common;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class CommonBean {
            public CommonBean(String device_port, String ip, long reqtime, String trackid, String version, String action) {
                this.device_port = device_port;
                this.ip = ip;
                this.reqtime = reqtime;
                this.trackid = trackid;
                this.version = version;
                this.action = action;
            }

            /**
             * device_port : android
             * ip : 127.0.0.1
             * reqtime : 1530671774
             * trackid : Android
             * version : 1.0.6
             * action : user_login
             */

            private String device_port;
            private String ip;
            private long reqtime;
            private String trackid;
            private String version;
            private String action;

            public String getDevice_port() {
                return device_port;
            }

            public void setDevice_port(String device_port) {
                this.device_port = device_port;
            }

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public long getReqtime() {
                return reqtime;
            }

            public void setReqtime(int reqtime) {
                this.reqtime = reqtime;
            }

            public String getTrackid() {
                return trackid;
            }

            public void setTrackid(String trackid) {
                this.trackid = trackid;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }
        }
    }
}
