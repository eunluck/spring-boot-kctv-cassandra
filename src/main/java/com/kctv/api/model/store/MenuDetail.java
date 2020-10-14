package com.kctv.api.model.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MenuDetail {

    private String menuTitle;
    private String menuDescription;
    private String menuPrice;
    private String menuImage;



}
