package com.rest.springRestApi.data.dto.response;

import lombok.*;

/**
 * <pre>
 *  행정안전부_지진 옥외대피장소 API return Data DTO
 * </pre>
 *
 * @ClassName: EarthQuakeDto
 * @Description: 행정안전부_지진 옥외대피장소 API return Data DTO
 */
@Getter @Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class EarthQuakeResponse {

    private String arcd;

    private String acmdfcltySn;

    private String ctprvnNm;

    private String sggNm;

    private String vtAcmdfcltyNm;

    private String rdnmadrCd;

    private String bdongCd;

    private String hdongCd;

    private String dtlAdres;

    private String fcltyAr;

    private String xcord;

    private String ycord;
}
