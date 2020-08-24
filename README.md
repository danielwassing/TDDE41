# TDDE41 - Topic 5 - Apache Zookeper
##### Daniel Wassing (danwa223), Robin Andersson (roban591)

# 1. How to start the ZooKeeper server
Currently it is possible to run seven servers in replicated mode.

For each server one has to change the config file.
These are located under servers/zookeeper-server-n/conf/zoo.cfg where n is the server number.
The only line that has to be changed is the data dir, so that it points to where
you actually store the project files.
 
To start the server one can run a bash script by performing the following steps:
```
cd servers
./start-servers.sh
```
To stop the servers one can run another bash script by performing the following steps:
```
cd servers
./stop-servers.sh
```
If you for some reason cannot run these bash scripts, you can perform the following for each server i:
```
cd servers/zookeeper-server-i
bin/zkServer.sh start
```
Then to stop the servers you have can perform the following for each server i:
```
cd servers/zookeeper-server-i
bin/zkServer.sh stop
```
To access the CLI for server i (that is running) you can do the following:
```
cd servers/zookeeper-server-i
bin/zkCli.sh -server 127.0.0.1:2182
```

# 2. Running the Java application
Launch the Java project under "code/zookeeper" using your favorite editor/IDE
(we are using IntelliJ IDEA).
Then, run the "Main" class and you are done.
The effects can then be viewed in the ZooKeeper CLI using:
```
ls /
```


