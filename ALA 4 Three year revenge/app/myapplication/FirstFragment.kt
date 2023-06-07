package com.example.myapplication

import GridRVAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.google.gson.Gson
import org.json.JSONObject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val app = AppRepository

    lateinit var courseGRV: GridView
    lateinit var courseList: ArrayList<Device>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseList = ArrayList<Device>()

        val json = "{\"topic\":\"devices\",\"payload\":[{\"definition\":null,\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[],\"clusters\":{\"input\":[\"genBasic\",\"genIdentify\",\"genOnOff\",\"genTime\",\"genOta\",\"26\",\"lightingColorCtrl\"],\"output\":[\"genBasic\",\"genIdentify\",\"genGroups\",\"genScenes\",\"genOnOff\",\"genLevelCtrl\",\"genPollCtrl\",\"lightingColorCtrl\",\"msIlluminanceMeasurement\",\"msTemperatureMeasurement\",\"msRelativeHumidity\",\"msOccupancySensing\",\"ssIasZone\",\"haMeterIdentification\",\"haApplianceStatistics\",\"haElectricalMeasurement\",\"seMetering\",\"touchlink\",\"manuSpecificUbisysDimmerSetup\",\"manuSpecificSamsungAccelerometer\"]},\"configured_reportings\":[],\"scenes\":[]},\"242\":{\"bindings\":[],\"clusters\":{\"input\":[],\"output\":[\"greenPower\"]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"Coordinator\",\"ieee_address\":\"0xdc8e95fffe2582a9\",\"interview_completed\":true,\"interviewing\":false,\"network_address\":0,\"supported\":false,\"type\":\"Coordinator\"},{\"date_code\":\"20220816\",\"definition\":{\"description\":\"TRADFRI LED bulb E14\\/E26\\/E27 600 lumen, dimmable, color, opal white\",\"exposes\":[{\"features\":[{\"access\":7,\"description\":\"On\\/off state of this light\",\"name\":\"state\",\"property\":\"state\",\"type\":\"binary\",\"value_off\":\"OFF\",\"value_on\":\"ON\",\"value_toggle\":\"TOGGLE\"},{\"access\":7,\"description\":\"Brightness of this light\",\"name\":\"brightness\",\"property\":\"brightness\",\"type\":\"numeric\",\"value_max\":254,\"value_min\":0},{\"access\":7,\"description\":\"Color temperature of this light\",\"name\":\"color_temp\",\"presets\":[{\"description\":\"Coolest temperature supported\",\"name\":\"coolest\",\"value\":250},{\"description\":\"Cool temperature (250 mireds \\/ 4000 Kelvin)\",\"name\":\"cool\",\"value\":250},{\"description\":\"Neutral temperature (370 mireds \\/ 2700 Kelvin)\",\"name\":\"neutral\",\"value\":370},{\"description\":\"Warm temperature (454 mireds \\/ 2200 Kelvin)\",\"name\":\"warm\",\"value\":454},{\"description\":\"Warmest temperature supported\",\"name\":\"warmest\",\"value\":454}],\"property\":\"color_temp\",\"type\":\"numeric\",\"unit\":\"mired\",\"value_max\":454,\"value_min\":250},{\"access\":7,\"description\":\"Color of this light in the CIE 1931 color space (x\\/y)\",\"features\":[{\"access\":7,\"name\":\"x\",\"property\":\"x\",\"type\":\"numeric\"},{\"access\":7,\"name\":\"y\",\"property\":\"y\",\"type\":\"numeric\"}],\"name\":\"color_xy\",\"property\":\"color\",\"type\":\"composite\"}],\"type\":\"light\"},{\"access\":2,\"description\":\"Triggers an effect on the light (e.g. make light blink for a few seconds)\",\"name\":\"effect\",\"property\":\"effect\",\"type\":\"enum\",\"values\":[\"blink\",\"breathe\",\"okay\",\"channel_change\",\"finish_effect\",\"stop_effect\"]},{\"access\":7,\"description\":\"Controls the behavior when the device is powered on after power loss\",\"name\":\"power_on_behavior\",\"property\":\"power_on_behavior\",\"type\":\"enum\",\"values\":[\"off\",\"on\",\"toggle\",\"previous\"]},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"LED1624G9\",\"options\":[{\"access\":2,\"description\":\"Controls the transition time (in seconds) of on\\/off, brightness, color temperature (if applicable) and color (if applicable) changes. Defaults to `0` (no transition).\",\"name\":\"transition\",\"property\":\"transition\",\"type\":\"numeric\",\"value_min\":0},{\"access\":2,\"description\":\"When enabled colors will be synced, e.g. if the light supports both color x\\/y and color temperature a conversion from color x\\/y to color temperature will be done when setting the x\\/y color (default true).\",\"name\":\"color_sync\",\"property\":\"color_sync\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true},{\"access\":2,\"description\":\"State actions will also be published as 'action' when true (default false).\",\"name\":\"state_action\",\"property\":\"state_action\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true}],\"supports_ota\":true,\"vendor\":\"IKEA\"},\"description\":\"eenvoudige naam was: 0x000b57fffe9c325b\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[],\"clusters\":{\"input\":[\"genBasic\",\"genIdentify\",\"genGroups\",\"genScenes\",\"genOnOff\",\"genLevelCtrl\",\"lightingColorCtrl\",\"haDiagnostic\",\"touchlink\"],\"output\":[\"genScenes\",\"genOta\",\"genPollCtrl\",\"touchlink\"]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"woonkamer\\/schemerlamp\",\"ieee_address\":\"0x000b57fffe9c325b\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"IKEA of Sweden\",\"model_id\":\"TRADFRI bulb E27 CWS opal 600lm\",\"network_address\":51468,\"power_source\":\"Mains (single phase)\",\"software_build_id\":\"2.3.093\",\"supported\":true,\"type\":\"Router\"},{\"definition\":{\"description\":\"Aqara temperature, humidity and pressure sensor\",\"exposes\":[{\"access\":1,\"description\":\"Remaining battery in %, can take up to 24 hours before reported.\",\"name\":\"battery\",\"property\":\"battery\",\"type\":\"numeric\",\"unit\":\"%\",\"value_max\":100,\"value_min\":0},{\"access\":1,\"description\":\"Measured temperature value\",\"name\":\"temperature\",\"property\":\"temperature\",\"type\":\"numeric\",\"unit\":\"\\u00b0C\"},{\"access\":1,\"description\":\"Measured relative humidity\",\"name\":\"humidity\",\"property\":\"humidity\",\"type\":\"numeric\",\"unit\":\"%\"},{\"access\":1,\"description\":\"The measured atmospheric pressure\",\"name\":\"pressure\",\"property\":\"pressure\",\"type\":\"numeric\",\"unit\":\"hPa\"},{\"access\":1,\"description\":\"Voltage of the battery in millivolts\",\"name\":\"voltage\",\"property\":\"voltage\",\"type\":\"numeric\",\"unit\":\"mV\"},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"WSDCGQ11LM\",\"options\":[{\"access\":2,\"description\":\"Calibrates the temperature value (absolute offset), takes into effect on next report of device.\",\"name\":\"temperature_calibration\",\"property\":\"temperature_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for temperature, takes into effect on next report of device.\",\"name\":\"temperature_precision\",\"property\":\"temperature_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the pressure value (absolute offset), takes into effect on next report of device.\",\"name\":\"pressure_calibration\",\"property\":\"pressure_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for pressure, takes into effect on next report of device.\",\"name\":\"pressure_precision\",\"property\":\"pressure_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Number of digits after decimal point for humidity, takes into effect on next report of device.\",\"name\":\"humidity_precision\",\"property\":\"humidity_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the humidity value (absolute offset), takes into effect on next report of device.\",\"name\":\"humidity_calibration\",\"property\":\"humidity_calibration\",\"type\":\"numeric\"}],\"supports_ota\":false,\"vendor\":\"Xiaomi\"},\"description\":\"0x00158d00032141ce\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[],\"clusters\":{\"input\":[],\"output\":[]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"woonkamer\\/klimaat\",\"ieee_address\":\"0x00158d00032141ce\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"LUMI\",\"model_id\":\"lumi.weather\",\"network_address\":42866,\"power_source\":\"Battery\",\"supported\":true,\"type\":\"EndDevice\"},{\"date_code\":\"20211118\",\"definition\":{\"description\":\"TRADFRI control outlet\",\"exposes\":[{\"features\":[{\"access\":7,\"description\":\"On\\/off state of the switch\",\"name\":\"state\",\"property\":\"state\",\"type\":\"binary\",\"value_off\":\"OFF\",\"value_on\":\"ON\",\"value_toggle\":\"TOGGLE\"}],\"type\":\"switch\"},{\"access\":7,\"description\":\"Controls the behavior when the device is powered on after power loss\",\"name\":\"power_on_behavior\",\"property\":\"power_on_behavior\",\"type\":\"enum\",\"values\":[\"off\",\"on\",\"toggle\",\"previous\"]},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"E1603\\/E1702\\/E1708\",\"options\":[{\"access\":2,\"description\":\"State actions will also be published as 'action' when true (default false).\",\"name\":\"state_action\",\"property\":\"state_action\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true}],\"supports_ota\":true,\"vendor\":\"IKEA\"},\"description\":\"vloerlamp hal\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[{\"cluster\":\"genOnOff\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}}],\"clusters\":{\"input\":[\"genBasic\",\"genIdentify\",\"genGroups\",\"genScenes\",\"genOnOff\",\"genLevelCtrl\",\"touchlink\"],\"output\":[\"genScenes\",\"genOta\",\"genPollCtrl\",\"touchlink\"]},\"configured_reportings\":[{\"attribute\":\"onOff\",\"cluster\":\"genOnOff\",\"maximum_report_interval\":3600,\"minimum_report_interval\":0,\"reportable_change\":0}],\"scenes\":[]},\"242\":{\"bindings\":[],\"clusters\":{\"input\":[\"greenPower\"],\"output\":[\"greenPower\"]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"hal\\/smart_plug\",\"ieee_address\":\"0x000d6ffffedd8fd5\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"IKEA of Sweden\",\"model_id\":\"TRADFRI control outlet\",\"network_address\":35996,\"power_source\":\"Mains (single phase)\",\"software_build_id\":\"2.3.089\",\"supported\":true,\"type\":\"Router\"},{\"date_code\":\"NULL\",\"definition\":{\"description\":\"Zigbee smart plug\",\"exposes\":[{\"access\":1,\"description\":\"Instantaneous measured power\",\"name\":\"power\",\"property\":\"power\",\"type\":\"numeric\",\"unit\":\"W\"},{\"access\":1,\"description\":\"Instantaneous measured electrical current\",\"name\":\"current\",\"property\":\"current\",\"type\":\"numeric\",\"unit\":\"A\"},{\"access\":1,\"description\":\"Measured electrical potential value\",\"name\":\"voltage\",\"property\":\"voltage\",\"type\":\"numeric\",\"unit\":\"V\"},{\"features\":[{\"access\":7,\"description\":\"On\\/off state of the switch\",\"name\":\"state\",\"property\":\"state\",\"type\":\"binary\",\"value_off\":\"OFF\",\"value_on\":\"ON\",\"value_toggle\":\"TOGGLE\"}],\"type\":\"switch\"},{\"access\":1,\"description\":\"Sum of consumed energy\",\"name\":\"energy\",\"property\":\"energy\",\"type\":\"numeric\",\"unit\":\"kWh\"},{\"access\":1,\"description\":\"Measured temperature value\",\"name\":\"temperature\",\"property\":\"temperature\",\"type\":\"numeric\",\"unit\":\"\\u00b0C\"},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"ROB_200-017-0\",\"options\":[{\"access\":2,\"description\":\"Calibrates the power value (percentual offset), takes into effect on next report of device.\",\"name\":\"power_calibration\",\"property\":\"power_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for power, takes into effect on next report of device.\",\"name\":\"power_precision\",\"property\":\"power_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the current value (percentual offset), takes into effect on next report of device.\",\"name\":\"current_calibration\",\"property\":\"current_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for current, takes into effect on next report of device.\",\"name\":\"current_precision\",\"property\":\"current_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the voltage value (percentual offset), takes into effect on next report of device.\",\"name\":\"voltage_calibration\",\"property\":\"voltage_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for voltage, takes into effect on next report of device.\",\"name\":\"voltage_precision\",\"property\":\"voltage_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"State actions will also be published as 'action' when true (default false).\",\"name\":\"state_action\",\"property\":\"state_action\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true},{\"access\":2,\"description\":\"Number of digits after decimal point for energy, takes into effect on next report of device.\",\"name\":\"energy_precision\",\"property\":\"energy_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the energy value (percentual offset), takes into effect on next report of device.\",\"name\":\"energy_calibration\",\"property\":\"energy_calibration\",\"type\":\"numeric\"},{\"access\":2,\"description\":\"Number of digits after decimal point for temperature, takes into effect on next report of device.\",\"name\":\"temperature_precision\",\"property\":\"temperature_precision\",\"type\":\"numeric\",\"value_max\":3,\"value_min\":0},{\"access\":2,\"description\":\"Calibrates the temperature value (absolute offset), takes into effect on next report of device.\",\"name\":\"temperature_calibration\",\"property\":\"temperature_calibration\",\"type\":\"numeric\"}],\"supports_ota\":false,\"vendor\":\"ROBB\"},\"description\":\"vloerlamp\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[{\"cluster\":\"genOnOff\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}},{\"cluster\":\"haElectricalMeasurement\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}},{\"cluster\":\"seMetering\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}},{\"cluster\":\"msTemperatureMeasurement\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}}],\"clusters\":{\"input\":[\"genBasic\",\"genIdentify\",\"genGroups\",\"genScenes\",\"genOnOff\",\"msTemperatureMeasurement\",\"seMetering\",\"haElectricalMeasurement\",\"haDiagnostic\",\"touchlink\",\"manuSpecificClusterAduroSmart\"],\"output\":[\"genIdentify\",\"genOta\"]},\"configured_reportings\":[{\"attribute\":\"onOff\",\"cluster\":\"genOnOff\",\"maximum_report_interval\":3600,\"minimum_report_interval\":0,\"reportable_change\":0},{\"attribute\":\"rmsVoltage\",\"cluster\":\"haElectricalMeasurement\",\"maximum_report_interval\":3600,\"minimum_report_interval\":5,\"reportable_change\":1},{\"attribute\":\"rmsCurrent\",\"cluster\":\"haElectricalMeasurement\",\"maximum_report_interval\":3600,\"minimum_report_interval\":5,\"reportable_change\":1},{\"attribute\":\"activePower\",\"cluster\":\"haElectricalMeasurement\",\"maximum_report_interval\":3600,\"minimum_report_interval\":5,\"reportable_change\":1},{\"attribute\":\"measuredValue\",\"cluster\":\"msTemperatureMeasurement\",\"maximum_report_interval\":3600,\"minimum_report_interval\":10,\"reportable_change\":100},{\"attribute\":\"currentSummDelivered\",\"cluster\":\"seMetering\",\"maximum_report_interval\":3600,\"minimum_report_interval\":5,\"reportable_change\":[1,1]}],\"scenes\":[]},\"242\":{\"bindings\":[],\"clusters\":{\"input\":[\"greenPower\"],\"output\":[\"greenPower\"]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"woonkamer\\/smart_plug\",\"ieee_address\":\"0x9035eafffe5f8d34\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"ROBB smarrt\",\"model_id\":\"ROB_200-017-0\",\"network_address\":14266,\"power_source\":\"Mains (single phase)\",\"software_build_id\":\"2.5.3_r7\",\"supported\":true,\"type\":\"Router\"},{\"date_code\":\"20190308\",\"definition\":{\"description\":\"TRADFRI motion sensor\",\"exposes\":[{\"access\":1,\"description\":\"Remaining battery in %, can take up to 24 hours before reported.\",\"name\":\"battery\",\"property\":\"battery\",\"type\":\"numeric\",\"unit\":\"%\",\"value_max\":100,\"value_min\":0},{\"access\":1,\"description\":\"Indicates whether the device detected occupancy\",\"name\":\"occupancy\",\"property\":\"occupancy\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true},{\"access\":1,\"name\":\"requested_brightness_level\",\"property\":\"requested_brightness_level\",\"type\":\"numeric\",\"value_max\":254,\"value_min\":76},{\"access\":1,\"name\":\"requested_brightness_percent\",\"property\":\"requested_brightness_percent\",\"type\":\"numeric\",\"value_max\":100,\"value_min\":30},{\"access\":1,\"description\":\"Indicates whether the device detected bright light (works only in night mode)\",\"name\":\"illuminance_above_threshold\",\"property\":\"illuminance_above_threshold\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"E1525\\/E1745\",\"options\":[{\"access\":2,\"description\":\"Time in seconds after which occupancy is cleared after detecting it (default 90 seconds).\",\"name\":\"occupancy_timeout\",\"property\":\"occupancy_timeout\",\"type\":\"numeric\",\"value_min\":0},{\"access\":2,\"description\":\"Set to false to also send messages when illuminance is above threshold in night mode (default true).\",\"name\":\"illuminance_below_threshold_check\",\"property\":\"illuminance_below_threshold_check\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true}],\"supports_ota\":true,\"vendor\":\"IKEA\"},\"description\":\"bewegingsmelder hal\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[{\"cluster\":\"genPollCtrl\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}},{\"cluster\":\"genPowerCfg\",\"target\":{\"endpoint\":1,\"ieee_address\":\"0xdc8e95fffe2582a9\",\"type\":\"endpoint\"}}],\"clusters\":{\"input\":[\"genBasic\",\"genPowerCfg\",\"genIdentify\",\"genAlarms\",\"genPollCtrl\",\"touchlink\",\"64636\"],\"output\":[\"genIdentify\",\"genGroups\",\"genOnOff\",\"genLevelCtrl\",\"genOta\",\"touchlink\"]},\"configured_reportings\":[{\"attribute\":\"batteryPercentageRemaining\",\"cluster\":\"genPowerCfg\",\"maximum_report_interval\":62000,\"minimum_report_interval\":3600,\"reportable_change\":0}],\"scenes\":[]}},\"friendly_name\":\"hal\\/beweging\",\"ieee_address\":\"0xbc33acfffe870f53\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"IKEA of Sweden\",\"model_id\":\"TRADFRI motion sensor\",\"network_address\":51281,\"power_source\":\"Battery\",\"software_build_id\":\"2.0.022\",\"supported\":true,\"type\":\"EndDevice\"},{\"date_code\":\"20211102\",\"definition\":{\"description\":\"TRADFRI LED bulb E12\\/E14 400 lumen, dimmable, white spectrum, opal white\",\"exposes\":[{\"features\":[{\"access\":7,\"description\":\"On\\/off state of this light\",\"name\":\"state\",\"property\":\"state\",\"type\":\"binary\",\"value_off\":\"OFF\",\"value_on\":\"ON\",\"value_toggle\":\"TOGGLE\"},{\"access\":7,\"description\":\"Brightness of this light\",\"name\":\"brightness\",\"property\":\"brightness\",\"type\":\"numeric\",\"value_max\":254,\"value_min\":0},{\"access\":7,\"description\":\"Color temperature of this light\",\"name\":\"color_temp\",\"presets\":[{\"description\":\"Coolest temperature supported\",\"name\":\"coolest\",\"value\":250},{\"description\":\"Cool temperature (250 mireds \\/ 4000 Kelvin)\",\"name\":\"cool\",\"value\":250},{\"description\":\"Neutral temperature (370 mireds \\/ 2700 Kelvin)\",\"name\":\"neutral\",\"value\":370},{\"description\":\"Warm temperature (454 mireds \\/ 2200 Kelvin)\",\"name\":\"warm\",\"value\":454},{\"description\":\"Warmest temperature supported\",\"name\":\"warmest\",\"value\":454}],\"property\":\"color_temp\",\"type\":\"numeric\",\"unit\":\"mired\",\"value_max\":454,\"value_min\":250},{\"access\":7,\"description\":\"Color temperature after cold power on of this light\",\"name\":\"color_temp_startup\",\"presets\":[{\"description\":\"Coolest temperature supported\",\"name\":\"coolest\",\"value\":250},{\"description\":\"Cool temperature (250 mireds \\/ 4000 Kelvin)\",\"name\":\"cool\",\"value\":250},{\"description\":\"Neutral temperature (370 mireds \\/ 2700 Kelvin)\",\"name\":\"neutral\",\"value\":370},{\"description\":\"Warm temperature (454 mireds \\/ 2200 Kelvin)\",\"name\":\"warm\",\"value\":454},{\"description\":\"Warmest temperature supported\",\"name\":\"warmest\",\"value\":454},{\"description\":\"Restore previous color_temp on cold power on\",\"name\":\"previous\",\"value\":65535}],\"property\":\"color_temp_startup\",\"type\":\"numeric\",\"unit\":\"mired\",\"value_max\":454,\"value_min\":250}],\"type\":\"light\"},{\"access\":2,\"description\":\"Triggers an effect on the light (e.g. make light blink for a few seconds)\",\"name\":\"effect\",\"property\":\"effect\",\"type\":\"enum\",\"values\":[\"blink\",\"breathe\",\"okay\",\"channel_change\",\"finish_effect\",\"stop_effect\"]},{\"access\":7,\"description\":\"Controls the behavior when the device is powered on after power loss\",\"name\":\"power_on_behavior\",\"property\":\"power_on_behavior\",\"type\":\"enum\",\"values\":[\"off\",\"on\",\"toggle\",\"previous\"]},{\"access\":1,\"description\":\"Link quality (signal strength)\",\"name\":\"linkquality\",\"property\":\"linkquality\",\"type\":\"numeric\",\"unit\":\"lqi\",\"value_max\":255,\"value_min\":0}],\"model\":\"LED1536G5\",\"options\":[{\"access\":2,\"description\":\"Controls the transition time (in seconds) of on\\/off, brightness, color temperature (if applicable) and color (if applicable) changes. Defaults to `0` (no transition).\",\"name\":\"transition\",\"property\":\"transition\",\"type\":\"numeric\",\"value_min\":0},{\"access\":2,\"description\":\"When enabled colors will be synced, e.g. if the light supports both color x\\/y and color temperature a conversion from color x\\/y to color temperature will be done when setting the x\\/y color (default true).\",\"name\":\"color_sync\",\"property\":\"color_sync\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true},{\"access\":2,\"description\":\"State actions will also be published as 'action' when true (default false).\",\"name\":\"state_action\",\"property\":\"state_action\",\"type\":\"binary\",\"value_off\":false,\"value_on\":true}],\"supports_ota\":true,\"vendor\":\"IKEA\"},\"description\":\"licht keuken\",\"disabled\":false,\"endpoints\":{\"1\":{\"bindings\":[],\"clusters\":{\"input\":[\"genBasic\",\"genIdentify\",\"genGroups\",\"genScenes\",\"genOnOff\",\"genLevelCtrl\",\"lightingColorCtrl\",\"touchlink\",\"64636\"],\"output\":[\"genScenes\",\"genOta\",\"genPollCtrl\",\"touchlink\"]},\"configured_reportings\":[],\"scenes\":[]},\"242\":{\"bindings\":[],\"clusters\":{\"input\":[],\"output\":[\"greenPower\"]},\"configured_reportings\":[],\"scenes\":[]}},\"friendly_name\":\"keuken\\/licht\",\"ieee_address\":\"0x000b57fffec5b893\",\"interview_completed\":true,\"interviewing\":false,\"manufacturer\":\"IKEA of Sweden\",\"model_id\":\"TRADFRI bulb E14 WS opal 400lm\",\"network_address\":676,\"power_source\":\"Mains (single phase)\",\"software_build_id\":\"2.3.087\",\"supported\":true,\"type\":\"Router\"}]}"

        val dat = JSONObject(json)
        val datarray = dat.getJSONArray("payload")
        val accesArray = ArrayList<Access>()
        for (i in 0 until datarray.length()) {
            val payload = datarray.getJSONObject(i)

            val friendlyName = payload.getString("friendly_name")
            val ieee = payload.getString("ieee_address")

            Log.d("friendlyname", "" + friendlyName + "  " + ieee)


            if(payload.has("definition") && !payload.isNull("definition")){
                val defenition = payload.getJSONObject("definition")
                val exposes = defenition.getJSONArray("exposes")
                for (i in 0 until exposes.length()) {
                    val features = exposes.getJSONObject(i)

                    val gson = Gson()
                    var acc = Access()
                    if(features.has("features") && !features.isNull("features")){
                        val featureArray = features.getJSONArray("features")
                        val featureObj = featureArray.getJSONObject(0)
                        accesArray.add(gson.fromJson(featureObj.toString(), Access::class.java))
                    }
                    else{
                        val access = exposes.getJSONObject(i)
                        accesArray.add(gson.fromJson(access.toString(), Access::class.java))
                    }
                }
                val dev = Device(friendlyName, ieee, accesArray)
                Log.d("device", "dev " + dev)
                courseList.add(dev)

            }

        }

        Log.d("device", "cours  " + courseList.count())

        // initializing variables of grid view with their ids.
        courseGRV = binding.idGRV


