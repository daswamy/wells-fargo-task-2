package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Portfolio {

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @OneToOne(optional = false)
    @JoinColumn(name = "client_id")
    @MapsId
    private Client client;

    protected Portfolio() {}

    public Portfolio(Client client) {
        this.client = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
