package ois.internship.model.repository.item;

import java.util.ArrayList;
import java.util.HashMap;

import ois.internship.model.entity.CategoryEntity;
import ois.internship.model.entity.ItemEntity;
import ois.internship.model.repository.BaseRepository;
import ois.internship.view.ui.Cards.CardModel;
import ois.internship.view.ui.If.CardsInterface;

public class ItemRepository extends BaseRepository implements CardsInterface {

    private ArrayList<CategoryEntity> categoryList;
    private HashMap<Integer, ArrayList<ItemEntity>> itemList;


    //=============================================================================
    // Constracter
    //=============================================================================
    public ItemRepository(){
        categoryList = new ArrayList<>();
        itemList = new HashMap<>();
    }

    //=============================================================================
    // public
    //=============================================================================

    /**
     * カテゴリーセット
     * @param data
     */
    public void set(ArrayList<CategoryEntity> data){
        this.categoryList= data;
    }

    /**
     * カテゴリー毎で商品セット
     * @param data
     */
    public void set(Integer category, ArrayList<ItemEntity> data){
        this.itemList.put(category, data);
    }

    //=============================================================================
    // getter
    //=============================================================================

    /**
     * 商品取得
     * @param category
     * @param key
     * @return
     */
    public ItemEntity getItem(int category, int key){
        return itemList.get(category).get(key);
    }


    /**
     * カテゴリ数を取得
     * @return
     */
    public int categorySize() {
        return itemList.size();
    }

    /**
     * 商品数を取得
     * @param category
     * @return
     */
    public int dataSize(int category) {
        return itemList.get(category) == null ? 0 : itemList.get(category).size();
    }

    /**
     * 商品をカテゴリ毎でカード型にする
     * @param category
     * @return
     */
    public ArrayList<CardModel> getCardData(int category) {
        ArrayList<CardModel> cardData = new ArrayList();
        for(int i=0; i < dataSize(category); i++) {
            cardData.add(new CardModel(getItem(category,i).getImg(), getItem(category,i).getName()));
        }
        return cardData;
    }

    /**
     * 商品をランダムでカード型にする
     * @return
     */
    @Override
    public ArrayList<CardModel> getCardData() {
        ArrayList<CardModel> cardData = new ArrayList();
        for(int category=0; category < itemList.size(); category++) {
            for(int i=0; i < itemList.get(category).size(); i++)
            cardData.add(new CardModel(getItem(category,i).getImg(), getItem(category,i).getName()));
        }
        return cardData;
    }
}
