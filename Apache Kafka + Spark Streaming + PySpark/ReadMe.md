# Apache Kafka + Spark Streaming + PySpark
## Description

  
  
  

## Step1: Study the basic concepts about Kafka by this [link](https://towardsdatascience.com/quickstart-apache-kafka-kafka-python-e8356bec94)

  Three primary concerns in Real-time data ingesting are:
  
  How we will [consume, produce, and process] these events efficiently?
  
  Apache Kafka addresses the first two problems stated above. The Zookeeper helps to maintain the server state and stores configurations as a key value pair in ZK data tree, and use them across the cluster in a distributed manner.
  
  <img width="529" alt="kafuka_1" src="https://user-images.githubusercontent.com/52802567/205165637-792eefec-c921-4c9b-b085-0710883a6cc2.PNG">
  
  Download: https://kafka.apache.org/downloads
  

## Step2: Study the basic concepts about Spark Streaming by this [link](https://spark.apache.org/docs/latest/streaming-programming-guide.html)

  Spark Streaming provides a high-level abstraction called discretized stream (DStream), which represents a continuous stream of data.
  DStreams can be created from input data streams from sources such as Kafka, Flume, and Kinesis, or by applying high-level operations on other DStreams.
  Internally, a DStream is represented as a sequence of RDDs.
  
  <img width="440" alt="2" src="https://user-images.githubusercontent.com/52802567/205167052-8ceda34a-b59a-4a8e-b560-3f7d5e094bc8.PNG">
  
  One example (WordCount with Streaming): 
  
  <img width="287" alt="3" src="https://user-images.githubusercontent.com/52802567/205167081-49e541df-4dfc-4bcf-8368-c59c47f5fda8.PNG">


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
  
  
  
  #### Create and Submit the park Application


## Presentation

## Reference
https://kontext.tech/article/978/install-hadoop-332-in-wsl-on-windows
https://kontext.tech/article/1044/install-spark-321-on-linux-or-wsl
https://towardsdatascience.com/connecting-the-dots-python-spark-and-kafka-19e6beba6404
