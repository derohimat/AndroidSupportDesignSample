package net.derohimat.sample.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import net.derohimat.sample.R;
import net.derohimat.sample.adapter.BaseListAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

public class CardListFragment extends BaseFragment {

	@InjectView(R.id.lvContent) ListView mLvContent;
	@InjectView(R.id.lyRefresh) SwipeRefreshLayout mLyRefresh;
	@InjectView(R.id.txtNoData) TextView mTxtNoData;

	private CardListApdater mListApdater;
//	private CardApiService mCardApiService;

	private ActionMode mActionMode;

	public static CardListFragment newInstance() {
		return new CardListFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list, container, false);
		ButterKnife.inject(this, rootView);
		setupUI();
		return rootView;
	}

	private void setupUI() {
		mLyRefresh.setColorSchemeResources(R.color.primary, R.color.accentColor);
		mLyRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//				loadData();
                mLyRefresh.setRefreshing(false);
            }
        });

		mListApdater = new CardListApdater(mContext);
		mLvContent.setAdapter(mListApdater);
		mLvContent.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.view_padding_small));
		mLvContent.setDivider(new ColorDrawable(Color.TRANSPARENT));

		loadData();
	}


	private void loadData() {
//		if (mCardApiService == null)
//			mCardApiService = new CardApiService(mContext);
//		mLyRefresh.setRefreshing(true);
//		mCardApiService.getCardList(Preferences.username(mContext), new EventCallback<List<Card>>() {
//			@Override
//			public void onEvent(List<Card> cards, Bundle bundle) {
//				resetLoadingUI();
//				mListApdater.pushData(cards);
//				invalidateEmptyView();
//			}
//		});
	}


	@OnItemClick(R.id.lvContent)
	public void onItemCardClick(final int position) {
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	private class CardListApdater extends BaseListAdapter<String> {

		public CardListApdater(Context context) {
			super(context);
		}

		@Override
		public int getCount() {
			return 100;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			CardViewHolder viewHolder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item_card, parent, false);
				viewHolder = new CardViewHolder(convertView);
			} else
				viewHolder = (CardViewHolder) convertView.getTag();

			viewHolder.txtTitle.setText("List " + position);
			return convertView;
		}
	}

	static class CardViewHolder {

		@InjectView(R.id.txtTitle) TextView txtTitle;

		CardViewHolder(View view) {
			ButterKnife.inject(this, view);
			view.setTag(this);
		}
	}
}