# MathAPI

A webserver application based in Java EE 8 providing calculations based on lists of values



## API List:

/api/math-api/avg
  - Given a list of values, returns the average value

/api/math-api/median
 - Given a list of values, returns the median value

/api/math-api/percentile
  - Given a list of values and a quantifier, returns the nearest rank percentile

/api/math-api/max
  - Given a list of values and a quantifier, returns the maxiumum value

/api/math-api/min
  - Given a list of values and a quantifier, returns the minimum value



## Testing:

JUNIT tests used to test the calculations using known correct results. API's were manually tested in this instance using a REST Client and the browser



## Future Improvements:
- Better error handling in calcualtion service incase of rogue values along with more response codes
- Test harness for APIs
- Add API documentation such as Swagger
