import java.util.*;

// User class representing a user node in the singly linked list
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;  // List of Friend IDs
    User next;

    // Constructor to initialize user details
    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    // Add a friend to the user's friend list
    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    // Remove a friend from the user's friend list
    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

// SocialMediaSystem class to manage friend connections using singly linked list
class SocialMediaSystem {
    User head;

    // Constructor to initialize the list
    public SocialMediaSystem() {
        this.head = null;
    }

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>();
            for (int friendId1 : user1.friendIds) {
                if (user2.friendIds.contains(friendId1)) {
                    mutualFriends.add(friendId1);
                }
            }

            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends between " + user1.name + " and " + user2.name);
            } else {
                System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + "'s friends: " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by Name
    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User with name " + name + " not found.");
    }

    // Search for a user by User ID
    public User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // User not found
    }

    // Count the number of friends for a specific user
    public void countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        User temp = head;
        if (temp == null) {
            System.out.println("No users in the system.");
            return;
        }

        System.out.println("User List:");
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age + ", Friends: " + temp.friendIds);
            temp = temp.next;
        }
    }
}

// Main class to test the Social Media Friend Connections functionality
public class SocialMediaTest {
    public static void main(String[] args) {
        SocialMediaSystem system = new SocialMediaSystem();

        // Add users to the system
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 28);
        system.addUser(4, "David", 22);

        // Add friend connections
        system.addFriendConnection(1, 2);  // Alice and Bob
        system.addFriendConnection(1, 3);  // Alice and Charlie
        system.addFriendConnection(2, 3);  // Bob and Charlie

        // Display all users and their friends
        system.displayAllUsers();

        // Display friends of a specific user
        system.displayFriends(1); // Alice's friends

        // Count the number of friends for a user
        system.countFriends(2); // Bob's friend count

        // Find mutual friends between two users
        system.findMutualFriends(1, 2);  // Mutual friends between Alice and Bob
        system.findMutualFriends(1, 4);  // Mutual friends between Alice and David (none)

        // Remove a friend connection
        system.removeFriendConnection(1, 2); // Remove Alice and Bob as friends

        // Display all users and their friends again after removal
        system.displayAllUsers();
    }
}
