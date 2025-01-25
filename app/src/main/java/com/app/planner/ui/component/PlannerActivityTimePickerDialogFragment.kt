package com.app.planner.ui.component

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.app.planner.R

class PlannerActivityTimePickerDialogFragment(
    private val onConfirm: (Int, Int) -> Unit,
    private val onCancel: () -> Unit
) : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            this,
            hour,
            minute,
            android.text.format.DateFormat.is24HourFormat(requireContext())
        )
    }

    fun TimePickerDialog.setupPlannerTimePicker(): TimePickerDialog =
        this.apply {
            window?.decorView?.setBackgroundColor(
                ContextCompat.getColor(requireContext(), R.color.lime_950)
            )
            setButton(
                Dialog.BUTTON_POSITIVE,
                getString(R.string.confirmar)
            ) { _, _ -> }

            setButton(
                Dialog.BUTTON_NEGATIVE,
                getString(R.string.cancelar)
            ) { _, _ ->
                onCancel()
            }
}

            override fun onTimeSet(
                view: TimePicker?,
                hourOfDay: Int,
                minute: Int
            ) {
                onConfirm(hourOfDay, minute)
            }
    companion object {
        const val TAG = "PlannerActivityTimePickerDialogFragment"

    }
        }