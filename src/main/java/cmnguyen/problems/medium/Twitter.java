package main.java.cmnguyen.problems.medium;

import java.util.*;

public class Twitter {
    private static int timeOrder = 0;

    static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeOrder++;
            next = null;
        }
    }

    static class User {
        int id;
        Tweet head;
        Set<Integer> followed;

        public User(int userId) {
            this.id = userId;
            followed = new HashSet<>();
            follow(id);
            head = null;
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = head;
            head = tweet;
        }

        public void follow(int followeeId) {
            followed.add(followeeId);
        }

        public void unFollow(int followeeId) {
            followed.remove(followeeId);
        }
    }

    HashMap<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            User user = new User(userId);
            users.put(userId, user);
        }
        users.get(userId).postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();

        if (!users.containsKey(userId)) return feeds;

        Set<Integer> userList = users.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<>(userList.size(), (a, b) -> b.time - a.time);
        for(Integer id: userList) {
            Tweet tweet = users.get(id).head;
            if (tweet != null ){
                queue.add(tweet);
            }
        }

        int n = 0;
        while(!queue.isEmpty() && n < 10) {
            Tweet t = queue.poll();
            feeds.add(t.id);
            n++;
            if (t.next != null) queue.add(t.next);
        }

        return feeds;

    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            User follower = new User(followerId);
            users.put(followerId, follower);
        }

        if (!users.containsKey(followeeId)) {
            User followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && followerId != followeeId) {
            users.get(followerId).unFollow(followeeId);
        }
    }
}
