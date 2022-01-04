package com.tony.javademo01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdm_product")
public class product {

    @Id
    private int id;
    @Column(name="prod_code")
    private String prodCode;

    @Column(name="prod_name")
    private String prodName;

    @Column(name="prod_unit")
    private String prodUnit;

    public product() {
        super();
    }

    public product(int id, String prodCode, String prodName, String prodUnit) {
        this.id = id;
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodUnit = prodUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdUnit() {
        return prodUnit;
    }


    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", prodCode='" + prodCode + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodUnit='" + prodUnit + '\'' +
                '}';
    }

}
