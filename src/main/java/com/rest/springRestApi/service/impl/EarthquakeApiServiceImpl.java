package com.rest.springRestApi.service.impl;

import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import com.rest.springRestApi.service.EarthquakeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeApiServiceImpl implements EarthquakeApiService {

    @Override
    public List<EarthQuakeResponse> getList() {
        return null;
    }
}
