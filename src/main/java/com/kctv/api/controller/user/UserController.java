
package com.kctv.api.controller.user;


import com.kctv.api.config.security.JwtTokenProvider;
import com.kctv.api.model.response.ErrorResult;
import com.kctv.api.model.response.UserResult;
import com.kctv.api.model.user.UserEntity;
import com.kctv.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@RequestMapping("/")
@RestController
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;




    @PostMapping("/login")
    public ResponseEntity<?> userLoginV2(@RequestBody UserEntity userEntity){

        if(userEntity.getUserEmailType().equals("user")){
            UserEntity login = userService.checkUserEmail(userEntity.getUserEmail(),userEntity.getUserEmailType());
            if(login == null){
                return new ResponseEntity<>(new ErrorResult("가입되지 않은 이메일 주소입니다.",null),HttpStatus.FORBIDDEN);
            }else{
                UserEntity loginUser = userService.userLogin(userEntity.getUserEmail(),userEntity.getUserPassword());
                if(loginUser == null){
                    return new ResponseEntity<>(new ErrorResult("비밀번호를 확인해주세요.",null),HttpStatus.FORBIDDEN);
                }else{
                    UserResult result = new UserResult();
                    result.setToken(jwtTokenProvider.createToken(loginUser.getUserUid(), loginUser.getRoles()));
                    result.setUser(loginUser);

                    return new ResponseEntity<>(result,HttpStatus.OK);
                }
            }
        }else{
                if(!userEntity.getUserSnsKey().equals("") && userEntity.getUserSnsKey() != null) {
                    UserEntity user = userService.snsLogin(userEntity.getUserEmail(), userEntity.getUserSnsKey());
                    if (user == null){
                        return new ResponseEntity<>(new ErrorResult("가입되지 않은 이메일입니다.",null), HttpStatus.BAD_REQUEST);
                    }else{
                        UserResult result = new UserResult();
                        result.setToken(jwtTokenProvider.createToken(user.getUserUid(), user.getRoles()));
                        result.setUser(user);
                        return new ResponseEntity<>(result,HttpStatus.OK);
                    }
                }else{
                    return new ResponseEntity<>(new ErrorResult("userSnsKey를 입력해주세요.",null),HttpStatus.NO_CONTENT);
                }
        }
    }




    @PutMapping("/password")
    public ResponseEntity<?> passwordUpdate(@RequestBody UserEntity userEntity){
        System.out.println("패스워드");

        try {
            UserEntity updateUser = userService.checkUserEmail(userEntity.getUserEmail(),userEntity.getUserEmailType());

            if (updateUser != null) {
                updateUser.setUserPassword(userEntity.getUserPassword());
                UserEntity resultUser = userService.userPasswordUpdate(updateUser);

                return new ResponseEntity<>(resultUser, HttpStatus.OK);
            }else
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> userUpdate(@RequestBody UserEntity userEntity){

        try {
            UserEntity resultUser = userService.userUpdate(userEntity);

            return new ResponseEntity<>(resultUser, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @GetMapping("/check/{email}/{emailType}")
    public ResponseEntity<?> checkEmail(@PathVariable("email") String email, @PathVariable("emailType") String emailType){


        try {
        UserEntity redundant = userService.checkUserEmail(email,emailType);

            if (redundant != null)
                return new ResponseEntity<>(new ErrorResult("중복된 이메일입니다.",redundant), HttpStatus.FOUND);
            else
                return new ResponseEntity<>(new ErrorResult("사용 가능한 이메일입니다.",null),HttpStatus.OK);

        }catch (Exception e){

            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        try {
            userEntity.setRoles(Collections.singletonList("ROLE_USER"));
            userEntity.setUserUid(String.valueOf(UUID.randomUUID()));

            System.out.println(userEntity.toString());

            UserEntity insertUser = userService.signUpService(userEntity);

            return new ResponseEntity<>(insertUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/user")
    public ResponseEntity<List<?>> getAllUser(@RequestParam(name = "search",required = false) String search,
                                              @RequestParam(name = "kinds",required = false) String kinds) {


        System.out.println("유저리스트호출");
        try {
            List<UserEntity> userList = new ArrayList<>();

            if (search == null || search.equals("")) {
                userService.getUserList().forEach(userList::add);
            }else if(!kinds.equals("") && kinds !=null) {

                if (kinds.equals("userName")){

                    userService.getUserName(search).forEach(userList::add);

                }else if (kinds.equals("userPhone")){
                    userService.getUserPhone(search).forEach(userList::add);
                }else if (kinds.equals("userNickname"))
                    userService.getUserNickname(search).forEach(userList::add);
            }
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

