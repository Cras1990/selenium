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
        DOCKER_HUB = credentials('dockerhub-credentials')
      }
      steps{
        bat 'echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin'
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
