# Microservice Health

## Build

Will be built by gradle

```
gradle clean image
```

## Run Docker

```
docker-compose -f wip.yml up
```

## Test
```
curl -X POST -v --header "Content-Type: application/json" --header "Accept: */*" "http://localhost:8080/commands/patients/add/1?name=Patrick%20Schlaepfer"
```



