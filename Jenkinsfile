pipeline {
    environment {
     registry = "lassoued404/image"
     registryCredential = "dockerHub"
     dockerImage = ''
  }

    agent any
    stages{
        stage('Checkout GIT'){
         steps {
             echo 'Pulling ...';
              git branch: 'hamza',
              url : 'https://github.com/hajerhassine/ProjetDevOps.git'
         } 

        }
        stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
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
		stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=lassoued'
            }
        }
        
        stage('Nexus Repository Manager') {
            steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'com.esprit.examen', nexusUrl: '192.168.1.139:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0.0-SNAPSHOT'
				}
            }}

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



    }
}