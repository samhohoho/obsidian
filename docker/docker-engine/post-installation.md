https://docs.docker.com/engine/install/linux-postinstall/

Manage Docker as a non-root user
1. create docker group
2. add user to docker group
3. reboot or activate the changes to groups
	1. `newgrp docker`
```
sudo groupadd docker
sudo usermod -aG docker $USER
reboot
```