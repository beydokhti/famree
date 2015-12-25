/**
 * RegisterController
 * 
 * @author Manohar Viswanathan
 */
class RegisterController {
  EmailerService emailerService
  AuthenticateService authenticateService
  
  /**
   * User Registration Top page
   */
  def index = {
    //if logon user.
    if(authenticateService.userDomain()!=null){
      log.info("${authenticateService.userDomain()} user hit the register page")
      redirect(action:"show")
      return
    }

    def person = new AuthUser()
    person.properties = params
    return ['person': person]
  }

  def allowedMethods = [save: 'POST', update: 'POST']

  /**
   * User Information page for current user.
   */
  def show = {
    //get user id from session's domain class.
    def uinfo = authenticateService.userDomain()
    if(uinfo){
      render(view:"show", model:[person:AuthUser.get(uinfo.id)])
    }else{
      redirect(action:"index")
    }
  }

  /**
   * edit page for current user
   */
  def edit = {
    def uinfo = authenticateService.userDomain()
    def person
    if(uinfo){
      person = AuthUser.get(uinfo.id)
    }else{
      redirect(action:"index")
    }
    if (!person) {
      flash.message="[Illegal Access] User not found with id ${params.id}"
      redirect(action:"index")
    } else {
      return ['person': person]
    }
  }

  /**
   * update action for current user's edit page
   */
  def update = {
    def uinfo = authenticateService.userDomain()
    def person
    if(uinfo){
      person = AuthUser.get(uinfo.id)
    }else{
      redirect(action:"index")
    }

    if (person){
      //if user want to change password. leave passwd field blank, passwd will not change.
      if((params.passwd && params.passwd.length()>0) || (params.repasswd && params.repasswd.length()>0)){
         if(params.passwd.equals(params.repasswd)){
           person.passwd = authenticateService.passwordEncoder(params.passwd)
         }else{
           person.passwd = ""
           params.repasswd = ""
           flash.message = "The passwords you entered twice are not identical, please try again."
           render(view:"edit", model: [person: person])
         }
      }
      person.userRealName=params.userRealName

      if (person.save()) {
    	flash.message = "Account updated"
        redirect(action:"show", id: person.id)
      }else {
        render(view:"edit", model: [person: person])
      }
    }else {
      flash.message = "[Illegal Access] User not found with id ${params.id}"
      redirect(action:"index", id: params.id)
    }
  }

  /** person save action, added additional codes to save the user's roles*/
  def save = {

    if(authenticateService.userDomain()!=null){
      log.info("${authenticateService.userDomain()} user hit the register page")
      redirect(action:"show")
      return
    }
    
    def person = new AuthUser()
    person.properties = params
    
    def cnf = authenticateService.getAcegiConfig()
    def defaultRole = cnf.acegi.defaultRole
    def useMail = cnf.acegi.useMail
    def role = Role.findByAuthority(defaultRole)
    if(!role){
      person.passwd = ""
      flash.message = "Default Role not found."
      render(view:"index", model: [person: person])
      return 
    }

    if (params.captcha.toUpperCase() == session.captcha) {
      if (params.passwd.equals(params.repasswd) ) {
        def pass = authenticateService.passwordEncoder(params.passwd)
        person.passwd = pass
        //person.enabled = true
        person.email_show = true
        person.description=""
        if(person.save()){

          role.addToPeople(person)

          // send email if(useMail)
          if(useMail){
         String emailContent = """You have signed up for an account at:

 ${request.getScheme()}://${request.getServerName()}:${request.getServerPort()}${request.getContextPath()}

 Here are the details of your account:
 -------------------------------------
 LoginName: ${person.username}
 Email: ${person.email}
 Full Name: ${person.userRealName}
 Password: ${params.passwd}
"""

            def email = [
              to: [person.email], // "to" expects a List, NOT a single email address
              subject: "[${request.getContextPath()}] Account Signed Up",
              text: emailContent // "text" is the email body
            ]
            emailerService.sendEmails([email])
          }

          person.save(flush:true)
         // def parMap =['j_username':person.username,'j_password':params.passwd]
          //redirect(controller:'login',action:'../j_acegi_security_check',params:parMap)
        }else {
          person.passwd = ""
          render(view: "index", model: [person: person])
        }
      }else {
        person.passwd = ""
        flash.message = "The passwords you entered twice are not identical, please try again."
        render(view: "index", model: [person: person])
      }
    }else {
      person.passwd = ""
      flash.message = "Access code did not match."
      render(view: "index", model: [person: person])
    }
   } //save
}