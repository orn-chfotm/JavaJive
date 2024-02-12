package com.rest.springRestApi.controller;

import com.rest.springRestApi.data.dto.request.EarthQuakeRequest;
import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import com.rest.springRestApi.service.EarthquakeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <pre>
 *  행정안전부_지진 옥외대피장소 API
 * </pre>
 *
 * @ClassName: EarthquakeApiController
 * @Description: 행정안전부_지진 옥외대피장소 API Controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/earthQuake")
public class EarthquakeApiController {

    private final EarthquakeApiService earthquakeApiService;

    @GetMapping(value = "/getList")
    public List<EarthQuakeResponse> getList(EarthQuakeRequest earthQuakeRequest) throws IOException, JSONException {
        earthQuakeRequest.setPageNo("1");
        earthQuakeRequest.setType("JSON");
        earthQuakeRequest.setNumOfRows("10");
        List<EarthQuakeResponse> list = earthquakeApiService.getList(earthQuakeRequest);
        return list;
    }
}
