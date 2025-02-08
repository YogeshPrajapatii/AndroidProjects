package com.devleoperyogi.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    private boolean isFirstTime = true;
    ArrayList<contactModel> arrContacts;

    RecyclerContactAdapter(Context context, ArrayList<contactModel> arrContacts) {
        this.context = context;
        this.arrContacts = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgProfile.setImageResource(arrContacts.get(position).img);
        holder.txtPhone.setText(arrContacts.get(position).number);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.setIsRecyclable(false);

        // Click Listener for Editing Contact
        holder.llRow.setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_update_lay);

            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText edtNumber = dialog.findViewById(R.id.edtNumber);
            Button actionButton = dialog.findViewById(R.id.actionButton);
            TextView contactTitle = dialog.findViewById(R.id.contactTitle);

            actionButton.setText("Update");
            contactTitle.setText("Update Contact");
            edtName.setText(arrContacts.get(position).name);
            edtNumber.setText(arrContacts.get(position).number);

            actionButton.setOnClickListener(view -> {
                String name = edtName.getText().toString().trim();
                String number = edtNumber.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(context, "Please enter a valid Contact Name.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (number.isEmpty()) {
                    Toast.makeText(context, "Please enter a valid Contact Number.", Toast.LENGTH_SHORT).show();
                    return;
                }

                arrContacts.set(position, new contactModel(name, number));
                notifyDataSetChanged();
                dialog.dismiss();
            });

            dialog.show();
        });

        // Long Click Listener for Deleting Contact
        holder.llRow.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Delete Contact")
                    .setMessage("Are you sure you want to delete this contact?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        arrContacts.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, arrContacts.size());
                    })
                    .setNegativeButton("No", null);

            builder.show();
            return true;
        });
        if(isFirstTime){
        setAnim(holder.itemView, position);}


    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtPhone;
        ImageView imgProfile;
        LinearLayout llRow;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }

    public void setAnim(View viewToAnimate , int position){
        Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(slideIn);
        if(position==arrContacts.size()-1) {
            isFirstTime = false;
        }
    }
}
