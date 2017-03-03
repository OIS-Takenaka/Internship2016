package ois.internship.view.ui.Cards;

public class CardModel {

    String img = null;
    String text = null;
    String disp = null;
    boolean mark = false;

    public CardModel(String img, String text, String disp, Boolean mark){
        this.img = img;
        this.text = text;
        this.disp = disp;
        this.mark = mark;
    }
}
