class FamilyTagLib {

	def templateService
	
    // render avatar
	def avatar = { attrs, body ->
		def member = attrs.member
		if (member?.avatar?.length > 0 && member.avatarMime) {
		  out << "${request.contextPath}/member/avatar/${member.id}"
		} else {
		   out << "${request.contextPath}/images/avatar_default.gif"
		}
	}
	
	def ordinal = { attrs ->
	   def number = Math.abs(attrs.value.toInteger()) % 100
	   def check = number > 10 && number < 20? 0 : number%10
	   switch(check) {
	      case 1: 
	         out << "${attrs.value}<sup>st</sup>"
	         break
	      case 2: 
	         out << "${attrs.value}<sup>nd</sup>"
	         break
	      case 3: 
	         out << "${attrs.value}<sup>rd</sup>"
	         break
	      default: 
	         out << "${attrs.value}<sup>th</sup>"
	   }
	
	}
    
    def template = { attrs ->
    	def key = attrs.key
    	def defaultValue = attrs.defaultValue
    	def ctx = attrs.ctx
    	def value = templateService.getTemplate(key, defaultValue, ctx)
    	out << value
    }
}