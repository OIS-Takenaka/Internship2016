package ois.internship.view.ui.Cards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ois.internship.model.loader.AsyncImgLoader;


public class CardAdapter extends BaseAdapter {

    private Context context;
    private CardLayout cardLayout;
    private LayoutInflater layoutInflater;
    private ArrayList<CardModel> data = new ArrayList<CardModel>();

    public CardAdapter(Context context, ArrayList data, CardLayout cardLayout){
        super();
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
        this.cardLayout = cardLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("DEBUG", "getView");
        //画像挿入
        convertView = layoutInflater.inflate(cardLayout.layout, parent, false);
        ViewHolder holder = new ViewHolder(convertView);
        holder.textView.setText(data.get(position).text);
        new AsyncImgLoader(context, holder.imageView).execute(data.get(position).img);
        return convertView;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * インナークラス
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(cardLayout.textLayout);
            imageView = (ImageView) itemView.findViewById(cardLayout.imgLayout);
        }
    }

}
