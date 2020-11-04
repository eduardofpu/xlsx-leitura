node{
  stage('SCM Checkout'){
   
   git 'https://github.com/eduardofpu/xlsx-leitura'
 }
 stage('Compile-Package'){
  // Get maven home path
  def mvnHome = tool name: 'M3', type: 'maven' 
  sh "${mvnHome}/bin/mvn package"
 }
}
