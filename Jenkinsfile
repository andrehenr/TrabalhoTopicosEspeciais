pipeline {
  agent {
    docker {
      args '-v /root/.m2:/root/.m2'
      image '3.5.3-jdk-10-slim'
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