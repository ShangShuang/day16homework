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
import com.example.day16homework.bean.DailyNewsBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<DailyNewsBean.TopStoriesBean> datas;
    private int TYPE_ITEM_ONE = 1;
    private int TYPE_ITEM_TWO = 2;
    private int TYPE_ITEM_THREE = 3;
    private int TYPE_ITEM_FOUR = 4;

    public SchoolAdapter(Context context, ArrayList<DailyNewsBean.TopStoriesBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_ONE) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent,false);
            return new ViewHolderOne(view);
        } else if (viewType == TYPE_ITEM_TWO) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item2, parent,false);
            return new ViewHolderTwo(view);
        } else if (viewType == TYPE_ITEM_THREE) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item3, parent,false);
            return new ViewHolderThree(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item4, parent,false);
            return new ViewHolderFour(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_ITEM_ONE) {
            SchoolAdapter.ViewHolderOne holder1 = (ViewHolderOne) holder;
            holder1.tvTitle.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getImage()).into(holder1.ivImg);
        } else if (itemViewType == TYPE_ITEM_TWO) {
            SchoolAdapter.ViewHolderTwo holder2 = (ViewHolderTwo) holder;
            holder2.tvTitleItem2.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getImage()).into(holder2.ivImgItem2);
        } else if (itemViewType == TYPE_ITEM_THREE) {
            SchoolAdapter.ViewHolderThree holder3 = (ViewHolderThree) holder;
            holder3.tvTitleItem3.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getImage()).into(holder3.ivImgItem3);
        } else {
            SchoolAdapter.ViewHolderFour holder4 = (ViewHolderFour) holder;
            holder4.tvTitleItem4.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getImage()).into(holder4.ivImgItem4);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ITEM_ONE;
        } else if (position == 1) {
            return TYPE_ITEM_TWO;
        } else {
            if (position % 2 == 0) {
                return TYPE_ITEM_THREE;
            } else {
                return TYPE_ITEM_FOUR;
            }
        }
    }

    static
    class ViewHolderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_img)
        ImageView ivImg;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static
    class ViewHolderTwo extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img_item2)
        ImageView ivImgItem2;
        @BindView(R.id.tv_title_item2)
        TextView tvTitleItem2;

        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static
    class ViewHolderThree extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title_item3)
        TextView tvTitleItem3;
        @BindView(R.id.iv_img_item3)
        ImageView ivImgItem3;

        public ViewHolderThree(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static
    class ViewHolderFour extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img_item4)
        ImageView ivImgItem4;
        @BindView(R.id.tv_title_item4)
        TextView tvTitleItem4;

        public ViewHolderFour(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
