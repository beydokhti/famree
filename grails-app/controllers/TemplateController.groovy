/*
 * Template Controller
 *
 * @author Manohar Viswanathan
 */
class TemplateController extends BaseController {

	def templateService
	
	def allowedMethods = [delete:'POST', save:'POST', update:'POST']
    
    def index = { redirect(action:list,params:params) }

    def list = {
        if(!params.max) params.max = 20
        [ templateList: Template.list( params ) ]
    }

    def show = {
        [ template : Template.get( params.id ) ]
    }

    def edit = {
        def template = Template.get( params.id )
        if(!template) {
            flash.message = "Template not found with id ${params.id}"
            redirect(action:list)
        } else {
            return [ template : template ]
        }
    }

    def update = {
        def template = Template.get( params.id )      
        if(template) {
        	template.templateValue = params.templateValue
            if(!template.hasErrors() && template.save()) {
            	templateService.updateTemplate(template)
                flash.message = "${template.templateKey} updated"
                redirect(action:list)
            } else {
                render(view:'edit',model:[template:template])
            }
        } else {
            flash.message = "Template not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

}