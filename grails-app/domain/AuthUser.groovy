/**
 * AuthUser for user account
 *
 * @author Manohar Viswanathan
 */
class AuthUser {

	String username
	String userRealName 
	String passwd // MD5 password
	boolean enabled = false
	String pass="[secret]" // plain password to create a MD5 password
//    FamilyMember member

	static transients = ["pass"]
	static hasMany=[authorities:Role]

	
	static mapping = {
	    table 'ft_auth_user'
	    version false
	    authorities joinTable:[name:'ft_auth_user_role', key:'people_id', column:'authorities_id']
	}
	
	static constraints = {
		username(blank:false,unique:true)
		userRealName(blank:false)
		passwd(blank:false)
//		member (nullable: true,unique: true)
        enabled()
	}
}