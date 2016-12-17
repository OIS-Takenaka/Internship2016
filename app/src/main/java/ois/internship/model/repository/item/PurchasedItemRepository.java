package ois.internship.model.repository.item;

import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.model.entity.PurchasedItemEntity;

public class PurchasedItemRepository extends ItemRepository {

    private ArrayList<PurchasedItemEntity> itemList;

    //=============================================================================
    // Constracter
    //=============================================================================
    public PurchasedItemRepository(){
        itemList = new ArrayList<>();
    }

    //=============================================================================
    // public
    //=============================================================================

    /**
     * 商品セット
     * @param data
     */
    public void add(ItemEntity data, int amount){
        PurchasedItemEntity temp = new PurchasedItemEntity(data, amount);
        this.itemList.add(temp);
    }

    //=============================================================================
    // getter
    //=============================================================================

    /**
     * 商品取得
     * @param key
     * @return
     */
    public PurchasedItemEntity getItem(int key){
        return itemList.get(key);
    }

    /**
     * 商品数を取得
     * @return
     */
    public int dataSize() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public boolean delete(String name) {
        for(int i=0; i < dataSize(); i++) {
            if(itemList.get(i).getName() == name) {
                itemList.remove(i);
                return true;
            }
        }
        return false;
    }

}

