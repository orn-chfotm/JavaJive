package com.rest.springRestApi.service.impl;

import com.rest.springRestApi.data.dto.EarthQuakeDto;
import com.rest.springRestApi.service.EarthquakeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeApiServiceImpl implements EarthquakeApiService {

    @Override
    public List<EarthQuakeDto> getList() {
        return null;
    }
}
