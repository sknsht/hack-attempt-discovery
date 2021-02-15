# Coding task 3

Security is concerned that your application might store sensitive information like session tokens in logs. 

Your app uses tokens in the format `xxxxx:yyy:zzzzz` , where `x`, `y`, and `z` are alphanumeric characters.

Use regex to find session tokens. Return the number of tokens found in the log file.

## Input
Logs are inside a `dynatrace.log` file, which is located in the same directory.

## Output
Single integer `N` that equals the number of tokens found.
