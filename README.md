### Conserjeria API
## Descripción
Este proyecto es una API desarrollada en Java, diseñada para ser ejecutada en contenedores Docker. Ofrece dos modos de operación con diferentes bases de datos: SQLite y MariaDB.

## Requisitos
Para ejecutar esta API, necesitas tener instalado:
- Docker
- Docker Compose

Clona el repositorio (si aún no lo has hecho):

   ```bash
   git clone https://github.com/Benjh4dev/conserjeria.git)https://github.com/Benjh4dev/conserjeria.git
   ```

## Ejecución con SQLite

Para ejecutar la API usando SQLite como base de datos, utiliza el archivo `docker-compose.yml`. Este modo no requiere de una configuración adicional de base de datos.
 ```bash
   docker-compose up -d
 ```

## Ejecución con MARIADB

Para ejecutar la API usando MariaDB como base de datos, utiliza el archivo `docker-compose-mariadb.yml`. Este modo no requiere de una configuración adicional de base de datos.
 ```bash
   docker-compose -f docker-compose-mariadb.yml up -d
 ```
