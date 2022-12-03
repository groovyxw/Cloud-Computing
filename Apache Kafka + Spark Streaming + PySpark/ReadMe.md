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

### Installing Spark which is availabe at https://spark.apache.org/downloads.html
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


  #set java related enviroment viriables
  
  epxort JAVA_HOME=/usr
  
  #### Start pyspark
    
  <img width="573" alt="1_spark_start" src="https://user-images.githubusercontent.com/52802567/205414037-13806bc1-6d06-4163-8aca-58d1a5894eb6.PNG">

## Presentation

## Reference
https://kontext.tech/article/978/install-hadoop-332-in-wsl-on-windows
https://kontext.tech/article/1044/install-spark-321-on-linux-or-wsl
https://towardsdatascience.com/connecting-the-dots-python-spark-and-kafka-19e6beba6404
