acegi {
  loadAcegi=true

  algorithm="MD5" 
  //use Base64 text ( true or false )
  encodeHashAsBase64=false
  errorPage="/notAuthorized.gsp"

  /** login user domain class name and fields */
  loginUserDomainClass="AuthUser"
  userName="username"
  password="passwd"
  enabled="enabled"
  relationalAuthorities = "authorities"

  /**
   * Authority domain class authority field name 
   * authorityFieldInList
   */
  authorityDomainClass="Role"
  authorityField="authority"

  /** use RequestMap from DomainClass */
  useRequestMapDomainClass = false
  /** Requestmap domain class (if useRequestMapDomainClass = true) */
  requestMapClass="Requestmap"
  requestMapPathField="url"
  requestMapConfigAttributeField="configAttribute"

 /** 
  * if useRequestMapDomainClass is false, set request map pattern in string
  * see example below
  */
  requestMapString = """
  CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON
  PATTERN_TYPE_APACHE_ANT

  /login/**=IS_AUTHENTICATED_ANONYMOUSLY
  /home/**=IS_AUTHENTICATED_ANONYMOUSLY
  /member/edit/**=ROLE_MANAGER, ROLE_ADMIN
  /member/update/**=ROLE_MANAGER, ROLE_ADMIN
  /member/delete/**=ROLE_MANAGER, ROLE_ADMIN
  /member/create/**=ROLE_MANAGER, ROLE_ADMIN
  /member/save/**=ROLE_MANAGER, ROLE_ADMIN
  /member/profile/**=ROLE_USER
  /admin/**=ROLE_ADMIN
  /item/**=ROLE_ADMIN
  /user/**=ROLE_ADMIN
  /people/**=ROLE_MANAGER, ROLE_ADMIN
  /role/**=ROLE_ADMIN
  /template/**=ROLE_ADMIN
  /**=IS_AUTHENTICATED_ANONYMOUSLY
  """

 /**
  * To use email notification for user registration, set the following userMail to
  * true and config your mail settings.Note you also need to implement the script
  * grails generate-registration.
  */
  useMail = true
  mailHost = "localhost"
  mailUsername = ""
  mailPassword = ""
  mailProtocol = "smtp"
  mailFrom = "maryam.beydokhti2005@gmail.com"
  
  /** AJAX request header */
  ajaxHeader="X-Requested-With"
  
  /** default user's role for user registration */
  defaultRole="ROLE_USER"
}