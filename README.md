# Java GRPC example with k6

Run the service at localhost:50051:

```bash
gradle run
```

Then in separate terminal run the [k6](github.com/grafana/k6)


```bash
k6 run script.js
```

# Original Code

Java code based on the tutorial [Implement gRPC Service (Server) Using Java + Gradle](https://intuting.medium.com/implement-grpc-service-using-java-gradle-7a54258b60b8) by Justin Holiday.