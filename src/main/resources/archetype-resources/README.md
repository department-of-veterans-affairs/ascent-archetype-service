# What is this repository for?

This repository contains the VetsAPI Reference Data microservice for benefits and compensation applications.

# Overview - VetsAPI Reference Data

The service operations offer lists of data from authoritative sources that can be used by applications to conform to the expectations of other benefits and compensation services.

## Operations offered
1. /api/refdata/v1/countries<br>
  A list of country names, confroming to the federal naming conventions of the U.S. Treasury department.
2. /api/refdata/v1/states<br>
  A list of state abbreviations, conforming to the federal conventions of the U.S. Treasury department.
3. /api/refdata/v1/intakesites<br>
  A list of VA Intake sites.
4. /api/refdata/v1/treatmentcenter<br>
  A list of VA Treatment Centers
5. /api/refdata/v1/disabilities<br>
  The list of VA defined disabilities for benefits and compensation purposes.

# Service Consumers - How to use this API

See the swagger for the microservice at http://{server.domain}:8762/api/refdata/swagger-ui.html

# Requests and Contributions

If your team has requests for changes or additions to this service, please use the GitHub Issues tab.

If your team would like to contribute to the project, please fork the repo to make your changes, and [Create a pull request from the fork](https://help.github.com/articles/creating-a-pull-request-from-a-fork/).

## Contributors - How to set up

See the wiki tab.
