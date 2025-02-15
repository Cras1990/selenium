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
      steps{
        echo "docker push cras1990/selenium"

      }      

    }

  }

}
