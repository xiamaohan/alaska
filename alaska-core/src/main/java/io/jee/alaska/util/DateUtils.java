package io.jee.alaska.util;

import java.util.Date;

public class DateUtils {
	
    /**
	 * 由过去的某一时间,计算距离当前的时间
	 */
	public static String pastTime(Date setTime) {
		if(setTime==null) {
			return "";
		}
		long nowTime = System.currentTimeMillis(); // 获取当前时间的毫秒数
		String msg = null;
		long reset = setTime.getTime(); // 获取指定时间的毫秒数
		long dateDiff = nowTime - reset;
		if (dateDiff < 0) {
			msg = "date error";
		} else {
			long dateTemp1 = dateDiff / 1000; // 秒
			long dateTemp2 = dateTemp1 / 60; // 分钟
			long dateTemp3 = dateTemp2 / 60; // 小时
			long dateTemp4 = dateTemp3 / 24; // 天数
			long dateTemp5 = dateTemp4 / 30; // 月数
			long dateTemp6 = dateTemp5 / 12; // 年数
			if (dateTemp6 > 0) {
				msg = dateTemp6 + " years ago";
			} else if (dateTemp5 > 0) {
				msg = dateTemp5 + " months ago";
			} else if (dateTemp4 > 0) {
				msg = dateTemp4 + " days ago";
			} else if (dateTemp3 > 0) {
				msg = dateTemp3 + " hours ago";
			} else if (dateTemp2 > 0) {
				msg = dateTemp2 + " minutes ago";
			} else if (dateTemp1 > 0) {
				msg = "just now";
			}
		}
		return msg;
	}

}
