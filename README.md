# Project 2 - SimpleTweet

**SimpleTweet** is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **10** hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] User can **compose and post a new tweet**
  - [x] User can click a “Compose” icon in the Action Bar on the top right
  - [x] User can then enter a new tweet and post this to twitter
  - [x] User is taken back to home timeline with **new tweet visible** in timeline
  - [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
  - [ ] User can **see a counter with total number of characters left for tweet** on compose tweet page

The following **optional** features are implemented:

- [x] User is using **"Twitter branded" colors and styles**
- [ ] User can click links in tweets launch the web browser 
- [ ] User can **select "reply" from detail view to respond to a tweet**
- [ ] The "Compose" action is moved to a FloatingActionButton instead of on the AppBar
- [ ] Compose tweet functionality is build using modal overlay
- [ ] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.org/android/Using-Parceler).
- [ ] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in offline mode.
- [ ] When a user leaves the compose view without publishing and there is existing text, prompt to save or delete the draft. If saved, the draft should then be **persisted to disk** and can later be resumed from the compose view.
- [ ] Enable your app to receive implicit intents from other apps. When a link is shared from a web browser, it should pre-fill the text and title of the web page when composing a tweet. 

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I had challenges implementing the character counter.  The walkthrough suggested wrapping the edit text in a textinputlayout but that seemed to not work, with android studio saying it didn't recognize the layout.

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright 2000 Lauren Work

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.








# Project 2 - SimpleTweet

**SimpleTweet** is an android app that allows a user to view his Twitter timeline. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: 16 hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] User can **sign in to Twitter** using OAuth login
- [x]	User can **view tweets from their home timeline**
  - [x] User is displayed the username, name, and body for each tweet
  - [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
- [x] User can refresh tweets timeline by pulling down to refresh

The following **optional** features are implemented:

- [x] User can view more tweets as they scroll with infinite pagination
- [x] Improve the user interface and theme the app to feel "twitter branded"
- [ ] Links in tweets are clickable and will launch the web browser
- [ ] User can tap a tweet to display a "detailed" view of that tweet
- [ ] User can see embedded image media within the tweet detail view
- [ ] User can watch embedded video within the tweet
- [ ] User can open the twitter app offline and see last loaded tweets
- [ ] On the Twitter timeline, leverage the CoordinatorLayout to apply scrolling behavior that hides / shows the toolbar.

The following **additional** features are implemented:

- [x] List anything else that you can get done to improve the app functionality!
  - I collected data for number of likes and retweets for each tweet to display next to them.  I also change the vector file to resemble the Twitter feel when the user has liked or retweeted the particular tweet.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

The first gif shows the start of the program, with login screen for OAuth to the Twitter Timeline

<img src='startup with oauth.gif' title='Start of App' width='' alt='Video Walkthrough' />


The next gif shows the extra data pulled for each tweet with changes to the vectors based on if the tweet's status of being retweeted or favorited by the user is set to true.  Refresh is also shown (with proof of refresh shown with the change in retweets and favorites, as well as updated times on the tweets)

<img src='refresh.gif' title='Refresh' width='' alt='Video Walkthrough 2' />


Another gif with refresh, where new tweets have now been written by others, so new tweets show up in the timeline.

<img src='refresh with new tweets.gif' title='Refresh 2' width='' alt='Video Walkthrough 3' />


The final gif shows infinite scroll

<img src='infinite scroll.gif' title='Infinite Scroll' width='' alt='Video Walkthrough 4' />

## Notes

I had a hard time getting setup going.  The walkthroughs did not match the current layouts so I was applying the knowledge to new data.  I also had an issue when changing the api.properties file that BuildConfig did not find the proper BuildConfig class, until using the Run Generate Sources Gradle Tasks option that then allowed everything to properly be recognized.
RecyclerView felt slightly easier this time, so that went smoothly.
Manipulating the vectors dynamically based on info collected from the tweet JSON was a little tricky.  I particularly had trouble with tinting and ended up utilizing a different way to enact the color change, as all of the tints appeared to turn my images grey.

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [Relative Time Formatter Class](https://github.com/nesquena/TimeFormatter) - Gist for converting Twitter API date format to relative date

## License

    Copyright 2020 Lauren Work

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
