package com.project.aqualife.fragment.filtration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.FiltrationCalFragmentBinding
import com.project.aqualife.fragment.filtration.CalDecorator.*
import com.project.aqualife.viewModel.AuthViewModel
import com.project.aqualife.viewModel.DataViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import java.util.*

class FiltrationCalFragment : Fragment() {
    private var binding : FiltrationCalFragmentBinding? = null

    private lateinit var authViewModel : AuthViewModel
    private lateinit var dataViewModel : DataViewModel

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FiltrationCalFragmentBinding.inflate(inflater, container, false)

        val cal = binding!!.materialCalendar

        authViewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        dataViewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]

        var startTimeCalendar = Calendar.getInstance()
        val currentYear = startTimeCalendar.get(Calendar.YEAR)
        val currentMonth = startTimeCalendar.get(Calendar.MONTH)

        cal.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setMinimumDate(CalendarDay.from(currentYear, currentMonth, 1))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()

        dataViewModel.recentIndex.observe(requireActivity()){

            var dayCode = (activity as MainActivity).aquariumList[it].filtDayCode

            var dayCodeToken = dayCode.chunked(1)

            for(i: Int in 0..6) {
                if (dayCodeToken[i] == "1") {
                    when (i) {
                        0 -> cal.addDecorators(SundayDecorator(1))
                        1 -> cal.addDecorators(MondayDecorator(1))
                        2 -> cal.addDecorators(ThuesdayDecorator(1))
                        3 -> cal.addDecorators(WednesdayDecorator(1))
                        4 -> cal.addDecorators(ThursdayDecorator(1))
                        5 -> cal.addDecorators(FridayDecorator(1))
                        6 -> cal.addDecorators(SaturdayDecorator(1))
                    }
                }
            }
        }

        authViewModel.aquariumData.observe(requireActivity()) {
            var dayCode = it[0].filtDayCode

            var dayCodeToken = dayCode.chunked(1)

            for(i: Int in 0..6) {
                if (dayCodeToken[i] == "1") {
                    when (i) {
                        0 -> cal.addDecorators(SundayDecorator(1))
                        1 -> cal.addDecorators(MondayDecorator(1))
                        2 -> cal.addDecorators(ThuesdayDecorator(1))
                        3 -> cal.addDecorators(WednesdayDecorator(1))
                        4 -> cal.addDecorators(ThursdayDecorator(1))
                        5 -> cal.addDecorators(FridayDecorator(1))
                        6 -> cal.addDecorators(SaturdayDecorator(1))
                    }
                }else {
                    when (i) {
                        0 -> cal.addDecorators(SundayDecorator(0))
                        1 -> cal.addDecorators(MondayDecorator(0))
                        2 -> cal.addDecorators(ThuesdayDecorator(0))
                        3 -> cal.addDecorators(WednesdayDecorator(0))
                        4 -> cal.addDecorators(ThursdayDecorator(0))
                        5 -> cal.addDecorators(FridayDecorator(0))
                        6 -> cal.addDecorators(SaturdayDecorator(0))
                    }
                }
            }

        }
        return binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}