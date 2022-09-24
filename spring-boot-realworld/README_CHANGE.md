# 변경사항

## 1) 외부 DB 사용 및 JPA 구성
외부 database : MySQL

관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/3

## 2) Article 히스토리 저장 구현
대상 테이블 : article_history

관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/4

## 3) Article History 조회 API 구현
### Article History API 스펙
- article_history 테이블의 이력을 조회해서 Array로 반환
```
curl -X GET localhost:8081/article-history
```
관련 이슈 : https://github.com/ruby-box/realworld-ruby/issues/7