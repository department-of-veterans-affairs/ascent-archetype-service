#!/bin/sh

# useful variables
cwd=`pwd`
thisScript="$0"
args="$@"
# script variables
propertiesFile="generate.properties"
generateLog="generate.log"
# properties
# not required in properties file
archetypeCatalog="local"
interactiveMode="false"
archetypeGroupId="gov.va.ascent"
archetypeArtifactId="ascent-archetype-service"
# required in properties file
archetypeVersion=""
groupId=""
artifactId=""
version=""
artifactName=""
artifactNameLowerCase=""
artifactNameUpperCase=""
servicePort=""

## function to exit immediately         ##
## required parameter: exit code to use ##
## scope: private (internal calls only) ##
function exit_now() {
  #  5 = invalid command line argument
  #  6 = property not allocated a value
  # 10 = project directory already exists
  # 20 = a maven error occurred

  code=$1
  if [[ -z $code || "$code" == "0" ]]; then
    code="0"
  else
    echo "------------------------------------------------------------------------" >&2
    echo " BUILD FAILED" >&2
    echo "" >&2
    echo "------------------------------------------------------------------------" >> $cwd/$generateLog 2>&1
    echo " BUILD FAILED" >> $cwd/$generateLog 2>&1
    echo "" >> $cwd/$generateLog 2>&1
    # check exit codes
    if [ "$code" -eq "5" ]; then
      # Invalie command line argument
      echo " ERROR: Invalid command-line argument \"-$OPTARG\" (use \"$thisScript -h\" for help) ... aborting immediately" >&2
      echo " ERROR: Invalid command-line argument \"-$OPTARG\" (use \"$thisScript -h\" for help) ... aborting immediately" >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "6" ]; then
      # One or more properties not set
      echo " ERROR: \"$propertiesFile\" does not provide values for the following properties:" >&2
      echo "        $missingProperties" >&2
      echo " ERROR: \"$propertiesFile\" does not provide values for the following properties:" >> $cwd/$generateLog 2>&1
      echo "        $missingProperties" >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "10" ]; then
      # One or more properties not set
      echo " ERROR: Directory \"$artifactId\" already exists. Delete the directory " >&2
      echo "        or execute this generate script and properties in another directory. " >&2
      echo " ERROR: Directory \"$artifactId\" already exists. Delete the directory " >> $cwd/$generateLog 2>&1
      echo "        or execute this generate script and properties in another directory. " >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "20" ]; then
      # A maven error occurred
      echo " FAILURE: 'mvn' exited with $mvnStatus" >&2
      echo " FAILURE: 'mvn' exited with $mvnStatus" >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "126" ]; then
      # Permission problem or command is not an executable
      echo " ERROR: Invalid permissions or non-executable command ... aborting immediately" >&2
      echo " ERROR: Invalid permissions or non-executable command ... aborting immediately" >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "127" ]; then
      # Possible problem with $PATH or a typo
      echo " ERROR: 'mvn' command not found (check \$PATH) ... aborting immediately" >&2
      echo " ERROR: 'mvn' command not found (check \$PATH) ... aborting immediately" >> $cwd/$generateLog 2>&1
    elif [ "$code" -eq "130" ]; then
      # Ctrl+C was pressed
      echo " Interrupted (Ctrl_C) ... aborting immediately" >&2
      echo " Interrupted (Ctrl_C) ... aborting immediately" >> $cwd/$generateLog 2>&1
    elif [ "$code" -ge "128" ]; then
      # Fatal error signal 128+n
      echo " FATAL error (signal $code) ... aborting immediately" >&2
      echo " FATAL error (signal $code) ... aborting immediately" >> $cwd/$generateLog 2>&1
    else
      # some unexpected error
      echo " Unexpected error code: $code ... aborting immediately" >&2
      echo " Unexpected error code: $code ... aborting immediately" >> $cwd/$generateLog 2>&1
    fi
    echo "" >&2
    echo " Review execution in \"$generateLog\"" >&2
    echo " Use \"$thisScript -h\" for script usage help" >&2
    echo "------------------------------------------------------------------------" >&2
    echo "" >> $cwd/$generateLog 2>&1
    echo " Review execution in \"$generateLog\"" >> $cwd/$generateLog 2>&1
    echo " Use \"$thisScript -h\" for script usage help" >> $cwd/$generateLog 2>&1
    echo "------------------------------------------------------------------------" >> $cwd/$generateLog 2>&1
  fi
  # exit
  exit $code
}

