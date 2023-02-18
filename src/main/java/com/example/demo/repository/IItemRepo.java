package com.example.demo.repository;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.DTO.ItemDTO;

public interface IItemRepo {

	public void insertar(Item item);

	public Item buscarPorCodigo(String codigoBarras);

	public Integer actualizar(String codigoBarras, Integer stock);

	public ItemDTO buscarPorCodigoDTO(String codigoBarras);
}
