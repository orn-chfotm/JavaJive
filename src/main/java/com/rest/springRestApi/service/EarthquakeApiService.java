package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.EarthQuakeDto;

import java.util.List;

public interface EarthquakeApiService {
    public List<EarthQuakeDto> getList();
}
