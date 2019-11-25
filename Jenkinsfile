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
	stage('Ejecutar docker'){
		bat 'docker run --name jwebserver -t -i -p 8282:8080 zirtrex/koreanoapp'
	}
}