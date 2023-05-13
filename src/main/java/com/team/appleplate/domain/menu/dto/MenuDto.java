package com.team.appleplate.domain.menu.dto;

import com.team.appleplate.domain.menu.domain.Menu;
import lombok.*;

public class MenuDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {

        private String name;
        private String menuPrice;
        private String menuCategory;

        public MenuDto.Response fromEntity() {
            return Response.builder()
                    .name(this.name)
                    .menuPrice(this.menuPrice)
                    .menuCategory(this.menuCategory)
                    .build();
        }
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {

        private String name;
        private String menuPrice;
        private String menuCategory;

        public Menu toEntity() {
            return Menu.builder()
                    .name(this.name)
                    .menuPrice(this.menuPrice)
                    .menuCategory(this.menuCategory)
                    .build();
        }
    }
}
