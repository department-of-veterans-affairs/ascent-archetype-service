Feature: Get Country List

  #Background:
  #   Given valid VAAFI headers
  @countrylist @HappyPath
  Scenario Outline: Get Country List - successful
    Given the claimant is a "<Veteran>"
    And invoke token API by passing header from "<tokenrequestfile>" and sets the authorization in the header
    When I make a GET request using "<ServiceURL>"
    Then the service returns status code = 200
    And the response should be same as "<ResponseFile>"

    @DEV
    Examples: 
      | Veteran    | tokenrequestfile | ServiceURL                | ResponseFile         |
      | ci-janedoe | ci/token.Request | /api/refdata/v1/countries | countryList.Response |

    @VA
    Examples: 
      | Veteran    | tokenrequestfile | ServiceURL                | ResponseFile         |
      | va-janedoe | va/token.Request | /api/refdata/v1/countries | countryList.Response |

  @countrylist @HttpError
  Scenario Outline: Get Country List - partner service error 401
    Given the claimant is a "<Veteran>"
    When Using bad token I make a GET request using "<ServiceURL>"
    Then the service returns status code = 401
    And the response should be same as "<ResponseFile>"

    @DEV
    Examples: 
      | Veteran    | ServiceURL                | ResponseFile                 |
      | ci-janedoe | /api/refdata/v1/countries | generalHttpError401.Response |

    @VA
    Examples: 
      | Veteran    | ServiceURL                | ResponseFile                 |
      | va-janedoe | /api/refdata/v1/countries | generalHttpError401.Response |

  @countrylist @HttpError
  Scenario Outline: Get Country List - service error 406
    Given the claimant is a "<Veteran>"
    And invoke token API by passing header from "<tokenrequestfile>" and sets the authorization in the header
    When I make a GET request using "<ServiceURL>"
    Then the service returns status code = 406

    @DEV
    Examples: 
      | Veteran | tokenrequestfile | ServiceURL                |
      | ci-jane | ci/token.Request | /api/refdata/v1/countries |

    @VA
    Examples: 
      | Veteran | tokenrequestfile | ServiceURL                |
      | va-jane | va/token.Request | /api/refdata/v1/countries |
