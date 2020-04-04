package com.devglan.springboothibernatelogin;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.springboothibernatelogin.*;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    //Optional<ImageModel> findByName(String name);

}