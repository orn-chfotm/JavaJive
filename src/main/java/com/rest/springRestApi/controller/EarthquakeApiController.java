package com.rest.springRestApi.controller;

import com.rest.springRestApi.data.dto.EarthQuakeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EarthquakeApiController {

    @GetMapping(value = "/getList")
    public List<EarthQuakeDto> getList() {
        List<EarthQuakeDto> list = new ArrayList<>();

        return list;
    }
}
