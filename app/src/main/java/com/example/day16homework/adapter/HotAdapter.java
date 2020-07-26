package com.example.day16homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day16homework.R;
import com.example.day16homework.bean.HotBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HotBean.RecentBean> datas;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public HotAdapter(Context context, ArrayList<HotBean.RecentBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvAuthor.setText(datas.get(position).getNews_id() + "");
        holder.tvTitleHot.setText(datas.get(position).getTitle());
        Glide.with(context).load(datas.get(position).getThumbnail()).into(holder.ivHot);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img_hot)
        ImageView ivImgHot;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.iv_hot)
        ImageView ivHot;
        @BindView(R.id.tv_title_hot)
        TextView tvTitleHot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
