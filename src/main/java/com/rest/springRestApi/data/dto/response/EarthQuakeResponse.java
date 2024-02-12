package com.rest.springRestApi.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Data
public class EarthQuakeResponse extends ApiExplorerResponse{

    private String arcd;

    @JsonProperty("acmdfclty_sn")
    private String acmdfcltySn;

    @JsonProperty("ctprvn_nm")
    private String ctprvnNm;

    @JsonProperty("sgg_nm")
    private String sggNm;

    @JsonProperty("vt_acmdfclty_nm")
    private String vtAcmdfcltyNm;

    @JsonProperty("rdnmadr_cd")
    private String rdnmadrCd;

    @JsonProperty("bdong_cd")
    private String bdongCd;

    @JsonProperty("hdong_cd")
    private String hdongCd;

    @JsonProperty("dtl_adres")
    private String dtlAdres;

    @JsonProperty("fclty_ar")
    private String fcltyAr;

    private String xcord;

    private String ycord;
}
