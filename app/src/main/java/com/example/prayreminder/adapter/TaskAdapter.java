package com.example.prayreminder.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prayreminder.EditActivity;
import com.example.prayreminder.MainActivity;
import com.example.prayreminder.R;
import com.example.prayreminder.db.entity.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    List<Task> mList;
    Context context;
    private LayoutInflater mInflater;
    private static final String DUMMY_PASSWORD = "dtsrocks";
    Task task;

    public TaskAdapter(Context context) {
        this.context = context;
    }

    public TaskAdapter(List<Task> mList) {
        this.mList = mList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View diaryView = layoutInflater.inflate(R.layout.item_card,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(diaryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Task model = mList.get(position);

        holder.tvTask.setText(model.getKegiatan());
        holder.tvJadwal.setText(model.getJadwal());
        holder.tvKeterangan.setText(model.getKeterangan());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                view.getContext().startActivity(new Intent(context, EditActivity.class));
//                holder.tvTask.setText(model.getKegiatan());
//                holder.tvKeterangan.setText(model.getKeterangan());
//                holder.tvJadwal.setText(model.getJadwal());
                Intent i = new Intent(context,EditActivity.class);
                i.putExtra(DUMMY_PASSWORD, mList.get(position));
                context.startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTask,tvKeterangan,tvJadwal;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvJadwal = itemView.findViewById(R.id.txt_jam);
            tvKeterangan = itemView.findViewById(R.id.txt_keterangan);
            tvTask = itemView.findViewById(R.id.txt_kegiatan);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
