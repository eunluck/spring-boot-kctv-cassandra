package com.kctv.api.controller.store;


import com.kctv.api.model.store.StoreEntity;
import com.kctv.api.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    StoreService storeService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getStoreDetail(@PathVariable("id") String id){

        try {

             StoreEntity store = storeService.getStoreDetailService(id);

            return new ResponseEntity<>(store, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }




}
