            
class WeddingController extends BaseController {
   
	def edit = {
    	def wedding = Wedding.get( params.id )	
		render(template:'edit', model:[ wedding :  wedding]) 
	}
	
	def update = {
		def wedding = Wedding.get( params.id )	
		def prevActiveWedding =  wedding.mainMember?.wedding || wedding.spouseMember?.wedding
		def prevActive = wedding.active 
        def msg = null
        if(wedding) {
            wedding.properties = params
            wedding.active = params.active? true : false
            // check if there is already an active marriage	
            if (!prevActive && wedding.active && prevActiveWedding)	{
            	wedding.errors.rejectValue('active', 'active.twice', [wedding.mainMember?.nickname, wedding.spouseMember?.nickname].toArray(), '')
            }
            if(!wedding.hasErrors() && wedding.validate() && wedding.save()) {
                msg = "true"
            } else {
            	wedding.discard()
            	msg = message(code:wedding.errors?.allErrors[0]?.code, args:wedding.errors?.allErrors[0]?.arguments.toList())
            }
        } 
		render msg
	}
   
}