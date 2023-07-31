package com.ucema.proga3.clase;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Repositorios.IAvisoRepository;
import com.ucema.proga3.clase.Servicios.IAvisoService;
import com.ucema.proga3.clase.Servicios.IReservaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {AppConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClaseApplicationTests {

	@Autowired
	private IAvisoService avisoService;
	@Test
	void contextLoads() {
	}

	/*@Test
		void testCreateAviso(){
		avisoService.createAviso("JUJU");
		Aviso aviso=avisoService.findBy_Texto("JUJU").get(0);
		assert(aviso.getTexto().equals("JUJU"));
		}*/


	}


