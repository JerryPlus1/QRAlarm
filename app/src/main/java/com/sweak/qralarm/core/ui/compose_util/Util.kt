package com.sweak.qralarm.core.ui.compose_util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sweak.qralarm.R
import com.sweak.qralarm.core.ui.model.AlarmRepeatingScheduleWrapper
import com.sweak.qralarm.core.ui.model.AlarmRepeatingScheduleWrapper.AlarmRepeatingMode
import java.time.DayOfWeek

// 扩展函数，将 DayOfWeek 映射为中文简称
fun DayOfWeek.shortChineseName(): String {
    return when (this) {
        DayOfWeek.MONDAY -> "周一"
        DayOfWeek.TUESDAY -> "周二"
        DayOfWeek.WEDNESDAY -> "周三"
        DayOfWeek.THURSDAY -> "周四"
        DayOfWeek.FRIDAY -> "周五"
        DayOfWeek.SATURDAY -> "周六"
        DayOfWeek.SUNDAY -> "周日"
    }
}

// 主函数，用于获取闹钟重复日程的显示字符串
@Composable
fun getAlarmRepeatingScheduleString(
    alarmRepeatingScheduleWrapper: AlarmRepeatingScheduleWrapper
): String {
    return when (alarmRepeatingScheduleWrapper.alarmRepeatingMode) {
        AlarmRepeatingMode.ONLY_ONCE -> stringResource(R.string.only_once)
        AlarmRepeatingMode.MON_FRI -> {
            DayOfWeek.MONDAY.shortChineseName() + " - " + DayOfWeek.FRIDAY.shortChineseName()
        }
        AlarmRepeatingMode.SAT_SUN -> {
            DayOfWeek.SATURDAY.shortChineseName() + ", " + DayOfWeek.SUNDAY.shortChineseName()
        }
        AlarmRepeatingMode.EVERYDAY -> stringResource(R.string.everyday)
        AlarmRepeatingMode.CUSTOM -> {
            val days = alarmRepeatingScheduleWrapper.alarmDaysOfWeek

            if (days.size == 1) {
                return days.first().shortChineseName()
            } else if (days.size == 2) {
                return days.joinToString { it.shortChineseName() }
            } else if (areAllDaysAfterOneAnother(days)) {
                return days.first().shortChineseName() + " - " + days.last().shortChineseName()
            } else {
                return days.joinToString { it.shortChineseName() }
            }
        }
    }
}

// 辅助函数，用于检查天数是否连续
private fun areAllDaysAfterOneAnother(days: List<DayOfWeek>): Boolean {
    days.forEachIndexed { index, day ->
        if (index == days.size - 1) return true
        if (days[index + 1].value - day.value != 1) return false
    }

    return false
}
