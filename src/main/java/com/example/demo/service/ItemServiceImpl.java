package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repository.IItemRepo;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepo itemRepo;

	@Override
	public void guardar(Item item) {
		// TODO Auto-generated method stub
		Item item2 = this.buscarProdcuto(item.getCodigoBarras());
		if (!item.getCodigoBarras().equals(item2.getCodigoBarras())) {
			this.itemRepo.insertar(item);
		} else {
			item2.setStock(item.getStock() + item2.getStock());
			this.itemRepo.actualizar(item2.getCodigoBarras(), item2.getStock());
		}
	}

	@Override
	public Item buscarProdcuto(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.itemRepo.buscarPorCodigo(codigoBarras);
	}

}