## function to display help             ##
## scope: private (internal calls only) ##
function show_help() {
  echo "" >&2
  echo "Examples:" >&2
  echo "  $thisScript -h" >&2
  echo "      - show this help" >&2
  echo "  $thisScript" >&2
  echo "      - generate project using default generate.properties file"
  echo "  $thisScript -i myprops.properties" >&2
  echo "      - generate using the specified properties file" >&2
  echo "" >&2
  echo "Notes:" >&2
  echo "• Full instructions available in development branch at:" >&2
  echo "  https://github.com/department-of-veterans-affairs/ascent-starter-archetype/"
  echo "• This script must be located in a directory that does not already" >&2
  echo "  contain the project to be generated." >&2
  echo "• A valid \"generate.properties\" file must exist in the same directory" >&2
  echo "  as this script." >&2
  echo "• It is recommended that a git credential helper be utilized to" >&2
  echo "  eliminate authentication requests while executing. For more info see" >&2
  echo "  https://help.github.com/articles/caching-your-github-password-in-git/"
  echo "• Output from this script can be found in ./$generateLog" >&2
  echo "  Each run of this script will overwrite any previous logs." >&2
  echo "  To view output logs:   \$ less $generateLog" >&2
  echo "" >&2
  echo "------------------------------------------------------------------------" >&2
  # if we are showing this, force exit
  exit_now
}

## get argument options off of the command line        ##
## required parameter: array of command-line arguments ##
## scope: private (internal calls only)                ##
function get_args() {
  # echo "args: \"$@\""
  #if [ "$@" -eq "" ]; then
  if [[ "$@" == "" ]]; then
    echo "Using default properties file \"$propertiesFile\"" >&2
    echo "Using default properties file \"$propertiesFile\"" >> $cwd/$generateLog 2>&1
  else
    while getopts "hi:" opt; do
      case "$opt" in
        h)
          # echo "-h \> show help" >&2
          show_help
        ;;
        i)
          # echo "-i \> input properties file" >&2
          # remove spaces from the -i options argument
          propertiesFile=`echo "${OPTARG//[[:space:]]/}"`
          echo "Using specified properties file \"$propertiesFile\"" >&2
          echo "Using specified properties file \"$propertiesFile\"" >> $cwd/$generateLog 2>&1
        ;;
        \?)
          exit_now 5
        ;;
      esac
    done
  fi
}

