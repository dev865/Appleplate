package com.team.appleplate.domain.store.service;

import com.team.appleplate.domain.menu.domain.Menu;
import com.team.appleplate.domain.menu.repository.MenuRepository;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.domain.store.dto.CreateStoreDto;
import com.team.appleplate.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    /**
     * 가게 등록
     */
    public void createStore(final CreateStoreDto.Request request) {
        existStoreName(request.getName());

        Store store = request.toEntity();
        Store saveStore = storeRepository.save(store);

        List<Menu> menus = store.getMenus();
        menus.forEach(menu -> menu.addStore(saveStore));

        menuRepository.saveAll(menus);
    }


    public void existStoreName(final String storeName) {
        List<Store> findStore = storeRepository.findByName(storeName);

        if (!findStore.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 식당입니다.");
        }
    }

}