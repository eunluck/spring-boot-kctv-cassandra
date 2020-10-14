package com.kctv.api.controller.place;


import com.kctv.api.common.GeoOperations;
import com.kctv.api.model.store.StoreEntity;
import com.kctv.api.service.place.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/place")
@RestController
public class PlaceController {

    @Autowired
    PlaceService placeService;




    @GetMapping("/hot/{lat}/{lng}")
    public ResponseEntity<?> getPlaceHot(@PathVariable("lat")double lat,
                                         @PathVariable("lng")double lng){



        List<StoreEntity> placeList = placeService.getPlaceHotService(lat,lng);


        return new ResponseEntity<>(placeList, HttpStatus.OK);



    }
    @GetMapping("/wakeup")
    public ResponseEntity<?> getPlaceWakeup(){

        List<StoreEntity> placeList = placeService.getPlaceWakeupService();


        return new ResponseEntity<>(placeList, HttpStatus.OK);



    }



    @GetMapping("/theme")
    public ResponseEntity<?> getThemes(){


        return null;

    }


    @GetMapping("/wifi")
    public void getgeo(@RequestParam("let")double let,@RequestParam("lon") double lon){
        System.out.println(""+let + lon+"::호출");
        GeoOperations geo = new GeoOperations(let,lon);

        geo.GenerateBoxCoordinates(1);


    }
}
