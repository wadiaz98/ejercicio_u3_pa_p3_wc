package com.example.demo.service;

import com.example.demo.modelo.Item;

public interface IItemService {

	public void guardar(Item item);

	public Item buscarProdcuto(String codigoBarras);

}
