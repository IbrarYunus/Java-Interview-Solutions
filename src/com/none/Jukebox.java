package com.none;

import java.util.Queue;
import java.util.Set;

public class Jukebox {

    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public Jukebox (CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.ts = ts;
    }

    public Song getCurrentSong() { return ts.getCurrentSong(); }
    public void setUser(User u) {this.user = u;}
}

class CDPlayer {
    private Playlist p;
    private CD c;

    public CDPlayer(CD c, Playlist p) { this.p = p; this.c = c;}
    public CDPlayer(Playlist p) {this.p = p;}
    public CDPlayer(CD c) {this.c = c;}

    public void playSong(Song s) { }


    /// Getters and Setters
}


class Playlist {
    private Song song;
    private Queue<Song> queue;
    public Playlist(Song song, Queue<Song> queue) {
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSToPlay() {
        return queue.peek();
    }
    public void queueUpSong(Song s) {
        queue.add(s);
    }
}

class CD {
    /// data for id, artist, songs...etc
}

class Song {
    /// data for id, CD, title, length ...
}

class User {
    // user info
}

class SongSelector {
    /// Song selection mechanism

    public Song getCurrentSong() {
        return null;
    }
}
