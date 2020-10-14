package com.kctv.api.model.store;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreEntity {


    private String storeId; //UUID
    private String storeName; //가게이름
    private String storeAddress; // 가게주소
    private String storeImageCover; //대표이미지
    private String storeTel; //전화번호
    private List<String> stroeWebpage; //대표홈페이지
    private String storeCategory; // 가게분류 (ex: 카페, 중식당, 한식당)
    private double storeLatitude; // 위도
    private double storeLongitude; //경도
    private String openDateTime; //오픈시간
    private String closeDateTime; //마감시간
    private List<StoreMenu> storeMenus; //메뉴리스트









}
