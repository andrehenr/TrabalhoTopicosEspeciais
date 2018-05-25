pipeline {
  agent {
    docker {
      args '-v /root/.m2:/root/.m2'
      image 'maven:3.3-jdk-8'
    }

  }
  stages {
    stage('error') {
      steps {
        sh 'mvn jetty:run'
      }
    }
  }
}