package ois.internship.view.ui.Cards;

public class CardModel {

    public String img = null;
    public String text = null;
    boolean effectFlag = false;

    public CardModel(String img, String text, boolean effectFlag){
        this.img = img;
        this.text = text;
        this.effectFlag = effectFlag;
    }
}
