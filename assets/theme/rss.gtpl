<?xml version="1.0" encoding="UTF-8" ?>
<rss version="2.0">
  <channel>
    <description>feedId:69672878966108160+userId:68458142099595264</description>
    {{ range $descussoin := .Data.Nodes }}
    <item>
      <title>
        <![CDATA[{{ $descussoin.Title }}]]>
      </title>
      <pubDate>{{ $descussoin.CreatedAt }}</pubDate>
      <updated>{{ $descussoin.UpdatedAt }}</updated>
      <link>https://blog.metaprogramming.space{{ url $descussoin }}</link>
      <description>
        <![CDATA[{{ $descussoin.Body }}]]>
      </description>
    </item>
    {{ end }}
  </channel>

</rss>
