package com.team.appleplate.domain.menu.dto;

import com.team.appleplate.domain.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequestDto {

        private String name;
        private String menuPrice;

        public Menu toEntity() {
            return Menu.builder()
                    .name(this.name)
                    .menuPrice(this.menuPrice)
                    .build();
        }
}
