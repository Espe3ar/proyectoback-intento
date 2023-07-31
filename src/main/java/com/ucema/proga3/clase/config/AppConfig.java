package com.ucema.proga3.clase.config;

import com.ucema.proga3.clase.Repositorios.*;
import com.ucema.proga3.clase.Servicios.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean
    @Primary
    public IAvisoService createAvisoService(){
        return new AvisoServiceImpt();
    }
    @Bean
    @Primary
    public IUsuarioService createUsuarioService(){return new UsuarioServiceImpt();}
    @Bean
    @Primary
    public ICanchaTennisService createCanchaTennisService(){return new CanchaTennisServiceImpt();}
    @Bean
    @Primary
    public ICanchaPaddleService createCanchaPaddleService(){return new CanchaPaddleServiceImpt();}
    @Bean
    @Primary
    public IReservaService createReservaService(){return new ReservaServiceImpt();}
    @Bean
    @Primary
    public ISedeService createSedeService(){return new SedeServiceImpt();}



}
