# Movie Recommandation System

## Step1: Study PySpark Collaborative Filtering with ALS
Link: [PySpark Collaborative Filtering with ALS](https://towardsdatascience.com/build-recommendation-system-with-pyspark-using-alternating-least-squares-als-matrix-factorisation-ebe1ad2e7679)

Pyspark Link: [Recommendation_Engine_MovieLens](https://github.com/snehalnair/als-recommender-pyspark/blob/master/Recommendation_Engine_MovieLens.ipynb)

## Step2: Study Colab

Overview Link: [Google Colab](https://hc.labnet.sfbu.edu/~henry/npu/classes/machine_learning/colab/slide/index_slide.html)

### How to start colab?

1> Login your google account

2> Click this [the colab page link](https://colab.research.google.com/notebooks/intro.ipynb#recent=true)
    
## Step3: Experiment Pyspark code (ipynb) of PySpark Collaborative Filtering with ALS

#### 1> Download the ipynb file from Github [link](https://github.com/snehalnair/als-recommender-pyspark)

Code --> Download ZIP

<img width="333" alt="9" src="https://user-images.githubusercontent.com/52802567/202865854-aec5f164-066b-4fe3-90a8-1906444e9235.PNG">



#### 2> Upload the ipynb file to your Colab

File --> Upload notebook

<img width="685" alt="7" src="https://user-images.githubusercontent.com/52802567/202865692-69a015c2-194f-4c27-bb90-35608021fc12.PNG">


#### 3> Modify the code on your Colab

Add one line to install pyspark at the very beginning:

    !pip3 install pyspark
    
Please refer to this [file](https://github.com/groovyxw/Cloud-Computing/blob/main/Machine%20Learning/Movie%20Recommendation%20System/Recommendation_Engine_MovieLens.ipynb) for details.

#### 4> Upload input data files into Colab Storage

Files --> upload

<img width="387" alt="8" src="https://user-images.githubusercontent.com/52802567/202865705-004d7339-8ef4-4482-8942-704eb7e9e4b2.PNG">


#### 5> Do the experiment on Colab

Run the code snippet one by one, final result as below:

<img width="449" alt="Capture" src="https://user-images.githubusercontent.com/52802567/202846547-a5887c2f-fdd7-4ef1-99dd-e5a4b2429414.PNG">

#### 6> Save file as .py file on Colab

File --> Download --> Download .py

Please refer to [recommendation_engine_movielens.py](https://github.com/groovyxw/Cloud-Computing/blob/main/Machine%20Learning/Movie%20Recommendation%20System/recommendation_engine_movielens.py).

#### 7> Save file as .html file

File --> Save (right click) --> Save as (click)

## Step4: Run the py file (just saved in last step) on GCP

1> Create a project on GCP

<img width="421" alt="24" src="https://user-images.githubusercontent.com/52802567/203263154-731a07d2-ffd8-4aa9-b90d-888e515040c2.PNG">


2> Create an Dataproc Cluster instance based on compute engine on GCP

<img width="871" alt="22" src="https://user-images.githubusercontent.com/52802567/203263239-795807dd-1e78-4f2a-9098-50f305ae9c5c.PNG">


3> Create a bucket and Upload all files 

<img width="910" alt="23" src="https://user-images.githubusercontent.com/52802567/203263329-d486ea0e-8c9f-4f9a-ae5e-acdf613fd62d.PNG">


4> Pyspark run
Notice: Comment out prspark installation line in *.py file.

<img width="530" alt="4" src="https://user-images.githubusercontent.com/52802567/203270445-13324371-2c65-4e92-b7e6-5ef1a67e636f.PNG">

Best Model:


<img width="210" alt="1" src="https://user-images.githubusercontent.com/52802567/203270485-e9306b72-73d0-462c-8fb8-d57d0f40e780.PNG">

Evaluation:


<img width="404" alt="3" src="https://user-images.githubusercontent.com/52802567/203270689-a5f60dc1-cf43-435b-adf7-bab87d755b94.PNG">



## Presenstation
[]()

Reference links:
https://colab.research.google.com/drive/1G894WS7ltIUTusWWmsCnF_zQhQqZCDOc


