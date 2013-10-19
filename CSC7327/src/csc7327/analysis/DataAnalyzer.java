/**
 * 
 */
package csc7327.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import csc7327.enums.DayInWeek;
import csc7327.enums.TimeInDay;
import csc7327.objects.CheckIn;
import csc7327.objects.DataTimeSlot;

/**
 * @author luongnv89
 * 
 */
public class DataAnalyzer {
	/**
	 * The name of the city where the data is collected
	 */
	String cityName;
	/**
	 * The url to get the data source file
	 */
	String dataURL;
	/**
	 * List all the checkins of the city divided by time slot
	 */
	ArrayList<DataTimeSlot> listDataTimeSlot;

	/**
	 * @param cityName
	 * @param dataURL
	 */
	public DataAnalyzer(String cityName, String dataURL) {
		this.cityName = cityName;
		this.dataURL = dataURL;
		this.listDataTimeSlot = new ArrayList<DataTimeSlot>();
		loadData();
	}

	/**
	 * @param dataURL2
	 * @return
	 */
	private void loadData() {

		try {
			InputStream inputs = new FileInputStream(dataURL);
			InputStreamReader inputReader = new InputStreamReader(inputs);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(inputReader);
			String checkInString = br.readLine();
			while (checkInString != null) {
				classify(new CheckIn(checkInString));
				checkInString = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Some thing wrong!\n");
			e.printStackTrace();
		}

	}

	/**
	 * @param checkIn
	 * @throws Exception
	 */
	private void classify(CheckIn checkIn) throws Exception {
		int day = checkIn.getCheckInTime().getCityTime().getDayOfWeek();
		int hours = checkIn.getCheckInTime().getCityTime().getHourOfDay();

		TimeInDay timeInDay;
		DayInWeek dayInWeek;

		if (hours >= 0 && hours < 8)
			timeInDay = TimeInDay.AFTERNIGHT;
		else if (hours >= 8 && hours < 12)
			timeInDay = TimeInDay.MORNING;
		else if (hours >= 12 && hours < 18)
			timeInDay = TimeInDay.AFTERNOON;
		else if (hours >= 18 && hours <= 23)
			timeInDay = TimeInDay.NIGHT;
		else
			throw new Exception("The hours of day is invalid: " + hours);

		switch (day) {
		case 1:
			dayInWeek = DayInWeek.MON;
			break;
		case 2:
			dayInWeek = DayInWeek.TUE;
			break;
		case 3:
			dayInWeek = DayInWeek.WED;
			break;
		case 4:
			dayInWeek = DayInWeek.THU;
			break;
		case 5:
			dayInWeek = DayInWeek.FRI;
			break;
		case 6:
			dayInWeek = DayInWeek.SAT;
			break;
		case 7:
			dayInWeek = DayInWeek.SUN;
			break;
		default:
			throw new Exception("The day of week is invalid: " + day);
		}

		boolean existTimeSlot = false;
		for (int i = 0; i < listDataTimeSlot.size(); i++) {
			if (listDataTimeSlot.get(i).getTimeInDay() == timeInDay
					&& listDataTimeSlot.get(i).getDayInWeek() == dayInWeek) {
				existTimeSlot = true;
				listDataTimeSlot.get(i).addACheckIn(checkIn);
			}
		}

		if (!existTimeSlot) {
			DataTimeSlot newDataSlot = new DataTimeSlot(timeInDay, dayInWeek,cityName);
			newDataSlot.addACheckIn(checkIn);
			listDataTimeSlot.add(newDataSlot);
		}

	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	
	public void analyzer(){
		for(int i=0;i<listDataTimeSlot.size();i++){
			listDataTimeSlot.get(i).analyze(cityName);
		}
	}
}
