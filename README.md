# rental car

To pull all docker images:

```text
docker compose pull
```

To build project:

```text
docker compose run maven-build
```

To build local docker image:

```text
docker compose build
```

To run database:

```text
docker compose up -d db-mysql
```

To run web app:
```text
docker compose up -d rentalcar
```

Go to [http://localhost:8080/rentalcar](http://localhost:8080/rentalcar)