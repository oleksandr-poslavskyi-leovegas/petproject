#!/bin/zsh

consul kv put config/application/cloud.uploadBucket "my-petproject-bucket"
consul kv put config/application/spring.cloud.gcp.credentials.location "file:/Users/oleksandr.poslavskyi/IdeaProjects/petproject/gcpCredentials.json"
