pipeline {


    agent any
    stages{
        stage('Checkout GIT'){
         steps {
              echo 'Pulling ...';
              git branch: 'hajer',
              url : 'https://github.com/hajerhassine/ProjetDevOps.git'
         } 

        }
        stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
          }
        }



        stage('Build image') {
          steps {
            sh "docker build -t hajerdockerhajer/imagedevops ."
       		}
       		}
    		
 	    stage('Push image') {
 		steps {
 	       withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker push hajerdockerhajer/imagedevops"
        	}
        	}
        	}
          stage('Testing maven'){
            steps {
                sh """mvn -version """
            }

        }
           stage('MVN CLEAN'){
            steps {
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE'){
            steps {
                sh 'mvn compile'
            }
        }
        stage ('Junit and Mockito Test'){
            steps {
                echo 'Testing ...';
                sh 'mvn test -Dtest="FournisseurServiceImplMock"'
            }
        }
        
        stage('Cleaning up') {
 		steps {
 	       withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker rmi -f hajerdockerhajer/imagedevops"
        	}
        	}
        	}
     
        

        stage('MVN Nexus'){
            steps {
                sh 'mvn deploy'
            } 
            } 
	stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=test'
            }
        }


    }
}
