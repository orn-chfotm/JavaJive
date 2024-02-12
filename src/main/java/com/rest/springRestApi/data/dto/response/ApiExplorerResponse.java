package com.rest.springRestApi.data.dto.response;

import lombok.*;

/**
 * @ClassName: ApiExplorerResponse
 * @Description: Api Response DTO 최상위
 */

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class ApiExplorerResponse {

    Integer resCode;

    String resStr;

    @Builder
    public ApiExplorerResponse(Integer resCode, String resStr) {
        this.resCode = resCode;
        this.resStr = resStr;
    }
}
