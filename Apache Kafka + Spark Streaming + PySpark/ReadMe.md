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
  
  <img width="632" alt="download_spark_2" src="https://user-images.githubusercontent.com/52802567/205380060-38fedaac-401f-42aa-87e3-fdfc10d2c003.PNG">

  #### create a soft link
  $ ln -s /home/cindy/cs570/spark-3.3.1-bin-hadoop3 /home/cindy/cs570/spark
  
  #### set spark related environment varibales
  SPARK_HOME="/home/cindy/cs570/spark"
  export PATH=$SPARK_HOME/bin:$PATH
  export PATH=$SPARK_HOME/sbin:$PATH
  
  <img width="526" alt="download_spark_3" src="https://user-images.githubusercontent.com/52802567/205380108-93ac0f90-4ef2-48ff-960a-4030b90243b7.PNG">
  
  #### Verify the installation
  
  $pyspark
  $ which java
  <img width="250" alt="java_install_0" src="https://user-images.githubusercontent.com/52802567/205387820-67379be3-f5b7-45b9-947f-cea30d289748.PNG">
  
  Note:
  
  If you can NOT start pyspark sucessfully due to JAVA_HOME is not set or java command not found, please install java and set JAVA_HOME.
  
  #### Install JAVA
  Install java8:
  $ sudo apt update
  $ sudo apt-get install openjdk-8-jdk
  
  <img width="552" alt="java_install_1" src="https://user-images.githubusercontent.com/52802567/205387875-eb839c0a-9732-42bb-b437-80c357ad958e.PNG">
  <img width="376" alt="java_install_2" src="https://user-images.githubusercontent.com/52802567/205387895-41348db9-a588-4b10-910c-2255f38f5248.PNG">

  #set java related enviroment viriables
  
  epxort JAVA_HOME=/usr/bin
  
  #### Start pyspark
  
  <img width="664" alt="start_spark" src="https://user-images.githubusercontent.com/52802567/205390660-432be9d4-ead5-4b8a-a40d-585a850ce19f.PNG">

  
## Presentation

## Reference
https://kontext.tech/article/978/install-hadoop-332-in-wsl-on-windows
https://kontext.tech/article/1044/install-spark-321-on-linux-or-wsl
https://towardsdatascience.com/connecting-the-dots-python-spark-and-kafka-19e6beba6404
