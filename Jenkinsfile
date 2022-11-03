pipeline {
	agent any 
	stages{
			stage('Checkout Git'){
			steps {
				echo 'Pulling...';
				git branch : 'rania,
				url : 'https://github.com/hajerhassine/ProjetDevOps.git';
				}
			}
			stage('Testing maven'){
				steps {
					sh """mvn --version """
					}
			}		
		}
}		
		
		
				
	