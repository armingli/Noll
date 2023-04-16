<!DOCTYPE html>
<html lang="zh-CN">

<head>
  {{ template "HeadTemplate" .Viewer }}
  <title>Aoubt —— {{ .Viewer.ShowName }}'s Blog </title>
  <link id="giscus-css" rel="stylesheet" href="https://giscus.app/default.css">
</head>

<body>
  {{ template "HeaderTemplate" . }}
  <div class="clearfix"></div>
  <h1>About {{ .Viewer.ShowName }}</h1>
  {{ if .Viewer.Bio }}
  <p>{{ .Viewer.Bio }}</p>
  {{ end }}
  {{ if .Viewer.Company }}
  <p>🏢 {{ .Viewer.Company }}</p>
  {{ end }}
  {{ if .Viewer.Location }}
  <p>🌍 {{ .Viewer.Location }}</p>
  {{ end }}
  {{ if .Viewer.Email }}
  <p>📧 {{ .Viewer.Email }}</p>
  {{ end }}
  <p>😺 <a style="padding: 0px;" href="{{ .Viewer.GitHubURL }}">{{ .Viewer.GitHubURL }}</a></p>
  {{ if .Viewer.Twitter }}
  <p>🕊️ <a style="padding: 0px;" href="https://twitter.com/{{ .Viewer.Twitter }}">
      https://twitter.com/{{ .Viewer.Twitter }}</a></p>
  {{ end }}
    
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