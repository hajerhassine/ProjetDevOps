pipeline {

agent any
tools{
nodejs '14.17.6'
}
stages {
stage("Build") {
steps {
sh " mvn -f  /var/lib/jenkins/workspace/DevOpsProject/pom.xml compile"
}
}
stage("Unit tests") {
steps {
sh " mvn -f  /var/lib/jenkins/workspace/DevOpsProject/pom.xml test"

}}
stage("Nexus") {
steps {
sh " mvn deploy"

}}
stage("Sonar") {
steps {
sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=lassoued"


}}
stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
          }
      }
stage('Deploy our image') {
         steps {
              withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
              sh "docker tag uu_app lassoued404/uu_app:uu_app"
              sh "docker push lassoued404/uu_app:uu_app"

         }}
     }
stage('Cleaning up') {
         steps {
            sh "docker rmi -f uu_app" 
           
         }
     }

}
}