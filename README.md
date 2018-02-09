# OpenWeatherMap API Java Wrapper

![logo_OpenWeatherMap_orange.svg](/images/logo_OpenWeatherMap_orange.svg)

오픈웨더맵 API 자바 Wrapper 

## 라이브러리
- retrofit2와 lombok 사용.
```
Java 1.8
retrofit2
lombok
```

## 사용
```
// 서울
double LATITUDE = 37.56667;
double LONGITUDE = 126.97806;

OpenWeatherMap openWeatherMap = new OpenWeatherMap("API_KEY");
CurrentWeatherInfo currentWeatherInfo = openWeatherMap.getCurrentWeatherByGeo(LATITUDE, LONGITUDE);    
ForecastWeatherInfo forecastWeatherInfo = openWeatherMap.getForecastWeatherByGeo(LATITUDE, LONGITUDE);
```

## 참고
1. 오픈웨더맵 API
- https://openweathermap.org/api

2. retorfit 한글문서
- http://devflow.github.io/retrofit-kr/

3. Project Lombok
- https://projectlombok.org/
