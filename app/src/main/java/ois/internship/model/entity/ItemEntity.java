package ois.internship.model.entity;

public class ItemEntity extends BaseEntity{

    // 画像
    private String img = null;

    // 商品名
    private String name = null;

    // メーカー
    private String maker = null;

    // カテゴリー
    private String category = null;

    // 価格
    private float price = -1;

    //=================================================================
    // CONSTRACTER
    public ItemEntity(String img, String name, String maker, String category, float price){
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
    public float getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
}
