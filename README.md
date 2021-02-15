# Dynatrace Hack Attempt Discovery Hiring Challenge

This repository contains solutions to programming tasks that were the first stage of the [Dynatrace Hack Attempt Discovery Hiring Challenge](https://challengerocket.com/hack-attempt-discovery/).

This challenge consisted of two stages:
1. Solving programming tasks (~ 45 min)
2. Dynatrace product task

**I won this competition and received the first prize** :tada:

## Programming tasks

### Coding task 1
Security, in cooperation with other teams, identified the following offending ID adresses:
```
57.48.9.100
2.21.107.254
130.25.179.252
```
Count the log entries for each offending IP and return the occurrencies sorted by number of log entries in descending order.

**Input:** Logs are inside a `dynatrace.log` file, which is located in the same directory.

**Output:** `Map <IP, number of entries>` returned in string format, sorted in descending order by log entries.

**Example output:** `"{2.21.107.254=27, 130.25.179.252=12, 57.48.9.100=5}"`

### Coding task 2
Security asks for an analysis as to whether there were any successful logins from the offending IPs:
```
IP1: 57.48.9.100 
IP2: 2.21.107.254 
IP3: 130.25.179.252 
```
Provide the IP and number of successful logins from that IP.

**Input:** Logs are inside a `dynatrace.log` file, which is located in the same directory.

**Output:** List of strings formatted exactly as `"<N> successful logins from that <IP>"`. IP's in list should be in order as presented above.

**Succesful login example:**
```
INFO clientIp=130.25.179.252 userAgent=Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0 header=[Authorization:_Basic_ZTU4NmI3MTAtMzY1Yy00MWYAWFkN2ItNmQ0YzY5ZDYzYzAw] httpMethod=POST requestUrl=/dynatrace.com/login statusCode=200 userId=1481850e-ac07- 4a43-a155-b82c766aa07a
```

### Coding task 3

Security is concerned that your application might store sensitive information like session tokens in logs. Your app uses tokens in the format `xxxxx:yyy:zzzzz` , where `x`, `y`, and `z` are alphanumeric characters.

Use regex to find session tokens. Return the number of tokens found in the log file.

**Input:** Logs are inside a `dynatrace.log` file, which is located in the same directory.

**Output:** Single integer `N` that equals the number of tokens found.

## Product task
- Create your own demo Java microservice
- Simulate any malicious activity
- Use Dynatrace to discover hack attempt e.g. by observing increased error rate on a dashboard
