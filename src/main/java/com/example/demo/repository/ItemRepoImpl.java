package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.DTO.ItemDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepoImpl implements IItemRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
	}

	@Override
	public Item buscarPorCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Item.buscarPorCodigo");
		query.setParameter("datoCodigo", codigoBarras);
		if ((Item) query.getSingleResult() == null) {
			return null;
		} else {
			return (Item) query.getSingleResult();
		}

	}

	@Override
	public Integer actualizar(String codigoBarras, Integer stock) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Item.actualizarPorCodigo");
		query.setParameter("datoCodigo", codigoBarras);
		query.setParameter("datoStock", stock);

		return query.executeUpdate();
	}

	@Override
	public ItemDTO buscarPorCodigoDTO(String codigoBarras) {
		// TODO Auto-generated method stub

		Query query = this.entityManager.createNamedQuery("Item.buscarPorCodigo");
		query.setParameter("datoCodigo", codigoBarras);
		Item item = (Item) query.getSingleResult();
		if (item == null) {
			return null;
		} else {
			return new ItemDTO(item.getCodigoBarras(), item.getStock());
		}
	}
}
