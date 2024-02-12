package com.rest.springRestApi.service;

import com.rest.springRestApi.data.dto.request.ApiExplorerRequest;
import com.rest.springRestApi.data.dto.response.ApiExplorerResponse;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ApiExplorerService {
    public <T extends ApiExplorerRequest> String getBaseURL(T apiExplorerRequest) throws UnsupportedEncodingException;

    public <T extends ApiExplorerResponse> List<T> getJson(ApiExplorerResponse apiExplorerResponse) throws ParseException;
}
