/**
 * Role class for Authority
 *
 * @author Manohar Viswanathan 
 */
class Role {

	String description
	String authority="ROLE_"

	static hasMany=[people:AuthUser]
	static belongsTo = AuthUser
	
	static mapping = {
	    table 'ft_role'
	    version false
	   	people joinTable:[name:'ft_auth_user_role', key:'authorities_id', column:'people_id']
	}
	
	static constraints = {
		authority(blank:false)
		description()
	}
}