class DateUtil {
	
	// get start date
	public static getStartDate(Date date) {
		def cal = new GregorianCalendar()
		cal.time = date
		cal.add(Calendar.HOUR_OF_DAY, 0)
		cal.add(Calendar.MINUTE, 0)
		cal.add(Calendar.SECOND, 0)
		cal.add(Calendar.MILLISECOND, 0)
		cal.time
	}
	
    // get end date
	public static getEndDate(Date date) {
		def cal = new GregorianCalendar()
		cal.time = date
		cal.add(Calendar.HOUR_OF_DAY, 23)
		cal.add(Calendar.MINUTE, 59)
		cal.add(Calendar.SECOND, 59)
		cal.add(Calendar.MILLISECOND, 999)
		cal.time
	}
}