package com.kctv.api.service.store;


import com.kctv.api.model.store.MenuDetail;
import com.kctv.api.model.store.StoreEntity;
import com.kctv.api.model.store.StoreMenu;
import com.kctv.api.repository.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public StoreEntity getStoreDetailService(String storeUuid){

        // 테스트용 객체 임의생성



        StoreEntity store = new StoreEntity();

        List<String> storeWebpage = new ArrayList<>();

        storeWebpage.add("instagram.com/skgoddns");
        storeWebpage.add("facebook.com/skgoddns");

        MenuDetail menu1 = new MenuDetail("맛있는 청포도주스","제주도에서 재배한 청포도 주스","5000","C://asd.jpg");
        MenuDetail menu2 = new MenuDetail("맛없는 애호박","직접 재배한 애호박 주스","25000","C://애호박.jpg");

        List<MenuDetail> menuDetailList = new ArrayList<>();
        menuDetailList.add(menu1);
        menuDetailList.add(menu2);

        MenuDetail menu3 = new MenuDetail("제주돈까스","연돈에서배워온돈까스","11000","C://asd.jpg");
        MenuDetail menu4 = new MenuDetail("제주흑돼지","직접키운돼지","25000","C://애호박.jpg");

        List<MenuDetail> menuDetailList2 = new ArrayList<>();
        menuDetailList2.add(menu3);
        menuDetailList2.add(menu4);

        StoreMenu storeMenu = new StoreMenu("음료메뉴",menuDetailList);
        StoreMenu storeMenu1 = new StoreMenu("식사메뉴",menuDetailList2);

        List<StoreMenu> menus = new ArrayList<>();

        menus.add(storeMenu);
        menus.add(storeMenu1);


        store.setStoreName("제주말차카페");
        store.setStoreId(storeUuid);
        store.setStoreCategory("카페");
        store.setStoreTel("01023523943");
        store.setStoreAddress("제주시 오렌지동");
        store.setOpenDateTime("09:00");
        store.setCloseDateTime("24:00");
        store.setStoreImageCover("C://kctv.jpg");
        store.setStroeWebpage(storeWebpage);
        store.setStoreLongitude(36.634249797);
        store.setStoreLatitude(127.129160067);
        store.setStoreMenus(menus);



        return store;
    }

}
