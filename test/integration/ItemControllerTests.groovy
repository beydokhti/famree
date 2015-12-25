class ItemControllerTests extends BaseTests {

    void testIndex() {
		def ic = new ItemController()
		ic.index()
		assertEquals "/item/list", ic.response.redirectedUrl
    }
    
    void testList() {
		def ic = new ItemController()
		def model = ic.list()
		assert model
		assert model.itemList
		assertEquals 1, model.itemList.size()    	
    }
    
    void testShow() {
    	def id = Item.list()[0].id
    	ItemController.metaClass.getParams = {-> [id:id] }
    	def ic = new ItemController()
		def model = ic.show()
		assert model
		assertEquals id, model?.item?.id? model?.item?.id:0
    }

    void testShowError() {
    	ItemController.metaClass.getParams = {-> [id:999] }
    	def ic = new ItemController()
		def model = ic.show()
		assert model
		assertNull model.item
    }
    
    void testDelete() {
    	def id = Item.list()[0].id
    	ItemController.metaClass.getParams = {-> [id:id] }
    	def count = Item.count()
    	
    	def ic = new ItemController()
		ic.delete()
		
		assertEquals count-1, Item.count()
		assertEquals "FAQ on subject deleted", ic.flash.message
		assertEquals "/item/list", ic.response.redirectedUrl
    }    

    void testDeleteError() {
    	ItemController.metaClass.getParams = {-> [id:999] }

    	def ic = new ItemController()
		ic.delete()
		
		assertEquals "Item not found with id 999", ic.flash.message
		assertEquals "/item/list", ic.response.redirectedUrl
    }   

    void testEdit() {
    	def id = Item.list()[0].id
    	ItemController.metaClass.getParams = {-> [id:id] }
  
    	
    	def ic = new ItemController()
		def model = ic.edit()
		
		assert model
		assertEquals id, model.item.id
	}
    
    void testEditError() {
    	ItemController.metaClass.getParams = {-> [id:999] }
    	
    	def ic = new ItemController()
		ic.edit()
		
		assertEquals "Item not found with id 999", ic.flash.message
		assertEquals "/item/list", ic.response.redirectedUrl
    }  
    
    void testSave() {
    	ItemController.metaClass.getParams = {-> [type:'FAQ', subject:'new faq', details:'new faq details'] }
    	def count = Item.count()
    	
    	def ic = new ItemController()
		ic.save()
		
		assertEquals "FAQ on new faq created", ic.flash.message
		assert "/item/show", ic.response.redirectedUrl[0..9]
		assertEquals count+1, Item.count()
    }
    
//    void testSaveError() {
//    	ItemController.metaClass.getParams = {-> [subject:'new faq', details:'new faq details'] }
// 
//    	def ic = new ItemController()
//		ic.save()
//		println "save done"
//		assertEquals "/item/create", ic.modelAndView.viewName
//		ic.modelAndView.model.item = null
//		sessionFactory.currentSession.clear()
//		println "*"+ ic.modelAndView.model
//		println "**"+ ic.modelAndView.model.item
//		
//    }   
}