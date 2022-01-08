# Synalogik_Word_Parser
Rudimentary word parser for basic txt files, counts word length, average word count etc 

# Example output:
![code output](https://p-oof.me/HZqeHJgR.png)

## How a word is defined
When parsing the txt file, a word is simply any set of characters delimited by a space. Including punctuation.
E.g. "the big brown fox." counts as 4 words including the fullstop at the end of fox.

# Usage
### Clone repo
``` 
git clone https://github.com/whosboosh/Synalogik_Word_Parser.git
```
### Install Maven
```
https://maven.apache.org/download.cgi
```
### Compile and Execute
```
mvn clean compile exec:java
```
This will automatically use the file in "src/main/resources/short.txt" by default if no arguments are provided.


### Run with arguments for custom files
```
mvn clean compile exec:java -Dexec.args="absolute_directory_to_file_from_project_root"
```
### Run tests
```
mvn clean test
```
