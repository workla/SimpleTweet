package com.codepath.apps.restclienttemplate.models;

import android.text.format.DateUtils;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;
    public long tweetId;
    public long retweetCount;
    public long favoriteCount;
    public boolean favorited;
    public boolean retweeted;

    //empty for Parceler library
    public Tweet() {

    }


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.tweetId = jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.retweetCount = jsonObject.getLong("retweet_count");
        Log.i("lauren", "retweetCount: " + tweet.retweetCount + " for tweet " + tweet.body);
        tweet.favoriteCount = jsonObject.getLong("favorite_count");
        tweet.favorited = jsonObject.getBoolean("favorited");
        tweet.retweeted = jsonObject.getBoolean("retweeted");

        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }

    public static String getFormattedTimestamp(Tweet tweet) {
        String timeDiff;
        timeDiff = TimeFormatter.getTimeDifference(tweet.createdAt);
        return timeDiff;
    }

}
