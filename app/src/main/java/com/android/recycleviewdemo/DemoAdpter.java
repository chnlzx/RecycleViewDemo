package com.android.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：admin on 2016/11/18 10:40
 * 邮箱：androiden@163.com
 */


public class DemoAdpter extends RecyclerView.Adapter<MyViewHolder> {
    List<String> list = new ArrayList<>();
    Context context;
    private OnItemClickLitener mOnItemClickLitener;

    public interface OnItemClickLitener
    {void onItemClick(View view, int position);}

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        mOnItemClickLitener = onItemClickLitener;
    }

    public DemoAdpter(Context context) {
        this.context = context;
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = MyViewHolder.createViewHolder(context, parent, R.layout.item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setText(R.id.tv_title, list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickLitener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

}
