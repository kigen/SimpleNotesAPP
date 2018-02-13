package com.kigen.notes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Base class for all recyclerAdapter for a specific Model class
 * @param <T> Any model class of your choice.
 * @param <VH> ViewHolder implementation.
 */
public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected final Context context;
    private List<T> mObjects;

    public BaseRecyclerAdapter(Context context,final List<T> objects) {
        mObjects = objects;
        this.context =context;
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(final T object) {
        mObjects.add(object);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        final int size = getItemCount();
        mObjects.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public int getItemCount() {
        if(mObjects==null){
            return  0;
        }
        return mObjects.size();
    }

    public T getItem(final int position) {
        return mObjects.get(position);
    }

    public long getItemId(final int position) {
        return position;
    }

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    public int getPosition(final T item) {
        return mObjects.indexOf(item);
    }

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index  The index at which the object must be inserted.
     */
    public void insert(final T object, int index) {
        mObjects.add(index, object);
        notifyItemInserted(index);

    }


    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     */
    public void insertAll(final List<T> object) {
        int last_index  = mObjects.size()-1;
        mObjects.addAll(object);
        notifyItemRangeInserted(last_index,object.size());
    }


    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    public void remove(T object) {
        final int position = getPosition(object);
        mObjects.remove(object);
        notifyItemRemoved(position);
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained in this adapter.
     */
    public void sort(Comparator<? super T> comparator) {
        Collections.sort(mObjects, comparator);
        notifyItemRangeChanged(0, getItemCount());
    }
}