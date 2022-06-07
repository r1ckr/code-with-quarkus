# code-with-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

```bash
./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
```
You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Creating the native docker container:
```bash
docker build -f Dockerfile.native . -t quarkus-quickstart/getting-started-native
```
## Creating the native-micro docker container:
```bash
docker build -f Dockerfile.native-micro . -t quarkus-quickstart/getting-started-native-micro
```
## Creating the java docker container:
```bash
docker build -f Dockerfile.jvm . -t quarkus-quickstart/getting-started-jvm
```

## Starting all the containers:
```bash
docker run -m 300m --name quarkus-native -d -p 8080:8080 quarkus-quickstart/getting-started-native
docker run -m 300m --name quarkus-native-micro -d -p 8081:8080 quarkus-quickstart/getting-started-native-micro
docker run -m 300m --name quarkus-jvm -d -p 8082:8080 quarkus-quickstart/getting-started-jvm
```

## Running Benchmarks
Quarkus Native:
```bash
 ab -n 10000 -c 10 localhost:8080/hello
...
Requests per second:    1323.44 [#/sec] (mean)
Time per request:       7.556 [ms] (mean)
Time per request:       0.756 [ms] (mean, across all concurrent requests)
...
```
Quarkus Native Micro:
```bash
 ab -n 10000 -c 10 localhost:8081/hello
...
Requests per second:    1337.71 [#/sec] (mean)
Time per request:       7.475 [ms] (mean)
Time per request:       0.748 [ms] (mean, across all concurrent requests)
...
```
Quarkus JVM:
```bash
 ab -n 10000 -c 10 localhost:8082/hello
...
Requests per second:    1465.40 [#/sec] (mean)
Time per request:       6.824 [ms] (mean)
Time per request:       0.682 [ms] (mean, across all concurrent requests)
...
```
### Memory usage after benchmarks:
```bash
CONTAINER ID   NAME                   CPU %     MEM USAGE / LIMIT   MEM %     NET I/O           BLOCK I/O    PIDS
1a97df9bd9bf   quarkus-jvm            0.23%     147.9MiB / 300MiB   49.31%    8.93MB / 9.81MB   0B / 115kB   27
61b0042dfbfb   quarkus-native-micro   0.01%     233.4MiB / 300MiB   77.79%    4.68MB / 5.14MB   0B / 0B      22
e704f01d2492   quarkus-native         0.00%     235.3MiB / 300MiB   78.44%    4.68MB / 5.14MB   0B / 0B      13
```


## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
