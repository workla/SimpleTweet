package com.codepath.apps.restclienttemplate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;
    //Pass in context and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }


    //for each row, inflate layout for tweet
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }


    //bind values to layout based on position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get data at position
        Tweet tweet = tweets.get(position);
        //bind tweet with viewholder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    //define viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        TextView tvRelativeDate;
        TextView tvName;
        ImageView ivComment;
        TextView tvComment;
        ImageView ivRetweet;
        TextView tvRetweet;
        ImageView ivLike;
        TextView tvLike;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvRelativeDate = itemView.findViewById(R.id.tvRelativeDate);
            tvName = itemView.findViewById(R.id.tvName);
            ivComment = itemView.findViewById(R.id.ivComment);
            tvComment = itemView.findViewById(R.id.tvComment);
            ivRetweet = itemView.findViewById(R.id.ivRetweet);
            tvRetweet = itemView.findViewById(R.id.tvRetweet);
            ivLike = itemView.findViewById(R.id.ivLike);
            tvLike = itemView.findViewById(R.id.tvLike);


        }

        @SuppressLint("ResourceAsColor")
        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText("@" + tweet.user.screenName);
            tvName.setText(tweet.user.name);
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
            tvRelativeDate.setText(Tweet.getFormattedTimestamp(tweet));
            String tvRetweetString = "" + tweet.retweetCount;
            tvRetweet.setText(tvRetweetString);
            String tvLikeString = "" + tweet.favoriteCount;
            tvLike.setText(tvLikeString);
            if (tweet.retweeted) {
                ivRetweet.setImageResource(R.drawable.ic_vector_retweet);
            }
            else {
                ivRetweet.setImageResource(R.drawable.ic_vector_retweet_stroke);
            }
            if(tweet.favorited) {
                ivLike.setImageResource(R.drawable.ic_vector_heart);
            }
            else {
                ivLike.setImageResource(R.drawable.ic_vector_heart_stroke);
            }
        }
    }
}
