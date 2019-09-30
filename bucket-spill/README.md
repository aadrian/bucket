# bucket-spill
`bucket-spill` checks out all the [GitBucket](https://github.com/gitbucket/gitbucket) Repos a user has, and **spill** them into a nice subdirectory structure.


### Usage
Prerequisites is Gradle >= 5.6 *(e.g. by installing using [SDKMAN](http://sdkman.io/))*.

Run ```%> gradle getAll``` to download all configured GitBucket plug-ins.

**Available Tasks:**
```
clean   - Cleans all the previously downloaded GitBucket plug-ins!
getAll  - Downloads all the configured GitBucket plug-ins!
makeZip - Creates a ZIP of all the configured GitBucket plug-ins!
listAll - Lists all the configured GitBucket plug-ins!
```

If you don't need all the plug-ins, or what different versions, see in [build.gradle](build.gradle) the ```dependencies``` section for changes.

### Why
 - there are already quite a few nice plug-ins for GitBucket, but no easy way to get them.
 - there's no automatic GitBucket plug-in update/download functionality yet (that can work behind proxies too).
 - it can fetch unpublished or unreleased plug-in versions too, thanks to [JitPack](https://jitpack.io) so it's
 good and quick solution to trying new plug-in features.

### How
[JitPack](https://jitpack.io) really does all the magic:
 - allows any GitHub branch, tag or commit to be accessible as a Maven package, as if it were released.
 - this ```build.gradle``` only references those Maven coordinates.

**Note:** GitHub PRs can also be used, but only the last one and one needs as coordinates the branch or the author that submitted the PR.
