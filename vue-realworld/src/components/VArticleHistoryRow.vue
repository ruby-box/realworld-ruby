<template>
  <div class="article-preview">
    <!-- RwvArticleMeta isPreview :article="article" / -->
    <router-link :to="articleHistoryLink" class="preview-link">
      <h1 v-text="article.title" />
      <p v-text="article.description" />
      <span>Read more...</span>
      <!-- TagList :tags="article.tagList" / -->
    </router-link>
  </div>
</template>

<script>
import RwvArticleMeta from "./ArticleMeta";
import TagList from "./TagList";

export default {
  name: "RwvArticlePreview",
  components: {
    RwvArticleMeta,
    TagList
  },
  props: {
    article: { type: Object, required: true }
  },
  computed: {
    articleHistoryLink() {
      return {
        name: "article-history-detail",
        params: {
          id: this.article.id
        }
      };
    }
  }
};
</script>
