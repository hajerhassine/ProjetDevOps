pipeline {

        agent any
        stages {
                stage('Checkout Git'){
                   
                steps{
                        echo 'Pulling...';
                        git branch: 'donia',
                        url : 'https://github.com/hajerhassine/ProjetDevOps.git';
                    }
                }
       
        stage('Testing maven') {
            steps {
                sh """mvn -version"""
                 
            }
        }
       
        stage('Mvn Clean') {
            steps {
                sh 'mvn clean'
                 
            }
        }
        stage('Mvn Compile') {
            steps {
                sh 'mvn compile'
                 
            }
        }
        
        stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Admin123456789'
            }
        }
        stage('JUnit and Mockito Test'){
            steps{
                script
                {
                    if (isUnix())
                    {
                        sh 'mvn --batch-mode test'
                    }
                    else
                    {
                        bat 'mvn --batch-mode test'
                    }
                }
            }
        
    }
        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
                  
            }
        }
 	 
    	stage('Build image') {
           	steps {
       		 sh "docker build -t doniakacem/devopsimagedocker ."
       		}
       		}        
        
        
        stage('Push image') {
 			steps {
 			    withDockerRegistry([ credentialsId: "DockerHub", url: "" ]) {
 			
        	  sh "docker push doniakacem/devopsimagedocker"
        	}
        	}
        	}
        
       stage('Run app With DockerCompose') {
              steps {
                  sh "docker-compose -f docker-compose.yml up -d  "
              }
              }
        
    stage('Cleaning up') {
         steps {
			sh "docker rmi -f doniakacem/devopsimagedocker"
         }
     }    
}
}