install-lib:
	$(MAKE) -C scramble-lib install

run-server:
	$(MAKE) -C scramble-server run

run-webapp:
	$(MAKE) -C scramble-webapp serve

clean:
	$(MAKE) -C scramble-lib clean
	$(MAKE) -C scramble-server clean
	$(MAKE) -C scramble-webapp clean