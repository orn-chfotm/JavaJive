package com.rest.springRestApi.service.impl;

import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import com.rest.springRestApi.data.dto.request.EarthQuakeRequest;
import com.rest.springRestApi.data.dto.response.ApiExplorerResponse;
import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import com.rest.springRestApi.service.EarthquakeApiService;
import com.rest.springRestApi.util.ApiExplorer;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  행정안전부_지진 옥외대피장소 API
 * </pre>
 *
 * @ClassName: EarthquakeApiServiceImpl
 * @Description: 행정안전부_지진 옥외대피장소 API Service interface implements
 */
@Service
@RequiredArgsConstructor
public class EarthquakeApiServiceImpl implements EarthquakeApiService {

    @Value("${api.Earthquake.baseURL}")
    private String baseURL;

    @Value("${api.Earthquake.EncodingKey}")
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
                .append("=").
                append(URLEncoder.encode(apiExplorerRequest.getPageNo(), UNC));
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
        JSONArray jsonArray = (JSONArray) jsonObject.get("EarthquakeOutdoorsShelter");

        List<EarthQuakeResponse> resList = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject object = (JSONObject) obj;
            if(object.get("row") != null ){
                resList = (List<EarthQuakeResponse>) object.get("row");
            }
        }

        return (List<T>) resList;
    }


    @Override
    public List<EarthQuakeResponse> getList(EarthQuakeRequest earthQuakeRequest) {
        List<EarthQuakeResponse> list = new ArrayList<>();
        try {
            ApiExplorerResponse apiExplorerResponse = ApiExplorer.getConntion(this.getBaseURL(earthQuakeRequest), earthQuakeRequest.getReqType());
            if(apiExplorerResponse.getResultCode() == HttpURLConnection.HTTP_OK) {
                list = this.getJson(apiExplorerResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
