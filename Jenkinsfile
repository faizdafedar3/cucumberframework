pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/faizdafedar3/cucumberframework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
