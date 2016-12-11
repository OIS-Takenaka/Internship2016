package ois.internship.view.ui.Cards;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import ois.internship.model.loader.AsyncImgLoader;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.ui.If.AsyncImg;


public class CardAdapter extends BaseAdapter implements AsyncImg {

    private BaseActivity activity;
    private CardLayout cardLayout;
    private LayoutInflater layoutInflater;
    private ArrayList<CardModel> data = new ArrayList<CardModel>();
    private static HashMap cache = null;

    public CardAdapter(BaseActivity activity, ArrayList data, CardLayout cardLayout){
        super();
        this.layoutInflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.data = data;
        this.cardLayout = cardLayout;

        // 画像ロード
        if(cache != null) return;
        cache = new HashMap();
        for(int i=0; i < data.size(); i++) {
            new AsyncImgLoader(activity, this, i).execute(this.data.get(i).img);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("DEBUG", "getView");
        //画像挿入
        convertView = layoutInflater.inflate(cardLayout.layout, parent, false);
        ViewHolder holder = new ViewHolder(convertView);
        holder.textView.setText(data.get(position).text);
        holder.imageView.setImageBitmap((Bitmap)cache.get(position));
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
        activity.setSelectItemNum(position);
        return position;
    }

    @Override
    public void setImage(int position, Bitmap bitmap) {
        this.cache.put(position, bitmap);
        notifyDataSetChanged();
    }

    public Bitmap getImage(int position) {
        return (Bitmap) this.cache.get(position);
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
