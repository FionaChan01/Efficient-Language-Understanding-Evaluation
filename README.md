# Efficient Language Understanding Evaluation

<center><img src="https://raw.githubusercontent.com/FionaChan01/Efficient-Language-Understanding-Evaluation/main/logo.png" style="width:48%;margin:0 auto" /></center>

This is the Source Code repo for the [ELUE website](http://eluebenchmark.fastnlp.top/#/landing), ELUE (Efficient Language Understanding Evaluation) is a standard benchmark for efficient NLP models.

The overall framework of ELUE is shown in the figure below.

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/overall.png?raw=true" style="width:80%;margin:0 auto" /></center>





# Ⅰ Frontend

#### 1⃣️ **Home Page**

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/homepage.png?raw=true" style="width:80%;margin:0 auto" /></center>

The homepage is mainly responsible for the overall introduction and task presentation, and can also download all datasets and view the paper of ELUE

#### 2⃣️ About Page

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/aboutpage.png?raw=true" style="width:80%;margin:0 auto" /></center>

The about page is responsible for presenting common questions and answers

#### 3⃣️ Leaderboard Page

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/leaderboardpage.png?raw=true" style="width:80%;margin:0 auto" /></center>

The leaderboard page shows the scores (descending order) of each model under ELUE, which can be filtered by parameter quantity

#### 4⃣️ Profile Page

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/profilepage.png?raw=true" style="width:80%;margin:0 auto" /></center>

The profile page displays all the submitted data of the user, and the user can delete his/her submission record on this page

#### 5⃣️ Task Page

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/taskpage.png?raw=true" style="width:80%;margin:0 auto" /></center>

The task page displays the elue data points of each model under this task. Users can download the task data set and submit their own data points on this page. You can also submit code files, and the platform automatically measures each data point

# Ⅱ Backend

ELUE's backend uses a distributed framework that includes four microservices: login, data, tasks, and submit. Also apache Dubbo and Zookeeper are used as the registration center and management framework respectively.

#### 1⃣️ **Login Service**

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/login_signup.png?raw=true" style="width:80%;margin:0 auto" /></center>

ELUE provides users with secure and convenient single sign on and registration services. Passwords are stored in the database after encryption

#### 2⃣️ Data Service

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/data.png?raw=true" style="width:80%;margin:0 auto" /></center>

ELUE provides users with automatic data visualization, storage and sorting services to help users quickly see the performance of their models

#### 3⃣️ Task Service

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/task.png?raw=true" style="width:80%;margin:0 auto" /></center>

The elue stores all information of all tasks, and can easily expand tasks and data sets at any time

#### 4⃣️ Submit Service

<center><img src="https://github.com/FionaChan01/Efficient-Language-Understanding-Evaluation/blob/main/images/submit.png?raw=true" style="width:80%;margin:0 auto" /></center>

Elue provides users with a fast and friendly file upload service, and evaluating models in queue reduces the pressure on the server

## Ⅲ Contributor
