package com.rest.springRestApi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * <pre>
 *  공공데이터 포털 통신 Util Class
 * </pre>
 *
 * @ClassName: ApiExplorer
 * @Description: 공공데이터 포털 통신 Util Class
 */

@Log4j2
public class ApiExplorer{

    public static void getConApi(ApiExplorerRequest apiExplorerRequest) throws IOException {
        final String UNC = "UTF-8";
        // Api Url
        //StringBuilder urlBuilder = new StringBuilder(apiExplorerRequest.getUrl());
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/1741000/EmergencyAssemblyArea_Earthquake3/getArea3List");

        urlBuilder.append("?").append(URLEncoder.encode("ServiceKey", UNC)).append("=").append("%2Bn9ZwKaEA0%2FZzATwHrLLjpzLtJNyZQnIGhoOQYgZQ65rUGySka3qW95tM9lhzAaCszxEOaphTYE9DSF%2FNNFgaQ%3D%3D");
        urlBuilder.append("&").append(URLEncoder.encode("pageNo", UNC)).append("=").append(URLEncoder.encode("1", UNC));
        urlBuilder.append("&").append(URLEncoder.encode("numOfRows", UNC)).append("=").append(URLEncoder.encode("10", UNC));
        urlBuilder.append("&").append(URLEncoder.encode("type", UNC)).append("=").append(URLEncoder.encode("JSON", UNC));

        //urlBuilder.append("?").append(URLEncoder.encode("ServiceKey", UNC)).append("=").append(apiExplorerRequest.getServiceKey());
        //urlBuilder.append("&").append(URLEncoder.encode("pageNo", UNC)).append("=").append(URLEncoder.encode(apiExplorerRequest.getPageNo(), UNC));
        //urlBuilder.append("&").append(URLEncoder.encode("numOfRows", UNC)).append("=").append(URLEncoder.encode(apiExplorerRequest.getNumOfRows(), UNC));
        //urlBuilder.append("&").append(URLEncoder.encode("type", UNC)).append("=").append(URLEncoder.encode(apiExplorerRequest.getType(), UNC));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setRequestMethod("GET");
        urlConn.setRequestProperty("Content-type", "application/json");

        log.info("Response Code :: " + urlConn.getResponseCode());

        BufferedReader br;

        if (urlConn.getResponseCode() >= 200 && urlConn.getResponseCode() <= 300) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        System.err.println(sb.toString());

        br.close();
        urlConn.disconnect();
        /*
        JSONArray dataArr = null;
        try {
            // 1. 문자열 형태의 JSON을 파싱하기 위한 JSONParser 객체 생성.
            JSONParser parser = new JSONParser(sb.toString());
            // 2. 문자열을 JSON 형태로 JSONObject 객체에 저장.
            JSONObject obj = (JSONObject) parser.parse();
            // 3. 필요한 리스트 데이터 부분만 가져와 JSONArray로 저장.
            dataArr = (JSONArray) obj.get("row");
            // 4. model에 담아준다.
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return dataArr;
        */
    }

}
