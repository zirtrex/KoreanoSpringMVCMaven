node{
	stage('SCM Checkout'){
		git 'https://github.com/zirtrex/KoreanoSpringMVCMaven'
	}
	stage('Compile-Package'){
		bat 'mvn package'
	}
}