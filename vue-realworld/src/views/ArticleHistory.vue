<template>
  <div class="editor-page">
    <div class="container page">
      <div class="row">
        <div class="col-md-10 offset-md-1 col-xs-12">
          <RwvArticleList type="all" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import RwvArticleList from "@/components/ArticleList";

export default {
  name: "rwv-home-global",
  components: {
    RwvArticleList
  }
};
</script>
