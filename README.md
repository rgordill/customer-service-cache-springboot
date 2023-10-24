# Spring Boot Infinispan Embedded Sample

The rationale behind this sample and the implementation details are expressed on [this blog](https://blog.ramon-gordillo.dev/2020/12/spring-boot-embedded-cache-with-infinispan-in-kubernetes/)

If you find anything relevant to make it easier or you need some extra information, don't hesitate to open an PR/issue.

Thanks to those that have helped me on the development, particularly those in [jkube slack channel](https://app.slack.com/client/T027F3GAJ/CKATNCPA4) and in the [infinispan zulip channel](https://infinispan.zulipchat.com/)

## Testing
For testing, you can do the following:

### Embedded in local env
Just execute 

```bash
mvn clean compile jar:jar spring-boot:repackage spring-boot:run -Pembedded,host
```

Connect to http://localhost:8080/swagger-ui.html and test some methods

If you want to check everything is ok, connect to http://localhost:8080/actuator/prometheus, and see the cache_* metrics

### Remote in local env
Download infinispan-server

Create an user with the following credentials:

user: developer
pass: 

mvn clean compile jar:jar spring-boot:repackage spring-boot:run -Premote,host

### Remote in kubernetes

mvn clean compile jar:jar spring-boot:repackage k8s:build k8s:push k8s:resource k8s:deploy -Premote,kubernetes -Djkube.build.strategy=jib

mvn k8s:resource k8s:undeploy -Pkubernetes,embedded

## Remote + Protostream

For a quick test

1. Start the infinispan server
2. From the console, create a cache called `customers` using the "example.PROTOBUF_DIST" template
3. Start the app in remote mode
4. Check `Data Container / Schemas tab` in the console. You should see a `customer.proto`
5. Put a customer `http PUT http://localhost:8080/customer < data/customer-1.json`