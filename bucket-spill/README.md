# bucket-spill
`bucket-spill` checks out all the [GitBucket](https://github.com/gitbucket/gitbucket) Git repos a user has, and **spill** them into a nice subdirectory structure.

It also has a few various actions to be able to get more information out of the GitBucket system.

### Usage
Prerequisites is Gradle >= 6.x *(e.g. by installing using [SDKMAN](http://sdkman.io/))*.

### Development

- Start a Docker image with:
```
docker run -d --name gitbucket -p 8080:8080 -v `pwd`/gitbucket:/gitbucket gitbucket/gitbucket
```

- Create at least 2 groups and and 2 repos for each

- generate an API key to be used in `conf.yml`
