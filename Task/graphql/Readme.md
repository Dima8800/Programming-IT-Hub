# Spring Boot GraphQL API

Этот проект представляет собой простое приложение на Spring Boot, которое реализует GraphQL API для управления пользователями и их автомобилями.

## Описание

Приложение позволяет:
- Добавлять пользователей

- Получать информацию о пользователях

- Добавлять автомобили к пользователям

- Получать список автомобилей для каждого пользователя

## Технологии

- Java 21+
- Spring GraphQL
- Lombok
- Maven

## Установка

1. Клонируйте репозиторий:

git clone <данный репозитории>

2. Установите maven и добавьте его в path если это не сдлали раньше

3. Соберите проект:

4. mvn clean install

4. Запустите приложение:

mvn spring-boot:run

## Использование

### GraphQL API

После запуска приложения вы можете использовать Postman для выполнения запросов.

#### Примеры запросов

**Получить всех пользователей:**

{
"query": "{ users { id name surname phone cars { brand model color engine } } }"
}

**Получить пользователя по ID с его машинами:**

{
"query": "{ user(id: 1) { id name surname phone cars { brand model color engine } } }"
}

**Добавить нового пользователя:**

{
"query": "mutation { addUser(name: "Dima", surname: "java", phone: "123456789") { id name } }"
}}

**Добавить автомобиль пользователю:**

{
"query": "mutation { addCar(userId: 1, brand: "Toyota", model: "Corolla", color: "Red", engine: 1.8) { brand model } }"
}

## Зависимости

В проекте используются следующие зависимости:

- spring-boot-starter-web
- spring-boot-starter-graphql
- lombok

## Лицензия

Можете полбзоваться. В целом ничего там секретного и сложного

## Автор

Горелов Дмитрий

