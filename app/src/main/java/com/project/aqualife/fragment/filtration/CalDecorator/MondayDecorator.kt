package com.project.aqualife.fragment.filtration.CalDecorator

import android.graphics.Color
import android.text.style.BackgroundColorSpan
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import java.util.*

class MondayDecorator(val i: Int) : DayViewDecorator {
    private val calendar = Calendar.getInstance()
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        day?.copyTo(calendar)
        val weekDay = calendar.get(Calendar.DAY_OF_WEEK)
        return weekDay == Calendar.MONDAY
    }
    override fun decorate(view: DayViewFacade?) {
        if(i == 0)
            view?.addSpan(object: BackgroundColorSpan(Color.WHITE){})
        else
            view?.addSpan(object: BackgroundColorSpan(Color.YELLOW){})
    }
}