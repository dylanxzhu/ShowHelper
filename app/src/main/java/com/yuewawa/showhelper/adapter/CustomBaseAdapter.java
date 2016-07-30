package com.yuewawa.showhelper.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuewawa on 2016-07-29.
 */
public abstract class CustomBaseAdapter<T> extends BaseAdapter{

    private List<T> list;
    private int mLayoutRes; //布局id

    public CustomBaseAdapter() {

    }

    public CustomBaseAdapter(List<T> list, int mLayoutRes) {
        this.list = list;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes, position);
        bindView(holder, getItem(position));
        return holder.getItemView();
    }

    public abstract void bindView(ViewHolder holder, T obj);

    //添加一条数据
    public void add(T t) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(t);
        notifyDataSetChanged();
    }

    //在指定位置添加一条数据
    public void add(int position,T t) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(position, t);
        notifyDataSetChanged();
    }

    public void remove(T t) {
        if (list != null) {
            list.remove(t);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (list != null) {
            list.remove(position);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        private Context context;
        private View item;
        private SparseArray<View> mViews;
        private int position;

        private ViewHolder(Context context, ViewGroup parent, int layoutRes) {
            this.context = context;
            mViews = new SparseArray<>();
            View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }
        //绑定ViewHolder与item
        public static ViewHolder bind(Context context, View convertView, ViewGroup parent, int layoutRes, int position) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder(context, parent, layoutRes);
            } else {
                holder = (ViewHolder) convertView.getTag();
                holder.item = convertView;
            }
            holder.position = position;
            return holder;
        }

        public <T extends View> T getView(int id) {
            T t = (T) mViews.get(id);
            if (t == null) {
                t = (T) item.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }

        /**
         * 获取当前条目
         */
        public View getItemView() {
            return item;
        }

        public int getItemPosition() {
            return position;
        }

        /**
         * 设置文字
         */
        public ViewHolder setText(int id, CharSequence text) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        /**
         * 设置图片
         */
        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }

        /**
         * 设置点击监听
         */
        public ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         */
        public ViewHolder setVisibility(int id, int visible) {
            getView(id).setVisibility(visible);
            return this;
        }

        /**
         * 设置标签
         */
        public ViewHolder setTag(int id, Object obj) {
            getView(id).setTag(obj);
            return this;
        }
    }
}
