class FamilyTagLibTests extends BaseTests {

    void testOrdinal() {
	    assertEquals '1<sup>st</sup>', new FamilyTagLib().ordinal([value:'1'])
	    assertEquals '2<sup>nd</sup>', new FamilyTagLib().ordinal([value:'2'])
	    assertEquals '3<sup>rd</sup>', new FamilyTagLib().ordinal([value:'3'])
	    assertEquals '4<sup>th</sup>', new FamilyTagLib().ordinal([value:'4'])
	    assertEquals '12<sup>th</sup>', new FamilyTagLib().ordinal([value:'12'])
    }
    
    void testAvatar() {
    	def member = FamilyMember.list()[0]
        assertEquals '/images/avatar_default.gif', new FamilyTagLib().avatar([member:member])
    }
    
	
}