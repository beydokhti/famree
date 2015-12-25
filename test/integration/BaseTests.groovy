abstract class BaseTests extends GroovyTestCase {

	def sessionFactory
	
	void setUp() {
        new FamilyMember(name:'male1', nickname:'male1', birthDate:new Date()+1, root:true, gender:'MALE').save(flush:true)
        new FamilyMember(name:'female1', nickname:'female1', birthDate:new Date()+10, root:false, gender:'FEMALE').save(flush:true)
        new FamilyMember(name:'female2', nickname:'female2', birthDate:new Date(), root:false, gender:'FEMALE').save(flush:true)
        
        new Item(subject:'subject', details:'details', type:'FAQ').save(flush:true)
	}
	
	void tearDown() {
		FamilyMember.list()*.delete()
		Item.list()*.delete()
	}

}