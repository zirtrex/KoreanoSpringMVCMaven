# Obtener imagen de MySQL oficial
FROM mysql
#FROM mysql:5.6

# Agregar una base de datos
ENV MYSQL_DATABASE db_koreano

# Agregar el contenido de ./db_koreano_docker.sql a la imagen
# Todos los scripts en docker-entrypoint-initdb.d/ son ejecutados automaticamente al iniciar
COPY ./db_koreano_docker.sql /docker-entrypoint-initdb.d/