pipeline {
  agent {
    docker {
      image '3.5.3-jdk-8-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('') {
      steps {
        sh 'mvn jetty:run'
      }
    }
  }
}