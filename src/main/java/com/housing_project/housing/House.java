package com.housing_project.housing;
import jakarta.persistence.*;


@Entity
@Table(name="HOUSES")
public class House {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="Address")
    private String address;
    @Column(name="Price")
    private Integer price;
    @Column(name="Size") //in sqrt ft
    private Integer size;
    @Column(name="Rooms")
    private Integer rooms;
    @Column(name="isSold")
    private Boolean isSold;

    public Integer getId(){ return this.id; }
    public String getAddress(){ return this.address; }
    public Integer getPrice() { return this.price; }
    public Integer getSize() { return this.size; }
    public Integer getRooms() { return this.rooms; }
    public Boolean getIsSold() { return this.isSold; }

    public void setId(Integer id){ this.id = id; }
    public void setAddress(String address){ this.address = address; }
    public void setPrice(Integer price){ this.price = price; }
    public void setSize(Integer size){ this.size = size; }
    public void setRooms(Integer rooms){ this.rooms = rooms; }
    public void setIsSold(Boolean isSold){ this.isSold = isSold; }
}
