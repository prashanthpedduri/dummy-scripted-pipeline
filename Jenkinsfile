// CRM Portal - CI --> 00db27bb53d33300b231ddeeff7b12f8
// CRM Portal - UAT --> 8cdb27bb53d33300b231ddeeff7b12f7
// CRM Portal - Stage --> c0db27bb53d33300b231ddeeff7b12f7
// CRM Portal - Prod --> 0cdb27bb53d33300b231ddeeff7b12f7
pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('Checkout') {
            steps {
                snDevOpsStep '00db27bb53d33300b231ddeeff7b12f8'
                checkout scm
            }
        }

        stage('Build') {
            stages {
                stage("Build-Compile") {
                    steps {
                        snDevOpsStep '8cdb27bb53d33300b231ddeeff7b12f7'
                        sh "mvn clean install -DskipTests=true"
                    }
                }
                stage("Build-Generate-JavaDoc") {
                    stages {
                        stage("Build-Generate-JavaDoc-HTML") {
                            steps {
                                snDevOpsStep 'c0db27bb53d33300b231ddeeff7b12f7'
                                sh "mvn javadoc:javadoc"
                            }
                        }
                        stage("Build-Generate-JavaDoc-JAR") {
                            steps {
                                //snDevOpsStep '0cdb27bb53d33300b231ddeeff7b12f7'
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
                        snDevOpsStep '0cdb27bb53d33300b231ddeeff7b12f7'
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
                // snDevOpsStep '0cdb27bb53d33300b231ddeeff7b12f7'
                // sh "mvn -B deploy"
                // sh "mvn -B release:prepare"
                // sh "mvn -B release:perform"
                echo "Deploy"
            }
        }
    }
}
