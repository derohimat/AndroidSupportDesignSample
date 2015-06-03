package net.derohimat.sample.adapter;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import net.derohimat.sample.fragment.BaseFragment;
import net.derohimat.sample.utils.Logger;

public abstract class SmartFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
	// Sparse array to keep track of registered fragments in memory
	private SparseArray<BaseFragment> registeredFragments = new SparseArray<>();

	public SmartFragmentStatePagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	// Register the fragment when the item is instantiated
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		BaseFragment fragment = (BaseFragment) super.instantiateItem(container, position);
		registeredFragments.put(position, fragment);
		return fragment;
	}

	// Unregister when the item is inactive
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		registeredFragments.remove(position);
		super.destroyItem(container, position, object);
	}

	// Returns the fragment for the position (if instantiated)
	public BaseFragment getRegisteredFragment(int position) {
		return registeredFragments.get(position);
	}

	public void dispatchActivityResultForPosition(int position, int requestCode, int resultCode, Intent data) {
		if (registeredFragments.size() >= position && registeredFragments.get(position) != null) {
			registeredFragments.get(position).onActivityResult(requestCode, resultCode, data);
		} else
			Logger.log(Log.WARN, "dispatch activity result to null fragment");
	}
}