package main

import (
	"time"
)

// Body is Github GraphQL api response body
type Body struct {
	Data *GithubData `json:"data"`
}

// GithubData is Github GraphQL api data
type GithubData struct {
	Repository *Repository `json:"repository"`
	Viewer     *User       `json:"viewer"`
}

// PageInfo is Github GraphQL api page data info
type PageInfo struct {
	HasNextPage bool   `json:"hasNextPage"`
	EndCursor   string `json:"endCursor"`
	HasPrevPage bool   `json:"-"`
	StartCursor string `json:"-"`
}

// Repository is Github repository scheme
type Repository struct {
	Labels      *LabelPage      `json:"labels"`
	Categories  *CategoryPage   `json:"discussionCategories"`
	Discussions *DiscussionPage `json:"discussions"`
	Discussion  *Discussion     `json:"discussion"`
}

// CategoryPage is Github discussion category page scheme
type CategoryPage struct {
	TotalCount int         `json:"totalCount"`
	Nodes      []*Category `json:"nodes"`
}

// Category is Github discussion category scheme
type Category struct {
	Emoji       string          `json:"emoji"`
	EmojiHTML   string          `json:"emojiHTML"`
	Name        string          `json:"name"`
	Description string          `json:"description"`
	CreatedAt   time.Time       `json:"createdAt"`
	UpdatedAt   time.Time       `json:"updatedAt"`
	Discussions *DiscussionPage `json:"-"`
}

// LabelPage is Github discussion label page scheme
type LabelPage struct {
	TotalCount int      `json:"totalCount"`
	Nodes      []*Label `json:"nodes"`
}

// Label is Github label(discussion and issue) scheme
type Label struct {
	Color       string          `json:"color"`
	Name        string          `json:"name"`
	Description string          `json:"description"`
	CreatedAt   time.Time       `json:"createdAt"`
	UpdatedAt   time.Time       `json:"updatedAt"`
	Discussions *DiscussionPage `json:"-"`
}

// DiscussionPage is Github Discussion page scheme
type DiscussionPage struct {
	TotalCount int           `json:"totalCount"`
	Nodes      []*Discussion `json:"nodes"`
	PageInfo   *PageInfo     `json:"pageInfo"`
}

// Discussion is Github Discussion scheme
type Discussion struct {
	Number         int              `json:"number"`
	Title          string           `json:"title"`
	Body           string           `json:"body"`
	BodyHTML       string           `json:"bodyHTML"`
	Locked         bool             `json:"locked"`
	UpvoteCount    int              `json:"upvoteCount"`
	GitHubURL      string           `json:"url"`
	CreatedAt      time.Time        `json:"createdAt"`
	UpdatedAt      time.Time        `json:"updatedAt"`
	Author         *User            `json:"author"`
	Category       *Category        `json:"category"`
	Labels         *LabelPage       `json:"labels"`
	Comments       *CommentPage     `json:"comments"`
	ReactionGroups []*ReactionGroup `json:"reactionGroups"`
}

// CommentPage is Github Discussion Comment page scheme
type CommentPage struct {
	TotalCount int        `json:"totalCount"`
	Nodes      []*Comment `json:"nodes"`
	PageInfo   *PageInfo  `json:"pageInfo"`
}

// Comment is Github Discussion comment scheme
type Comment struct {
	Body              string           `json:"body"`
	BodyHTML          string           `json:"bodyHTML"`
	UpvoteCount       int              `json:"upvoteCount"`
	GitHubURL         string           `json:"url"`
	AuthorAssociation string           `json:"authorAssociation"`
	CreatedAt         time.Time        `json:"createdAt"`
	UpdatedAt         time.Time        `json:"updatedAt"`
	Author            *User            `json:"author"`
	ReactionGroups    []*ReactionGroup `json:"reactionGroups"`
}

// ReactionGroup is Github Discussion Reaction group scheme
type ReactionGroup struct {
	Content  string        `json:"content"`
	Reactors *ReactionPage `json:"reactors"`
}

// ReactionPage is Github Discussion Reaction page scheme
type ReactionPage struct {
	TotalCount int `json:"totalCount"`
}

// User is Github user scheme
type User struct {
	Login     string `json:"login"`
	AvatarURL string `json:"avatarUrl"`
	GitHubURL string `json:"url"`
	Bio       string `json:"bio"`
	Email     string `json:"email"`
	Company   string `json:"company"`
	Location  string `json:"location"`
	Name      string `json:"name"`
	Twitter   string `json:"twitterUsername"`
}

// ShowName 返回该用户的对外显示的名字
func (u *User) ShowName() string {
	if u.Name != "" {
		return u.Name
	}
	return u.Login
}
