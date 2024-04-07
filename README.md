This project implements a thread-safe Singleton pattern in Java for managing database connections. It ensures that only one database connection instance is created and used throughout the application, optimizing resource use and maintaining consistent access to the database.



Description

The DatabaseConnection class is designed to prevent multiple instances of a database connection. It includes methods for connecting to the database, executing SQL queries, and retrieving connection information. The database connection details are loaded from a db_config.properties file, ensuring that sensitive information is not hard-coded into the application.






