package com.example.mvvmjava.ui.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmjava.data.domain.Mobile;
import com.example.mvvmjava.databinding.ItemMobileBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Asadi on 24/03/2018.
 */
public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MovieViewHolder> {

    public interface MovieListener {
        void onMovieClicked(Mobile movie);
    }

    private List<Mobile> items;
    private final MovieListener listener;

    public MobileAdapter(MovieListener listener) {
        this.listener = listener;
        items = new ArrayList<>();
    }

    public void setItems(List<Mobile> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMobileBinding binding = ItemMobileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private Mobile getItem(int position) {
        return items.get(position);
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemMobileBinding binding;
        MovieViewHolder(ItemMobileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(int position) {
            Mobile movie = getItem(position);

            setClickListener(movie);
            setTitle(movie.getMobileName());
            setImage(movie.getMobileImageUrl());
            setDescription(movie.getMobileDetails());
        }

        private void setTitle(String title) {
            binding.textViewTitleid.setText(title);
        }

        private void setImage(String imageUrl) {
            //Glide.with(itemView.getContext()).load(imageUrl).into(binding.imageView);
        }

        private void setDescription(String description) {
            binding.textViewDescriptionid.setText(description);
        }

        private void setClickListener(Mobile movie) {
            itemView.setTag(movie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onMovieClicked((Mobile) view.getTag());
        }
    }
}