package com.kctv.api.service.place;


import com.kctv.api.model.store.StoreEntity;
import com.kctv.api.repository.store.StoreRepository;
import com.kctv.api.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    StoreService storeService;
    public List<StoreEntity> getPlaceHotService(double userLat, double userLng){


        List<StoreEntity> hotList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hotList.add(storeService.getStoreDetailService("hotplace::"+i));
        }

        return hotList;

    }
    public List<StoreEntity> getPlaceWakeupService(){


        List<StoreEntity> wakeupService = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wakeupService.add(storeService.getStoreDetailService("wakeup::"+i));

        }

        return wakeupService;

    }





}
