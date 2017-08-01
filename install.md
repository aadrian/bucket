Install
=======

Unpack the GitBucket Zip distribution to `/opt` .

Running as a Service
--------------------

Followings will be assumed:
 - Java 8 is running correctly with `/usr/bin/java`
 - Install directory is `/opt/gitbucket`
 - The GitBucket (java) process will run as user `gitbucket` and group `gitbucket`, with UID and GID 555
 - A non-root user account that can use `sudo` to execute commands as `root` will be the example 
 
1. Add the user and the group:
```bash
sudo groupadd -g 555 gitbucket

sudo useradd \
  -g gitbucket --no-user-group \
  --home-dir /opt/gitbucket --no-create-home \
  --shell /usr/sbin/nologin \
  --system --uid 555 gitbucket

```

2. Make the owner of the GitBucket to be the `gitbucket:gitbucket` user:
```bash
sudo chown -R gitbucket:gitbucket /opt/gitbucket
```

3. Change `gitbucket.service` to suit your needs. Especially line 18. Consult https://github.com/gitbucket/gitbucket/wiki 
for further details.

4. Install the `systemd` service unit configuration file, reload the `systemd` daemon, and start GitBucket:
```bash
sudo cp gitbucket.service /etc/systemd/system/
sudo chown root:root /etc/systemd/system/gitbucket.service
sudo chmod 644 /etc/systemd/system/gitbucket.service
sudo systemctl daemon-reload
sudo systemctl start gitbucket.service
```

5. Start GitBucket automatically when booting:
```bash
sudo systemctl enable gitbucket.service
```

6. If GitBucket is not starting properly, view the logs:
```bash
journalctl --boot -u gitbucket.service
```
or just follow the logs with:
```bash
journalctl -f -u gitbucket.service
```