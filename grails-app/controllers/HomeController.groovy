import com.mano.familytree.data.ItemType
import java.text.SimpleDateFormat
import com.mano.familytree.data.EventType
import com.sun.syndication.feed.synd.*
import com.sun.syndication.io.SyndFeedOutput
import java.text.SimpleDateFormat

/*
 * Home Controller
 *
 * @author Manohar Viswanathan
 */
class HomeController extends BaseController {

    def eventService
    def itemService
    def memberService
    def templateService
    
    // landing page

    def constructTree = {member, s->
        if (!member) return

        if (!member?.children) {
            if (member.spouse) s.append("<member name='${member.nickname + " &amp; " + member.spouse.nickname}' id='${member.id}'/>")
            else s.append("<member name='${member.nickname}' id='${member.id}'/>")
        } else {
            if (member.spouse) s.append("<member name='${member.nickname + " &amp; " + member.spouse?.nickname}' id='${member.id}'>")
            else s.append("<member name='${member.nickname}' id='${member.id}'>")
            member.children.each{ constructTree(it,s) }
            s.append("</member>")
        }
    }

    def index = { 
       def announcements = itemService.listByType(ItemType.ANNOUNCEMENT)
       
       def genderColors = ['99ff33','66ccff']
       def genderValues = memberService.getGenderCount()
       def genderLabels = ['Male('+genderValues[0]+')','Female('+genderValues[1]+')']
       
       def ageValues = memberService.getAgeCount()
       def ageLabels = ['Died('+ageValues[0]+')','0-20('+ageValues[1]+')','21-40('+ageValues[2]+')', '41-60('+ageValues[3]+')', '61-80('+ageValues[4]+')', '80%2B('+ageValues[5]+')']
       def ageColors = ['cc0000','00cc00','663399', '0000cc',  '003300', 'c0c0c0']

       def totalMembers = FamilyMember.count()

        def root = memberService.getRootMember()
        def s = new StringBuffer()
        constructTree(root, s)
        def member
        if (params.id) member = FamilyMember.get(params.id.toString())

        [ events : eventService.upcomingEvents, announcements:announcements,"data": s.toString()]//, genderLabels:genderLabels, genderColors:genderColors, genderValues:genderValues, ageColors:ageColors, ageLabels:ageLabels, ageValues:ageValues, totalMembers:totalMembers ]
    }
    
    // faq page
    def faq = { 
       def criteria = Item.createCriteria()
       def faqList = criteria {
         eq("type", ItemType.FAQ)
         eq("active", true)
         order("position", "asc")
       } 
       render(view:'faq', model:[faqList:faqList]) 
    }
    
    // get events by ajax to be displayed in Timiline SIMILE
    def eventsAjax = {
       def events = eventService.upcomingEvents
       def taglib = new FamilyTagLib()
       render(contentType: "text/xml") {
          data() {
             events.each {
               //Special date format which is needed for the timeline control
	           String startDate = new SimpleDateFormat("MMMMM dd yyyy HH:mm:ss", Locale.US).format(it.startDate) + " GMT"
	           def message
	           def title
	           if (it.type == EventType.BIRTH) {
	        	 title = templateService.getTemplate("timeline.event.birth.title", "Birthday title", [member:it.object])
	        	 message = templateService.getTemplate("timeline.event.birth.description", "Birthday details", [member:it.object, num:taglib.ordinal(value:it.number)])
	             event('start': startDate, 'title':title, 'link':"${createLink(controller:'member', action:'display', id:it.object.id)}", message)
               } else if (it.type == EventType.DEATH) {
            	 title = templateService.getTemplate("timeline.event.death.title", "Death title", [member:it.object])
            	 message = templateService.getTemplate("timeline.event.death.description", "Death details", [member:it.object, num:taglib.ordinal(value:it.number)])
                 event('start': startDate, 'title':title, 'link':"${createLink(controller:'member', action:'display', id:it.object.id)}", message)
               } else if (it.type == EventType.WEDDING) {
            	 title = templateService.getTemplate("timeline.event.wedding.title", "Wedding title", [couple:it.object])
            	 message = templateService.getTemplate("timeline.event.wedding.description", "Wedding details", [couple:it.object, num:taglib.ordinal(value:it.number)])
                 event('start': startDate, 'title':title, 'link':"${createLink(controller:'member', action:'display', id:it.object.mainMember.id)}", message)
               } else if (it.type == EventType.CUSTOM_EVENT) {
                 String endDate = it.endDate? (new SimpleDateFormat("MMMMM dd yyyy HH:mm:ss", Locale.US).format(it.endDate) + " GMT") : startDate
                 event('start': startDate, 'end':endDate, 'title':"${it.object.subject}", "${it.object.details}")
               }
             }
          }
       }
       
    }   
    
