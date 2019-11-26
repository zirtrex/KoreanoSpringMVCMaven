pipeline {
    agent any
	
	environment {
		imagename = 'zirtrex/koreanoapp'
		container = 'jwebserver2'		
	}
	
    stages {
        stage('Verificar SCM') {
            steps {
                git 'https://github.com/zirtrex/KoreanoSpringMVCMaven'
            }
        }
		stage('Compilar Paquete'){
			steps {
				powershell 'mvn clean package'
			}
		}
		/*stage('Contruir Imagen Docker'){
			steps {
				dockerCmd  "build -f Dockerfile -t ${imagename} ."
			}
		}*/
		stage('Prueba de Integracion con Selenium'){
			steps {
				powershell 'mvn -Dtest=NewSeleneseIT  surefire:test'
			}
		}
    }
	
    /*post {
        always {
            echo 'I will always say Hello again!'
        }
		success {
			mail to: "zirtrex@live.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "Si, se pasaron las pruebas."
		}
		failure {
			mail to: "zirtrex@live.com", subject:"FAILURE: ${currentBuild.fullDisplayName}", body: "Ohhh, no se pasaron las pruebas."
		}
    }*/
}

def dockerCmd(args) {
	powershell "docker ${args}"
}


/*
node ('master'){
	
	stage('Verificar SCM'){
		git 'https://github.com/zirtrex/KoreanoSpringMVCMaven'
	}
	stage('Compilar Paquete'){
		powershell 'mvn package'
	}
	stage('Contruir Imagen Docker'){
		dockerCmd  "build -f Dockerfile -t ${imagename} ."
	}
	stage('Ejecutar docker'){
		dockerCmd "run --name ${container} -d -t -p 8282:8080 --mount src=mysql-db-data,dst=/var/lib/mysql ${imagename}"
	}
	stage('Ejecutar Tomcat'){
		dockerCmd "exec -d ${container} ./bin/startup.sh"
	}
	stage('Ejecutar Mysql p1'){
		dockerCmd "exec -d ${container} find /var/lib/mysql -type f -exec touch {} +"
	}
	stage('Ejecutar Mysql p2'){
		dockerCmd "exec -d ${container} service mysql start"
	}
	
}

def dockerCmd(args) {
    powershell "docker ${args}"
}
*/