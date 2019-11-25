node{
	stage('Verificar SCM'){
		git 'https://github.com/zirtrex/KoreanoSpringMVCMaven'
	}
	stage('Compilar Paquete'){
		bat 'mvn package'
	}
	stage('Contruir Imagen Docker'){
		bat 'docker build -f Dockerfile -t zirtrex/koreanoapp .'
	}
	stage('Eliminar contenedor docker'){
		
	}
	stage('Ejecutar docker'){
		bat 'docker run --name jwebserver2 -d -t -p 8282:8080 zirtrex/koreanoapp'
	}
	stage('Ejecutar Tomcat'){
		bat 'docker exec -d zirtrex/koreanoapp ./bin/startup.sh'
	}
	stage('Ejecutar Mysql'){
		
	}
}