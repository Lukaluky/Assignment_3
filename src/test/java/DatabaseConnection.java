import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private static final Object lock = new Object();

    private String hostname;
    private String username;
    private String password;
    private String databaseName;


    private DatabaseConnection() {

        try {
            String path = "C:\\Users\\bulat\\IdeaProjects\\json\\db_config.properties";
            File configFile = new File(path);
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            this.hostname = props.getProperty("hostname");
            this.username = props.getProperty("username");
            this.password = props.getProperty("password");
            this.databaseName = props.getProperty("databaseName");

            reader.close();
        } catch (Exception e) {
            throw new RuntimeException("Error loading database configuration", e);
        }
    }


    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }


    public void connect() {

        System.out.println("Connecting to " + databaseName + " at " + hostname + " with user " + username);
    }


    public void executeQuery(String query) {
        // Placeholder for actual query execution logic.
        System.out.println("Executing query: " + query);
    }


    public String getConnectionInfo() {
        return "DatabaseConnection{" +
                "hostname='" + hostname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}