pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('Checkout') {
            steps {
                snDevOpsStep 'ff0559dd53673300b231ddeeff7b12a4'
                checkout scm
            }
        }

        stage('Build') {
            //snDevOpsStep '8cdb27bb53d33300b231ddeeff7b12f7'
            stages {
                stage("Build-Compile") {
                    steps {
                        snDevOpsStep '7f0559dd53673300b231ddeeff7b12a4'
                        sh "mvn clean install -DskipTests=true"
                    }
                }
                stage("Build-Generate-JavaDoc") {
                    stages {
                        stage("Build-Generate-JavaDoc-HTML") {
                            steps {
                                //snDevOpsStep '730559dd53673300b231ddeeff7b12a5' //deploy stage sys-id
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
                        snDevOpsStep 'b70559dd53673300b231ddeeff7b12a4'
                        //snDevOpsChange()
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
                        snDevOpsStep 'b70559dd53673300b231ddeeff7b12a4'
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
                snDevOpsStep '730559dd53673300b231ddeeff7b12a5'
                snDevOpsChange()
                // sh "mvn -B deploy"
                // sh "mvn -B release:prepare"
                // sh "mvn -B release:perform"
                echo "Deploy"
            }
        }
    }
}
