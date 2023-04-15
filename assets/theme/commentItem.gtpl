{{define "CommentItemTemplate"}}
<div>
  <div>
  <div style="margin-left: 10px; flex: 1;">
    <div style="display: flex; align-items: center; margin: 15px auto;">
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
    <time style="margin: 0 10px" title="{{ .UpdatedAt }}">更新于{{ .UpdatedAt.Format "2006-01-02" }} </time>
    <div style="flex: 1; height: 1px; background-color: #ddd;"></div>
    </div>
    <div class="markdown-body" style="margin: 12px 0;">{{ .BodyHTML }}</div>
  </div>
</div>
{{end}}