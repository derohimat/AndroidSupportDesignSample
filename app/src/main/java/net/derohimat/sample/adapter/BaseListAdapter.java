package net.derohimat.sample.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.derohimat.sample.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class BaseListAdapter<T> extends BaseAdapter {

	public static final String PAGE = "BaseListAdapter.Page";

	protected List<T> mListData = new ArrayList<T>();

	protected Context mContext;
	protected LayoutInflater mInflater;

	private int mFirstPage;
	private int mCurrentPage;

	public BaseListAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}

	public void setFirstPage(int firstPage) {
		mFirstPage = firstPage;
		mCurrentPage = firstPage;
	}

	public void setCurrentPage(int currentPage) {
		mCurrentPage = currentPage;
	}

	public int getCurrentPage() {
		return mCurrentPage;
	}

	public int getFirstPage() {
		return mFirstPage;
	}

	public void nextPage() {
		mCurrentPage++;
	}

	public void previousPage() {
		if (mCurrentPage - 1 >= mFirstPage)
			mCurrentPage--;
		else
			resetPage();
	}

	public void resetPage() {
		mCurrentPage = mFirstPage;
	}

	@Override
	public int getCount() {
		return mListData.size();
	}

	@Override
	public T getItem(int position) {
		return mListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

	public void pushData(final List<T> data) {
		pushData(data, null);
	}

	public void setData(final int position, T data) {
		mListData.set(position, data);
	}

	public List<T> getListData() {
		return mListData;
	}

	public void clear() {
		mListData.clear();
		notifyDataSetChanged();
	}

	public void pushData(final List<T> data, Bundle bundle) {

		if (data == null) {
			Logger.log(Log.WARN, "Data null pushed");
			return;
		}

		if (bundle == null || !bundle.containsKey(PAGE) || bundle.getInt(PAGE) == 0)
			mListData.clear();

		mListData.addAll(data);
		notifyDataSetChanged();
	}

	public void remove(int position) {
		mListData.remove(position);
		notifyDataSetChanged();
	}
}
