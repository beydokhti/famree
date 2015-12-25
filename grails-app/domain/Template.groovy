/**
 * Template
 *
 * @author Manohar Viswanathan
 */
class Template {

	String templateKey
	String templateDescription
	String templateValue
	
	static mapping = {
	    table 'ft_template'
	    version false
	}
	
	static constraints = {
		templateKey(blank:false, unique:true)
		templateDescription(blank:false)
	    templateValue(blank:false)
	}	
}
