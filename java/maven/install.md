source: https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu#installing-maven-on-linux-ubuntu

1. [Download](https://maven.apache.org/download.cgi) binaries, apache-maven-3.9.9-bin.tar.gz.
   Or wget.
   `wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz` 
2. Untar.
	1. `tar -xvf apache-maven-3.6.3-bin.tar.gz`
3. Move to /opt/.
	1. `mv apache-maven-3.6.3 /opt/`
4. Set M2_HOME and Path Variables in ~/.profile file.
   `M2_HOME='/opt/apache-maven-3.6.3'`
   `PATH="$M2_HOME/bin:$PATH"`
   `export PATH`
   
1. Verify.
	1. `mvn -version`
   