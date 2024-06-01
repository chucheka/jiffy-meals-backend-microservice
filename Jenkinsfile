pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code"
                git branch: 'develop', url: 'https://github.com/chucheka/jiffy-meals-backend-microservice.git'
                script {
                    echo "Current working directory: ${pwd()}"
                }
            }
        }
        stage('Load and Execute Subfolder Jenkinsfiles') {
            steps {
                script {
                    def subfolders = [
                        'payment-service',
                        'order-service',
                        'resturant-service',
                        'identity-service',
                        'config-server',
                        'eureka-server',
                        'gateway-server'
                    ]
                    for (subfolder in subfolders) {
                        def jenkinsfilePath = "${subfolder}/Jenkinsfile"
                        if (fileExists(jenkinsfilePath)) {
                            echo "Executing Jenkinsfile in ${subfolder}"
                            dir(subfolder) {
                                load 'Jenkinsfile'
                            }
                        } else {
                            echo "Jenkinsfile not found in ${subfolder}"
                        }
                    }
                }
            }
        }
    }
}
