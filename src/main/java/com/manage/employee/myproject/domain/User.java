package com.manage.employee.myproject.domain;


import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @Column(name="email")
  private String email;

  @Column(name="password")
  private String password;


  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "users_roles",
    joinColumns = @JoinColumn(
    name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
    name = "role_id", referencedColumnName = "id"))
  private Collection<Role> roles;

  public User(){

  }

  public User(String firstName, 
  String lastName, 
  String email, 
  String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  // public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
  //       this.firstName = firstName;
  //       this.lastName = lastName;
  //       this.email = email;
  //       this.password = password;
  //       this.roles = roles;
  //   }
}
