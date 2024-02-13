package com.rest.springRestApi.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TsunamiResponse extends ApiExplorerResponse{

    /** 일련 번호 */
    private Integer id;

    /** 시도명 */
    private String sidoName;

    /** 시군구명 */
    private String sigunguName;

    /** 대피지구명 */
    private String remarks;

    /** 대피장소명 */
    private String shelNm;

    /** 주소 */
    private String address;

    /** 경도 */
    private String lon;

    /** 위도 */
    private String lat;

    /** 수용가능인원수(명) */
    private Integer shelAv;

    /** 해변으로부터거리 */
    private Integer lenth;

    /** 대피소 분류명 */
    private String shelDivType;

    /** 내진적용여부 */
    private String seismic;

    /** 해발높이 */
    private String height;
}
