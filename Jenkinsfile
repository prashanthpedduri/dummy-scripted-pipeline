pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            stages {
                stage("Build-Compile") {
                    snDevOpsStep '193c590bdbbee300f16092dadb9619e7'
                    steps {
                        sh "mvn clean install -DskipTests=true"
                    }
                }
                stage("Build-Generate-JavaDoc") {
                    stages {
                        stage("Build-Generate-JavaDoc-HTML") {
                            snDevOpsStep '193c590bdbbee300f16092dadb9619e7'
                            steps {
                                sh "mvn javadoc:javadoc"
                            }
                        }
                        stage("Build-Generate-JavaDoc-JAR") {
                            steps {
                                sh "mvn javadoc:jar"
                            }
                        }
                    }
                }
            }
        }

        stage('Test') {
            parallel {
                stage("Test-Test") {
                    steps {
                        sh "mvn test"
                    }
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
                }
                stage("Test-Generate-JavaDoc") {
                    steps {
                        sh "mvn javadoc:test-jar"
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                // sh "mvn -B deploy"
                // sh "mvn -B release:prepare"
                // sh "mvn -B release:perform"
                echo "Deploy"
            }
        }
    }
}
