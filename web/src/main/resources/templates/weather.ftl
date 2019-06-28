<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Weather</title>
</head>
<body>
<div align="center">
    <h1>Weather</h1>
    <p>From <a href="${service}">worldweatheronline</a></p>
    <h3>Time UTC: ${time}</h3>
    <table style="line-height: 30px;">
        <tr>
            <th>City</th>
            <th>Temperature</th>
            <th>Humidity</th>
            <th>Wind speed (kmph)</th>
            <th>Pressure</th>
            <th>Description</th>
        </tr>
        <#list weathers as weather>
            <tr align="center">
                <td>${weather.city}</td>
                <td style="border-left: solid 1px;">${weather.temp}</td>
                <td style="border-left: solid 1px;">${weather.humidity}</td>
                <td style="border-left: solid 1px;">${weather.windSpeedKmph}</td>
                <td style="border-left: solid 1px;">${weather.pressure}</td>
                <td style="border-left: solid 1px;">${weather.weatherDesc}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
