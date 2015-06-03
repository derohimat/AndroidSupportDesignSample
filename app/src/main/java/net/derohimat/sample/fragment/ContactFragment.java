package net.derohimat.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.derohimat.sample.R;

import butterknife.ButterKnife;

public class ContactFragment extends BaseFragment {


    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.inject(this, rootView);

        setUpUi();
        return rootView;
    }

    private void setUpUi() {
    }

//    @OnClick(R.id.fabAdd)
//    public void onFabClick(){
//        Snackbar
//                .make(parentLayout, R.string.hello_world, Snackbar.LENGTH_LONG)
//                .setAction(R.string.undo, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(mContext, "Snackbar", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .show();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}