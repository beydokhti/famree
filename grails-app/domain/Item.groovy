import com.mano.familytree.data.ItemType

/**
 * Item object represents either a FAQ, ANNOUNCEMENT or CUSTOM_EVENT
 *
 * @author Manohar Viswanathan
 */
class Item { 
	
	String subject
	String details
	Boolean active = true
	ItemType type
    Integer position = 0
    Date startDate 
    Date endDate 
    
    static mapping = {
      table 'ft_item'
      version false
      type type:'text'
    }
    
    static constraints = {
      subject(blank:false)
      details(blank:false)
      active(nullable:false)
      type(blank:false)
      startDate(nullable:true)
      endDate(nullable:true)
    }

}