package com.ecommerce.ECommerceBackend.Config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    /*We are gonna need this for every part of this project that's why we are creating this rather initializing in every package which is gotta make many objects and the code will be meesed up*/
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
