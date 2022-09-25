# 변경사항

## 1) 외부 DB 사용 및 JPA 구성
외부 database : MySQL

관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/3

## 2) Article 히스토리 저장 구현
대상 테이블 : article_history

article_history 스키마

|field|type|description|KEY|
|---|---|---|---|
|id|bigint|식별자|PK|
|article_id|article id|||
|body|longtext|내용||
|create_at|tinyblob|생성일||
|description|longtext|설명||
|mode|char|history 모드(신규:C, 업데이트:U, 삭제:D)||
|slub|varchar(255)|slug||
|title|varchar(255)|제목||
|user_id|varchar(255)|user id||


관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/4

## 3) Article History 조회 API 구현
### Article History API 스펙
- article_history 테이블의 이력을 조회해서 Array로 반환

Request
```
curl -X GET localhost:8081/article-history
```
Response
```
{
  "articleHistoryList": [
    {
      "id": 1,
      "userId": "3af3cd9d-08bf-4333-aba4-19c53c6db92e",
      "articleId": "204c6c74-effa-4e50-baf1-19aae96bb2ad",
      "slug": "bbbbbcc1",
      "title": "bbbbbcc1",
      "description": "cc",
      "body": "ss",
      "mode": "C",
      "createdAt": null
    },
    {
      "id": 2,
      "userId": "3af3cd9d-08bf-4333-aba4-19c53c6db92e",
      "articleId": "204c6c74-effa-4e50-baf1-19aae96bb2ad",
      "slug": "bbbbbcc1",
      "title": "bbbbbcc1",
      "description": "cc",
      "body": "ss",
      "mode": "U",
      "createdAt": null
    }
  ],
  "articleHistoryCount": 2
}
```
관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/7


## 4) Article History 상세보기 API 구현
### Article History 상세보기 API 스펙
Request
```
curl -X GET localhost:8081/article-history/{article_history_id}
```

Response
```
{
  "article_history": {
    "id": 1,
    "userId": "3af3cd9d-08bf-4333-aba4-19c53c6db92e",
    "articleId": "204c6c74-effa-4e50-baf1-19aae96bb2ad",
    "slug": "bbbbbcc1",
    "title": "bbbbbcc1",
    "description": "cc",
    "body": "ss",
    "mode": "C",
    "createdAt": null
  }
}
```
관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/11