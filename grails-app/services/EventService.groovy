import com.mano.familytree.data.Event
import com.mano.familytree.data.EventType

/*
 * Event Service
 *
 * @author Manohar Viswanathan
 */
class EventService {
	
    boolean transactional = true
    static upcomingEvents = []
    def itemService
    def templateService
    
    // generate upcoming events - birth, death, wedding, and custom events
    def generateEvents() {
       def today = new GregorianCalendar()
       def thisYear = today.get(Calendar.YEAR)
       def b = templateService.getTemplate("event.upcoming.start.before", "30").toInteger()
       def a = templateService.getTemplate("event.upcoming.end.after", "60").toInteger()
       def start = DateUtil.getStartDate(today.time-b)
       def end = DateUtil.getEndDate(today.time+a)
       

       def events = []
       
       // get birthdays
       def members = FamilyMember.list()
       members.each {
         if (it.birthDate) {
           def cal = new GregorianCalendar()
           cal.time = it.birthDate
           def bd = cal.clone()
           cal.set(Calendar.YEAR, thisYear)
           if (cal.time.before(start)) cal.add(Calendar.YEAR, 1) 
           if (cal.time.after(start) && cal.time.before(end)) {
             def event = new Event()
             event.type = EventType.BIRTH  
             event.number = cal.get(Calendar.YEAR) - bd.get(Calendar.YEAR)
             event.startDate = cal.time
             event.object = it
             events << event
           }
         }
         if (it.deathDate) {
           def cal = new GregorianCalendar()
           cal.time = it.deathDate
           def bd = cal.clone()
           cal.set(Calendar.YEAR, thisYear)
           if (cal.time.before(start)) cal.add(Calendar.YEAR, 1) 
           if (cal.time.after(start) && cal.time.before(end)) {
             def event = new Event()
             event.type = EventType.DEATH  
             event.number = cal.get(Calendar.YEAR) - bd.get(Calendar.YEAR)
             event.startDate = cal.time
             event.object = it
             events << event
           }
         }
       }
       
       // get weddings
       def weddings = Wedding.list()
       weddings.each {
         if (it.weddingDate) {
           def cal = new GregorianCalendar()
           cal.time = it.weddingDate
           def bd = cal.clone()
           cal.set(Calendar.YEAR, thisYear)
           if (cal.time.before(start)) cal.add(Calendar.YEAR, 1) 
           if (cal.time.after(start) && cal.time.before(end)) {
             def event = new Event()
             event.type = EventType.WEDDING  
             event.number = cal.get(Calendar.YEAR) - bd.get(Calendar.YEAR)
             event.startDate = cal.time
             event.object = it
             events << event
           }
         }
       }
       
       // get custom events
       def customEvents = itemService.listCustomEvents()
       customEvents.each {
          if ( it.startDate && it.startDate.after(start) ) {
             def event = new Event()
             event.type = EventType.CUSTOM_EVENT
             event.startDate = it.startDate
             event.endDate = it.endDate
             event.object = it
             events << event
          }
       }
       
       
       // sort them by date
       events.sort{ it.startDate }
              
       upcomingEvents = events
    }
}