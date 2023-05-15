package com.team.appleplate.domain.menu.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponseDto {

    private String name;
    private String menuPrice;

}
