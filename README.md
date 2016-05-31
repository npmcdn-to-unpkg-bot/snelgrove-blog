# Snelgrove Blog
Simple blog built using [Perun](https://github.com/hashobject/perun) 
a super simple static site generator that takes advantage of the immutable file
system concept in the very cool Clojure build tool [Boot](http://boot-clj.com/). 

## Setup
```
brew install boot-clj

https://github.com/kingoftheknoll/snelgrove-blog.git
```
## Development

To work locally, compile markdown and serve on [localhost:3000](localhost:3000)
First time it runs you'll see Boot fetch all the dependencies from Clojars
and install them in your local Maven repository. 

```
boot dev
```

## Deployment

Using boot task that syncs dirs to s3, we just compose that task onto our normal build
and we're off to the races. Only thing that's needed is AWS keys as environment vars named:

```
SNELGROVE_AWS_ACCESS_KEY

SNELGROVE_AWS_SECRET_KEY
```
