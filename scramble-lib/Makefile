build:
	clojure -A:jar

install: build
	clojure -A:install

clean:
	rm -rf target

.PHONY: test
test:
	clojure -A:test:runner