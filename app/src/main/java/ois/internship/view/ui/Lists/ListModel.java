package ois.internship.view.ui.Lists;

public class ListModel {

    private String img = null;
    private String text = null;

    public ListModel(String img, String text){
        this.img = img;
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public String getText() {
        return text;
    }
}
