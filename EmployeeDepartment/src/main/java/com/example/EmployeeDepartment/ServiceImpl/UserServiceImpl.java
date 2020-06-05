package com.example.EmployeeDepartment.ServiceImpl;

import com.example.EmployeeDepartment.DAO.RoleRepository;
import com.example.EmployeeDepartment.DAO.UserRepository;
import com.example.EmployeeDepartment.entity.Role;
import com.example.EmployeeDepartment.entity.User;
import com.example.EmployeeDepartment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role=roleRepository.findById(2).orElse(null);
        Set<Role> roleSet=new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
