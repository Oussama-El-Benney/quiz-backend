# quiz-backend


docker volume create quiz_mysql_data
docker volume create quiz_mysql_data

docker network create mysqlnet                


docker run -it --rm -d -v mysql_data:/var/lib/mysql -v mysql_config:/etc/mysql/conf.d --network mysqlnet --name mysqlserver -e MYSQL_USER=oussa -e MYSQL_PASSWORD=oussa -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=quiz -p 3306:3306 mysql:8.0


docker build --tag java-docker .


docker run --rm -d --name springboot-server --network mysqlnet -e MYSQL_URL=jdbc:mysql://mysqlserver/quiz -p 8080:8080 quiz





docker compose -f docker-compose.dev.yml up --build
