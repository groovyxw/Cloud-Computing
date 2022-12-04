# Apache Kafka + Spark Streaming + PySpark
## Description

  
  
  

## Step1: Study the basic concepts about Kafka by this [link](https://towardsdatascience.com/quickstart-apache-kafka-kafka-python-e8356bec94)

  Three primary concerns in Real-time data ingesting are:
  
  How we will [consume, produce, and process] these events efficiently?
  
  Apache Kafka addresses the first two problems stated above. The Zookeeper helps to maintain the server state and stores configurations as a key value pair in ZK data tree, and use them across the cluster in a distributed manner.
  
  <img width="529" alt="kafuka_1" src="https://user-images.githubusercontent.com/52802567/205165637-792eefec-c921-4c9b-b085-0710883a6cc2.PNG">
  
  Download: https://kafka.apache.org/downloads
  
  #### Implementation: Please see details in "Step3 Part Two"

## Step2: Study the basic concepts about Spark Streaming by this [link](https://spark.apache.org/docs/latest/streaming-programming-guide.html)

  Spark Streaming provides a high-level abstraction called discretized stream (DStream), which represents a continuous stream of data.
  DStreams can be created from input data streams from sources such as Kafka, Flume, and Kinesis, or by applying high-level operations on other DStreams.
  Internally, a DStream is represented as a sequence of RDDs.
  
  <img width="440" alt="2" src="https://user-images.githubusercontent.com/52802567/205167052-8ceda34a-b59a-4a8e-b560-3f7d5e094bc8.PNG">
  
  One example (WordCount with Streaming): 
  
  <img width="287" alt="3" src="https://user-images.githubusercontent.com/52802567/205167081-49e541df-4dfc-4bcf-8368-c59c47f5fda8.PNG">

  #### Implementation: Please see details in "Step3 Part One"
  
  
## Step3: Connecting the Dots (Python, Spark, and Kafka)

  Discuss the steps to perform to setup Apache Spark in a Linux environment.
  
  Starting Kafka (for more details, please refer to this article).
  
  Creating a PySpark app for consume and process the events and write back to Kafka.
  
  Steps to produce and consume events using Kafka-Python.

