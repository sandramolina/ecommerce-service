package com.reginageorge.ecommerceservice.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cartItems")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private Product product;

    @Column(name = "count")
    private int count;

}
