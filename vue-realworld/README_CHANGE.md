# 변경사항

## Article History 화면 추가
1. `article-history` router 추가
2. `view/ArticleHistory.vue` 구현


## Article History API 연동
1. `mutation.type`, `action.type` 추가
2. `article.module.js` 에 `FETCH_ARTICLE_HISTORY` 관련 vuex 설정, mutations `SET_ARTICLE_HISTORY` 추가
3. `api.service.js`에 ArticlesHistoryService 서비스 추가
4. `articleHistoryList` 를 반환하는 `getters` 추가

action -> mutation -> state 로 데이터 흐름

article history 관련 state 관리 값 : articleHistoryList

Article History 리스트 화면 구현 이슈 : https://github.com/ruby-box/realworld-ruby/issues/6

