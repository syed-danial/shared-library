def call(String successMessage='', String failureMessage='', String otherMessage='') {
  try{
    def buildStatus = currentBulid.currentResult
    def message = buildStatus == 'SUCCESS' ? successMessage :
        buildStatus == 'FAILURE' ? failureMessage : otherMessage
    if(message) {
      slackSend(
        color : buildStatus == 'SUCCESS' ? '#36a64f' :
                buildStatus == 'FAILURE' ? 'danger' : '#ffa550' , 
        message : message, channel = "jenkins-status"
      )
    }
  }  
  catch (Exception e){
    currentBuild.result = 'FAILURE'
    error("Failed to send Slack notification: ${e.message}")
  }
}
