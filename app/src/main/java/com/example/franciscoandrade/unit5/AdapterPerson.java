package com.example.franciscoandrade.unit5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.unit5.pojos.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class AdapterPerson extends RecyclerView.Adapter<AdapterPerson.PersonViewHolder> {
    List<Result> list;
    Context context;

    public AdapterPerson( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, final int position) {
        holder.lastNamePerson.setText(list.get(position).getName().getLast());
        holder.namePerson.setText(list.get(position).getName().getFirst());
        String url= list.get(position).getPicture().getMedium();

        Picasso.with(context).load(url)
                .resize(400, 400)
                .centerCrop()
                .into(holder.personImage);

        holder.personImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(context, PersonInfoActivity.class);
                //JSONObject object= lista.get(position);
                Result result= list.get(position);
                Bundle bundle= new Bundle();
                bundle.putSerializable("result", result);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addImages(List<Result> rootObject) {
        list.clear();
        list.addAll(rootObject);
        notifyDataSetChanged();
    }
    public class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView personImage;
        TextView namePerson, lastNamePerson;

        public PersonViewHolder(View itemView) {
            super(itemView);
            personImage=(ImageView)itemView.findViewById(R.id.personImage);
            namePerson=(TextView) itemView.findViewById(R.id.namePerson);
            lastNamePerson=(TextView) itemView.findViewById(R.id.lastNamePerson);

        }
    }
}
