https://wiki.archlinux.org/title/PostgreSQL#

## [Initial configuration](https://wiki.archlinux.org/title/PostgreSQL#Initial_configuration)
Switch to postgres user using a [privilege elevation program](https://wiki.archlinux.org/title/List_of_applications/Security#Privilege_elevation) (using [[sudo#[Login shell](https //wiki.archlinux.org/title/Sudo Login_shell)|sudo]]).
Initialize db cluster.
Return to regular user.
Start and enable `postgres.service`.
## [Create your first database/user](https://wiki.archlinux.org/title/PostgreSQL#Create_your_first_database/user)
```
[postgres]$ createuser --interactive
```
```
$ createdb myDatabaseName
```
## [Familiarize with PostgreSQL](https://wiki.archlinux.org/title/PostgreSQL#Familiarize_with_PostgreSQL)
```
psql -d mydb
```
`\l` - list all databases.
`\du` - list all users and permission levels.
`\dt` - summary information about all tables.