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
import csc7327.tools.Tools;

/**
 * @author luongnv89
 * 
 */
public class DataAnalyzer {
	static int[] workingdays = { 2, 3, 4, 5, 6 };
	static int[] normalEvening = { 2, 3, 4, 5, 1 };
	static int[] weekenddays = { 1, 7 };
	static int[] fullWeek = { 1, 2, 3, 4, 5, 6, 7 };
	static int[] relaxEvening = { 6, 7 };
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
		// Full week
		analyzerByTimer(0, 7, fullWeek,"sleeping");

		// Working days
		analyzerByTimer(7, 9, workingdays,"goToWork");
		analyzerByTimer(9, 12, workingdays,"WorkingMorning");
		analyzerByTimer(12, 14, workingdays,"lunch");
		analyzerByTimer(14, 18, workingdays,"workingAfternoon");
		analyzerByTimer(18, 20, workingdays,"GoHome");

		// Activity weekend
		analyzerByTimer(7, 12, weekenddays,"weekendMorning");
		analyzerByTimer(12, 20, weekenddays,"weekendAfternoon");

		// Evening
		analyzerByTimer(20, 24, normalEvening,"normalEvening");
		analyzerByTimer(20, 24, relaxEvening,"relaxEvening");

	}

	/**
	 * @param i
	 * @param j
	 * @param days
	 */
	private void analyzerByTimer(int i, int j, int[] days,String labelTime) {
		ArrayList<CheckIn> listFilteredResult = this.queryData(i, j,
				days);
		String outputPath = this.dataURL.replace("data/", "").replace(".txt", "")
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
			String outputPath = this.dataURL.replace("data/", "").replace(".txt",
					"")
					+ "_gender_" + i + "_.txt";
			Tools.writeToFile(listFilteredResult, outputPath);
			DataAnalyzer genderAnalyzer = new DataAnalyzer(outputPath);
			genderAnalyzer.setListAllCheckin(listFilteredResult);
			genderAnalyzer.analyzerByTime();
		}
	}

}
