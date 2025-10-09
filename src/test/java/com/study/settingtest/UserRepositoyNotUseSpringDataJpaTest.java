package com.study.settingtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@Rollback(false)
class UserRepositoyNotUseSpringDataJpaTest {
    @Autowired
    UserRepositoyNotUseSpringDataJpa userRepositoyNotUseSpringDataJpa;

    @Test
    public void testSaveMethod() throws Exception {
        // given
        User user = new User();
        user.setName("TestUser");

        // when
        Long savedId = userRepositoyNotUseSpringDataJpa.save(user);
        Long id = user.getId();

        // then
//        System.out.println("id = " + id);
//        System.out.println("savedId = " + savedId);
        Assertions.assertThat(savedId).isEqualTo(id);
    }

    @Test
    public void testFindById() throws Exception {
        // given
        User user = new User();
        user.setName("TestUser2");

        // when
        Long userId = userRepositoyNotUseSpringDataJpa.save(user);
        User foundUser = userRepositoyNotUseSpringDataJpa.findById(userId);

        // then
        Assertions.assertThat(foundUser.getId()).isEqualTo(userId);
        Assertions.assertThat(foundUser).isEqualTo(user);   // 같은 영속성 컨텍스트 내 니까, 식별자가 같으면 같은 객체!

    }

}