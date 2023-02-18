package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.DTO.ItemDTO;

public interface IFacturaService {

	public void realizarFactura(List<ItemDTO> itemsDTO, String cedula);
}
