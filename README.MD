# GitHub API

Analysis of GitHub repositories activities

### Prerequisites


```
JDK 1.8
Maven 3.2+
```

### Running


```
Extract somewhere -> go to that folder -> run the following command:
 mvn clean install
 mvn spring-boot:run 
```

```
In case you don't want to build the project using maven, there's also a prebuilt jar that you can just run
 cd prebuilt-jar             
 java -jar github-api.jar
```


### Running the tests


### API 
```
http://localhost:9090/searchRepository?query=tetris&page=1 - search for a public project (also called repository) hosted on the GitHub platform
http://localhost:9090/listUniqueUsers?repositoryFullName=chvin%2Freact-tetris - List of committers (users) for this project.
http://localhost:9090/usersImpact?repositoryFullName=chvin%2Freact-tetris - Based on the 100 latest commits, the impact of each user on the project (based on
 number of commits)
http://localhost:9090/projectionOfCommits?repositoryFullName=chvin%2Freact-tetris -  Based on the 100 latest commits, the projection of commits on a timeline.

```

###Design
