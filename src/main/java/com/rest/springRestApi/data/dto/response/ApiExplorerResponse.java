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

    /** Conn Data */
    String resStr;

    /** 전체 페이지 결과 수 */
    private Integer totalCount;

    /** 한 페이지결과 수 */
    private Integer numOfRows;

    /** 페이지 번호 */
    private Integer pageNo;

    /** 수신 문서형식 */
    private String type;

    /** 결과코드 */
    private Integer resultCode;

    /** 결과메세지 */
    private String resultMsg;

    @Builder
    public ApiExplorerResponse(Integer totalCount, Integer numOfRows, Integer pageNo, String type, Integer resultCode, String resStr) {
        this.totalCount = totalCount;
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.type = type;
        this.resultCode = resultCode;
        this.resStr = resStr;
    }
}
