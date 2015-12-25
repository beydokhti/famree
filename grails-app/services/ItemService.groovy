import com.mano.familytree.data.ItemType

class ItemService {
	
    boolean transactional = true

    def save(item) {

    }
    
    def listCustomEvents() {
       Item.executeQuery("select i from Item i where i.type=:type and i.active is true", [type:ItemType.CUSTOM_EVENT])
    }
    
    def listByType(ItemType type) {
        def cal = new GregorianCalendar()
        cal.set(Calendar.HOUR, 0)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)       
        def today = cal.time
 
        def c = Item.createCriteria()
        def results = c {
           eq("active", true)
           or {
              isNull("startDate")
              le("startDate", today)
           }
           or {
              isNull("endDate")
              ge("endDate", today) 
           }
           eq("type", type)
           order("position", "asc")
        }
        return results
    }
}