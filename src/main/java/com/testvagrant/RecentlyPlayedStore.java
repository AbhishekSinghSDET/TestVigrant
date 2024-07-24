package com.testvagrant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {

    private final int capacity;
    private final Map<String, LinkedList<String>> userSongs;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.userSongs = new HashMap<>();
    }

    public void addSong(String user, String song) {
        userSongs.putIfAbsent(user, new LinkedList<>());
        LinkedList<String> songs = userSongs.get(user);

        songs.remove(song);

        songs.addFirst(song);

        if (songs.size() > capacity) {
            songs.removeLast();
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        return userSongs.getOrDefault(user, new LinkedList<>());
    }
}
