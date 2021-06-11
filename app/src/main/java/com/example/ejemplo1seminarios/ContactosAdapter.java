package com.example.ejemplo1seminarios;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import androidx.core.content.ContextCompat;
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

        int picture = listaContactos.get(position).getImage();
        String name = listaContactos.get(position).getName();
        String phone = listaContactos.get(position).getPhone();
        String address = listaContactos.get(position).getAddress();
        long id = listaContactos.get(position).getId();
        holder.id=id;
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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageViewRowPicture;
        private TextView textViewRowName;
        private TextView textViewRowPhone;
        private TextView textViewRowAddress;
        public ImageView imgViewRemoveIcon;
        public long id;
        public ViewHolder(View v) {
            super(v);
            imgViewRemoveIcon= (ImageView) v.findViewById(R.id.delleteIcon);
            imageViewRowPicture = (ImageView) v.findViewById(R.id.imagenViewRC);
            textViewRowName = (TextView) v.findViewById(R.id.textViewRCName);
            textViewRowPhone = (TextView) v.findViewById(R.id.textViewRCAddress);
            textViewRowAddress = (TextView) v.findViewById(R.id.textViewRCPhone);
            imgViewRemoveIcon.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(view.equals(imgViewRemoveIcon)){
                Contact contact = Contact.findById(Contact.class, id);
                String m =" Estas a punto de eliminar el contacto de: "+contact.getName();
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Delete entry")
                        .setMessage(m)
                        .setPositiveButton(android.R.string.yes,new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                contact.delete();
                                Intent intent= new Intent(view.getContext(),MainActivity.class);
                                ContextCompat.startActivity(view.getContext(),intent,null);
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();

             //   contact.delete();

            }

        }



    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}