package com.rest.springRestApi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import com.rest.springRestApi.data.dto.request.TsunamiRequest;
import com.rest.springRestApi.data.dto.response.ApiExplorerResponse;
import com.rest.springRestApi.data.dto.response.TsunamiResponse;
import com.rest.springRestApi.service.TsunamiApiService;
import com.rest.springRestApi.util.ApiExplorer;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TsunamiApiServiceImpl implements TsunamiApiService {

    @Value("${api.Tsunami.baseURL}")
    private String baseURL;

    @Value("${api.Tsunami.EncodingKey}")
    private String serviceKey;

    private final String UNC = "UTF-8";

    @Override
    public <T extends ApiExplorerRequest> String getBaseURL(T apiExplorerRequest) throws UnsupportedEncodingException {
        StringBuffer urlBuffer = new StringBuffer(baseURL);
        urlBuffer.append("?")
                .append(URLEncoder.encode("ServiceKey", UNC))
                .append("=")
                .append(serviceKey);
        urlBuffer.append("&")
                .append(URLEncoder.encode("pageNo", UNC))
                .append("=")
                .append(URLEncoder.encode(apiExplorerRequest.getPageNo(), UNC));
        urlBuffer.append("&")
                .append(URLEncoder.encode("numOfRows", UNC))
                .append("=")
                .append(URLEncoder.encode(apiExplorerRequest.getNumOfRows(), UNC));
        urlBuffer.append("&")
                .append(URLEncoder.encode("type", UNC))
                .append("=")
                .append(URLEncoder.encode(apiExplorerRequest.getType(), UNC));

        return urlBuffer.toString();
    }

    @Override
    public <T extends ApiExplorerResponse> List<T> getJson(ApiExplorerResponse apiExplorerResponse) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(apiExplorerResponse.getResStr());
        JSONArray jsonArray = (JSONArray) jsonObject.get("TsunamiShelter");

        List<TsunamiResponse> list = new ArrayList<>();
        for(Object obj : jsonArray) {
            JSONObject object = (JSONObject) obj;
            if(object.get("row") != null) {
                list = (List<TsunamiResponse>) object.get("row");
            }
        }
        return (List<T>) list;
    }

    @Override
    public List<TsunamiResponse> getList(TsunamiRequest tsunamiRequest) throws IOException {
        List<TsunamiResponse> resList = new ArrayList<>();

        try {
            ApiExplorerResponse apiExplorerResponse = ApiExplorer.getConntion(this.getBaseURL(tsunamiRequest), tsunamiRequest.getReqType());
            if(apiExplorerResponse.getResultCode() == HttpURLConnection.HTTP_OK) {
                resList = this.getJson(apiExplorerResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }
}
