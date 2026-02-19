
pipelineJob('Personal-Monorepo-CI') {
    description('Main pipeline for FDM and MDM modules')
    
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/kolangiraja123/myrepo.git')
                        credentials('github-pat')
                    }
                    branches('*/main')
                }
            }
            scriptPath('Jenkinsfile') // Point to your Jenkinsfile in the repo
        }
    }
}