package ois.internship.model.repository.injector;

import java.util.ArrayList;

import ois.internship.model.entity.ItemEntity;
import ois.internship.view.ui.Cards.CardModel;
import ois.internship.view.ui.If.CardsInterface;

public interface ItemRepositoryInjector extends CardsInterface {

    //=============================================================================
    // public
    //=============================================================================
    void set(ArrayList<ItemEntity> data);

    void add(String img, String name, String maker, String category, float price);

    void delete(int index);

    int dataSize();

    //=============================================================================
    // getter
    //=============================================================================
    String getImg(int index);

    String getName(int index);

    @Override
    ArrayList<CardModel> getCardData();
}
