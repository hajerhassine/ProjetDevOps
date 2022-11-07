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
            sh "docker build -t dockerraniamilouchi/imagedevops ."
       		}
       		}
    		
 	    stage('Push image') {
 		  steps {
 	          withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	   sh "docker push dockerraniamilouchi/imagedevops"
        	}
        	}
        	}
        stage('Cleaning up') {
 		  steps {
 	         withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker rmi -f dockerraniamilouchi/imagedevops"
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
      

       
        stage("Email"){
            steps{
               emailext attachLog: true, body: "the result is :  ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'rania.milouchi@esprit.tn'
           }
        } 
      


     

 


      


    

     
    
    }
}