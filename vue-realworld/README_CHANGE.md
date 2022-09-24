# 추가사항

개발 환경 설정

* develop node version : v16.17.0

도커 빌드
 1. 도커 이미지 생성
  ``` bash
  docker build -t unacha/vue-realworld .
  ```

 2. 도커 이미지 실행
  ``` bash
  docker run -it -p 8080:80 --rm --name vue-realworld-app-1 unacha/vue-realworld
  ```
