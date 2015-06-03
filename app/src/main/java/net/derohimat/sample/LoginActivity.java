package net.derohimat.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @InjectView(R.id.inpUsername)    EditText mInpUsername;
    @InjectView(R.id.inpPassword)    EditText mInpPassword;
    @InjectView(R.id.btnSubmit)    Button mBtnSubmit;
    @InjectView(R.id.btnMore)    TextView mBtnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.btnSubmit)
    public void onLoginClick() {
        MainActivity.start(mContext);
        finish();
    }

    @OnClick(R.id.btnMore)
    public void onRegisterClick() {

    }

    public static void start(Context mContext){
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

}
