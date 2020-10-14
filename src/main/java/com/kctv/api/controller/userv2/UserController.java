/*

package com.kctv.api.controller.userv2;


import com.kctv.api.config.security.JwtTokenProvider;
import com.kctv.api.model.response.ErrorResult;
import com.kctv.api.model.response.UserResult;
import com.kctv.api.model.userv2.entity.User;
import com.kctv.api.service.userv2.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@RequestMapping("/v3")
@RestController
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;




    @PostMapping("/v2/login")
    public ResponseEntity<?> userLoginV2(@RequestBody User user){

        if(user.getEmailType().equals("user")){
            User login = userService.checkUserEmailService(user.getEmail(),user.getEmailType());
            if(login == null){
                return new ResponseEntity<>(new ErrorResult("가입되지 않은 이메일 주소입니다.",null),HttpStatus.FORBIDDEN);
            }else{
                User loginUser = userService.userLoginService(user.getEmail(),user.getEmailType(),user.getPassword());
                if(loginUser == null){
                    return new ResponseEntity<>(new ErrorResult("비밀번호를 확인해주세요.",null),HttpStatus.FORBIDDEN);
                }else{
                    UserResult result = new UserResult();
                    result.setToken(jwtTokenProvider.createToken(String.valueOf(loginUser.getUserId()), loginUser.getRoles()));
                    result.setUser(loginUser);

                    return new ResponseEntity<>(result,HttpStatus.OK);
                }
            }
        }else{
                if(!user.getSnsKey().equals("") && user.getSnsKey() != null) {
                    User user = userService.snsLogin(user.getEmail(), user.getSnsKey());
                    if (user == null){
                        return new ResponseEntity<>(new ErrorResult("가입되지 않은 이메일입니다.",null), HttpStatus.BAD_REQUEST);
                    }else{
                        UserResult result = new UserResult();
                        result.setToken(jwtTokenProvider.createToken(String.valueOf(user.getUserId()), user.getRoles()));
                        result.setUser(user);
                        return new ResponseEntity<>(result,HttpStatus.OK);
                    }
                }else{
                    return new ResponseEntity<>(new ErrorResult("userSnsKey를 입력해주세요.",null),HttpStatus.NO_CONTENT);
                }
        }
    }


*/
/*
    @PostMapping("/ex/login")
    public ResponseEntity<?> userLogin(@RequestBody User user){

        if(user.getEmailType().equals("user")){
            try {
                User user = userService.userLogin(user.getEmail(),user.getPassword());


                if (user == null){
                    return new ResponseEntity<>(new ErrorResult("아이디와 비밀번호를 확인해주세요.",null),HttpStatus.BAD_REQUEST);
                }else {
                    UserResult result = new UserResult();
                    result.setToken(jwtTokenProvider.createToken(user.getUid(), user.getRoles()));
                    result.setUser(user);


                    return new ResponseEntity<>(result, HttpStatus.OK);
                }

            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            try {
                if(!user.getSnsKey().equals("") && user.getSnsKey() != null) {
                    User user = userService.snsLogin(user.getEmail(), user.getSnsKey());
                    if (user == null){
                        return new ResponseEntity<>(new ErrorResult("가입되지 않은 이메일입니다.",null), HttpStatus.BAD_REQUEST);
                    }else{
                        user.setToken(jwtTokenProvider.createToken(user.getUid(),user.getRoles()));
                        return new ResponseEntity<>(user,HttpStatus.OK);
                    }
                }else{
                    return new ResponseEntity<>(new ErrorResult("userSnsKey를 입력해주세요.",null),HttpStatus.NO_CONTENT);
                }

            }catch (Exception e){
                System.out.println("snsLogin 에러발생");
                e.printStackTrace();
                return new ResponseEntity<>(new ErrorResult("에러발생",null),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }*//*



    @PutMapping("/password")
    public ResponseEntity<?> passwordUpdate(@RequestBody User user){
        System.out.println("패스워드");

        try {
            User updateUser = userService.checkUserEmail(user.getEmail(),user.getEmailType());

            if (updateUser != null) {
                updateUser.setUserPassword(user.getPassword());
                User resultUser = userService.userPasswordUpdate(updateUser);

                return new ResponseEntity<>(resultUser, HttpStatus.OK);
            }else
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
*/
/*
    @PutMapping("/user")
    public ResponseEntity<?> userUpdate(@RequestBody User user){

        try {
            User resultUser = userService.userUpdate(user);

            return new ResponseEntity<>(resultUser, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }*//*



    @GetMapping("/check/{email}/{emailType}")
    public ResponseEntity<?> checkEmail(@PathVariable("email") String email, @PathVariable("emailType") String emailType){


        try {
        User redundant = userService.checkUserEmail(email,emailType);

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
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            user.setRoles(Collections.singletonList("ROLE_USER"));

            System.out.println(user.toString());

            User insertUser = userService.signUpService(user);

            return new ResponseEntity<>(insertUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

*/
/*
    @GetMapping("/user")
    public ResponseEntity<List<?>> getAllUser(@RequestParam(name = "search",required = false) String search,
                                              @RequestParam(name = "kinds",required = false) String kinds) {


        System.out.println("유저리스트호출");
        try {
            List<User> userList = new ArrayList<>();

            if (search == null || search.equals("")) {
                userService.getList().forEach(userList::add);
            }else if(!kinds.equals("") && kinds !=null) {

                if (kinds.equals("userName")){

                    userService.getName(search).forEach(userList::add);

                }else if (kinds.equals("userPhone")){
                    userService.getPhone(search).forEach(userList::add);
                }else if (kinds.equals("userNickname"))
                    userService.getNickname(search).forEach(userList::add);
            }
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*//*

}
*/
