# lab-redis
Estudos sobre REDIS

# REDIS docker

## Server and Tools
* [install RDM Redis Desktop Manager on ubuntu](https://snapcraft.io/install/redis-desktop-manager/ubuntu)
* [docker Redis](https://hub.docker.com/_/redis)


## Commands

```
docker run --name teste-redis -d -p 6379:6379 -i -t redis
```

#start a redis instance
```
docker run --name teste-redis -p 6379:6379 -d redis
```

#start with persistent storage
```
docker run --name teste-redis -p 6379:6379 -d redis redis-server --appendonly yes
```
```
docker run -v ~/dev/database/redis/conf:/usr/local/etc/redis --name teste-redis redis redis-server /usr/local/etc/redis/redis.conf
```

#Where ~/dev/database/redis/conf is a local directory containing your redis.conf file. Using this method means that there is no need for you to have a Dockerfile for your redis container.