package com.example.manuel.post.Adaptars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.manuel.post.Model.ResponseService;
import com.example.manuel.post.R;

import java.util.List;

/**
 * Created by Jose Antonio on 02/04/2018.
 */

public class MyAdapter extends BaseAdapter {
    int layout;
    List<ResponseService>list;
    Context context;


    public  MyAdapter (int layout, List<ResponseService> list, Context context){
        this.context=context;
        this.list=list;
        this.layout=layout;
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // View Holder Pattern
        ViewHolder holder;

        if (convertView == null) {
            // Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            // Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.name);
            holder.lastName = (TextView) convertView.findViewById(R.id.lastname);
            holder.nickName = (TextView) convertView.findViewById(R.id.nickname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Nos traemos el valor actual dependiente de la posición
        String currentName = list.get(position).getName();
        //currentName = (String) getItem(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        holder.nameTextView.setText("Nombre:"+" "+list.get(position).getName());
        holder.lastName.setText("LastName:"+" "+list.get(position).getLastName());
        holder.nickName.setText("NickName:"+" "+list.get(position).getNickName());

        // devolvemos la vista inflada y modificada con nuestros datos
        return convertView;
    }

    static class ViewHolder {
        private TextView nameTextView,lastName,nickName;
    }
}
