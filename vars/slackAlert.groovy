def sendSlackNotification(String message, String channel) {
    try {
        slackSend(
            color: 'good',
            message: message,
            channel: channel
        )
    } catch (Exception e) {
        error("Failed to send Slack notification: ${e.message}")
    }
}
