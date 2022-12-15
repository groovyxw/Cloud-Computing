# Apache Spark + GraphFramse + GraphX

GraphFrame mainly provides the following built-in algorithms:

Triangle count

PageRank

Shortest Path

...

<img width="402" alt="9" src="https://user-images.githubusercontent.com/52802567/207792419-f9604b6d-b6ce-4ee0-ae3d-774e83334c98.PNG">

## Description

Family and Friend information:

<img width="185" alt="desc" src="https://user-images.githubusercontent.com/52802567/207792681-2ebf9109-6859-44cb-bac6-39117a14e513.PNG">



## How to implement?

#### 1. Create GCP project and compute engine vm instance



#### 2. Install pyspark and java 11



#### 3. Prepare input data file



#### 4. Create program file pyspark_graphX.py

#### 5. Run

Command:

$ spark-submit --packages graphframes:graphframes:0.8.2-spark3.1-s_2.12 pyspark_graphX.py


Note:

In case, you need to install numpy,

$ sudo apt install python3-pip
$ pip3 install numpy


graphframes versions available at:
https://spark-packages.org/package/graphframes/graphframes

#### 6. Result



#### 7. References

https://spark-packages.org/package/graphframes/graphframes

https://towardsdatascience.com/graphframes-in-jupyter-a-practical-guide-9b3b346cebc5#:~:text=The%20functionality%20of%20GraphFrames%20and,browsing%20through%20the%20API%20documentation.

https://hc.labnet.sfbu.edu/~henry/sfbu/course/pyspark_sql_recipes/graphframes/slide/graphx.html
