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

<img width="688" alt="gcp-1" src="https://user-images.githubusercontent.com/52802567/207848337-b78a7a1d-e446-480e-bd14-be3bdb510250.PNG">


<img width="407" alt="gcp-ssh" src="https://user-images.githubusercontent.com/52802567/207848363-99f8a673-d7c5-4111-a77b-0c53eac894dd.PNG">


#### 2. Install pyspark and java 11

<img width="925" alt="download_pyspark" src="https://user-images.githubusercontent.com/52802567/207848413-8c4412a1-a62a-4639-8904-837ec6a1dbdf.PNG">



#### 3. Prepare input data file

<img width="216" alt="input-files" src="https://user-images.githubusercontent.com/52802567/207848653-445d30de-e41e-4798-b333-635f706a370c.PNG">


#### 4. Create program file pyspark_graphX.py
Please refer to [pyspark_graphX.py](https://github.com/groovyxw/Cloud-Computing/blob/main/Apache%20Spark%20%2B%20GraphFramse%20%2B%20GraphX/pyspark_graphX.py)


#### 5. Run

Command:

$ spark-submit --packages graphframes:graphframes:0.8.2-spark3.1-s_2.12 pyspark_graphX.py


Note:
graphframes versions available at:
https://spark-packages.org/package/graphframes/graphframes

#### 6. Result

GraphFrame:

<img width="115" alt="result1" src="https://user-images.githubusercontent.com/52802567/207848853-be938968-7c5d-410d-b18a-4959e8459f46.PNG">

TriangleCount:

<img width="93" alt="result2" src="https://user-images.githubusercontent.com/52802567/207848942-619b300c-03e2-4cd6-9540-50cc7cede208.PNG">

<img width="202" alt="result3" src="https://user-images.githubusercontent.com/52802567/207848960-8e3dd96e-b86e-405b-ba23-4465b54361f6.PNG">

PageRank:

<img width="236" alt="result4" src="https://user-images.githubusercontent.com/52802567/207849011-27e750ba-d852-4a65-bd96-ebd2ef5bd7d7.PNG">

<img width="155" alt="result5" src="https://user-images.githubusercontent.com/52802567/207849066-5a9d9787-54e7-4ea4-add9-401fdb411251.PNG">

BFS:

<img width="477" alt="result6" src="https://user-images.githubusercontent.com/52802567/207849103-590da06e-3751-4362-a73b-03453b23031d.PNG">

#### 7. Documentation
[PySpark_GraphX.pdf](https://github.com/groovyxw/Cloud-Computing/blob/main/Apache%20Spark%20%2B%20GraphFramse%20%2B%20GraphX/PySpark_GraphX.pdf)

#### 8. References
https://spark-packages.org/package/graphframes/graphframes
https://towardsdatascience.com/graphframes-in-jupyter-a-practical-guide-9b3b346cebc5#:~:text=The%20functionality%20of%20GraphFrames%20and,browsing%20through%20the%20API%20documentation.

https://hc.labnet.sfbu.edu/~henry/sfbu/course/pyspark_sql_recipes/graphframes/slide/graphx.html
