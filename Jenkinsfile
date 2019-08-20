pipeline {
    agent any
    tools { 
        maven 'Maven 3.6.1' 
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean install -DskipTests=true"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('Deploy') {
            steps {
                // sh "mvn -B deploy"
                // sh "mvn -B release:prepare"
                // sh "mvn -B release:perform"
                echo "Deploy"
            }
        }
    }
}
