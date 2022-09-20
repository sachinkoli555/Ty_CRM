package ty.crm.genricutility;


import java.util.Random;

/**
 * it consist all jav reusable
 * 
 * @author admin
 *
 */
public class javaUtility {

	public int getRandomNumber(int limit) {

		return new Random().nextInt(limit);
	}

	public Object convertToAnyDataType(String dataType, DataType statrgey) {
		Object obj = null;
		if (statrgey.toString().equalsIgnoreCase("long"))
			obj = Long.parseLong(dataType);
		else if (statrgey.toString().equalsIgnoreCase("int"))
			obj = Integer.parseInt(dataType);
		else if (statrgey.toString().equalsIgnoreCase("double"))
			obj = Double.parseDouble(dataType);
		return obj;

	}
//	public void dateformat() {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd_mm_yyyy_hh_mm_sss");
//		String actuldata = sdf.format(date);
//	}
}
