rm -rf build
find . -name '*.java' > sources.txt
javac src/com/avaj/Main.java -sourcepath @sources.txt -d build
rm -rf sources.txt

