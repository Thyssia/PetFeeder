package ca.algonquin.petfeeder;

public class ObserverDaysLeft {
	protected CalculationDao calcDao;
	private SendEmail email = SendEmail.getInstance();
	private UserBean user;
	private UserDao userDao;

		public ObserverDaysLeft(CalculationDao calcDao) {
			this.calcDao = calcDao;
			this.calcDao.attach(this);
			System.out.println("Attaching dao to the foodbag");
		}
		
		public void update() {
			System.out.println("debug, notifer received update for  " + calcDao.getDaysLeft());
			if ((calcDao.getDaysLeft()==14) || (calcDao.getDaysLeft()==7)) {
				//call userdao to do user =  userDao.getUser(calcDao.getDaysLeft())
				
				////MY INPUT
				email.sendEmail(user, calcDao.getDaysLeft());
				System.out.println("Calling SendEmail class" + calcDao.getDaysLeft() + user.getFirstName());
				
			System.out.println("Sending email for  " + calcDao.getDaysLeft());
			}
		}
}
