package com.example.EmployeeDepartment;


import com.example.EmployeeDepartment.DAO.UserRepository;

import com.example.EmployeeDepartment.entity.User;

import com.example.EmployeeDepartment.services.UserService;
import org.junit.Assert;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void findByUsernameTest() {
        User user = new User((long) 1, "Naren", "password", "8555031091", "password", null);
        Mockito.when(userRepository.findByUsername("Naren")).thenReturn(Optional.of(user));
        Assert.assertNotNull(userService.findByUsername("Naren"));
        Assert.assertEquals(Optional.of(user), userService.findByUsername("Naren"));
    }
    @Test
    public void saveUserTest(){
        User user=new User((long) 1,"naren","11111","8555031091","11111",null);
        userService.save(user);
        Mockito.verify(userRepository,Mockito.times(1)).save(user);
    }
}
