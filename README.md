# Ascent Archetype for Services

This is the project for the ascent-archetype-service artifact. This archetype can then be locally installed and used to create a microservice leveraging the Ascent Platform.

## Get Started

Learn about creating and using Maven Archetypes:<br/>
* Great tutorial: <a href="http://geekofficedog.blogspot.be/2013/08/creating-maven-archetypes-tutorial.html">Creating maven archetypes</a>
* Apache's incomplete documentation: <a href="http://maven.apache.org/archetype/maven-archetype-plugin/index.html">Maven Archetype Plugin</a>

Clone this repo to your local machine:

`git clone https://github.com/department-of-veterans-affairs/ascent-archetype-service.git`

Then in the directory of your checkout run (make sure you're on the right branch):

`mvn clean install`

Navigate to another directory where you'd like to generate your new services project. Replace all the values in < > in the below command then run it:


    mvn archetype:generate \
	-DarchetypeCatalog=local \
    -DinteractiveMode=false \
    -DarchetypeGroupId=gov.va.ascent \
    -DarchetypeArtifactId=ascent-archetype-service \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=<InsertYourGroupID> \
    -DartifactId=<InsertYourArtifactID> \
    -Dversion=<InsertYourVersion> \
    -DartifactName=<InsertYourArtifactName> \
    -DartifactNameLowerCase=<InsertYourArtfactNameInLowerCase> \
    -DartifactNameUpperCase=<InsertYourArtfactNameInUpperCase> \
    -DservicePort=<InsertYourPort>  

Here is the example:

    mvn archetype:generate \
	-DarchetypeCatalog=local \
    -DinteractiveMode=false \
    -DarchetypeGroupId=gov.va.ascent \
    -DarchetypeArtifactId=ascent-archetype-service \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=gov.va.vetservices.intenttofile \
    -DartifactId=vetservices-intenttofile \
    -Dversion=0.0.1-SNAPSHOT \
    -DartifactName=IntentToFile \
    -DartifactNameLowerCase=intenttofile \
    -DartifactNameUpperCase=INTENTTOFILE \
    -DservicePort=8080

Run the below commands. Replace the PathToApp with actual path.

    cd /PathToApp/vetservices-intenttofile/
    sed -i -- 's/__rootArtifactId__/vetservices-intenttofile/g' pom.xml
    rm pom.xml--

 ## Notes

 - The project can now be imported into an IDE as an existing maven reactor project.
 - Running `mvn clean install` will build and generate a docker image for you
 - Running `start-all.sh` will launch the docker image created from the build
 - Running `stop-all.sh` will stop the docker image for your new project

 ## Quick Test

 Within your project navigate to the same directory as the Application.java class created for your project. Create a controller called `IndexController.java`:

    @RestController
    public class HomeController {
    
        final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ResponseEntity<HelloWorld> helloWorld(){
            LOGGER.info("Request received for Hello World");
            HelloWorld helloWorld = new HelloWorld();
            helloWorld.setHelloWorld("Test Hello World!");
    
            return new ResponseEntity<HelloWorld>(helloWorld, HttpStatus.OK);
        }
    
    }
    
    class HelloWorld extends ServiceResponse{
        
        private static final long serialVersionUID = -3634564399169817507L;
    
        private String helloWorld = "Hello World!";
    
        public String getHelloWorld() {
            return helloWorld;
        }
    
        public void setHelloWorld(String helloWorld) {
            this.helloWorld = helloWorld;
        }
    }
     
On the command line in your project directory run `mvn clean install`. 

Make sure you have the Ascent-Platform already running locally in Docker. If you don't, follow the [Ascent Quick Start Guide](https://github.com/department-of-veterans-affairs/ascent-platform/wiki/Ascent-Quick-Start-Guide) and then return here.

Once your platform is running execute this command in your project directory:

`start-all.sh`

Navigate to the [Ascent Dashboard Swagger URL page](http://ascent-dashboard:8763/swagger-dash) and your project should be listed. If it isn't then check the ascent-gateway configuration, namely ascent-gateway.yml file in ascent-ext-configs repo, as you may have static routing enabled for docker profiles.

There should be the `index-controller` that was added as well as a `token-resource` in the list. Get a JWT token through the `token-resource` service. Then click on Authorize in the upper right corner and type in `Bearer < paste token from response body of token-resource POST>`. Then click login.

Now select your `index-controller`, click on the GET operation and try it out. You should see a JSON response. 
