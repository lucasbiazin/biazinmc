package com.biazinsistemas.biazinmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biazinsistemas.biazinmc.domain.ItemPedido;
import com.biazinsistemas.biazinmc.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
