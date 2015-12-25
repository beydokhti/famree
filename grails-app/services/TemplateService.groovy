import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import java.io.StringReader
import java.io.StringWriter
import java.util.Map
/*
 * Template Service
 *
 * @author Manohar Viswanathan
 */
class TemplateService {
	
    boolean transactional = true

    def templateCache = [:]
    
    // Get template by key
    def getTemplate(key) {
    	getTemplate(key, null, null)
    }

    // Get template by key
    def getTemplate(key, defaultValue) {
    	getTemplate(key, defaultValue, null)
    }
     
    // Get template with substitution
    def getTemplate(key, defaultValue, ctx) {
    	if (!templateCache) initCache()
    	def value = templateCache[key]
    	if (value && ctx) {
    		def velocityContext = new VelocityContext(ctx)
    		def result = new StringWriter()
    		Velocity.evaluate(velocityContext, result, "", new StringReader(value))
    		value = result.getBuffer().toString()
    	} 
    	return value? value : defaultValue
    }
    
    def updateTemplate (template) {
    	if (!templateCache) initCache()
    	templateCache[template.templateKey] = template.templateValue?.trim()
    }
    
	// initialize cache
	private void initCache() {
		def templates = Template.list()
		log.debug "Initializing template cache"
		templateCache = [:]
		templates.each { template ->
		  templateCache[template.templateKey] = template.templateValue?.trim()
		}
	}
	

}