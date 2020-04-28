package com.rzm.downloadmodle.down;

import java.util.Map;
import okhttp3.Request;

public class HttpUtils {
    /**
     * get请求
     * @param path
     * @param params
     * @return
     */
    public static Request getRequest(String path, Map<String, Object> params) {
        StringBuffer urlBuffer = new StringBuffer(Constants.Http.HOST);
        urlBuffer.append(path);
        urlBuffer.append(getUrlParamsByMap(params));
        Request request = new Request.Builder().get().url(urlBuffer.toString()).build();
        return request;
    }


    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer("?");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}