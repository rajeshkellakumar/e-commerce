package com.omnicuris.ecommerce.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name")
    @NotBlank
    private String itemName;
    @Column(name = "item_desc")
    private String itemDesc;
    @Column(name = "item_price")
    private Long itemPrice;
    @Column(name = "available_qty")
    private Long availableQty;
}
