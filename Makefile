all: Deck.class

Deck.class: Card.class Deck.java
	@javac Deck.java

Card.class: Card.java
	@javac Card.java

.PHONY: clean

clean:
	@rm -rf *.class
