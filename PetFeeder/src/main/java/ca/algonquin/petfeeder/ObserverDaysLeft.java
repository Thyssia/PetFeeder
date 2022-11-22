package ca.algonquin.petfeeder;

public class ObserverDaysLeft {
	protected CalculationDao calcDao;

		public ObserverDaysLeft(CalculationDao calcDao) {
			this.calcDao = calcDao;
			this.calcDao.attach(this);
			System.out.println("Attaching dao to the foodbag");
		}
		
		public void update() {
			System.out.println("debug, notifer received update for  " + calcDao.getDays());
			if ((calcDao.getDays()==14) || (calcDao.getDays()==7)) {
			System.out.println("Sending email for  " + calcDao.getDays());
			}
		}
}
