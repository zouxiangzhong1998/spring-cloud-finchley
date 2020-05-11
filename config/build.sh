#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

docker build -t ccr.ccs.tencentyun.com/carlos/config .

docker push ccr.ccs.tencentyun.com/carlos/config