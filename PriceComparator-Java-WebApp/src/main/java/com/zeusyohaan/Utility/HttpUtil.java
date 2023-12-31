package com.zeusyohaan.Utility;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    public static String jsonFromHttpRequest(HttpServletRequest request) throws IOException {
        StringBuilder jsonRequest = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonRequest.append(line);
        }
        return jsonRequest.toString();
    }
}
