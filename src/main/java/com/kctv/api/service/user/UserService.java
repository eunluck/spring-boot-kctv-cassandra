package com.kctv.api.service.user;


import com.kctv.api.model.user.UserEntity;
import com.kctv.api.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {



    @Autowired
    UserRepository userRepository;


    public UserEntity userUpdate(UserEntity userEntity){


        UserEntity updateUser = checkUserEmail(userEntity.getUserEmail(),userEntity.getUserEmailType());

        if (updateUser != null) {


            updateUser.setUserPassword(userEntity.getUserPassword());
            updateUser.setUserAddress(userEntity.getUserAddress());
            updateUser.setUserNickname(userEntity.getUserNickname());
            updateUser.setUpdateDate(new Date());

            return userRepository.save(updateUser);

        }else{
            return userEntity;
        }


    }


    public UserEntity signUpService(UserEntity userEntity){

        System.out.println("호출");
        userEntity.setCreateDate(new Date());
        System.out.println(userEntity.toString());
       return userRepository.save(userEntity);

    }


    public List<UserEntity> getUserList() {



        return userRepository.findAll();

    }

    public List<UserEntity> getUserName(String search) {

        return userRepository.findByUserNameContaining(search);
    }



    public List<UserEntity> getUserNickname(String search) {

        return userRepository.findByUserNicknameContaining(search);
    }



    public List<UserEntity> getUserPhone(String search) {

        return userRepository.findByUserPhoneContaining(search);
    }

    public UserEntity checkUserEmail(String email,String eamilType){

        return userRepository.findByUserEmailAndUserEmailType(email,eamilType);

    }

    public UserEntity userPasswordUpdate(UserEntity userEntity){


        userEntity.setUpdateDate(new Date());

        return userRepository.save(userEntity);
    }


    public UserEntity userLogin(String id, String pwd){


        return userRepository.findByUserEmailAndUserEmailTypeAndUserPassword(id,"user",pwd);

    }

    public UserEntity snsLogin(String id, String Snskey){

        return userRepository.findByUserEmailAndUserSnsKey(id,Snskey);

    }



    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        return userRepository.findByUserUid(uuid);
    }
}
