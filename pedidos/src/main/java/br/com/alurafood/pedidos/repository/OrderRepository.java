package br.com.alurafood.pedidos.repository;

import br.com.alurafood.pedidos.model.Order;
import br.com.alurafood.pedidos.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order o set o.status = :status where o = :order")
    void updateStatus(Status status, Order order);

    @Query(value = "SELECT o from Order o LEFT JOIN FETCH o.itens where o.id = :id")
    Order findByIdWithItems(Long id);
}
