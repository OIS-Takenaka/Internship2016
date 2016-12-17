package ois.internship.model.entity;

import java.io.Serializable;

public class PurchasedItemEntity extends ItemEntity implements Serializable{

    // 購入個数
    private int amount = 0;

    //=================================================================
    // CONSTRACTER
    public PurchasedItemEntity(ItemEntity itemEntity, int amount){
        super(itemEntity.img, itemEntity.name, itemEntity.maker, itemEntity.category, itemEntity.price);
        this.amount = amount;
    }

    //=================================================================
    // GETTER
    public int getAmount() {
        return amount;
    }
}
