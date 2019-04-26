package com.example.hrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<T> mDataList;
    private int mLayoutId;
    private int mFixX;
    private ArrayList<View> mMoveViewList = new ArrayList<>();

    public CommonAdapter(Context context, List<T> dataList, int layoutId) {
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
        mLayoutId = layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(mLayoutId, parent, false);
        CommonViewHolder holder = new CommonViewHolder(itemView);
//获取可滑动的view布局
        LinearLayout moveLayout = holder.getView(R.id.id_move_layout);
//建议: 根据RecyclerView的复用机制，在重新刷新或者加载更多的时候可能会出现新创建的item的右边可滑动的布局没有滚动到对应的位置，所以建议此处对moveLayout进行初始化滚动到HRecyclerView中保存的相对滑动位置mFixX
        moveLayout.scrollTo(mFixX, 0); //新增mFixX属性并设置初始化到滑动的相对位置
        mMoveViewList.add(moveLayout);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        bindData(holder, mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList==null?0:mDataList.size();
    }

    public abstract void bindData(CommonViewHolder holder, T data);

    public ArrayList<View> getMoveViewList(){
        return mMoveViewList;
    }

    public void setFixX(int fixX){
        mFixX=fixX;
    }
}
