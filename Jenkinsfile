pipeline {

  agent any
  stages {

    stage ('Build jar'){
      steps{
        bat "mvn clean package -DskipTests"
      }
    }

    stage ('Build image'){
      steps{
        bat "docker build -t cras1990/selenium ."

      }      

    }


    stage ('Push Image'){
      environment{
        DOCKER_HUB = credentials{"dockerhub-credentials"}
      }
      steps{
        bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
        bat "docker push cras1990/selenium"

      }      

    }

  }

  post{
      always{
          bat "docker logout"
      }
  }

}
