package com.rest.springRestApi.data.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class EarthQuakeBasicDto {

    private String ServiceKey;

    private String pageNo;

    private String numOfRows;

    private String type;
}
