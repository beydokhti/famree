class HomeControllerTests extends BaseTests {

	def itemService
	def eventService
	def memberService
	
	def c
    
	void testIndex() {
        def model = c.index()
        assert model
        assert model.genderValues
        assertEquals 1, model.genderValues[0]
        assertEquals 2, model.genderValues[1]
        
    }
	
	void testFaq() {
		c.faq()
	    def modelAndView = 	c.modelAndView
	    assert modelAndView
	    assertEquals '/home/faq', modelAndView.viewName
	    def model = modelAndView.model
	    assert model
	    assertEquals 1, model.faqList?.size()
	}
	
	void testEventsAjax() {
		println "*"+ eventService.upcomingEvents
	    assertEquals 0, eventService.upcomingEvents?.size()
	    c.eventsAjax()
	    println "*"+ c.response.contentAsString
	    //assert eventService.upcomingEvents
	    assertEquals 2, eventService.upcomingEvents?.size()
	}
	
	void setUp() {
		super.setUp()
		c = new HomeController()
        c.itemService = itemService
        c.eventService = eventService
        c.memberService = memberService
	}
}