pipeline {
    agent any

    stages {
        stage('Build Jar'){
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Build Image'){
            steps {
                bat "docker build -t jhuynh14/selenium ."
            }
        }

        stage('Push Image'){
            steps {
                bat "docker push jhuynh14/selenium ."
            }
        }
    }

    post {
        success{
            echo "I was successful"
        }
        failure{
            echo "I was a failure"
        }
        aborted{
            echo "I was aborted"
        }
        always{
            echo "doing clean up"
        }
    }
}