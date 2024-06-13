# GreetGo Task - CRUD Telephony Application

## Описание проекта

Этот проект представляет собой Spring Boot приложение, которое реализует два CRUD контроллера для работы с PostgreSQL и MongoDB. 
Приложение поддерживает базовые операции CRUD (Создание, Чтение, Обновление, Удаление) для управления клиентами.

## Требования

- Java 17
- Gradle
- PostgreSQL
- MongoDB

## Установка и запуск

### 1. Склонировать репозиторий

```sh
git clone https://github.com/abai45/GreetGoTask.git
```

### 2. Перейти в папку проекта

```sh
cd GreetGoTask
```

### 3. Настроить базы данных

Перед запуском приложения необходимо настроить базы данных PostgreSQL и MongoDB. В файле `application-dev.properties` задайте параметры подключения:

```properties
# PostgreSQL
POSTGRESQL_URL=jdbc:postgresql://localhost:5432/greetgo_psql
POSTGRESQL_USERNAME=postgres
POSTGRESQL_PASSWORD=1234

# MongoDB
MONGODB_URI=mongodb://localhost:27017/greetgodb
ACTIVE_PROFILE=dev
```

### 4. Запустить приложение

```sh
./gradlew bootRun
```

### 5. Использование API

Для работы с приложением используйте Postman. В приложении реализованы следующие эндпоинты:

#### PostgreSQL CRUD

- Получить клиента по ID:
  - `GET /psql/client/get?id= `
- Получить клиента по телефону:
  - `GET /psql/client/get/phone?phone= `
- Создать пользователя:
  - `POST /psql/client/create`
- Удалить клиента по ID:
  - `POST /psql/client/delete?id= `
- Удалить клиента по телефону:
  - `POST /psql/client/delete/phone?phone= `
- Получить список клиентов с фильтром:
  - `GET /psql/client?limit=10&offset=0`
- Обновить клиента по ID:
  - `PATCH /psql/client/update?id= `
- Обновить клиента по телефону:
  - `PATCH /psql/client/update/phone?phone= `

#### MongoDB CRUD

- Получить клиента по ID:
  - `/mongo/client/get?id= `
- Получить клиента по телефону:
  - `GET /mongo/client/get/phone?phone= `
- Создать пользователя:
  - `POST /mongo/client/create`
- Удалить клиента по ID:
  - `POST /mongo/client/delete?id= `
- Удалить клиента по телефону:
  - `POST /mongo/client/delete/phone?phone= `
- Получить список клиентов с фильтром:
  - `GET /mongo/client?limit=10&offset=0`
- Обновить клиента по ID:
  - `PATCH /mongo/client/update?id= `
- Обновить клиента по телефону:
  - `PATCH /mongo/client/update/phone?phone= `
- *Форма для создания пользователя и обновления:*
  `{
  "firstName": "Abai",
  "lastName": "Amangeldiuly",
  "phone": "1234567",
  "secondPhone": "4321",
  "birthday": "1990-01-01"
  }`
  
### 7. Экспортировать запросы в Postman

Запросы в Postman можно создать вручную, используя вышеуказанные эндпоинты, либо экспортировать готовый набор запросов. Готовый набор запросов экспортирован в файл `postman_collection.json`, который можно импортировать в Postman.

### Примечания

1. Убедитесь, что PostgreSQL и MongoDB запущены и доступны по указанным адресам.
2. Для настройки приложения используйте файл `application.properties`.
3. При возникновении ошибок, ознакомьтесь с логами приложения для диагностики проблем.

### Дополнительные фишки

В проекте так-же реализовано аудирование создания/обновления информации о пользователях и отдельная таблица с аудированием действий, связанных с пользователями. При совершений каких-либо операций над пользователем, в этой таблице будут сохраняться соответственные операции (create/read/update) со ссылкой на пользователя.

## Авторы

- Амангелдыулы Абай(https://github.com/abai45)
