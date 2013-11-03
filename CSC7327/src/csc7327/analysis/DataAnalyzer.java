/**
 * 
 */
package csc7327.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.joda.time.DateTime;

import csc7327.objects.CheckIn;
import csc7327.objects.UserInfor;
import csc7327.tools.Tools;

/**
 * @author luongnv89
 * 
 */
public class DataAnalyzer {
	static int[] workingdays = { 2, 3, 4, 5, 6 };
	static int[] saturday = {7 };
	static int[] sunday = { 1};
	/**
	 * The url to get the data source file
	 */
	String dataURL;
	/**
	 * List all the checkins of the city divided by time slot
	 */
	// ArrayList<DataTimeSlot> listDataTimeSlot;
	ArrayList<CheckIn> listAllCheckin;

	/**
	 * @param cityName
	 * @param dataURL
	 */
	public DataAnalyzer(String dataURL) {
		this.dataURL = dataURL;
		this.listAllCheckin = new ArrayList<>();
	}

	/**
	 * @param dataURL2
	 * @return
	 */
	public void loadData() {
		try {
			InputStream inputs = new FileInputStream(dataURL);
			InputStreamReader inputReader = new InputStreamReader(inputs);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(inputReader);
			String checkInString = br.readLine();
			while (checkInString != null) {
				listAllCheckin.add(new CheckIn(checkInString));
				checkInString = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Some thing wrong!\n");
			e.printStackTrace();
		}

	}

	public void loadData(String dominateVenue) {
		try {
			InputStream inputs = new FileInputStream(dataURL);
			InputStreamReader inputReader = new InputStreamReader(inputs);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(inputReader);
			String checkInString = br.readLine();
			while (checkInString != null) {
				if (!checkInString.toLowerCase().contains(dominateVenue.toLowerCase())) {
					listAllCheckin.add(new CheckIn(checkInString));
				}
//				else{
//					System.out.println("Hello1");
//				}
				checkInString = br.readLine();

			}
		} catch (Exception e) {
			System.out.println("Some thing wrong!\n");
			e.printStackTrace();
		}
	}

	/**
	 * @param listAllCheckin
	 *            the listAllCheckin to set
	 */
	public void setListAllCheckin(ArrayList<CheckIn> listAllCheckin) {
		this.listAllCheckin = listAllCheckin;
	}

	public ArrayList<CheckIn> getListAllCheckin() {
		return listAllCheckin;
	}

	// QUERY FILTER DATA
	/**
	 * Filter data by time
	 * 
	 * @param startHour
	 * @param endHour
	 * @param dayInWeek
	 * @return
	 */
	public ArrayList<CheckIn> queryData(int startHour, int endHour,
			int[] dayInWeek) {
		ArrayList<CheckIn> listResultCheckin = new ArrayList<>();
		for (int i = 0; i < listAllCheckin.size(); i++) {
			DateTime checkInTime = listAllCheckin.get(i).getCheckInTime()
					.getCityTime();
			if (checkInTime.getHourOfDay() > startHour
					&& checkInTime.getHourOfDay() < endHour
					&& dayInWeek(dayInWeek, checkInTime.getDayOfWeek())) {
				listResultCheckin.add(listAllCheckin.get(i));
			}
		}
		return listResultCheckin;
	}

	/**
	 * Filter data by gender
	 * 
	 * @param gender
	 * @return
	 */
	public ArrayList<CheckIn> queryData(int gender) {
		ArrayList<CheckIn> listResultCheckin = new ArrayList<>();
		for (int i = 0; i < listAllCheckin.size(); i++) {
			if (listAllCheckin.get(i).getUser().getGender() == gender) {
				listResultCheckin.add(listAllCheckin.get(i));
			}
		}
		return listResultCheckin;
	}

	/**
	 * @param dayInWeek
	 * @return
	 */
	private boolean dayInWeek(int[] daysInWeek, int day) {
		for (int i = 0; i < daysInWeek.length; i++) {
			if (daysInWeek[i] == day)
				return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void analyzerByTime() {
		// Weekdays
		analyzerByTimer(0, 8, workingdays, "afternight");
		analyzerByTimer(8, 12, workingdays, "morning");
		analyzerByTimer(12, 18, workingdays, "afternoon");
		analyzerByTimer(18, 24, workingdays, "night");

		// Activity weekend
		analyzerByTimer(0, 8, saturday, "saturday_afternight");
		analyzerByTimer(8, 12, saturday, "saturday_morning");
		analyzerByTimer(12, 18, saturday, "saturday_afternoon");
		analyzerByTimer(18, 24, saturday, "saturday_night");
		
		// Activity weekend
				analyzerByTimer(0, 8, sunday, "sunday_afternight");
				analyzerByTimer(8, 12, sunday, "sunday_morning");
				analyzerByTimer(12, 18, sunday, "sunday_afternoon");
				analyzerByTimer(18, 24, sunday, "sunday_night");
		


//		// Evening
//		analyzerByTimer(20, 24, normalEvening, "normalEvening");
//		analyzerByTimer(20, 24, relaxEvening, "relaxEvening");

	}

	/**
	 * @param i
	 * @param j
	 * @param days
	 */
	private void analyzerByTimer(int i, int j, int[] days, String labelTime) {
		ArrayList<CheckIn> listFilteredResult = this.queryData(i, j, days);
		String outputPath = this.dataURL.replace("data/", "").replace(".txt",
				"")
				+ "_timer_" + i + "_" + j + labelTime + "_.txt";
		Tools.writeToFile(listFilteredResult, outputPath);

	}

	/**
	 * 
	 */
	public void analyzerByGender() {
		for (int i = -1; i < 2; i++) {
			ArrayList<CheckIn> listFilteredResult = new ArrayList<>();
			listFilteredResult.addAll(this.queryData(i));
			String outputPath = this.dataURL.replace("data/", "").replace(
					".txt", "")
					+ "_gender_" + i + "_.txt";
			Tools.writeToFile(listFilteredResult, outputPath);
//			DataAnalyzer genderAnalyzer = new DataAnalyzer(outputPath);
//			genderAnalyzer.setListAllCheckin(listFilteredResult);
//			genderAnalyzer.analyzerByTime();
		}
	}
	
	public void analyzerByFollow(){
		int nbMale = 0;
		int nbMaleFollowee = 0;
		int nbMaleFollower=0;
		
		int nbFemale = 0;
		int nbFemaleFollowee = 0;
		int nbFemaleFollwer = 0;
		
		for(int i=0;i<listAllCheckin.size();i++){
			UserInfor user = listAllCheckin.get(i).getUser();
			if(user.getGender()==-1){
				nbFemale++;
				nbFemaleFollowee+=user.getFollowingCount();
				nbFemaleFollwer+=user.getFollowerCount();
			}
			else if(user.getGender()==1){
				nbMale++;
				nbMaleFollowee+=user.getFollowingCount();
				nbMaleFollower+=user.getFollowerCount();
			}
		}
		
		System.out.println("Data source: " + this.dataURL);
		System.out.println("Male: \t" + nbMale+"\t"+nbMaleFollowee+"\t"+nbMaleFollower+"\n");
		System.out.println("Female: \t" + nbFemale+"\t"+nbFemaleFollowee+"\t"+nbFemaleFollwer+"\n");
	}

}
