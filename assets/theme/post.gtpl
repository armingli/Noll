<!DOCTYPE html>
<html lang="zh-CN">

{{ $githubURL := .Data.GitHubURL }}

<head>
  {{ template "HeadTemplate" .Viewer }}
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" />
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
      border: dashed 0.5px #667c87;
      border-radius: 20px;
      margin: 20px auto;
    }

    .comment-input {
      text-align: center;
      border: 1px solid #ddd;
      background-color: #f9f9f9;
      min-width: 100%;
      padding: 30px 0;
    }
  </style>
 <link id="giscus-css" rel="stylesheet" href="https://giscus.app/default.css">
</head>

<body>
  {{ template "HeaderTemplate" . }}
  <div class="clearfix">
    <h1 style="margin-bottom: 0.5rem;"> {{ .Data.Title }} </h1>
    <div style="font-size: 1rem; align-items: center;" class="column">
      <img src="{{ .Viewer.AvatarURL }}" style="width: 1.4rem; height: 1.4rem;" />
      <a href='{{ url "/" }}'>{{ .Viewer.ShowName }}</a>
      于<time title="{{ .Data.CreatedAt }}">
        {{ .Data.CreatedAt.Format "2006-01-02" }}</time>
      发布在<a style="margin-left: 5px;" class="flex-fill" href="{{ url .Data.Category}}">{{ .Data.Category.Name }}</a>
      
    </div>
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
  {{ if .Data.Comments }}
  <ul class="ul" style="margin: 30px auto; font-size: 1rem;">
    {{ range $comment := .Data.Comments.Nodes }}
    <li class="li comment">
      {{ template "CommentItemTemplate" $comment }}
    </li>
    {{ end }}
  </ul>
  {{ end }}

<div style="display: flex; align-items: center; margin: 30px auto;">
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
    <span class="COMMENT" style="margin: 0 12px"></span>
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
</div>

<div class="comments giscus-container">
<script src="https://giscus.app/client.js"
        data-repo="armingli/blog-comment"
        data-repo-id="R_kgDOJXgsWQ"
        data-category="Comments"
        data-category-id="DIC_kwDOJXgsWc4CV0WY"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="top"
        data-theme="light"
        data-lang="zh-CN"
        data-loading="lazy"
        crossorigin="anonymous"
        async>
</script><div class="giscus"><iframe class="giscus-frame"></iframe></div></div>

  {{ template "footerTemplate" .Viewer }}
</body>

</html> 