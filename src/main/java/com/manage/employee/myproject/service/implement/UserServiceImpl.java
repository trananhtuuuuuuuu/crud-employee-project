package com.manage.employee.myproject.service.implement;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manage.employee.myproject.DTO.UserRegistrationDto;
import com.manage.employee.myproject.domain.Role;
import com.manage.employee.myproject.domain.User;
import com.manage.employee.myproject.repository.UserRepository;
import com.manage.employee.myproject.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository,
  BCryptPasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User save(UserRegistrationDto registrationDto){
    User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), 
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword())
                );

                // Set roles using Lombok setter
      user.setRoles(Arrays.asList(new Role("ROLE_USER")));
    return userRepository.save(user);
  }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByEmail(username);
      if (user == null) {
        throw new UsernameNotFoundException("Invalid username or password.");
      }
      //System.out.println("✅ User found: " + user.getEmail());
      //System.out.println("Stored hash: " + user.getPassword().substring(0, 20) + "...");
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
  }



  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }
  
}
