job('example-1') {
    steps {
        shell('echo Hello World!')
    }
}

job('example-2') {
    steps {
        shell(readFileFromWorkspace('build.sh'))
    }
}

job('Flask Docker Build and Push') {
    scm {
        git('git://github.com/Numb77/elbit-test.git') {  node ->
            node / gitConfigName('Numb77')
            node / gitConfigEmail('amitmiron77@gmail.com')
        }
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('numb77/job_1')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('Dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}