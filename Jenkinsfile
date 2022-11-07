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
       
        stage('Nexus'){
            steps{
                sh 'mvn deploy '
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
         
      

        stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
          }
        }
        stage('Build image') {
          steps {
            sh "docker build -t raniamilouchi/imagedevops ."
       		}
       		}
    		
 	    stage('Push image') {
 		  steps {
 	          withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	   sh "docker push raniamilouchi/imagedevops"
        	}
        	}
        	}
        stage('Cleaning up') {
 		  steps {
 	         withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker rmi -f raniamilouchi/imagedevops"
        	}
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
       

      


     

 


      


    

     
    
    }
}