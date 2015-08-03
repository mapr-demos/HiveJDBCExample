# HiveJDBCExample

This repository contains a simple Maven project for connecting to Hive 1.0 on a secure MapR cluster in Java. We use the MapR maven repository for dependencies.

# To build and run

1. Clone this repo.
2. Edit the JDBC URL to your liking.
3. `mvn package`
4. Use `maprlogin` to obtain your ticket: `maprlogin password`
5. Run: 

```
  java -cp $(hadoop classpath):/opt/mapr/hive/hive-1.0/lib/hive-jdbc-1.0.0-mapr-standalone.jar:target/HiveJDBCExample-1.0-SNAPSHOT.jar \
    HiveJDBCExample
```
