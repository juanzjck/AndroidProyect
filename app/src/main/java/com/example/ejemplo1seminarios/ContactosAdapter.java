package com.example.ejemplo1seminarios;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ViewHolder> {

    private List<Contact> listaContactos;

    protected View.OnClickListener onClickListener;

    public ContactosAdapter(List<Contact> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        v.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Long id = listaContactos.get(position).getId();
        int picture = listaContactos.get(position).getImage();
        String name = listaContactos.get(position).getName();
        String phone = listaContactos.get(position).getPhone();
        String address = listaContactos.get(position).getAddress();

        holder.imageViewRowPicture.setImageResource(picture);
        holder.imageViewRowPicture.setTag(picture);
        holder.textViewRowName.setText(name);
        holder.textViewRowPhone.setText(phone);
        holder.textViewRowAddress.setText(address);
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewRowPicture;
        private TextView textViewRowName;
        private TextView textViewRowPhone;
        private TextView textViewRowAddress;

        public ViewHolder(View v) {
            super(v);
            imageViewRowPicture = (ImageView) v.findViewById(R.id.imagenViewRC);
            textViewRowName = (TextView) v.findViewById(R.id.textViewRCName);
            textViewRowPhone = (TextView) v.findViewById(R.id.textViewRCAddress);
            textViewRowAddress = (TextView) v.findViewById(R.id.textViewRCPhone);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public void setOnItemClickListenerDelete(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}