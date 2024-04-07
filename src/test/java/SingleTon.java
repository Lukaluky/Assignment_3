public class SingleTon {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Singleton test (should be true): " + (db1 == db2));

        db1.connect();
        db2.executeQuery("SELECT * FROM users");

        System.out.println(db1.getConnectionInfo());

    }
}
