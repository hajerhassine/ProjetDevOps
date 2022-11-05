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
        //stage('MVN SONARQUBE analysis 1'){
          //  steps {
           //     sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=test'
           // }
       // }
            stage ('Test'){
            steps {
                echo 'Testing ...';
                sh 'mvn test -Dtest="FournisseurServiceImplMock"'
            }
        }
       
    }
}