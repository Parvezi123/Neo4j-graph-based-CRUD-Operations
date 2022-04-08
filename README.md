# Neo4j-graph-based-CRUD-Operations
User Movie Model of Neo4j, A Graph based Database is used for Storing and retrieving the information for CRUD Operations

## INSTALLATION STEPS
Use IntelliJ IDEA Software for Coding
1. Clone the Repository to your Local Machine.
2. Open the  pom.xml file and Update (load) the dependencies. Press ( Ctrl + Shift + O )
3. **Replace your IpAddress in the Prometheus.yml file as below example**
4. Example:  From  =>   targets: ['IpAddress:8080']    to    targets: ['192.168.0.102:8080']   <= take IpAddress from ipconfig command frpm cmd
5. Create jar file, by executing the below command in IntelliJ Builtin Terminal =>   
6.      ./mvnw clean install -DskipTests
7. Install the Docker Desktop => https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe
8. Install Neo4j Community Desktop => https://go.neo4j.com/download-thanks.html?edition=community&release=4.4.5&flavour=winzip
9. Navigate to the project location in Windows PowerShell =>  C:\Projects\User Movie Graph Application
10. ###### Execute the below Commands in Windows PowerShell to pull necessary Images => 
11.      docker pull neo4j 
12.      docker pull grafana/grafana 
13.      docker pull prom/prometheus 
14.      docker build -t usermovie_image . 
15.      docker-compose up
       After executing the above commands step by step in Windows PowerShell with the Project location path, 
            Verify the images in the Docker Desktop and Check the Container is running or not.
            
15.  In the URL, hit  [YourIPAddress]:8080/swagger-ui/index.html#/    replace [YourIPAddress] to your localIpAddress of PC which is updated in Prometheus.yml file
16.  Hit [YourIPAddress]:9090/  for Prometheus dashboard
17.  Hit [YourIPAddress]:3000/  for Grafana Dashboard
18.       Grafana Dashboard Configuration will be released soon ..... 
19.       Hope you like it...  Star my repo as a Support towards my work
       
