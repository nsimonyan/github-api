package com.nsimonyan.wf.github.commons.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeUtils {


    private EncodeUtils(){}
    public static String encode(String param) {
        String encoded = "";

        try {
            encoded  = URLEncoder.encode(param, "UTF-8");

            encoded = encoded.replaceAll("\\+", "%20");

        } catch (UnsupportedEncodingException e) { }

        return encoded;
    }

    public static String decode(String param) {
        String encoded = "";

        try {
            encoded  = URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) { }

        return encoded;
    }

    public static String tryToDecode(String param) {
        String encoded = param;

        try {
            encoded  = URLDecoder.decode(param, "UTF-8");
        } catch (Throwable e) { }

        return encoded;
    }

}
