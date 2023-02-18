package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.DTO.ItemDTO;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3WcApplication implements CommandLineRunner {

	@Autowired
	private IItemService iItemService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3WcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Opcion 1
		Item item = new Item();
		item.setCodigoBarras("ABC");
		item.setNombre("Tornillo");
		item.setTipo("Perno");
		item.setStock(5);
		item.setPrecio(new BigDecimal(0.50));

		this.iItemService.guardar(item);

		List<ItemDTO> itemDTOs = new ArrayList();
	}

}
