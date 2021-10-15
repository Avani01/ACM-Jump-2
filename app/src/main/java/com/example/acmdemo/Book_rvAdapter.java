package com.example.acmdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Book_rvAdapter extends RecyclerView.Adapter<Book_rvAdapter.ViewHolder>{

    private ArrayList<Book> book = new ArrayList<>();
    private Context context;

    public Book_rvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Book_rvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        // if we put null instead of false, it is not attached to root
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Book_rvAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // we can set on click listener for every item of recycler view here
        holder.bookName.setText(book.get(position).getName());
        holder.bookAuthor.setText(book.get(position).getAuthor());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, book.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // adding glide here
        Glide.with(context)
                .asBitmap()
                .load(book.get(position).getImageURL())
                .into(holder.bookImg);
    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
        notifyDataSetChanged();  // for notifying adapter if any data in arraylist is changed
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bookName, bookAuthor;
        private CardView parent;
        private ImageView bookImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // find view by id for tv
            bookName = itemView.findViewById(R.id.bookName);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookImg = itemView.findViewById(R.id.bookImg);
            // if we are inside an activity, we can directly write findviewbyid()
            // if we are inside some class, we need to write the parameter.findviewbyid()

            parent = itemView.findViewById(R.id.parent);
            // after this line, we have access to put on click listener in bindViewHolder method
        }
    }
}
