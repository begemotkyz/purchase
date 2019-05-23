package com.online.purchase.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id")
    private Content description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Content getDescription() {
        return description;
    }

    public void setDescription(Content description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
