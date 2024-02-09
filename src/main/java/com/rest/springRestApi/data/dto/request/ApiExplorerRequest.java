package com.rest.springRestApi.data.dto.request;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class ApiExplorerRequest {

    private String url;

    private String ServiceKey;

    private String type;

    private String serviceNm;

    private String pageNo;

    private String numOfRows;

}
