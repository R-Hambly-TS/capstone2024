# Capstone 2024
Capstone Project Repo Winter 2024

Author: Rafe Hambly

Jodrey School of Computer Science | Acadia University

> This project was created using Java Spring Boot in the Eclipse IDE and with Apache Maven.
This project was built with assistance from the following resources:
> - www.baeldung.com
> - www.stacksimplify.com
> - www.spring.io
> - www.anywhere.epam.com
> - www.hub.docker.com
> - www.getbootstrap.com
> - www.w3schools.com
> - Resources provided by the Jodrey School of Computer Science, Acadia University, and Dr. Amir Eaman

> [!IMPORTANT]
> The following sections provide a detailed overview of how to run this project.
> There are two options for running this project:
> 1. Running the PEANUTS-0.2.jar file located in the server>snoopy>target folder via Terminal and accessing via localhost in a browser.
> 2. Running the application via a Docker image that can be pulled from Docker Hub. (recommended)
>
>This file walks through both options.

## Option #1: Running via .jar file.
> [!WARNING]
> This tutorial assumes that you are using a macOS or linux terminal and have an IDE capable of building Maven projects.

Steps:
1. Download the .zip folder from this GitHub page and unzip the folder.
2. Open your Terminal.
3. cd into the directory where you downloaded the .zip file.
4. cd into the project's server folder.
5. cd into the snoopy folder.
6. Open the project in an IDE like Eclipse.
7. Once in Eclipse, run build clean and then run build install.
8. After the build has completed, cd into the target folder.
9. Once in the target folder run the following command:
   ```
   java -jar PEANUTS-0.2.jar
   ```
10. Open a browser and navigate to localhost:8088
11. View the data entries and those flagged as abnormal in red on the webpage.

## Option #2: Running via Docker. (recommended)
> [!WARNING]
> You must have a Docker Hub account in order to run this Docker image.

Steps:
1. Open the Docker Desktop App.
2. Verify Docker version and login to Docker Hub.
   ```
   docker version
   docker login
   ```
3. Pull the image from Docker Hub.
   ```
   docker pull rhamblyts/peanuts:latest
   ```
4. Run the downloaded Docker image.
   ```
   docker run --name peanuts -p 8088:80 -d rhamblyts/peanuts:latest
   ```
5. In the Docker Desktop App, navigate to the Containers tab and open the app by clicking on the link found in the Port(s) column.
6. View the data entries and those flagged as abnormal in red on the webpage.
> [!NOTE]
> You may need to refresh the page a couple of times before the Docker container connects properly.
> To access the H2 Console, you may need to change the datasource url line to read:
> ```
> jdbc:h2:mem:mydb
> ```
