package com.rest.springRestApi.service.impl;

import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;
import com.rest.springRestApi.service.EarthquakeApiService;
import com.rest.springRestApi.util.ApiExplorer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeApiServiceImpl implements EarthquakeApiService {

    @Override
    public List<EarthQuakeResponse> getList(ApiExplorerRequest apiExplorerRequest) throws IOException, JSONException {
        ApiExplorer.getConApi(apiExplorerRequest);

        List<EarthQuakeResponse> list = new ArrayList<>();
        return list;
    }
}
