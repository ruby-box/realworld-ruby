<template>
  <div class="article-page">
    <div class="banner">
      <div class="container">
        <h1>{{ articleHistory.title }}</h1>
        <!-- RwvArticleMeta :article="articleHistory" :actions="false" :isHistory="true"></RwvArticleMeta -->
      </div>
    </div>
    <div class="container page">
      <div class="row article-content">
        <div class="col-xs-12">
          <div v-html="parseMarkdown(articleHistory.body)"></div>
          <!-- ul class="tag-list">
            <li v-for="(tag, index) of articleHistory.tagList" :key="tag + index">
              <RwvTag
                :name="tag"
                className="tag-default tag-pill tag-outline"
              ></RwvTag>
            </li>
          </ul -->
        </div>
      </div>
      <hr />
      <div class="article-actions">
        <!-- RwvArticleMeta :article="articleHistory" :actions="false" :isHistory="true"></RwvArticleMeta -->
      </div>
      <div class="row">
        <div class="col-xs-12 col-md-8 offset-md-2">
          <!--RwvComment
            v-for="(comment, index) in comments"
            :slug="slug"
            :comment="comment"
            :key="index"
          >
          </RwvComment -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import marked from "marked";
import store from "@/store";
import RwvArticleMeta from "@/components/ArticleMeta";
import RwvComment from "@/components/Comment";
import RwvCommentEditor from "@/components/CommentEditor";
import RwvTag from "@/components/VTag";
import { FETCH_COMMENTS, FETCH_ARTICLE_HISTORY_DETAIL  } from "@/store/actions.type";

export default {
  name: "rwv-article",
  props: {
    id: {
      type: Number,
      required: true
    }
  },
  components: {
    RwvArticleMeta,
    RwvComment,
    RwvCommentEditor,
    RwvTag
  },
  beforeRouteEnter(to, from, next) {
    Promise.all([
      store.dispatch(FETCH_ARTICLE_HISTORY_DETAIL, to.params.id),
      //store.dispatch(FETCH_COMMENTS, to.params.id)
    ]).then(() => {
      next();
    });
  },
  computed: {
    ...mapGetters(["articleHistory", "currentUser", "comments", "isAuthenticated"])
  },
  methods: {
    parseMarkdown(content) {
      return marked(content);
    }
  }
};
</script>
