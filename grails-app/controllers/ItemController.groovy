import com.mano.familytree.data.ItemType
/*
 * Item Controller
 * Manages FAQ, Announcement, and Custom Events
 *
 * @author Manohar Viswanathan
 */
class ItemController extends BaseController {

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']
    
    def index = { redirect(action:list,params:params) }

    def list = {
        if(!params.max) params.max = 20
        [ itemList: Item.list( params ) ]
    }

    def show = {
        [ item : Item.get( params.id ) ]
    }

    def delete = {
        def item = Item.get( params.id )
        if(item) {
            item.delete()
            flash.message = "${item.type.name} [${item.subject}] deleted"
            redirect(action:list)
        } else {
            flash.message = "Item not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def item = Item.get( params.id )
        if(!item) {
            flash.message = "Item not found with id ${params.id}"
            redirect(action:list)
        } else {
            return [ item : item ]
        }
    }

    def update = {
        def item = Item.get( params.id )
        // Sanitize params     
        if ((!params.startDate_day || !params.startDate_month || !params.startDate_year) || (params.startDate_day=='undefined' || params.startDate_month=='undefined' || params.startDate_year=='undefined')) {
          params.startDate=null
        }
        if ((!params.endDate_day || !params.endDate_month || !params.endDate_year)  || (params.endDate_day=='undefined' || params.endDate_month=='undefined' || params.endDate_year=='undefined')) {
              params.endDate=null
        }         
        if(item) {
            item.properties = params
            if (item.startDate) {
                if (!item.endDate) item.errors.rejectValue("endDate", "item.endDate.nullable")	
                else if (item.startDate.after(item.endDate)) item.errors.rejectValue("endDate", "item.endDate.before.startDate")
                else {
              	  item.startDate = DateUtil.getStartDate(item.startDate)
              	  item.endDate = DateUtil.getEndDate(item.endDate)
                }
             }
            if(!item.hasErrors() && item.save()) {
                flash.message = "${item.type.name} [${item.subject}] updated"
                redirect(action:show,id:item.id)
            } else {
                render(view:'edit',model:[item:item])
            }
        } else {
            flash.message = "Item not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def item = new Item()
        item.properties = params
        return ['item':item]
    }

    def save = {
       // Sanitize params     
       if ((!params.startDate_day || !params.startDate_month || !params.startDate_year) || (params.startDate_day=='undefined' || params.startDate_month=='undefined' || params.startDate_year=='undefined')) {
          params.startDate=null
       }
       if ((!params.endDate_day || !params.endDate_month || !params.endDate_year)  || (params.endDate_day=='undefined' || params.endDate_month=='undefined' || params.endDate_year=='undefined')) {
              params.endDate=null
       }       		
       def item = new Item(params)
       
       if (item.type && item.type != ItemType.FAQ && !item.startDate) {
          item.errors.rejectValue("startDate", "item.startDate.nullable")	
       }
       if (item.startDate) {
          if (!item.endDate) item.errors.rejectValue("endDate", "item.endDate.nullable")	
          else if (item.startDate.after(item.endDate)) item.errors.rejectValue("endDate", "item.endDate.before.startDate")
          else {
        	  item.startDate = DateUtil.getStartDate(item.startDate)
        	  item.endDate = DateUtil.getEndDate(item.endDate)
          }
       }
       if(!item.hasErrors() && item.save()) {
            flash.message = "${item.type.name} [${item.subject}] created"
            redirect(action:show,id:item.id)
       } else {
            render(view:'create',model:[item:item])
       }
    }
   
}