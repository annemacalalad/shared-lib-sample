def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-anne"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "*.yml",
            bucket: stageParams.s3Bucket
        )
    }
}