## function to populate property vars from $propertiesFile ##
## scope: private (internal calls only)                    ##
function read_properties() {
  cd $cwd

  if [ ! -f "$propertiesFile" ]; then
    echo " *** ERROR File \"$propertiesFile\" is missing. Cannot generate the project." >&2
    echo " *** ERROR File \"$propertiesFile\" is missing. Cannot generate the project." >> $cwd/$generateLog 2>&1
  else
    echo "" >&2
    echo "Read project generation properties declared in $propertiesFile" >&2
    echo "Read project generation properties declared in $propertiesFile" >> $cwd/$generateLog 2>&1

    # set up to parse property lines
    OIFS=$IFS
    IFS='='
    # read file
    # echo "△ start reading file"
    while read line
    do
      if [[ $line != *"#"* && $line != "" ]]; then
        # remove all whitespace from the line
        tuple=`echo "${line//[[:space:]]/}"`
        # get the key and value from the tuple
        theKey=$(echo "$tuple" | cut -d'=' -f 1)
        theVal=$(echo "$tuple" | cut -d'=' -f 2)
        # assigning values cannot be done using declare or eval - this is what bash reduces us to ...
        if [[ "$theKey" == "archetypeCatalog" ]]; then archetypeCatalog=$theVal; fi
        if [[ "$theKey" == "interactiveMode" ]]; then interactiveMode=$theVal; fi
        if [[ "$theKey" == "archetypeGroupId" ]]; then archetypeGroupId=$theVal; fi
        if [[ "$theKey" == "archetypeArtifactId" ]]; then archetypeArtifactId=$theVal; fi
        if [[ "$theKey" == "archetypeVersion" ]]; then archetypeVersion=$theVal; fi
        if [[ "$theKey" == "groupId" ]]; then groupId=$theVal; fi
        if [[ "$theKey" == "artifactId" ]]; then artifactId=$theVal; fi
        if [[ "$theKey" == "version" ]]; then version=$theVal; fi
        if [[ "$theKey" == "artifactName" ]]; then artifactName=$theVal; fi
        if [[ "$theKey" == "artifactNameLowerCase" ]]; then artifactNameLowerCase=$theVal; fi
        if [[ "$theKey" == "artifactNameUpperCase" ]]; then artifactNameUpperCase=$theVal; fi
        if [[ "$theKey" == "servicePort" ]]; then servicePort=$theVal; fi
      fi
    done < "$cwd/$propertiesFile"
    IFS=OIFS
  fi
}

## function to validate property vars from $propertiesFile ##
## scope: private (internal calls only)                    ##
function validate_properties() {
  echo "Validating project generation properties declared in $propertiesFile" >&2
  echo "Validating project generation properties declared in $propertiesFile" >> $cwd/$generateLog 2>&1

  missingProperties=""
  if [[ "$archetypeCatalog" == "" ]]; then missingProperties+="archetypeCatalog "; fi
  if [[ "$interactiveMode" == "" ]]; then missingProperties+="interactiveMode "; fi
  if [[ "$archetypeGroupId" == "" ]]; then missingProperties+="archetypeGroupId "; fi
  if [[ "$archetypeArtifactId" == "" ]]; then missingProperties+="archetypeArtifactId "; fi
  if [[ "$archetypeVersion" == "" ]]; then missingProperties+="archetypeVersion "; fi
  if [[ "$groupId" == "" ]]; then missingProperties+="groupId "; fi
  if [[ "$artifactId" == "" ]]; then missingProperties+=( "artifactId " ); fi
  if [[ "$version" == "" ]]; then missingProperties+=( "version " ); fi
  if [[ "$artifactName" == "" ]]; then missingProperties+=( "artifactName " ); fi
  if [[ "$artifactNameLowerCase" == "" ]]; then missingProperties+=( "artifactNameLowerCase " ); fi
  if [[ "$artifactNameUpperCase" == "" ]]; then missingProperties+=( "artifactNameUpperCase " ); fi
  if [[ "$servicePort" == "" ]]; then missingProperties+=( "servicePort " ); fi

  if [[ "$missingProperties" != "" ]]; then
    exit_now 6
  fi
}

## function to check pre-build requirements                 ##
## scope: private (internal calls only)                     ##
function pre_build() {
  echo "Performing pre-build checks" >&2
  echo "Performing pre-build checks" >> $cwd/$generateLog 2>&1
  if [ -d "$artifactId" ]; then
    exit_now 10
  fi
}

