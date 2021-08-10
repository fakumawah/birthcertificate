###To use a dockerised Postgress Database
Step 1: Create a local volume
`docker create -v /var/lib/postgresql/data --name PostgresData alpine`

Step 2: Run a postgress image with database=birthcertificate user=birthcertificate password=birthcertificate2021
`docker run -p 5433:5432 --name postgres -e POSTGRES_DB=birthcertificate -e POSTGRES_USER=birthcertificate -e POSTGRES_PASSWORD=birthcertificate2021 -d --volumes-from PostgresData postgres`

###To build the birthcertificate application 
Make sure to first commit all changes(even without pushing), then run

`./gradlew clean disTar`

This generates in build/libs a file called birthcertificate-<sem version>.tar

Then a distributable can be created in build/dist using

`./gradlew createDistributable  `

###To build the docker image (Dockerfile in root directory)
`docker build --tag=birthcertificate-server:latest . `

###To run the docker image in detached Mode(-d)
`docker run -d -p8080:8080 birthcertificate-server:latest`

###To test the application in a browser
`http://localhost:8080/api/v1/citizen`

This should show a list of citizens

Some