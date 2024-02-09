package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import com.rest.springRestApi.util.ApiExplorer;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface EarthquakeApiService {
    public List<EarthQuakeResponse> getList(ApiExplorerRequest apiExplorerRequest) throws IOException, JSONException;
}