//         on below line we are initializing our course adapter
//         and passing course list and context.
        val courseAdapter = GridRVAdapter(courseList, requireContext())

        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter

        // on below line we are adding on item
        // click listener for our grid view.
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)


//            Toast.makeText(
//                requireContext(), courseList[position].devicename + " selected",
//                Toast.LENGTH_SHORT
//            ).show()
        }

//        val eventSourceListener = object : EventSourceListener() {
//            override fun onOpen(eventSource: EventSource, response: Response) {
//                super.onOpen(eventSource, response)
//                Log.d(ContentValues.TAG, "Connection Opened")
//            }
//
//            override fun onClosed(eventSource: EventSource) {
//                super.onClosed(eventSource)
//                Log.d(ContentValues.TAG, "Connection Closed")
//            }
//
//            override fun onEvent(
//                eventSource: EventSource,
//                id: String?,
//                type: String?,
//                data: String
//            ) {
//                super.onEvent(eventSource, id, type, data)
//                Log.d(ContentValues.TAG, "On Event Received! Data -: $data")
//
//                val test = "{a: 3, b:4}"
//                val gson = Gson()
//
//                val json = JSONObject(test) // String instance holding the above json
//                val status = json.getInt("a")
//
//                Log.d("test","status = " + status)
//
////                val mDevices = gson.fromJson(data, ExampleJson2KtKotlin::class.java)
////
////                if(mDevices.topic == "devices"){
////                    Log.d("test","this is a device")
////                }else {
////                    Log.d("test", "geen device")
////                }
//
//
//            }
//
//            override fun onFailure(eventSource: EventSource, t: Throwable?, response: Response?) {
//                super.onFailure(eventSource, t, response)
//                Log.d(ContentValues.TAG, "On Failure -: ${response?.body}")
//            }
//        }
//
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
//
//        EventSources.createFactory(app.client)
//            .newEventSource(request = app.request, listener = eventSourceListener)
//
//        lifecycleScope.launchWhenCreated {
//            withContext(Dispatchers.IO) {
//                app.client.newCall(app.request).enqueue(responseCallback = object : Callback {
//                    override fun onFailure(call: Call, e: IOException) {
//                        Log.e(TAG, "API Call Failure ${e.localizedMessage}")
//                    }
//
//                    override fun onResponse(call: Call, response: Response) {
//                        Log.d(TAG, "APi Call Success ${response.body.toString()}")
//                    }
//                })
//            }
//        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}