package com.rest.springRestApi.controller;

import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping(value = "/earthQuake")
public class EarthquakeApiController {

    @GetMapping(value = "/getList")
    public List<EarthQuakeResponse> getList() {
        List<EarthQuakeResponse> list = new ArrayList<>();

        return list;
    }
}
