package ois.internship.view.ui.Lists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    private Context context;
    private ListLayout listLayout;
    private LayoutInflater layoutInflater;
    private OnRecyclerListener listener;
    private ArrayList<ListModel> data = new ArrayList<ListModel>();

    /**
     * コンストラクタ
     * @param context
     * @param data
     * @param listener
     */
    public ListRecyclerAdapter(Context context, ArrayList data, OnRecyclerListener listener, ListLayout listLayout){
        Log.i("DEBUG","TempRecyclerAdapter");
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
        this.listener = listener;
        this.listLayout = listLayout;
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
        holder.textView.setText(data.get(position).getText());
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

    /**
     * インナークラス
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(listLayout.textLayout);
        }
    }
}