    def feed = {
      def events = eventService.upcomingEvents
      def taglib = new FamilyTagLib()
      
      SyndFeed feed = new SyndFeedImpl()
      feed.setFeedType("atom_0.3")
      feed.setTitle(templateService.getTemplate("site.title", "My Family Tree") + " News")
      feed.setLink(templateService.getTemplate("site.url", "http://myfamilytree.com"))
      feed.setDescription("This feed keeps you informed of important events")

      def title
      def message
      def linkId
      def eventDate
       
      List entries = new ArrayList()
      def nextDay = new Date() + 2
      def sdf = new SimpleDateFormat("MMM dd,yyyy")
      def feedEvents = events?.findAll{it.startDate < nextDay}?.sort { it.startDate }
      feedEvents.reverse()
      feedEvents.each {	  
      	if (it.type == EventType.BIRTH) {
	          title = templateService.getTemplate("timeline.event.birth.title", "Birthday title", [member:it.object]) + " on " + sdf.format(it.startDate)
	          message = templateService.getTemplate("timeline.event.birth.description", "Birthday details", [member:it.object, num:taglib.ordinal(value:it.number)])
	          linkId = it.object.id   
	          eventDate = it.startDate
        } else if (it.type == EventType.DEATH) {
         	  title = templateService.getTemplate("timeline.event.death.title", "Death title", [member:it.object]) + " on " + sdf.format(it.startDate)
         	  message = templateService.getTemplate("timeline.event.death.description", "Death details", [member:it.object, num:taglib.ordinal(value:it.number)])
         	  linkId = it.object.id   
         	  eventDate = it.startDate
        } else if (it.type == EventType.WEDDING) {
        	  title = templateService.getTemplate("timeline.event.wedding.title", "Wedding title", [couple:it.object]) + " on " + sdf.format(it.startDate)
         	  message = templateService.getTemplate("timeline.event.wedding.description", "Wedding details", [couple:it.object, num:taglib.ordinal(value:it.number)])
          	  linkId = "${it.object.mainMember.id}"
          	  eventDate = it.startDate
        } else if (it.type == EventType.CUSTOM_EVENT) {
              title = it.object.subject + " on " + sdf.format(it.startDate)
              message = it.object.details
              linkId = ""
              eventDate = it.startDate
        }
        SyndEntry entry = new SyndEntryImpl()
        entry.setTitle(title)
        entry.setLink(templateService.getTemplate("site.url", "http://myfamily.com") + "${request.contextPath}" + (linkId? "/member/display/${linkId}":""))
        entry.setPublishedDate(eventDate)
        SyndContent description = new SyndContentImpl()
        description.setType("text/html")
        description.setValue(message)
        entry.setDescription(description)
        entries.add(entry)   	
      }

      feed.setEntries(entries)
      
	  StringWriter writer = new StringWriter()
	  SyndFeedOutput output = new SyndFeedOutput()
	  output.output(feed, writer)
	  writer.close()
	
	  render(text:writer.toString(), contentType:"text/xml", encoding:"UTF-8") 
    }
    
}