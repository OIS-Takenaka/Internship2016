package ois.internship.model.repository.item;

import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.model.repository.BaseRepository;
import ois.internship.model.repository.injector.ItemRepositoryInjector;
import ois.internship.view.ui.Cards.CardModel;
import ois.internship.view.ui.If.CardsInterface;

public class TestItemRepository extends BaseRepository implements ItemRepositoryInjector, CardsInterface {

    private ArrayList<ItemEntity> data;


    //=============================================================================
    // Constracter
    //=============================================================================
    public TestItemRepository(){
        data = new ArrayList<>();
    }

    //=============================================================================
    // public
    //=============================================================================
    public void set(ArrayList<ItemEntity> data){
        this.data= data;
    }

    public void add(String img, String name, String maker, String category, int price) {
        data.add(new ItemEntity(img, name, maker, category, price));
    }

    public void delete(int index) {
        data.remove(index);
    }

    public int dataSize() {
        return data == null ? 0 : data.size();
    }

    //=============================================================================
    // getter
    //=============================================================================
    public String getImg(int index){
        return data.get(index).getImg();
    }

    public String getName(int index){
        return data.get(index).getName();
    }

    @Override
    public ArrayList<CardModel> getCardData() {
        ArrayList<CardModel> cardData = new ArrayList();
        for(int i=0; i < dataSize(); i++) {
            cardData.add(new CardModel(getImg(i), getName(i)));
        }
        return cardData;
    }
}
