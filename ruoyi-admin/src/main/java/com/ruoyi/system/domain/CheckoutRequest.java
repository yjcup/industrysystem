package com.ruoyi.system.domain;

import java.util.List;

public class CheckoutRequest {

    private String name;
    private String address;
    private String phone;
    private List<ProductFront> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ProductFront> getProducts() {
        return products;
    }

    public void setProducts(List<ProductFront> products) {
        this.products = products;
    }


    // 省略构造函数、getter 和 setter

}

