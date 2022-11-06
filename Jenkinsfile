pipeline {
    agent any
    stages{
        stage('Checkout GIT'){
         steps {
             echo 'Pulling ...';
              git branch: 'rania',
              url : 'https://github.com/hajerhassine/ProjetDevOps.git'
         }    
        }

        stage('Nexus Deploy '){
            steps{
                sh 'mvn deploy -DskipTests'
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

       


        stage('MVN SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rania123'
            }
        }


        stage ('JUnit / Mockito Test'){
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

        stage('Nexus'){
            steps{
                sh 'mvn deploy '
            }
        }


    

     
    
    }
}