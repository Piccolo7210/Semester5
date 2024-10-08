package singleton_Pattern;

// Singleton Database class in Java
public class Database {
    String value;
    // Static field to hold the single instance of Database
    private static Database instance;

    // Private constructor to prevent instantiation
    private Database(String value) {
        // Initialization code such as connection to the database
       // System.out.println("Initializing the database connection...");
        this.value = value;
      //  System.out.println(this.value);
    }

    // Static method to provide global access to the instance
    public static Database getInstance(String value) {
        Database result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Database.class) {
            if (instance == null) {
                instance = new Database(value);
            }
            return instance;
        }
    }

    // Example business logic that executes on the singleton instance
    public void query(String sql) {
        // Logic for executing queries, like throttling or caching
        System.out.println("Executing query: " + sql);
    }
}

// Application class


