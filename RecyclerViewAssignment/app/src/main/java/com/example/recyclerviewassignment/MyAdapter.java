package com.example.recyclerviewassignment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<Person> mPersonRealmResults;
    private Context mcontext;

    public MyAdapter(RealmResults<Person> person, Context context)
    {
        mPersonRealmResults=person;
        mcontext=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reycler_view,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
        Person person=mPersonRealmResults.get(position);
        holder.name.setText(person.getName());
        holder.dept.setText(person.getDept());
        holder.phone.setText(person.getPhone());
        holder.roll.setText(person.getRoll());
        holder.gender.setText(person.getGender());
        if(person.getDept().equals("Information Technology"))
            holder.relativeLayout.setBackgroundColor(Color.BLUE);
        if(person.getDept().equals("Computer Science Engineering"))
            holder.relativeLayout.setBackgroundColor(Color.GREEN);
        if(person.getDept().equals("Electronics Engineering"))
            holder.relativeLayout.setBackgroundColor(Color.YELLOW);
        if(person.getDept().equals("Electrical Engineering"))
            holder.relativeLayout.setBackgroundColor(Color.RED);

    }
    @Override
    public int getItemCount(){return mPersonRealmResults.size();}
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name,roll,phone,dept,gender;
        private RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.name_tv);
            dept=itemView.findViewById(R.id.dept_tv);
            phone=itemView.findViewById(R.id.phone_tv);
            roll=itemView.findViewById(R.id.roll_tv);
            gender=itemView.findViewById(R.id.gender_tv);
            relativeLayout=itemView.findViewById(R.id.category_image);
        }
    }
}
