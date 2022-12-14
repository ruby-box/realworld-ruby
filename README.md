# 개발환경
* GitHub URL : https://github.com/ruby-box/realworld-ruby

## spring-boot-realworld
* Datebase : MySQL latest 버전
* JDK : openjdk 11

## vue-realworld
* node.js : v16.17.0


# 환경 준비
Vue 프로젝트 의존성 설치
```
cd vue-realworld
yarn install
```


# Build 하기
도커 환경 구축 이슈 : https://github.com/ruby-box/realworld-ruby/issues/1

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

# 어플리케이션 정보
관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/2

- Vue 프로젝트 접근 : http://localhost:8080
- Spring Boot App 접근 : http://localhost:8081


# spring-boot-realworld 변경사항
[변경사항 보기](./spring-boot-realworld/README_CHANGE.md)


# vue-realworld 변경사항
[변경사항 보기](./vue-realworld/README_CHANGE.md)

# 완료
1. docker-compose 환경 구축
2. Vue, Spring API 연동
3. MySQL 외부 데이터베이스 연동
4. Article 히스토리 저장
5. Article 히스토리 리스트 구현(화면, API)
6. Article 히스토리 상세보기 구현(화면, API)


# 남은 일감
1. Article History 페이징 처리
2. Article History List 페이지 사용자 명 등 meta정보를 더 출력할 수 있도록 수정
3. 수정 시, Tag값 변경 안되는 버그 수정
4. 추가 기능 테스트 코드 작성