## Recently Played Songs Store

This project implements an in-memory store for recently played songs with a fixed capacity per user. It can store a list of song-user pairs, fetch recently played songs based on the user, and eliminate the least recently played songs when the store reaches its capacity.

## Features
- Store songs played by users
- Maintain a fixed number of songs per user
- Fetch recently played songs for a user
- Automatically remove least recently played songs when capacity is reached

## Requirements

- Java 8 or higher
- Maven 3.6.0 or higher
- TestNG 7.4.0 or higher

## Setup and Installation

1. Clone the repository.
2. Build the project using Maven:
   mvn clean install
3. Execute the following command to run the TestNG tests:
   mvn test

## Implementation Details

The RecentlyPlayedStore class uses a HashMap to store user-song pairs.
Each user's song list is implemented as a LinkedList for efficient addition and removal of songs.
When a new song is played, it's added to the front of the list.
If the capacity is exceeded, the least recently played song is removed from the end of the list.

## License
It is an open source project
