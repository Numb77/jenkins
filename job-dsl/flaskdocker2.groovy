job('Flask Docker Build and Push nginx') {
    scm {
        git('https://github.com/Numb77/elbit-test2') {  node ->
            node / gitConfigName('Numb77')
            node / gitConfigEmail('amitmiron77@gmail.com')
        }
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('numb77/job_2')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('Dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
