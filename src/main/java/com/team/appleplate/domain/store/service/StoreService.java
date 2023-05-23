package com.team.appleplate.domain.store.service;

import com.team.appleplate.domain.menu.domain.Menu;
import com.team.appleplate.domain.menu.repository.MenuRepository;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.domain.store.dto.CreateStoreRequestDto;
import com.team.appleplate.domain.store.dto.StoreResponseDto;
import com.team.appleplate.domain.store.dto.UpdateStoreRequestDto;
import com.team.appleplate.domain.store.exception.StoreDeleteException;
import com.team.appleplate.domain.store.exception.StoreDuplicateException;
import com.team.appleplate.domain.store.exception.StoreNotFoundException;
import com.team.appleplate.domain.store.repository.StoreRepository;
import com.team.appleplate.global.exception.ErrorCode;
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
    public void createStore(final CreateStoreRequestDto request) {
        existStoreName(request.getName());

        Store store = request.toEntity();
        Store saveStore = storeRepository.save(store);

        List<Menu> menus = store.getMenus();
        menus.forEach(menu -> menu.addStore(saveStore));

        menuRepository.saveAll(menus);
    }

    /**
     * 가게 정보 수정
     */
    public void updateStore(final Long id, final UpdateStoreRequestDto request) {
        Store findStore = getStore(id);
        Store updateStore = findStore.updateStore(request);

        List<Menu> menus = updateStore.getMenus();
        menus.forEach(menu -> menu.addStore(updateStore));
    }

    /**
     * 가게 단건 조회
     */
    @Transactional(readOnly = true)
    public StoreResponseDto getStoreDetail(Long id) {
        Store store = getStore(id);

        return StoreResponseDto.fromEntity(store);
    }

    /**
     * 가게 삭제(deleteYn 상태 변경)
     */
    public void deleteStore(final Long id) {
        Store store = getStore(id);
        store.deleteStore(id);
    }

    /**
     * 가게 조회 검증
     */
    public Store getStore(Long id) {

        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException(ErrorCode.STORE_NOT_FOUND));

        isDelete(id, store);

        return store;
    }

    /**
     * 삭제된 가게인지 검증
     */
    private static void isDelete(Long id, Store store) {
        if (store.getName() == "deleteStore" + id || store.getDeleteYn() == 'Y') {
            throw new StoreDeleteException(ErrorCode.DELETED_STORE);
        }
    }

    /**
     * 가게이름이 이미 존재하는지 검증
     */
    public void existStoreName(final String storeName) {
        List<Store> findStore = storeRepository.findByName(storeName);

        if (!findStore.isEmpty()) {
            throw new StoreDuplicateException(ErrorCode.DUPLICATE_STORE_NAME);
        }
    }

}