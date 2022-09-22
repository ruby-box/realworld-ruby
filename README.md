# 개발환경
## Database
Mysql latest 버전

## JDK
openjdk 11

## Vue node.js
v16.17.0


# Build 하기
## spring-boot-realworld 빌드

### 1. 디렉터리 이동
```bash
cd spring-boot-realworld
```

### 2. 도커 빌드
```bash
./gradlew bootBuildImage --imageName unacha/spring-boot-realworld
```


## vue-realworld 빌드

### 1. 디렉터리 이동
```bash
cd vue-realworld
```

### 2. 도커 빌드
```bash
docker build -t unacha/vue-realworld .
```

## 도커 compose 컨테이너 실행

### 1. 디렉터리 이동
```bash
cd {root}
```

### 2. docker compose 실행
```bash
docker-compose up
```
