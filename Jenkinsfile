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
        stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
          }
        }
	  stage('Deploy our image') {
         steps {
              withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
              sh "docker tag image lassoued404/image:latest"
              sh "docker push lassoued404/image:$BUILD_NUMBER"

         }}
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
                sh 'mvn deploy'
                  
            }
        }

    }
}