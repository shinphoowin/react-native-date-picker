package com.henninghall.date_picker.wheels;

import android.graphics.Paint;

import com.henninghall.date_picker.pickers.Picker;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.Utils;
import com.henninghall.date_picker.models.Mode;

import java.util.ArrayList;
import java.util.Calendar;

public class HourWheel extends Wheel {

    public HourWheel(Picker picker, State id) {
        super(picker, id);
    }

    @Override
    public ArrayList<String> getValues() {
        Calendar cal = Calendar.getInstance();
        ArrayList<String> values = new ArrayList<>();
        int numberOfHours = Utils.usesAmPm() ? 12 : 24;

        for(int i=0; i<numberOfHours; i++) {
            values.add(format.format(cal.getTime()));
            cal.add(Calendar.HOUR_OF_DAY, 1);
        }
        return values;
    }

    @Override
    public boolean visible() {
        return state.getMode() != Mode.date;
    }

    @Override
    public boolean wrapSelectorWheel() {
        return true;
    }

    @Override
    public String getFormatPattern() {
        return Utils.usesAmPm() ? "h": "HH";
    }

    @Override
    public Paint.Align getTextAlign() {
        return Paint.Align.RIGHT;
    }

}
