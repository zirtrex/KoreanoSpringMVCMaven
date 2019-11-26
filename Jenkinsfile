def imagename = "zirtrex/koreanoapp"
def container = "apache2"

node (master){	
	
	stage('Verificar SCM'){
		git 'https://github.com/zirtrex/KoreanoSpringMVCMaven'
	}
	stage('Compilar Paquete'){
		bat 'mvn package'
	}
	stage('Contruir Imagen Docker'){
		dockerCmd  'build -f Dockerfile -t ${imagename} .'
	}
	/*stage('Ejecutar docker'){
		dockerCmd 'run --name ${container} -d -t -p 8282:8080 --mount src=mysql-db-data,dst=/var/lib/mysql ${imagename}'
	}
	stage('Ejecutar Tomcat'){
		dockerCmd 'exec -d ${container} ./bin/startup.sh'
	}
	stage('Ejecutar Mysql p1'){
		dockerCmd 'exec -d ${container} find /var/lib/mysql -type f -exec touch {} +'
	}
	stage('Ejecutar Mysql p2'){
		dockerCmd 'exec -d ${container} service mysql start'
	}*/
	
}

def dockerCmd(args) {
    powershell "docker ${args}"
}