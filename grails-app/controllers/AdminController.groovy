/*
 * Admin Controller
 * Handles administrative tasks
 *
 * @author Manohar Viswanathan
 */
class AdminController extends BaseController {

	def eventService
	
    def index = { }
    
    // Refresh upcoming events
    def refreshUpcomingEventsAjax = {
    	eventService.generateEvents()
    	render "${eventService.upcomingEvents?.size()} Upcoming events updated. "
    }
}