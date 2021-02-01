# Spring Boot Infinispan Embedded Sample

The rationale behind this sample and the implementation details are expressed on [this blog](https://blog.ramon-gordillo.dev/2020/12/spring-boot-embedded-cache-with-infinispan-in-kubernetes/)

If you find anything relevant to make it easier or you need some extra information, don't hesitate to open an PR/issue.

Thanks to those that have helped me on the development, particularly those in [jkube slack channel](https://app.slack.com/client/T027F3GAJ/CKATNCPA4) and in the [infinispan zulip channel](https://infinispan.zulipchat.com/)

## Remote + Protostream

For a quick test

1. Start the infinispan server and the app in remote mode
2. From the console, create a cache called `customers` using the "example.PROTOBUF_DIST" template
3. Init the schema in the server with `http GET http://localhost:8080/init`
4. Check `Data Container / Schemas tab` in the console. You should see a `customer.proto`
5. Put a customer `http PUT http://localhost:8080/customer < data/customer-1.json`