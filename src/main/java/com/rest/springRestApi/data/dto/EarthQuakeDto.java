package com.rest.springRestApi.data.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class EarthQuakeDto {

    private String arcd;

    private String acmdfclty_sn;

    private String ctprvn_nm;

    private String sgg_nm;

    private String vt_acmdfclty_nm;

    private String rdnmadr_cd;

    private String bdong_cd;

    private String hdong_cd;

    private String dtl_adres;

    private String fclty_ar;

    private String xcord;

    private String ycord;
}
