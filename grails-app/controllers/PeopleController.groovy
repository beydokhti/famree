class PeopleController {
    def memberService
    AuthenticateService authenticateService

    def allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

    def index = { redirect(action: list, params: params) }

    def list = {
        if (!params.max) params.max = 10
//todo
        def users = Role.findByAuthority("ROLE_USER").people
        [personList: users]
    }

    def show = {
        def authUser = AuthUser.get(params.id)
        [person: authUser, member: FamilyMember.findAllByAuthUser(authUser)]
    }

    /** person delete action, before removing an existing person,
     *  he should be removed from those authorities which he is involved
     */
    def delete = {
        def person = AuthUser.get(params.id)
        def authPrincipal = authenticateService.principal()
        if (person) {
            //avoid self-delete if the logged-in user is an admin
            if (!(authPrincipal instanceof String) && authPrincipal.username != person.username) {
                def au = Role.findAll()
                if (Role.findAll() != null) {
                    //firstly, delete this person from People_Authorities table.
                    au.each { it.removeFromPeople(person) }
                }
                FamilyMember familyMember=FamilyMember.findByAuthUser(person)
                familyMember.authUser=null
                familyMember.save()
                person.delete()
                flash.message = "User ${person.username} deleted."
                redirect(action: list)
            } else {
                flash.message = "You can not delete yourself, please login with another admin and try again"
                redirect(action: list)
            }
        } else {
            flash.message = "User not found with id ${params.id}"
            redirect(action: list)
        }
    }

    def edit = {
        def person = AuthUser.get(params.id)

        if (!person) {
            flash.message = "User not found with id ${params.id}"
            redirect(action: list)
        } else {
            def authorityList = Role.list(params)
            return ['person': person, 'authorityList': authorityList, member: FamilyMember.findAllByAuthUser(person)]
        }
    }

    /** person update action, added additional codes to update the user's roles*/
    def update = {
        def person = AuthUser.get(params.id)
        def oldpw = person.passwd
        if (person) {
            person.properties = params
            String ps = params.get("passwd")
            if (!ps.equals(oldpw)) {
                def pass = authenticateService.passwordEncoder(ps)
                person.passwd = pass
            }
            Set paramsSet = params.keySet()
            Iterator itt = paramsSet.iterator()
            if (person.save()) {
                def au = Role.findAll()
                au.each { it.removeFromPeople(person) }
                while (itt.hasNext()) {
                    String key = itt.next()
                    if (params.get(key).equals("on") && key.contains("ROLE")) {
                        def role = Role.findByAuthority(key)
                        role.addToPeople(person)
                    }
                }
                redirect(action: show, id: person.id)
            } else {
                render(view: 'edit', model: [person: person])
            }
        } else {
            flash.message = "User not found with id ${params.id}"
            redirect(action: edit, id: params.id)
        }
    }//update

    def create = {
        def person = new AuthUser()
        person.properties = params
        return ['person': person]
    }

    // save user
    def save = {
        def person = new AuthUser()
        person.properties = params
        def pass = authenticateService.passwordEncoder(params.passwd)
        person.passwd = pass
        Set paramsSet = params.keySet()
        if (person.validate()) {
            def role = Role.findByAuthority("ROLE_USER")
            person.addToAuthorities(role)
            person.save()
            def member = FamilyMember.get(Integer.parseInt(params.member.id))
            member.authUser = person
            member.save()
            redirect(action: show, id: person.id)
        } else {
            render(view: 'create', model: [person: person])
        }
    }//save

}
