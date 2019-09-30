# bucket-jitpack
```Bucket``` buckets all the [GitBucket](https://github.com/gitbucket/gitbucket) plug-ins in one *bucket* under ```/plugins```.

This *"tool"* is using Gradle to download all the existing/required/configured [GitBucket](https://github.com/gitbucket/gitbucket) plug-ins into a single ```/plugins```
directory suitable for installation/update.

### Usage
Prerequisites is Gradle >= 3.5 *(e.g. by installing using [SDKMAN](http://sdkman.io/))*.

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
