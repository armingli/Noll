<!DOCTYPE html>
<html lang="zh-CN">

{{ $githubURL := .Data.GitHubURL }}

<head>
  {{ template "HeadTemplate" .Viewer }}
  <title> {{ .Data.Title }}</title>
  <link rel="stylesheet" href="https://sindresorhus.com/github-markdown-css/github-markdown.css">
  <style>
    .mermaid {
      text-align: center;
      background-color: transparent !important;
    }

    article:first-of-type {
      margin-top: 40px;
    }

    table {
      white-space: nowrap;
    }

    .d-inline-block {
      display: inline-block !important;
    }

    .ml-1 {
      margin-left: 4px !important;
    }

    .circle {
      border-radius: 50% !important;
    }

    .border {
      border: 1px solid var(--color-border-default) !important;
    }

    .markdown-body a {
      border-radius: 0;
      padding: 0;
      display: inline-block;
    }

    .markdown-body a:hover,
    .markdown-body a:active {
      background-color: transparent;
    }

    .reaction+.reaction {
      margin-left: 0;
    }

    .reaction a {
      border-radius: 100px;
    }

    .comment {
      width: 100%;
    }

    .comment-input {
      text-align: center;
      border: 1px solid #ddd;
      background-color: #f9f9f9;
      min-width: 100%;
      padding: 30px 0;
    }
  </style>

    <!-- CSS -->
    <link href="https://cdn.bootcdn.net/ajax/libs/artalk/2.5.4/Artalk.css" rel="stylesheet">
    <!-- JS -->
    <script src="https://cdn.bootcdn.net/ajax/libs/artalk/2.5.4/Artalk.js"></script>
</head>

<body>
  {{ template "HeaderTemplate" . }}
  <div class="clearfix">
    <h1 style="margin-bottom: 0.5rem;"> {{ .Data.Title }} </h1>
    <div style="font-size: 1rem; align-items: center;" class="column">
      <img src="{{ .Viewer.AvatarURL }}" style="width: 1.4rem; height: 1.4rem;" />
      <a href='{{ url "/" }}'>{{ .Viewer.ShowName }}</a>
      发布在<a href="{{ url .Data.Category}}">{{ .Data.Category.Name }}</a>
      于<time style="margin-left: 5px;" class="flex-fill" title="{{ .Data.CreatedAt }}">
        {{ .Data.CreatedAt.Format "01-02-2006" }}</time>
      {{ if .Data.UpvoteCount }}
      <a style="margin-left: -10px" href="{{ $githubURL }}">
        <span>{{ template "VoteSVGTemplate" 22 }}{{ .Data.UpvoteCount }}</span></a>
      {{ end }}
    </div>
    <!-- <div id="container" style="width: 100%; height: 500px; position: relative;"></div> -->
  </div>
  <article class="markdown-body" style="font-size: 1.2rem;">
    {{ .Data.BodyHTML }}
  </article>
  <ul class="ul" style="margin: 30px -10px;">
    <li class="li">{{ template "CategoryItemTemplate" .Data.Category }}</li>
    {{ if .Data.Labels }}
    {{ range $i, $label := .Data.Labels.Nodes }}
    <li class="li">{{ template "LabelItemTemplate" $label }}</li>
    {{ end }}
    {{ end }}
  </ul>
  <ul class="ul" style="text-align: center; margin: 30px auto;">
    <li class="li reaction">
      <a href="{{ $githubURL }}"><span class="SMILING"></span></a>
    </li>
    {{ range $reaction := .Data.ReactionGroups }}
    {{ if $reaction.Reactors.TotalCount }}
    <li class="li reaction">
      <a href="{{ $githubURL }}"><span class="{{ $reaction.Content }}">
          {{ $reaction.Reactors.TotalCount }}</span></a>
    </li>
    {{ end }}
    {{ end }}
  </ul>
  {{ template "TopComponentTemplate" }}
  <div style="display: flex; align-items: center; margin: 30px auto;">
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
    <span class="COMMENT" style="margin: 0 12px"></span>
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
  </div>
  {{ if .Data.Comments }}
  <ul class="ul" style="margin: 30px auto; font-size: 1rem;">
    {{ range $comment := .Data.Comments.Nodes }}
    <li class="li comment">
      {{ template "CommentItemTemplate" $comment }}
    </li>
    {{ end }}
  </ul>
  {{ end }}
  <!-- <a href="{{ $githubURL }}#issue-comment-box" class="comment-input">前往 GitHub Discussion 评论</a> -->

<!-- Artalk -->
<div id="Comments"></div>
<script>
  Artalk.init({
    el:        '#Comments',              // 绑定元素的 Selector
    pageKey:   '',                // 固定链接 (留空自动获取)
    pageTitle: '', // 页面标题 (留空自动获取)
    server:    'http://artalk.metaprogramming.space',  // 后端地址
    site:      "{{ .Viewer.ShowName }}'s Blog",           // 你的站点名
  })
</script>
  {{ template "footerTemplate" .Viewer }}
</body>

</html> 