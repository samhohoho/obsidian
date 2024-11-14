---
id: docker
aliases: []
tags: []
---

https://hub.docker.com/_/eclipse-temurin
https://github.com/docker-library/docs/blob/master/eclipse-temurin/README.md#supported-tags-and-respective-dockerfile-links

```
db   | The files belonging to this database system will be owned by user "postgres".
db   | This user must also own the server process.
db   | 
db   | The database cluster will be initialized with locale "en_US.utf8".
db   | The default database encoding has accordingly been set to "UTF8".
db   | The default text search configuration will be set to "english".
db   | 
db   | Data page checksums are disabled.
db   | 
db   | fixing permissions on existing directory /var/lib/postgresql/data ... ok
db   | creating subdirectories ... ok
db   | selecting dynamic shared memory implementation ... posix
db   | selecting default "max_connections" ... 100
db   | selecting default "shared_buffers" ... 128MB
db   | selecting default time zone ... Etc/UTC
db   | creating configuration files ... ok
db   | running bootstrap script ... ok
db   | performing post-bootstrap initialization ... ok
db   | syncing data to disk ... ok
db   | 
db   | 
db   | Success. You can now start the database server using:
db   | 
db   |     pg_ctl -D /var/lib/postgresql/data -l logfile start
db   | 
db   | initdb: warning: enabling "trust" authentication for local connections
db   | initdb: hint: You can change this by editing pg_hba.conf or using the option -A, or --auth-local and --auth-host, the next time you run initdb.
db   | waiting for server to start....2024-11-13 07:56:34.867 UTC [48] LOG:  starting PostgreSQL 17.0 (Debian 17.0-1.pgdg120+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 12.2.0-14) 12.2.0, 64-bit
db   | 2024-11-13 07:56:34.868 UTC [48] LOG:  listening on Unix socket "/var/run/postgresql/.s.PGSQL.5432"
db   | 2024-11-13 07:56:34.873 UTC [51] LOG:  database system was shut down at 2024-11-13 07:56:34 UTC
db   | 2024-11-13 07:56:34.882 UTC [48] LOG:  database system is ready to accept connections
db   |  done
db   | server started
db   | 
db   | /usr/local/bin/docker-entrypoint.sh: ignoring /docker-entrypoint-initdb.d/*
db   | 
db   | 2024-11-13 07:56:34.997 UTC [48] LOG:  received fast shutdown request
db   | waiting for server to shut down....2024-11-13 07:56:35.005 UTC [48] LOG:  aborting any active transactions
db   | 2024-11-13 07:56:35.008 UTC [48] LOG:  background worker "logical replication launcher" (PID 54) exited with exit code 1
db   | 2024-11-13 07:56:35.009 UTC [49] LOG:  shutting down
db   | 2024-11-13 07:56:35.010 UTC [49] LOG:  checkpoint starting: shutdown immediate
db   | 2024-11-13 07:56:35.015 UTC [49] LOG:  checkpoint complete: wrote 3 buffers (0.0%); 0 WAL file(s) added, 0 removed, 0 recycled; write=0.002 s, sync=0.001 s, total=0.007 s; sync files=2, longest=0.001 s, average=0.001 s; distance=0 kB, estimate=0 kB; lsn=0/14E4FA0, redo lsn=0/14E4FA0
db   | 2024-11-13 07:56:35.024 UTC [48] LOG:  database system is shut down
db   |  done
db   | server stopped
db   | 
db   | PostgreSQL init process complete; ready for start up.
db   | 
db   | 2024-11-13 07:56:35.128 UTC [1] LOG:  starting PostgreSQL 17.0 (Debian 17.0-1.pgdg120+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 12.2.0-14) 12.2.0, 64-bit
db   | 2024-11-13 07:56:35.128 UTC [1] LOG:  listening on IPv4 address "0.0.0.0", port 5432
db   | 2024-11-13 07:56:35.128 UTC [1] LOG:  listening on IPv6 address "::", port 5432
db   | 2024-11-13 07:56:35.129 UTC [1] LOG:  listening on Unix socket "/var/run/postgresql/.s.PGSQL.5432"
db   | 2024-11-13 07:56:35.133 UTC [62] LOG:  database system was shut down at 2024-11-13 07:56:35 UTC
db   | 2024-11-13 07:56:35.140 UTC [1] LOG:  database system is ready to accept connections
```