### Part One: Installing Spark which is availabe at https://spark.apache.org/downloads.html
  #### download the package and unpack it
  $ wget https://dlcdn.apache.org/spark/spark-3.3.1/spark-3.3.1-bin-hadoop3.tgz
  
  $ tar -xvf spark-3.3.1-bin-hadoop3.tgz
  
  <img width="572" alt="1_spark" src="https://user-images.githubusercontent.com/52802567/205414088-c2ca3ee1-29e8-4cc8-92dc-d18881c59c39.PNG">


  #### create a soft link
  $ ln -s /home/xwu/spark-3.3.1-bin-hadoop3 /home/xwu/spark
  
  #### set spark related environment varibales
  export SPARK_HOME=/home/xwu/spark
  
  export PATH=$SPARK_HOME/bin:$PATH
  
  export PATH=$SPARK_HOME/sbin:$PATH
  
  
  <img width="565" alt="1_spark_var" src="https://user-images.githubusercontent.com/52802567/205414109-da080729-7f6c-4685-9287-66c35d0070ff.PNG">

  
  #### Verify the installation
  
  $ pyspark
  
  $ which java
  
  
  <img width="312" alt="1_spark_verify" src="https://user-images.githubusercontent.com/52802567/205414128-1563fd75-4465-4e61-a542-95318b8e7761.PNG">

  Note:
  
  If you can NOT start pyspark sucessfully due to JAVA_HOME is not set or java command not found, please install java and set JAVA_HOME.
  
  #### Install JAVA
  
  Install java8:
  
  $ sudo apt update
  
  $ sudo apt-get install openjdk-8-jdk
  
  <img width="398" alt="1_spark_java" src="https://user-images.githubusercontent.com/52802567/205414146-f68c400e-257d-45aa-a43a-2dfce13e707d.PNG">
  
  Check java installation path:
  
  $ update-alternatives --list java
  
  <img width="280" alt="set_java_home" src="https://user-images.githubusercontent.com/52802567/205476984-920bc0ef-8527-4b72-a4ca-413e835dd35e.PNG">

  $ export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre
  
  #### Start pyspark
    
  <img width="573" alt="1_spark_start" src="https://user-images.githubusercontent.com/52802567/205414037-13806bc1-6d06-4163-8aca-58d1a5894eb6.PNG">
  
  Start the master in the local machine
  
  $ start-master.sh
  
  <img width="665" alt="1_spark_start_master" src="https://user-images.githubusercontent.com/52802567/205417403-03310a49-6c65-4cc2-9dc1-524dc4ebd202.PNG">

  
  In your browser, paste and go the link http://34.168.242.211:8080 
  
  
  <img width="915" alt="1_spark_master" src="https://user-images.githubusercontent.com/52802567/205417329-3a076370-c391-4aaf-b991-39933463c8f2.PNG">

  
  Starting worker
  
  $ start-slave.sh spark://34.168.242.211:7077
  
  <img width="669" alt="1_spark_start_worker" src="https://user-images.githubusercontent.com/52802567/205417414-85ed4057-59e7-4c88-ab61-2bab2ae7f24d.PNG">

  
  In the browser (http://34.168.242.211:8080 ), you can see one alive worker as bellow:
  
  <img width="907" alt="1_spark_worker" src="https://user-images.githubusercontent.com/52802567/205417320-56861235-f0fb-46ea-830e-37d614f6bd62.PNG">

#### Run Spark Streaming Word Count example

Due to compatibility issue b/w different tools(java, python, scala, spark, etc), I can not run word count example successfully.
So I re- setup the spark enviroment as below:

##### GCP platform CE VM
##### ubuntu 20.04 LTS

<img width="706" alt="pass_env_3" src="https://user-images.githubusercontent.com/52802567/205481637-9434fac9-ff19-433d-b09c-97874253a224.PNG">

##### spark-3.3.1-bin-hadoop3.tgz
  groupId: org.apache.spark
  artifactId: spark-core_2.12
  version: 3.3.1
  scala 2.12
  python 3.8.10
  
  <img width="839" alt="pass_env_1" src="https://user-images.githubusercontent.com/52802567/205481514-98270e7f-cc04-4e84-9490-50e2086008c5.PNG">

  
##### java 11

<img width="262" alt="pass_env_2" src="https://user-images.githubusercontent.com/52802567/205481551-5e148250-fba9-49cf-bbbb-16c6c3927310.PNG">



##### Run Networking WordCount example in python sucessfully:
Open a terminal 1:

$ nc -lk 9999

Open another terminal 2:

$ ./bin/spark-submit examples/src/main/python/streaming/network_wordcount.py localhost 9999


<img width="885" alt="stream_wordcount_1" src="https://user-images.githubusercontent.com/52802567/205481976-7d24bb18-f89a-4e05-ac22-1bebe048deba.PNG">

Final result:

<img width="942" alt="pass_env_result" src="https://user-images.githubusercontent.com/52802567/205482422-30c6c7a8-40f9-4f81-8358-f7fcab9377e5.PNG">


### Part Two: Starting Kafka
  #### Downlaod kafka which is available at https://kafka.apache.org/downloads
  
  $ wget https://downloads.apache.org/kafka/3.3.1/kafka_2.12-3.3.1.tgz
  
  $ tar -xvf kafka_2.12-3.3.1.tgz
  
  <img width="564" alt="2_kafka_install_0" src="https://user-images.githubusercontent.com/52802567/205414952-9c64a2ff-3cba-4503-9714-f9537ef07f4d.PNG">

  #### Start Kafka Zookeeper (Keep this terminal open)
  
  $ cd kafka_2.12-3.3.1/
  
  $ bin/zookeeper-server-start.sh config/zookeeper.properties
  
  <img width="673" alt="kafka_zookeeper_start" src="https://user-images.githubusercontent.com/52802567/205417674-6840d0fc-d80c-400d-91ab-affa374a2e47.PNG">


  #### Open a new terminal, Start Kafka broker  (Keep this terminal open)
  
  $ cd kafka_2.12-3.3.1/
  
  $ bin/kafka-server-start.sh config/server.properties
  
  <img width="676" alt="kafka_broker_start" src="https://user-images.githubusercontent.com/52802567/205417662-57d9b4df-3680-4c4f-84e6-1d65da6bd80f.PNG">

  
  #### Open another new terminal, Create Kafaka topics
  
  $ bin/kafka-topics.sh --create --topic input_recommend_product --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
  
  <img width="668" alt="2_kafka_create_topic" src="https://user-images.githubusercontent.com/52802567/205417683-687ff3c9-19f9-4667-b748-29f095d9b4d5.PNG">
  
  $ bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
  
  <img width="536" alt="2_kafka_list_topic" src="https://user-images.githubusercontent.com/52802567/205417686-33334eef-d955-4093-8323-ac08dde25d92.PNG">

### Part Three: Event Processing on Apache Spark (PySpark)
  
  #### Setup Spark
  
  $ pip3 install msgpack
  
  $ pip3 install kafka-python
  
  if pip3 command not found,
  
  $ sudo apt install python3-pip
  
  $ wget https://repo1.maven.org/maven2/org/apache/spark/spark-streaming-kafka-0-8-assembly_2.11/2.3.2/spark-streaming-kafka-0-8-assembly_2.11-2.3.2.jar
  
  #### Create and Submit the park Application
  
  Create /home/xwu/pyspark_script/spark_processor.py
  
  $ cd
  
  $ vi pyspark_script/spark_processor.py
  
  <img width="630" alt="spark_processor" src="https://user-images.githubusercontent.com/52802567/205487075-8d7adb96-1925-4a97-8b81-a0ea5768d903.PNG">

  
  Launch spark application
  Open a terminal 1:
  $ start-master.sh
  
  Open another terminal 2:
  
  $ ./spark/bin/spark-submit --jars myrun/spark-streaming-kafka-0-10_2.12-3.3.1.jar --master spark://34.70.211.224:7077 --deploy-mode client myrun/spark_processor.py
  
  Connect to the master successfully, but failed due to KafkaUtils not defined. 
  
  <img width="956" alt="Sparkstreaming_connection" src="https://user-images.githubusercontent.com/52802567/205487252-597ebc79-afdb-4de6-9534-9cb9c4b74985.PNG">


  <img width="941" alt="Sparkstreaming_connection_2_error" src="https://user-images.githubusercontent.com/52802567/205487265-d55c9dcd-186c-4d6c-a172-dbdf3fbdd9a3.PNG">

  
  spark-streaming-kafka-0-10 doesn't support python, spark-streaming-kafka-0-8 supports python, but spark version need roll back to 2.1.* version.
  Please refer to this [link](https://stackoverflow.com/questions/61891762/spark-3-x-integration-with-kafka-in-python) for details.
  
  <img width="693" alt="sparkstream-kafka-intergration-version-issue" src="https://user-images.githubusercontent.com/52802567/205487192-c005fad0-ffb4-4b03-b9be-e8f394307e30.PNG">
  
  <img width="641" alt="ff" src="https://user-images.githubusercontent.com/52802567/205487229-03fb413e-c48c-4b2b-8455-d96330d069d3.PNG">

  
  
  #### Kafka-python to create the events and consume the events 
  
  In terminal 1:
  
  $ cd kafka_2.12-3.3.1/
  
  $ bin/zookeeper-server-start.sh config/zookeeper.properties
  
  In terminal 2:
  
  $ cd kafka_2.12-3.3.1/
  
  $ bin/kafka-server-start.sh config/server.properties
  
  In terminal 3, create consumer.py, then run it:
  
  $ vi consumer.py
  
  $ python3 consumer.py
  
  In terminal 4, create producer.py, then run it:
  
  $ vi producer.py
  
  $ python3 producer.py
  
  Finally, you can see the event created by producer.py in terminal 3.
  
  <img width="949" alt="kafka_producer_consumer_final" src="https://user-images.githubusercontent.com/52802567/205430386-5f0c4e4b-5134-4e2a-8dc3-ff4b79c844b4.PNG">

  Code snippet as below:
  
  <img width="630" alt="code_snippet" src="https://user-images.githubusercontent.com/52802567/205476122-00f3e0ec-13eb-47d0-b345-e27d27eb8498.PNG">



## Presentation

## Reference
Spark:

https://kontext.tech/article/978/install-hadoop-332-in-wsl-on-windows

https://kontext.tech/article/1044/install-spark-321-on-linux-or-wsl

https://spark.apache.org/docs/latest/api/python/index.html

Spark Streaming:

https://spark.apache.org/docs/latest/streaming-programming-guide.html

https://spark.apache.org/docs/latest/index.html#running-the-examples-and-shell

https://stackoverflow.com/questions/61891762/spark-3-x-integration-with-kafka-in-python

Kafka:

https://towardsdatascience.com/connecting-the-dots-python-spark-and-kafka-19e6beba6404

https://docs.confluent.io/kafka-clients/python/current/overview.html#ak-python

kafka jar files:

https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka-0-10_2.12/3.3.1

https://mvnrepository.com/artifact/org.apache.spark/spark-sql-kafka-0-10

Spark python kafka intergration:

https://spark.apache.org/docs/latest/structured-streaming-kafka-integration.html

https://spark.apache.org/docs/latest/index.html#running-the-examples-and-shell

https://spark.apache.org/docs/latest/submitting-applications.html

https://spark.apache.org/docs/latest/structured-streaming-kafka-integration.html

Spark API interface:

https://spark.apache.org/docs/latest/api/python/reference/pyspark.streaming.html


