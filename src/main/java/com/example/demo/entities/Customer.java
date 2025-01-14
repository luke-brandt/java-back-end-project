package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;

    @Column(name="customer_first_name", nullable = false)
    private String firstName;

    @Column(name="customer_last_name", nullable = false)
    private String lastName;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="postal_code", nullable = false)
    private String postal_code;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cart> carts;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String postalCode, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postalCode;
        this.phone = phone;
        this.create_date = new Date();
    }

}
