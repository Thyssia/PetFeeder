package ca.algonquin.petfeeder.utils;

import ca.algonquin.petfeeder.dao.CalculationDao;

public class ObserverDaysLeft {
	protected CalculationDao calcDao;
	private SendEmail email = SendEmail.getInstance();
	
		public ObserverDaysLeft(CalculationDao calcDao) {
			this.calcDao = calcDao;
			this.calcDao.attach(this);
			System.out.println("Attaching dao to the foodbag");
		}
		
		public void update() throws ClassNotFoundException {
			System.out.println("debug, notifer received update for  " + calcDao.getDaysLeft());
			if ((calcDao.getDaysLeft()==14) || (calcDao.getDaysLeft()==7)) {
				
				new Thread(new Runnable() {
		             @Override
		             public void run() {
		                 try
		                 {
				email.sendEmail(calcDao.getUser(), calcDao.getDaysLeft());
				System.out.println("Calling SendEmail class from observer with number of days: " + calcDao.getDaysLeft());
				
			System.out.println("Sending email for  " + calcDao.getDaysLeft());
		                 }
		                 catch(Exception e)
		                 {

		                 }

		             }
				}).start();
			}
		}
}