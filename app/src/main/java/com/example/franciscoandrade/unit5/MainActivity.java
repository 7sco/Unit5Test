package com.example.franciscoandrade.unit5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.franciscoandrade.unit5.apiNetworking.ServiceApi;
import com.example.franciscoandrade.unit5.pojos.Result;
import com.example.franciscoandrade.unit5.pojos.RootObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    List<Result> newList;
    RecyclerView recyclerHolder;
    AdapterPerson adapterPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerHolder=(RecyclerView)findViewById(R.id.recyclerHolder);
        adapterPerson= new AdapterPerson(this);
        recyclerHolder.setAdapter(adapterPerson);
        recyclerHolder.setHasFixedSize(true);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerHolder.setLayoutManager(gridLayoutManager);
        retrofitConn();
        obtenerDatos();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected: "+item.toString(), Toast.LENGTH_SHORT).show();
        obtenerDatos();

        adapterPerson.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
    private void retrofitConn() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void obtenerDatos() {

        ServiceApi service = retrofit.create(ServiceApi.class);
        Call<RootObject> response = service.getResponseGet();

        response.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                Log.d("RESPONSE", "onResponse: "+response.toString());
                if (response.isSuccessful()) {
                    newList=new ArrayList<>();
                    newList.clear();
                    newList=response.body().getResults();
                    adapterPerson.addImages(newList);
                }

            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {

            }
        });
    }

}
