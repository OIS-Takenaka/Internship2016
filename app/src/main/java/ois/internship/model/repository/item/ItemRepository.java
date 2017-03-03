package ois.internship.model.repository.item;

import java.io.Serializable;
import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.model.repository.BaseRepository;
import ois.internship.view.ui.Cards.CardModel;
import ois.internship.view.ui.If.CardsInterface;

public class ItemRepository extends BaseRepository implements CardsInterface, Serializable{

    private ArrayList<ItemEntity> itemList;


    //=============================================================================
    // Constracter
    //=============================================================================
    public ItemRepository(){
        itemList = new ArrayList<>();
    }

    //=============================================================================
    // public
    //=============================================================================

    /**
     * 商品セット
     * @param data
     */
    public void set(ArrayList<ItemEntity> data){
        this.itemList = data;
    }

    public void add(ItemEntity data){
        this.itemList.add(data);
    }

    //=============================================================================
    // getter
    //=============================================================================

    /**
     * 商品取得
     * @param key
     * @return
     */
    public ItemEntity getItem(int key){
        return itemList.get(key);
    }


    /**
     * 商品数を取得
     * @return
     */
    public int dataSize() {
        return itemList == null ? 0 : itemList.size();
    }

    /**
     * 商品をカテゴリ毎でカード型にする
     * @return
     */
    public ArrayList<CardModel> getCardData() {
        ArrayList<CardModel> cardData = new ArrayList();
        for(int i=0; i < dataSize(); i++) {
            cardData.add(new CardModel(getItem(i).getImg(), getItem(i).getName(),getItem(i).getPrice() + "円", false));
        }
        return cardData;
    }

    /**
     * カートの商品を削除
     * @name
     */
    public boolean delete(String name){
        for(int i=0; i < dataSize(); i++) {
            if(itemList.get(i).getName() == name) {
                itemList.remove(i);
                return true;
            }
        }
        return false;
    }

}
