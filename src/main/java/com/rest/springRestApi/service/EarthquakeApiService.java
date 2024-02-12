package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.request.EarthQuakeRequest;
import com.rest.springRestApi.data.dto.response.EarthQuakeResponse;

import java.io.IOException;
import java.util.List;

/**
 * <pre>
 *  행정안전부_지진 옥외대피장소 API
 * </pre>
 *
 * @ClassName: EarthquakeApiService
 * @Description: 행정안전부_지진 옥외대피장소 API Service interface
 */
public interface EarthquakeApiService extends ApiExplorerService {
    public List<EarthQuakeResponse> getList(EarthQuakeRequest earthQuakeRequest) throws IOException;
}
