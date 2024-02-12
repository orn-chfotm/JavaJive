package com.rest.springRestApi.data.dto.request;

import lombok.*;

/**
 * @ClassName: ApiExplorerRequest
 * @Description: Api Request DTO 최상위
 */

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class ApiExplorerRequest {

    private String reqType;

    private String url;

    private String ServiceKey;

    private String type;

    private String serviceNm;

    private String pageNo;

    private String numOfRows;

}
