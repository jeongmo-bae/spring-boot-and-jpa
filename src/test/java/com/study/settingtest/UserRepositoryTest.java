package com.study.settingtest;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testConnectionAndSave() {
        //given
        User user = new User();
        user.setName("TestUser");
        userRepository.save(user);

        //when
        User foundUser = userRepository.findById(user.getId()) // SELECT 수행
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // then
        System.out.println("foundUser.getId() = " + foundUser.getId());
        System.out.println("foundUser.getName() = " + foundUser.getName());
        assertThat(foundUser.getId()).isEqualTo(user.getId());
        assertThat(foundUser.getName()).isEqualTo("TestUser");

    }
}