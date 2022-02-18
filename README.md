
##PROJECT

###POST

http://localhost:8080/api/v1/project

```
{
   
    "projectName": "In1",
    "projectCode": "dfghj2"
}
```

##ISSUE

###POST

insert into issue (id,description,date) values(1, 'test', now())

http://localhost:8080/api/v1/issue
```

 {
   
    "description":"TEST",
    "details":"test issue",
    "date":"2022-02-05T18:41:44.512+0000",
    "issueStatus":"OPEN"
    
}
{
    "id": 1,
    "description": "TEST",
    "details": "test issue",
    "date": "2022-02-05T18:41:44.512+00:00",
    "issueStatus": "OPEN",
    "assignee": null,
    "project": null
}
```

https://github.com/swagger-api/swagger-core/wiki/Annotations

##SWAGGER UI
For 3.0.0

https://github.com/springfox/springfox/issues/3362#issuecomment-953568248

http://localhost:8080/v2/api-docs

http://localhost:8080/swagger-ui/

http://localhost:8080/swagger-ui/#

spring.mvc.pathmatch.matching-strategy=ant-path-matcher

##H2 DATABASE

http://localhost:8080/h2-console

spring.h2.console.enabled=true

##For Log
debug=false 
######### Enable debug logs.
trace=false 
######### Enable trace logs.

logging.level.org.springframework.boot.autoconfigure =DEBUG

logging.level.web=TRACE
logging.level.org.springframework.web=TRACE


## Versioning
http://localhost:8080/versioning/1?version=1


##projects.json 

default records are added in json format.


## data.sql

default data is added using sql insert statements


## Pagination
http://localhost:8080/api/v1/project/pagination?page=0&size=3
