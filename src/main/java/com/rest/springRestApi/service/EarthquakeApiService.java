package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;

import java.util.List;

public interface EarthquakeApiService {
    public List<EarthQuakeResponse> getList();
}
