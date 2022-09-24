<template>
  <div class="editor-page">
    <div class="container page">
      <div class="row">
        <div class="col-md-10 offset-md-1 col-xs-12">
          <RwvArticleHistoryList type="all" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import RwvArticleHistoryList from "@/components/ArticleHistoryList";

export default {
  name: "rwv-home-global",
  components: {
    RwvArticleHistoryList
  }
};
</script>
