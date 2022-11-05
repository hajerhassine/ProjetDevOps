pipeline {
    agent any
    stages{
        stage('Checkout GIT'){
         steps {
             echo 'Pulling ...';
              git branch: 'hamza',
              url : 'https://github.com/hajerhassine/ProjetDevOps.git'
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
        stage('MVN SONARQUBE analysis 1'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=lassoued'
            }
        }
    	stage('NEXUS') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.43.249/:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar'
                  
            }
        }
    }
}