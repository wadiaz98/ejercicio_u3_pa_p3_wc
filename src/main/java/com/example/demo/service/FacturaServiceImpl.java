package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.DTO.ItemDTO;
import com.example.demo.repository.IDetalleFacturaRepo;
import com.example.demo.repository.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepo facturaRepo;

	@Autowired
	private IItemService iItemService;

	@Autowired
	private IDetalleFacturaRepo detalleFacturaRepo;

	@Override
	public void realizarFactura(List<ItemDTO> itemsDTO, String cedula) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		DetalleFactura detalleFactura = new DetalleFactura();
		factura.setCedulaCliente(cedula);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero("00001");

		detalleFactura.setFactura(factura);

		List<DetalleFactura> detalleFacturas = new ArrayList<>();
		BigDecimal total = null;
		for (ItemDTO i : itemsDTO) {

			detalleFactura.setCanitdad(i.getCantidad());
			detalleFactura.setItem(this.iItemService.buscarProdcuto(i.getCodigoBarras()));
			detalleFactura.setPrecioUnitario(this.iItemService.buscarProdcuto(i.getCodigoBarras()).getPrecio());
			detalleFactura.setSubtotal(detalleFactura.getPrecioUnitario().multiply(new BigDecimal(i.getCantidad())));
			detalleFacturas.add(detalleFactura);
			total = total.add(detalleFactura.getSubtotal());
			this.detalleFacturaRepo.insertar(detalleFactura);
		}

		total = detalleFactura.getSubtotal();
		factura.setTotalVenta(total);
		factura.setDetalleFacturas(detalleFacturas);
		this.facturaRepo.insertar(factura);
	}

}
