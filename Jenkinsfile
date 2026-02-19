pipeline {
    agent any

    stages {
        stage('Detect Changes') {
            steps {
                script {
                    
                    // It checks which files changed in the last commit
                    def changedFiles = sh(script: "git diff --name-only HEAD~1", returnStdout: true).trim()
                    
                    env.BUILD_FDM = changedFiles.contains('FDM/')
                    env.BUILD_MDM = changedFiles.contains('MDM/')
                    
                    echo "Changes detected in FDM: ${env.BUILD_FDM}"
                    echo "Changes detected in MDM: ${env.BUILD_MDM}"
                }
            }
        }

        stage('Build Modules') {
            parallel {
                stage('Build FDM') {
                    when { expression { env.BUILD_FDM == 'true' } }
                        steps 
                            {
                                echo "Building FDM Docker Image..."
                                // This builds the image locally on your laptop
                                sh "docker build -t fdm-local:latest ./FDM"
                            }
                }
                stage('Build MDM') {
                    when { expression { env.BUILD_MDM == 'true' } }
                    steps {
                        echo "Building the MDM module..."
                    }
                }
            }
        }
    }
}