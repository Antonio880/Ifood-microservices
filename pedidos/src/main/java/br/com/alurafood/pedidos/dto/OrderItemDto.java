package br.com.alurafood.pedidos.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private Integer quantidade;
    private String descricao;
}
