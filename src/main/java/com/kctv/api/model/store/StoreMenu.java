package com.kctv.api.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor

public class StoreMenu {

    private String menuCategory;
    private List<MenuDetail> menuList;


}
