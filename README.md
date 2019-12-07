 # Spring Boot + MongoDB 
 
### Git Repository
* https://github.com/gustavoponce7/mongodb-springboot

### MongoDB Installation
* https://treehouse.github.io/installation-guides/mac/mongo-mac.html

### Start MongoDB Server
```
sudo mongodb-macos-x86_64-enterprise-4.2.1/bin/mongod
```

### Start MongoDB Shell
```
sudo mongodb-macos-x86_64-enterprise-4.2.1/bin/mongo
```

### Documentations / How to query
* https://docs.mongodb.com/manual/crud/

### Query Examples
```
show collections
db.reservations.find({})
db.reservations.deleteMany({})
db.reservations.deleteOne({})
db.reservations.drop()
```

### Run The Application
```
mvn clean install
mvn spring-boot:run
```


