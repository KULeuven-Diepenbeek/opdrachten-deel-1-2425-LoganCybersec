# Compileert alle Java-bestanden en zet ze in build/
compile:
	mkdir -p build
	javac -d build *.java model/*.java

# Maakt een jar-bestand en voegt alle class files toe
jar:
	jar cvfe build/app.jar App -C build .

# Voert de jar file uit
run:
	java -jar build/app.jar

# Verwijdert de build directory
clean:
	rm -rf build
