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
            environment {
                DOCKER_HUB  = credentials('dockerhub-creds')
            }
            steps {
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat 'docker push jhuynh14/selenium:latest'
                bat "docker tag jhuynh14/selenium:latest jhuynh14/selenium:%env.BUILD_NUMBER%"
                bat "docker push jhuynh14/selenium:%env.BUILD_NUMBER%"
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
            echo "Logging out"
            bat "docker logout"
        }
    }
}