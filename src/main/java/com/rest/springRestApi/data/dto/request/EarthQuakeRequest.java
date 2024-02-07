package com.rest.springRestApi.data.dto.request;

import lombok.*;

/**
 * <pre>
 *  행정안전부_지진 옥외대피장소 API 호출 사용 DTO
 * </pre>
 *
 * @ClassName: EarthQuakeRequestDto
 * @Description: 행정안전부_지진 옥외대피장소 API 호출 사용 DTO
 */
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class EarthQuakeRequest {

    private String ServiceKey;

    private String pageNo;

    private String numOfRows;

    private String type;

    private String arcd;

    private String ctprvn_nm;

    private String sgg_nm;
}
