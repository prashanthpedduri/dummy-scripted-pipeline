pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('Checkout') {
            steps {
                snDevOpsStep '10946fb253c00010b231ddeeff7b12b7'
                checkout scm
            }
        }

        stage('Build') {
            //steps{
            //    snDevOpsStep '14946fb253c00010b231ddeeff7b12b7'
            //}
            stages {
                stage("Build-Compile") {
                    steps {
                        snDevOpsStep '14946fb253c00010b231ddeeff7b12b7'
                        sh "mvn clean install -DskipTests=true"
                    }
                }
                stage("Build-Generate-JavaDoc") {
                    stages {
                        stage("Build-Generate-JavaDoc-HTML") {
                            steps {
                                //snDevOpsStep '14946fb253c00010b231ddeeff7b12b7' //deploy stage sys-id
                                sh "mvn javadoc:javadoc"
                            }
                        }
                        stage("Build-Generate-JavaDoc-JAR") {
                            steps {
                                //snDevOpsStep '14946fb253c00010b231ddeeff7b12b7'
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
                        snDevOpsStep '9c946fb253c00010b231ddeeff7b12b6'
                        snDevOpsChange()
                        sh "mvn test"
                        junit "**/TEST-*.xml"
                    }
                    //post {
                    //    always {
                    //        junit "**/TEST-*.xml"
                    //    }
                    //}
                }
                stage("Test-Generate-JavaDoc") {
                    steps {
                        snDevOpsStep '9c946fb253c00010b231ddeeff7b12b6'
                        snDevOpsChange()
                        sh "mvn javadoc:test-jar"
                    }
                }
            }
        }

        stage('Deploy') {
            //when {
            //    branch 'master'
            //}
            steps {
                snDevOpsStep '90946fb253c00010b231ddeeff7b12b7'
                snDevOpsChange()
                // sh "mvn -B deploy"
                // sh "mvn -B release:prepare"
                // sh "mvn -B release:perform"
                echo "Deploy"
            }
        }
    }
}
