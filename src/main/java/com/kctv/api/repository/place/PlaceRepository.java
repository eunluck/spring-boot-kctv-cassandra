
package com.kctv.api.repository.place;


import com.kctv.api.model.user.UserEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends CassandraRepository<UserEntity, String> {
/*

    @Query( "UPDATE user_list_asc SET user_password = :userPassword WHERE user_email_type = :userEmailType AND user_email = :userEmail")
    UserEntity updateByUserEmailAndUserEmailType(@Param("userEmailType") String userEmailType,
                                                 @Param("userEmail") String userEmail,
                                                 @Param("userPassword") String userPassword);

    @AllowFiltering
    List<UserEntity> findByUserNameContaining(String search);
    @AllowFiltering
    List<UserEntity> findByUserNicknameContaining(String search);
    @AllowFiltering
    List<UserEntity> findByUserPhoneContaining(String search);

    @AllowFiltering
    UserEntity findByUserEmailAndUserEmailType(String email, String emailType);

    UserEntity findByUserEmailAndUserEmailTypeAndUserPassword(String email, String emailType, String pwd);


    @AllowFiltering
    UserEntity findByUserUid(String uid);

    @AllowFiltering
    UserEntity findByUserEmailAndUserSnsKey(String email, String SnsKey);

    //List<UserVO> findByTitleContaining(String title); // Containing : like
*/


}
