package com.rest.springRestApi.util;

import com.rest.springRestApi.data.dto.response.ApiExplorerResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <pre>
 *  공공데이터 포털 통신 Util Class
 * </pre>
 *
 * @ClassName: ApiExplorer
 * @Description: 공공데이터 포털 통신 Util Class
 */

@Log4j2
public class ApiExplorer{

    private static RestTemplate restTemplate;

    /**
     * URL Connection Common
     *
     * @param urlStr connection base URL
     * @param method connection Method(GET, POST)
     */
    public static ApiExplorerResponse getConntion(String urlStr, String method) throws IOException {

        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(method);
        urlConnection.setRequestProperty("Content-type", "application/json");
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setDoInput(true);

        log.info("ApiExplorer getConntion URL : " + urlStr);
        log.info("ApiExplorer getConntion resCode : " + urlConnection.getResponseCode());

        BufferedReader br;
        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } else {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        ApiExplorerResponse apiExplorerResponse = ApiExplorerResponse.builder()
                .resultCode(urlConnection.getResponseCode())
                .resStr(sb.toString())
                .build();

        br.close();
        urlConnection.disconnect();

        return apiExplorerResponse;
    }

    /**
     * URL Connection Common RestTemplate
     *
     */
    public static ApiExplorerResponse getConntionRestTemple(String urlStr, HttpMethod method) throws IOException {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(20000);
        factory.setReadTimeout(20000);

        RestTemplate restTemplate = new RestTemplate(factory);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity response = restTemplate.exchange(urlStr, method, entity, String.class);

        ApiExplorerResponse apiExplorerResponse = ApiExplorerResponse.builder()
                .resultCode(response.getStatusCodeValue())
                .resStr((String) response.getBody())
                .build();

        return apiExplorerResponse;
    }

}
