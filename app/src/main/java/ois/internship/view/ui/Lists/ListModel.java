package ois.internship.view.ui.Lists;

public class ListModel {

    private String img = null;
    private String title = null;
    private String price = null;

    public ListModel(String img, String text, String price){
        this.img = img;
        this.title = text;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
