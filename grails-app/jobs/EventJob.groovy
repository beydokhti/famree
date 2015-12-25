/*
 * Event Job
 * Runs at scheduled intervals and updates upcoming events. This includes
 * birth, death, wedding and custom events.
 *
 * @author Manohar Viswanathan
 */

class EventJob {
	
    //def timeout = grailsApplication.config.event.update.interval
    def timeout = 30000l
    def eventService
    
    // scheduled job
    def execute() {
        //log.debug "Running EventJob @ " + new Date()
	    eventService.generateEvents()	  
	}
}
