package com.edson.springdesktop.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String stateRegistration;

    @OneToOne(cascade = CascadeType.ALL) // Define a relação com o endereço
    @JoinColumn(name = "address_id") // Define a chave estrangeira na tabela Client
    private Address address;
    private String phone;

    
    public Client() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getStateRegistration() {
        return stateRegistration;
    }
    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
}

