package com.speakingclock.utility;

import com.speakingclock.exception.InvalidTimeException;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TimeValidation {

    public void validate(final String time) throws InvalidTimeException {

        if(StringUtils.isBlank(time)) {
            throw new InvalidTimeException("Time is blank");
        }


        if(time.length() != 5 || !time.contains(":")) {
            throw new InvalidTimeException("Invalid Time format, should be HH:mm");
        }

        String[] timeSplit = time.split(":");


        Integer hours = Integer.valueOf(0);
        try {
            hours = Integer.parseInt(timeSplit[0]);
        } catch(NumberFormatException e) {
            throw new InvalidTimeException("Invalid Hours");
        }

        if(hours < 0 || hours > 23) {
            throw new InvalidTimeException("Invalid Hours");
        }

        Integer minutes = Integer.valueOf(0);
        try {
            minutes = Integer.parseInt(timeSplit[1]);
        } catch(NumberFormatException e) {
            throw new InvalidTimeException("Invalid Minutes");
        }

        if(minutes < 0 || minutes > 59) {
            throw new InvalidTimeException("Invalid Minutes");
        }
    }
}
