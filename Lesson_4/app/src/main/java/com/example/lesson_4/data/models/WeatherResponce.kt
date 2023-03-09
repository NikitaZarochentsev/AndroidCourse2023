package com.example.lesson_4.data.models

import com.squareup.moshi.Json

data class WeatherResponce(
    @field:Json(name = "location")
    var location: LocationResponce,
    @field:Json(name = "current")
    var current: CurrentResponce
)

data class LocationResponce(
    @field:Json(name = "name")
    var name: String,
    @field:Json(name = "region")
    var region: String,
    @field:Json(name = "country")
    var country: String,
    @field:Json(name = "lat")
    var lat: Double,
    @field:Json(name = "lon")
    var lon: Double,
    @field:Json(name = "tz_id")
    var tz_id: String,
    @field:Json(name = "localtime_epoch")
    var localtime_epoch: Int,
    @field:Json(name = "localtime")
    var localtime: String
)

data class CurrentResponce(
    @field:Json(name = "last_updated_epoch")
    var last_updated_epoch: Int,
    @field:Json(name = "last_updated")
    var last_updated: String,
    @field:Json(name = "temp_c")
    var temp_c: Double,
    @field:Json(name = "temp_f")
    var temp_f: Double,
    @field:Json(name = "is_day")
    var is_day: Int,
    @field:Json(name = "condition")
    var condition: ConditionResponce,
    @field:Json(name = "wind_mph")
    var wind_mph: Double,
    @field:Json(name = "wind_kph")
    var wind_kph: Double,
    @field:Json(name = "wind_degree")
    var wind_degree: Int,
    @field:Json(name = "wind_dir")
    var wind_dir: String,
    @field:Json(name = "pressure_mb")
    var pressure_mb: Double,
    @field:Json(name = "pressure_in")
    var pressure_in: Double,
    @field:Json(name = "precip_mm")
    var precip_mm: Double,
    @field:Json(name = "precip_in")
    var precip_in: Double,
    @field:Json(name = "humidity")
    var humidity: Int,
    @field:Json(name = "cloud")
    var cloud: Int,
    @field:Json(name = "feelslike_c")
    var feelslike_c: Double,
    @field:Json(name = "feelslike_f")
    var feelslike_f: Double,
    @field:Json(name = "vis_km")
    var vis_km: Double,
    @field:Json(name = "vis_miles")
    var vis_miles: Double,
    @field:Json(name = "uv")
    var uv: Double,
    @field:Json(name = "gust_mph")
    var gust_mph: Double,
    @field:Json(name = "gust_kph")
    var gust_kph: Double
)

data class ConditionResponce(
    @field:Json(name = "text")
    var text: String,
    @field:Json(name = "icon")
    var icon: String,
    @field:Json(name = "code")
    var code: Int
)