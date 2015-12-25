/**
 * RoleController
 * Manage Authorization role
 *
 * @author Manohar Viswanathan
 */   
 // TODO This controller and views need to be removed
class RoleController {


    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

	def index = { redirect(action:list,params:params) }

    def list = {
        if(!params.max)params.max = 10
        [ authorityList: Role.list( params ) ]
    }

    def show = {
        [ authority : Role.get( params.id ) ]
    }

    def delete = {
        def authority = Role.get( params.id )
        String oldRole = authority.authority
        if(authority) {
         	def rms = Requestmap.findAllByConfigAttributeLike('%'+oldRole+'%')
         	rms.each{it.configAttribute=it.configAttribute.replace(oldRole,'');it.validate();}
            authority.delete()
            flash.message = "Role ${params.id} deleted."
            redirect(action:list)
        }
        else {
            flash.message = "Role not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def authority = Role.get( params.id )
        if(!authority) {
                flash.message = "Role not found with id ${params.id}"
                redirect(action:list)
        }
        else {
            return [ authority : authority ]
        }
    }

	/** Authority update action. when updating an existing authority instance, the requestmaps which contain
	 *  them should also be updated.
	 */
    def update = {
        def authority = Role.get( params.id )
        String oldRole = authority.authority
        if(authority) {
             authority.properties = params
             String role = params.authority
             authority.authority='ROLE_'+role.toUpperCase() 
             String newRole =authority.authority
             def rms = Requestmap.findAllByConfigAttributeLike('%'+oldRole+'%')
             rms.each{it.configAttribute=it.configAttribute.replace(oldRole,newRole);it.validate();}
            if(authority.save()) {
                redirect(action:show,id:authority.id)
            }
            else {
                render(view:'edit',model:[authority:authority])
            }
        }
        else {
            flash.message = "Role not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def authority = new Role()
        authority.authority=""
        authority.properties = params
        return ['authority':authority]
    }
	
	/** Authority save action*/
    def save = {
        def authority = new Role()
        String au=params.authority
        authority.properties = params
        //here translate user's input to the required Acegi format.
        authority.authority='ROLE_'+au.toUpperCase() 
        if(authority.save()) {
            redirect(action:show,id:authority.id)
        }
        else {
            render(view:'create',model:[authority:authority])
        }
    }

}