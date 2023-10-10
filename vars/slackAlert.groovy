def sendSlackNotification(String message, String channel, String webhookUrl) {
    try {
        slackSend(
            color: 'good',
            message: message,
            channel: channel,
            tokenCredentialId: webhookUrl
        )
    } catch (Exception e) {
        error("Failed to send Slack notification: ${e.message}")
    }
}
