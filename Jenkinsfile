pipeline {
    agent any

    environment {
        DOCKER_REGISTRY = "hub.docker.com" // Replace with your registry
        DOCKER_IMAGE_NAME = "Async_api_sid"
        APP_NAME = "demo12" // Replace with your application name
        GIT_URL = "https://github.com/jsiddhanth0/AsyncApi_main.git"
        GIT_CREDENTIALS_ID = "jsidgitcred"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: GIT_CREDENTIALS_ID, url: GIT_URL
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build image') {
            steps {
                script {
                    docker.build image: "${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}",
                                context: '.',
                                args: ['--build-arg', "JAR_FILE=target/${APP_NAME}.jar"]
                }
            }
        }

        stage('Push image') {
            steps {
                script {
                    docker.withCredentials([username: 'your_docker_username', password: 'your_docker_password']) {
                        docker.push("${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}")
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Replace with your deployment command or script, considering container orchestration if needed
                    sh "docker run -d -p 8080:8080 ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
                }
            }
        }
    }

    post {
        success {
            cleanWs()
        }
    }
}
