package net.derohimat.sample;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProfileActivity extends BaseActivity {

//    @InjectView(R.id.bgContent)
//    ImageView bgContent;
//    @InjectView(R.id.imgContent)
//    RoundedImageView imgContent;
    @InjectView(R.id.txtName)
    TextView txtName;
    @InjectView(R.id.txtFullName)
    TextView txtFullName;
    @InjectView(R.id.txtUsername)
    TextView txtUsername;
    @InjectView(R.id.txtPhone)
    TextView txtPhone;
    @InjectView(R.id.txtEmail)
    TextView txtEmail;
    @InjectView(R.id.txtDateBirth)
    TextView txtDateBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_collapse);
        ButterKnife.inject(this);

    }

    public static void start(Context mContext){
        Intent intent = new Intent(mContext, ProfileActivity.class);
        mContext.startActivity(intent);
    }
}
