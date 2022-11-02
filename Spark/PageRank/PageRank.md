# PageRank in Spark

PageRank is an algorithm that is used in Google Search Engine.
In this project, we will use a simplified version to implement pagerank in both Python and Scala on Google Cloud Platform.
    
# Design
<img width="234" alt="Capture" src="https://user-images.githubusercontent.com/52802567/199405437-fa198b68-6706-4c01-9a17-60e411ace3a5.PNG">

## Basic theory

The initial PageRank value for each webpage is 1.

    PR(A) = 1
    PR(B) = 1
    PR(C) = 1
    Page B has a link to pages C and A
    Page C has a link to page A
    Page D has links to all three pages
    and
    A's PageRank is
    PR(A) = (1-d) + d * (PR(B) / 2 + PR(C) / 1 + PR(D) / 3)
    B's PageRank is
    PR(B) = (1-d) + d * (PR(D) / 3)
    C's PageRank is
    PR(C) = (1-d) + d * (PR(B) / 2 + PR(D) / 3)
    D's PageRank is
    PR(D) = 1-d
    Damping factor is 0.85

## Methodology    

An iterative algorithm that performs many joins, so it is a good use case for RDD partitioning.

The algorithm maintains two datasets:

    (pageID, linkList) elements containing the list of neighbors of each page,
    (pageID, rank) elements containing the current rank for each page.

## Input links file format:
    A B
    A C
    B C
    C A
    
## RDD transformation:
<img width="454" alt="Capture" src="https://user-images.githubusercontent.com/52802567/199406102-07128d28-6d55-45a5-8bae-0ca1a4f0dc98.PNG">

# Impelementation

## python implementation
    Please refer to the pagerank.py
## scala implementation
    Please refer to the SparkPageRank.scala

# Testing
## Platform
Google Cloud Platform + Dataproc cluster compute engine instance + google storage bucket 

<img width="920" alt="Capture" src="https://user-images.githubusercontent.com/52802567/199407136-5ae8aab5-f2fe-42c7-bd2b-be1f84a19e05.PNG">

## Files Preparation

Step1. ssh login master cluster vm instance

Step2. Manually create input file pagerank_data.txt

       A B
       A C
       B C
       C A
## How to Run?
### For pagerank.py:

    hdfs dfs -mkdir hdfs:///mydata
    hdfs dfs -put pagerank_data.txt
    spark-submit hdfs:///mydata/pagerank.py hdfs:///mydata/pagerank_data.txt 10
    
Note: 
hdfs:///mydata/pagerank_data.txt  --> input file
10                                --> iteration number
### Result for 10th iteration
<img width="567" alt="python_10th_iteration" src="https://user-images.githubusercontent.com/52802567/199409314-48b363cf-2cf2-447c-86e8-86f936d262d0.PNG">

    
### For SparkPageRank.scala:
#### Install SBT
    echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
    echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
    sudo apt-get update
    sudo apt-get install sbt
        
#### Create JAR file:

create build.sbt:

    name := "Simple Project" 
    version := "1.0" 
    scalaVersion := "2.12.14" 
    libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.3"
Notice: Please make sure the scala version and spark version are matching with your GCP Spark enviroment.
    
put SparkPageRank.scala under correct directory:

    mkdir src
    cd src
    mkdir main
    cd main
    mkdir scala
    cd scala
    cp ~/SparkPageRank.scala .
    
back to the up 3 level parent directory(same as the directory which build.sbt is under:

    cd ../../../
    
create a jar file

    sbt package
            
#### Upload jar file and input file into the google storage

    gsutil cp pagerank_data.txt gs://my-bucket-0715
    gsutil cp target/scala-2.12/simple-project_2.12-1.0.jar gs://my-bucket-0715
    
#### Run gcloud command

    gcloud dataproc jobs submit spark --cluster=cluster-0715 --region=us-west1 --jars=gs://my-bucket-0715/simple-project_2.12-1.0.jar --class=org.apache.spark.examples.SparkPageRank -- gs://my-bucket-0715/pagerank_data.txt 10

Note: 
gs://my-bucket-0715/pagerank_data.txt  --> input file
10                                     --> iteration number

### Result for 10th iteration

<img width="496" alt="scala_10_new" src="https://user-images.githubusercontent.com/52802567/199409573-f5fc023a-25d6-488d-a251-057f7b863bbc.PNG">


# Presentation
[PageRank in Spark](https://docs.google.com/presentation/d/1nGF3BMhWOEujmbXNh2yDkfbr1aNsvn5A-FFt1W8t4oo/edit?usp=sharing)
