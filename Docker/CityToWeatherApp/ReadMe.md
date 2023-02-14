# Write a web application to find the weather of a given city, and deploy it on Decker Desktop. 

![hw1_topservices](https://user-images.githubusercontent.com/52802567/218651930-bca3974a-4f06-4f6f-ac44-8d6da46d9fa0.png)


## 1. Design the service using two microservices: 

![hw1_microservices](https://user-images.githubusercontent.com/52802567/218651951-5013755a-0c20-444e-a969-774eb2684339.png)


## 2. Implementation: Write two server programs in python and test them using either browser client or curl client.
### Implementation Directory Structure:
$ find . | sed -e "s/[^-][^\/]*\// |/g" -e "s/|\([^ ]\)/|-\1/"
.
 |-cityToZipcode
 | |-Dockerfile
 | |-app.py
 |-docker-compose.yaml
 |-zipcodeToWeather
 | |-Dockerfile
 | |-app.py
![dict](https://user-images.githubusercontent.com/52802567/218654855-96d95717-cc33-42d9-9a45-f35c3f5db096.JPG)
### Test using curl:
1. python3 ./zipcodeToWeather/app.py
2. python3 ./cityToZipcode/app.py
3. curl http://ip:5000/city?city=Fremont



## 3. Containerization: Create Dockerfiles and run two containers independently.

## 4. Networking: Make two containers talk to each other.
Using Docker Compose yaml setting to achieve this goal.

### How to Run?
#### docker compose up -d
![rs](https://user-images.githubusercontent.com/52802567/218656202-5ccbc258-2a97-4247-8b3f-cdea72a21c73.JPG)

#### In browser, enter the url: http://external-ip:5000/city?city=San Jose
![Result](https://user-images.githubusercontent.com/52802567/218655772-08bd52ed-cb66-448a-9cf7-047e5e94e3e7.JPG)

#### stop all containers
docker compose down 
![rs](https://user-images.githubusercontent.com/52802567/218656996-c9f2cd60-ca6e-40b4-8a5a-61406b028845.JPG)


## Results and Screenshots

