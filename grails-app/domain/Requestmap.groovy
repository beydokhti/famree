/**
 * Domain class for Request Map
 *
 * @author Manohar Viswanathan
 */
class Requestmap {

	String url
	String configAttribute

	static mapping = {
	    table 'ft_requestmap'
	    version false
	}
	
	static def constraints = {
		url(blank:false,unique:true)
		configAttribute(blank:false)
	}
	
}
