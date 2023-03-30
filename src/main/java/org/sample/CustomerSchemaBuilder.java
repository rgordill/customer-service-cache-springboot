package org.sample;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = {Customer.class},
      schemaFileName = "customer.proto",
      schemaFilePath = "proto/",
      schemaPackageName = "org.sample"
)
public interface CustomerSchemaBuilder extends SerializationContextInitializer {
}