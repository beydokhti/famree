/**
 * Base Controller
 *
 * @author Manohar Viswanathan
 */
abstract class BaseController {
   
	def beforeInterceptor = {
		log.debug "IN ${actionUri} ${params}"
	}
   
	def afterInterceptor = {
		log.debug "OUT ${actionUri}"	
	}
}