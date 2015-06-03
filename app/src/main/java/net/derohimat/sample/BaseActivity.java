package net.derohimat.sample;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;


public class BaseActivity extends AppCompatActivity {

	protected Toolbar mToolbar;
	protected MaterialMenuIconToolbar materialMenuIcon;
	protected Context mContext = this;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public FragmentManager getBaseFragmentManager() {
		return super.getFragmentManager();
	}

	protected void setupToolbar(final Toolbar toolbar) {
		setupToolbar(toolbar, null);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	protected void setupToolbar(final Toolbar toolbar, final View.OnClickListener onClickListener) {

		mToolbar = toolbar;

		setSupportActionBar(toolbar);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
			actionBar.setHomeButtonEnabled(true);

		if (onClickListener != null)
			toolbar.setNavigationOnClickListener(onClickListener);

		materialMenuIcon = new MaterialMenuIconToolbar(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN) {
			@Override
			public int getToolbarViewId() {
				return toolbar.getId();
			}
		};
	}

	public Toolbar getToolbar() {
		return mToolbar;
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		if (materialMenuIcon != null)
			materialMenuIcon.syncState(savedInstanceState);
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (materialMenuIcon != null)
			materialMenuIcon.onSaveInstanceState(outState);
	}

}
