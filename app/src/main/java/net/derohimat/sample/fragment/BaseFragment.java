package net.derohimat.sample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;

import net.derohimat.sample.BaseActivity;

public class BaseFragment extends Fragment {

	protected Context mContext;
	protected LayoutInflater mInflater;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext = activity;
		mInflater = LayoutInflater.from(activity);
	}

	public void finish() {
		if (isAdded())
			getActivity().finish();
	}

	public BaseActivity getBaseActivity() {
		return (BaseActivity) getActivity();
	}


	protected void showStockToast(int message) {
		if (isAdded())
			showStockToast(getString(message));
	}

	protected void showStockToast(String message) {
		if (isAdded()) {
			Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
			toast.show();
		}
	}
}
