package com.example.android_konyvtar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class bookAdapter extends BaseAdapter {
    private List<Book> books;
    private Context context;

    public bookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.book_list_items,viewGroup,false);
        TextView cardcim=view.findViewById(R.id.cardcim);
        Button delete=view.findViewById(R.id.delete);
        LinearLayout card=view.findViewById(R.id.item);

        cardcim.setText(books.get(i).getTitle());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Törlés");
                builder.setMessage("Biztos törölni szeretné a könyvet?");
                builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        books.remove(i);
                        notifyDataSetChanged();
                        Toast.makeText(context,
                                "Deleted",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Nem", null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, details_activity.class);
                intent.putExtra("booktitle", books.get(i).getTitle());
                intent.putExtra("bookauthor", books.get(i).getAuthor());
                intent.putExtra("bookpages", books.get(i).getPages());
                context.startActivity(intent);
            }
        });


        return view;
    }
}