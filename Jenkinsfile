pipeline {
    agent any
    tools {
        maven "Maven 3"
        git "Default"
        jdk "jdk8"
    }
    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: "5"))
    }
    stages {
        stage ("Build") {
            steps {
                sh "mvn clean package"
            }
        }

        stage ("Deploy") {
            steps {
                sh "mvn source:jar deploy"
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}
