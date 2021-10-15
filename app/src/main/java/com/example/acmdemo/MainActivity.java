package com.example.acmdemo;
// recycler view
// used https://developer.android.com/guide/topics/ui/layout/cardview site for gradle script dependencies
/*
for putting url for imageview, we are importing external library glide dependency https://github.com/bumptech/glide
Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
*/
// for material, use https://material.io/develop/android/docs/getting-started for gradle script dependencies
// give permission to use internet in manifest file
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView Bookrv;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find view by id for items
        Bookrv = findViewById(R.id.Bookrv);

        // making arraylist for books
        ArrayList<Book> book = new ArrayList<>();
        book.add(new Book("Anna Karenina", "Leo Tolstoy", "https://cdn.britannica.com/q:60/82/175382-050-8B76E4A8/Greta-Garbo-Anna-Karenina-Clarence-Brown.jpg"));
        book.add(new Book("To Kill a Mockingbird", "Harper Lee", "https://cdn.britannica.com/q:60/21/182021-050-666DB6B1/book-cover-To-Kill-a-Mockingbird-many-1961.jpg"));
        book.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "https://cdn.britannica.com/q:60/47/24647-050-E6E25F22/F-Scott-Fitzgerald.jpg"));
        book.add(new Book("Invisible Man", "Ralph Ellison", "https://cdn.britannica.com/q:60/11/79911-050-5C091BE6/Ralph-Ellison-1952.jpg"));
        book.add(new Book("A Passage to India", "E.M. Forster", "https://cdn.britannica.com/q:60/82/11782-004-305E324D/EM-Forster.jpg"));

        // setting adapter for recycler view
        Book_rvAdapter adapter = new Book_rvAdapter(this);    // 'this' is from Bookrv_adapter.java
        adapter.setBook(book);
        Bookrv.setAdapter(adapter);

        // layout manager for recycler view 2 methods -:
        //1. linear layout manager
        //Bookrv.setLayoutManager(new LinearLayoutManager(this));
        // reverseLayout is if we want to reverse order of items in layout

        //2. grid Layout manager
        Bookrv.setLayoutManager(new GridLayoutManager(this, 2));
        // span count divides screen into that particular no. of columns/rows. and it will show different content in each row/column
    }
}