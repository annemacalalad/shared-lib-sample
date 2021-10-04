def buildNum(){
  echo "Build image with tag: ${env.BUILD_ID}"
}

def buildImage(){
  myapp = docker.build("annemacalalad/ledger-service:${env.BUILD_ID}", "--build-arg VERSION=${env.BUILD_ID} .")
}

def pushImage(){
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub'){
    myapp.push("latest")
    myapp.push("${env.BUILD_ID}")
  }
}
