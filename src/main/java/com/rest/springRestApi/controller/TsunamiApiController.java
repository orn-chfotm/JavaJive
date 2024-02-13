package com.rest.springRestApi.controller;

import com.rest.springRestApi.data.dto.request.TsunamiRequest;
import com.rest.springRestApi.data.dto.response.TsunamiResponse;
import com.rest.springRestApi.service.TsunamiApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  행정안전부_지진해일 긴급대피장소 API
 * </pre>
 *
 * @ClassName: TsunamiApiController
 * @Description: 행정안전부_지진해일 긴급대피장소 API Controller
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tsunami")
public class TsunamiApiController {

    private final TsunamiApiService tsunamiApiService;

    @GetMapping(value = "/getList")
    public List<TsunamiResponse> getList(TsunamiRequest tsunamiRequest) throws IOException {
        List<TsunamiResponse> resList = new ArrayList<>();
        try {
            resList = tsunamiApiService.getList(tsunamiRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resList;
    }
}
