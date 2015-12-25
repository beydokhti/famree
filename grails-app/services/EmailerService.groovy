import org.springframework.mail.MailException
import javax.mail.MessagingException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * Simple service for sending emails.
 *
 * @auther Manohar Viswanathan
 */
class EmailerService {
  boolean transactional = false
  MailSender mailSender
  SimpleMailMessage mailMessage // a "prototype" email instance

  /**
   * Send a list of emails
   *
   * @param mails a list of maps
   */
  def sendEmails(mails) {
	log.debug "EmailService::sendEmails"
    def messages = []
    for (mail in mails) {
      // Create a thread safe "sandbox" of the message
      SimpleMailMessage message = new SimpleMailMessage(mailMessage)
      message.to = mail.to
      message.text = mail.text
      message.subject = mail.subject
      messages << message
    }
    // Send them all together
    try {
      mailSender.send(messages as SimpleMailMessage[])
    } catch (MailException ex) {
      log.error "Error sending emails", ex
    } catch (MessagingException mex){
      log.error "Error sending emails", mex
    }
  }
}