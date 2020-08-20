# Scramble Demo

This repo represents monorepo for 3 projects:

- [library](scramble-lib/README.md)
- [backend](scramble-server/README.md)
- [frontend](scramble-webapp/README.md)

To run whole solution you need to do the following steps:

- build and install locally the lib
- build and run the backend
- build and serve the frontend

There is Makefile with these commands:

```shell script
make install-lib
make run-server
make run-webapp
```
