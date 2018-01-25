package com.example.franciscoandrade.unit5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.unit5.pojos.Result;
import com.squareup.picasso.Picasso;

public class PersonInfoActivity extends AppCompatActivity {
    ImageView perdondetailImage;
    TextView fullName, email, phoneNumber,
            addressFirst, addressSecond,birthDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        perdondetailImage=(ImageView)findViewById(R.id.perdondetailImage);
        fullName=(TextView)findViewById(R.id.fullName);
        email=(TextView)findViewById(R.id.email);
        phoneNumber=(TextView)findViewById(R.id.phoneNumber);
        addressFirst=(TextView)findViewById(R.id.addressFirst);
        addressSecond=(TextView)findViewById(R.id.addressSecond);
        birthDate=(TextView)findViewById(R.id.birthDate);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        Bundle sendObject = getIntent().getExtras();
        Result result = null;

        if (sendObject != null) {
            result = (Result) sendObject.getSerializable("result");

            Picasso.with(getApplicationContext()).load(result.getPicture().getLarge())
                    .into(perdondetailImage);
            fullName.setText(result.getName().getTitle()+". "+result.getName().getFirst()+" "+result.getName().getLast());
            email.setText(result.getEmail());
            phoneNumber.setText(result.getCell());
            addressFirst.setText(result.getLocation().getStreet());
            addressSecond.setText(result.getLocation().getState()+", "+result.getLocation().getCity()+" "+result.getLocation().getPostcode());
            birthDate.setText(result.getDob());
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