## function to execute the maven archetype:generate command ##
## scope: private (internal calls only)                     ##
function generate_project() {
  echo "Executing:" >&2
  echo "  mvn archetype:generate \\" >&2
  echo "  -DarchetypeCatalog=$archetypeCatalog \\" >&2
  echo "  -DinteractiveMode=$interactiveMode \\" >&2
  echo "  -DarchetypeGroupId=$archetypeGroupId \\" >&2
  echo "  -DarchetypeArtifactId=$archetypeArtifactId \\" >&2
  echo "  -DarchetypeVersion=$archetypeVersion \\" >&2
  echo "  -DgroupId=$groupId \\" >&2
  echo "  -DartifactId=$artifactId \\" >&2
  echo "  -Dversion=$version \\" >&2
  echo "  -DartifactName=$artifactName \\" >&2
  echo "  -DartifactNameLowerCase=$artifactNameLowerCase \\" >&2
  echo "  -DartifactNameUpperCase=$artifactNameUpperCase \\" >&2
  echo "  -DservicePort=$servicePort" >&2
  echo "Executing:" >> $cwd/$generateLog 2>&1
  echo "  mvn archetype:generate \\" >> $cwd/$generateLog 2>&1
  echo "  -DarchetypeCatalog=$archetypeCatalog \\" >> $cwd/$generateLog 2>&1
  echo "  -DinteractiveMode=$interactiveMode \\" >> $cwd/$generateLog 2>&1
  echo "  -DarchetypeGroupId=$archetypeGroupId \\" >> $cwd/$generateLog 2>&1
  echo "  -DarchetypeArtifactId=$archetypeArtifactId \\" >> $cwd/$generateLog 2>&1
  echo "  -DarchetypeVersion=$archetypeVersion \\" >> $cwd/$generateLog 2>&1
  echo "  -DgroupId=$groupId \\" >> $cwd/$generateLog 2>&1
  echo "  -DartifactId=$artifactId \\" >> $cwd/$generateLog 2>&1
  echo "  -Dversion=$version \\" >> $cwd/$generateLog 2>&1
  echo "  -DartifactName=$artifactName \\" >> $cwd/$generateLog 2>&1
  echo "  -DartifactNameLowerCase=$artifactNameLowerCase \\" >> $cwd/$generateLog 2>&1
  echo "  -DartifactNameUpperCase=$artifactNameUpperCase \\" >> $cwd/$generateLog 2>&1
  echo "  -DservicePort=$servicePort" >> $cwd/$generateLog 2>&1

  cd $cwd
  mvn archetype:generate -DarchetypeCatalog="$archetypeCatalog" -DinteractiveMode="$interactiveMode" -DarchetypeGroupId="$archetypeGroupId" -DarchetypeArtifactId="$archetypeArtifactId" -DarchetypeVersion="$archetypeVersion" -DgroupId="$groupId" -DartifactId="$artifactId" -Dversion="$version" -DartifactName="$artifactName" -DartifactNameLowerCase="$artifactNameLowerCase" -DartifactNameUpperCase="$artifactNameUpperCase" -DservicePort="$servicePort" -e -X >> $cwd/$generateLog 2>&1
  mvnStatus="$?"
  if [ "$mvnStatus" -eq "0" ]; then
    echo "------------------------------------------------------------------------" >&2
    echo " BUILD SUCCESS"
  elif [ "$mvnStatus" -ge "126" ]; then
    exit_now $mvnStatus
  else
    exit_now 20
  fi

}

## function to perform post-build activities                ##
## scope: private (internal calls only)                     ##
function post_build() {
  echo "Performing post-build activities" >&2
  echo "Performing post-build activities" >> $cwd/$generateLog 2>&1
  cd $cwd/$artifactId >> $cwd/$generateLog 2>&1
  sed -i -- 's/__rootArtifactId__/vetservices-intenttofile/g' pom.xml >> $cwd/$generateLog 2>&1
  rm pom.xml-- >> $cwd/$generateLog 2>&1
  cd $cwd >> $cwd/$generateLog 2>&1
}

########## command-line execution starts here #############

# get args from the command line
echo "########################################################################" >&2
echo "#  Generate a VetServices Service App project                          #" >&2
echo "########################################################################" >&2
echo "########################################################################" > $cwd/$generateLog 2>&1>&2
echo "#  Generate a VetServices Service App project                          #" >> $cwd/$generateLog 2>&1
echo "########################################################################" >> $cwd/$generateLog 2>&1
get_args $args
read_properties
validate_properties
pre_build
generate_project
post_build
echo "------------------------------------------------------------------------" >&2
