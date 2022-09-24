<template>
  <div>
    <div v-if="isHistoryLoading" class="article-preview">Loading...</div>
    <div v-else>
      <div v-if="articleHistoryList.length === 0" class="article-preview">
        히스토리가 존재하지 않습니다.
      </div>
      <RwvArticleHistoryRow
        v-for="(article, index) in articleHistoryList"
        :article="article"
        :key="article.title + index"
      />
      <!-- VPagination :pages="pages" :currentPage.sync="currentPage"/ -->
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import RwvArticleHistoryRow from "./VArticleHistoryRow";
import VPagination from "./VPagination";
import { FETCH_ARTICLE_HISTORY } from "../store/actions.type";

export default {
  name: "RwvArticleList",
  components: {
    RwvArticleHistoryRow,
    VPagination
  },
  props: {
    type: {
      type: String,
      required: false,
      default: "all"
    },
    author: {
      type: String,
      required: false
    },
    tag: {
      type: String,
      required: false
    },
    favorited: {
      type: String,
      required: false
    },
    itemsPerPage: {
      type: Number,
      required: false,
      default: 10
    }
  },
  data() {
    return {
      currentPage: 1
    };
  },
  computed: {
    listConfig() {
      const { type } = this;
      const filters = {
        offset: (this.currentPage - 1) * this.itemsPerPage,
        limit: this.itemsPerPage
      };
      if (this.author) {
        filters.author = this.author;
      }
      if (this.tag) {
        filters.tag = this.tag;
      }
      if (this.favorited) {
        filters.favorited = this.favorited;
      }
      return {
        type,
        filters
      };
    },
    pages() {
      if (this.isHistoryLoading || this.articleHistoryCount <= this.itemsPerPage) {
        return [];
      }
      return [
        ...Array(Math.ceil(this.articleHistoryCount / this.itemsPerPage)).keys()
      ].map(e => e + 1);
    },
    ...mapGetters(["articleHistoryCount", "isHistoryLoading", "articleHistoryList"])
  },
  watch: {
    currentPage(newValue) {
      this.listConfig.filters.offset = (newValue - 1) * this.itemsPerPage;
      this.fetchArticleHistory();
    },
    type() {
      this.resetPagination();
      this.fetchArticleHistory();
    },
    author() {
      this.resetPagination();
      this.fetchArticleHistory();
    },
    tag() {
      this.resetPagination();
      this.fetchArticleHistory();
    },
    favorited() {
      this.resetPagination();
      this.fetchArticleHistory();
    }
  },
  mounted() {
    this.fetchArticleHistory();
  },
  methods: {
    fetchArticleHistory() {
      this.$store.dispatch(FETCH_ARTICLE_HISTORY, this.listConfig);
    },
    resetPagination() {
      this.listConfig.offset = 0;
      this.currentPage = 1;
    }
  }
};
</script>
