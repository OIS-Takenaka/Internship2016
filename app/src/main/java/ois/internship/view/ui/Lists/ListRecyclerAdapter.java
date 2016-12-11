package ois.internship.view.ui.Lists;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;

import java.util.ArrayList;
import java.util.HashMap;

import ois.internship.model.loader.AsyncImgLoader;
import ois.internship.view.activity.BaseActivity;
import ois.internship.view.ui.If.AsyncImg;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> implements AsyncImg {

    private BaseActivity activity;
    private ListLayout listLayout;
    private LayoutInflater layoutInflater;
    private OnRecyclerListener listener;
    private ArrayList<ListModel> data = new ArrayList<ListModel>();
    private static HashMap cache = null;

    /**
     * コンストラクタ
     * @param activity
     * @param data
     * @param listener
     */
    public ListRecyclerAdapter(BaseActivity activity, ArrayList data, OnRecyclerListener listener, ListLayout listLayout){
        Log.i("DEBUG","TempRecyclerAdapter");
        this.layoutInflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.data = data;
        this.listener = listener;
        this.listLayout = listLayout;

        // 画像ロード
        cache = new HashMap();
        for(int i=0; i < data.size(); i++) {
            Log.i("DEBUG", this.data.get(i).getImg());
            new AsyncImgLoader(activity, this, i).execute(this.data.get(i).getImg());
        }

    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("DEBUG","onCreateViewHolder");
        View view = layoutInflater.inflate(this.listLayout.layout, parent, false);
        return new ViewHolder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.i("DEBUG","onBindViewHolder");
        // 画像挿入
        holder.title.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice());
        holder.imageView.setImageBitmap((Bitmap)cache.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClicked(v, position);
            }
        });
    }

    /**
     * アイテム数を返す
     * @return
     */
    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void setImage(int position, Bitmap bitmap) {
        this.cache.put(position, bitmap);
        notifyDataSetChanged();
    }

    /**
     * インナークラス
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView price;
        BootstrapCircleThumbnail imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(listLayout.titleLayout);
            price = (TextView) itemView.findViewById(listLayout.priceLayout);
            imageView = (BootstrapCircleThumbnail) itemView.findViewById(listLayout.imgLayout);
        }
    }
}