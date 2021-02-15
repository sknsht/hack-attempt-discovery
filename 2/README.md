# Coding task 2
Security asks for an analysis as to whether there were any successful logins from the offending IPs:
```
IP1: 57.48.9.100 
IP2: 2.21.107.254 
IP3: 130.25.179.252 
```
Provide the IP and number of successful logins from that IP.

## Input
Logs are inside a `dynatrace.log` file, which is located in the same directory.

## Output
List of strings formatted exactly as `"<N> successful logins from that <IP>"`. 

IP's in list should be in order as presented above.

## Succesful login example
```
INFO clientIp=130.25.179.252 userAgent=Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0 header=[Authorization:_Basic_ZTU4NmI3MTAtMzY1Yy00MWYAWFkN2ItNmQ0YzY5ZDYzYzAw] httpMethod=POST requestUrl=/dynatrace.com/login statusCode=200 userId=1481850e-ac07- 4a43-a155-b82c766aa07a
```
