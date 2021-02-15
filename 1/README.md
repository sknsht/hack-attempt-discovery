# Coding task 1
Security, in cooperation with other teams, identified the following offending ID adresses:
```
57.48.9.100
2.21.107.254
130.25.179.252
```
Count the log entries for each offending IP and return the occurrencies sorted by number of log entries in descending order.

## Input
Logs are inside a `dynatrace.log` file, which is located in the same directory.

## Output
`Map <IP, number of entries>` returned in string format, sorted in descending order by log entries.

## Example output
`"{2.21.107.254=27, 130.25.179.252=12, 57.48.9.100=5}"`
