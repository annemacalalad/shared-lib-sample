def call(Map stageParams = [awsRegion: "us-east-1"]){
  withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:'EC2Jenkins', 
          changeSet:'my-change-set', 
          url:'https://testbucket-anne.s3.amazonaws.com/deployEC2.yml'
        )
        cfnExecuteChangeSet(
          stack:'EC2Jenkins', 
          changeSet:'my-change-set'
        )
  }
