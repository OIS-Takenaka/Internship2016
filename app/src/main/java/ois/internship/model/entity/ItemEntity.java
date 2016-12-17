package ois.internship.model.entity;

import java.io.Serializable;

public class ItemEntity extends BaseEntity implements Serializable{

    // 画像
    protected String img = null;

    // 商品名
    protected String name = null;

    // メーカー
    protected String maker = null;

    // カテゴリー
    protected String category = null;

    // 価格
    protected int price = -1;

    //=================================================================
    // CONSTRACTER
    public ItemEntity(String img, String name, String maker, String category, int price){
        this.img = img;
        this.name = name;
        this.maker = maker;
        this.category = category;
        this.price = price;
    }

    public ItemEntity(String img, String name) {
        this.img = img;
        this.name = name;
        this.maker = null;
        this.category = null;
        this.price = -1;
    }

    //=================================================================
    // GETTER
    public String getImg() {
        return img;
    }
    public String getName() {
        return name;
    }
    public String getMaker() {
        return maker;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
}
