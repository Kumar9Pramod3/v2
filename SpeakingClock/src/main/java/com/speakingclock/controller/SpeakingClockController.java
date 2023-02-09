package com.speakingclock.controller;

import com.speakingclock.exception.InvalidTimeException;
import com.speakingclock.service.SpeakingClockService;
import com.speakingclock.utility.TimeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/speakingclock")
public class SpeakingClockController {

    @Autowired
    SpeakingClockService speakingClockService;

    @Autowired
    TimeValidation timeValidation;

    @GetMapping("/{time}")
    public ResponseEntity<Object> speakingClock(@PathVariable String time) {
        try {
            timeValidation.validate(time);
            return new ResponseEntity<Object>(speakingClockService.convert(time), HttpStatus.OK);
        } catch (InvalidTimeException ex) {
            throw new InvalidTimeException("Error while converting time into word");
        } catch(RuntimeException ex){
            throw new InvalidTimeException("Error while converting time into word");
        }
    }
}
