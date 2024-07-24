package com.testvagrant;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RecentlyPlayedStoreTest {

        private RecentlyPlayedStore store;

        @BeforeTest
        void setUp() {
            store = new RecentlyPlayedStore(3);
        }

        @Test
        void testAddAndGetSongs() {
            String user = "user1";
            store.addSong(user, "S1");
            store.addSong(user, "S2");
            store.addSong(user, "S3");

            assertEquals(Arrays.asList("S3", "S2", "S1"), store.getRecentlyPlayedSongs(user));

            store.addSong(user, "S4");
            assertEquals(Arrays.asList("S4", "S3", "S2"), store.getRecentlyPlayedSongs(user));

            store.addSong(user, "S2");
            assertEquals(Arrays.asList("S2", "S4", "S3"), store.getRecentlyPlayedSongs(user));

            store.addSong(user, "S1");
            assertEquals(Arrays.asList("S1", "S2", "S4"), store.getRecentlyPlayedSongs(user));
        }

        @Test
        void testMultipleUsers() {
            store.addSong("user1", "S1");
            store.addSong("user1", "S2");
            store.addSong("user2", "S3");
            store.addSong("user2", "S4");

            assertEquals(Arrays.asList("S2", "S1"), store.getRecentlyPlayedSongs("user1"));
            assertEquals(Arrays.asList("S4", "S3"), store.getRecentlyPlayedSongs("user2"));
        }

        @Test
        void testEmptyList() {
            assertTrue(store.getRecentlyPlayedSongs("newUser").isEmpty());
        }
}
