# fleet-master-auth

# 📦 PostgreSQL Setup for This App

This application requires a PostgreSQL database to run.

## ✅ Database Requirements

Make sure your PostgreSQL database has the following credentials:

- **User:** `postgres`  
- **Password:** `postgres`  
- **Database name:** `test`

## 🐳 Setting up with Docker

If you have Docker installed, you can quickly spin up a PostgreSQL container using the following command:

```bash
docker run --name some-postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=test \
  -d -p 5432:5432 \
  postgres:latest
```

To check if the container is running:
```bash
docker ps
```

If the container is stopped, start it with:
```bash
docker start some-postgres
```