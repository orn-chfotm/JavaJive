package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.request.TsunamiRequest;
import com.rest.springRestApi.data.dto.response.TsunamiResponse;

import java.io.IOException;
import java.util.List;

public interface TsunamiApiService extends ApiExplorerService{
    public List<TsunamiResponse> getList(TsunamiRequest tsunamiRequest) throws IOException;
}
