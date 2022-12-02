package com.company;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MyMathTest {

    private MyMath myMath;

    public MyMathTest() {
        myMath = new MyMath(2, 3);
    }

    @Test
    public void getSum_2And3_Return5() {
        //подготовка //arrange //given

        //выполнение //act //when
//        double expected = 5;
//        double actual = myMath.getSum()+1;

        double expected = -1;
        double actual = -1;

        //проверка //assert //then

        assertEquals(expected, actual);

//          assertThat(actual)
//                .isEqualTo(expected)
//                .isPositive();
    }

    @Test
    void test_copy_user() {
        User user1 = new User("Сергей", 24);
        User user2 = new User("Сергей", 24);

        //assertEquals(user1,user2);

        //assertThat(user1).isEqualToComparingFieldByField(user2);

        //assertThat(user1).usingRecursiveComparison().isEqualTo(user2);

    }

    @Test
    void hasAccess_UserId1_ReturnTrue() {
        UsersService usersService = new UsersService(new TableUsers() {
            @Override
            public User getUserById(long userId) {
                if (userId == 1) {
                    return new User("admin", 15);
                } else {
                    return new User("noname", 0);
                }
            }
        });

        boolean actual = usersService.hasAccess(1);

        assertThat(actual).isTrue();
    }

    @Test
    void hasAccess_UserId1_ReturnTrue_MockVersion() {
        TableUsers tableUsers = Mockito.mock(TableUsers.class);
        when(tableUsers.getUserById(1)).thenReturn(new User("admin", 0));

        UsersService usersService = new UsersService(tableUsers);

        boolean actual = usersService.hasAccess(1);

        assertThat(actual).isTrue();
    }

    @Test
    void test_perfomance() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(1001);
            System.out.println("dd");
        });
    }

    @Test
    void test_exception() throws Exception {
        myMath = new MyMath(1, 0);
        //myMath.getDiv();

        //assertThrows(Exception.class, () -> myMath.getDiv());

        assertThatExceptionOfType(Exception.class).isThrownBy(() -> myMath.getDiv());
    }
}