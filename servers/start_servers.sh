#!/bin/bash

cd zookeeper-server-1
bin/zkServer.sh start
cd ../zookeeper-server-2
bin/zkServer.sh start
cd ../zookeeper-server-3
bin/zkServer.sh start
cd ../zookeeper-server-4
bin/zkServer.sh start
cd ../zookeeper-server-5
bin/zkServer.sh start
cd ../zookeeper-server-6
bin/zkServer.sh start
cd ../zookeeper-server-7
bin/zkServer.sh start
