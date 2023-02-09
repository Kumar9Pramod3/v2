package com.speakingclock.service;

import com.speakingclock.exception.InvalidTimeException;
import com.speakingclock.utility.Constant;
import org.springframework.stereotype.Service;

@Service
public class SpeakingClockService {
    public String convert(String time) throws InvalidTimeException {

        StringBuilder sb = new StringBuilder("It's ");

        if(time.equals("00:00")) {
            sb.append("Midnight");
        } else if(time.equals("12:00")) {
            sb.append("Midday");
        } else {
            String[] timeSplit = time.split(":");
            Integer hours = Integer.parseInt(timeSplit[0]);
            String hoursStr = this.convertInt(hours);
            sb.append(hoursStr + " ");

            Integer minutes = Integer.parseInt(timeSplit[1]);
            String minutesStr = this.convertInt(minutes);
            sb.append(minutesStr);
        }
        return sb.toString();
    }

    private String convertInt(final Integer number) {
        if(number < 20) return Constant.UNITS_ARRAY[number];
        return Constant.TENS_ARRAY[number/10] + ((number % 10 > 0) ? " " + convertInt(number % 10):"");
    }
}
