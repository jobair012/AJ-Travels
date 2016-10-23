package team.fibonacci.aj_travels.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonService {

	public static Timestamp getTimestampFromString(String date) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = formatter.parse(date);		
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		
		return timestamp;
	}
}
