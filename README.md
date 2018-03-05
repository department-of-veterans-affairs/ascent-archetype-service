# Ascent Starter Archetype

This is a starter project to create a microservice leveraging the Ascent Platform. 

## Get Started

Clone this repo to your local machine:

`git clone https://github.com/department-of-veterans-affairs/ascent-starter-archetype.git`

Then in the directory of your checkout run (make sure you're on the right branch):

`mvn clean install`

Navigate to another directory where you'd like to generate your new starter project. Replace all the values in < > in the below command then run it:


    mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=gov.va.ascent \
    -DarchetypeArtifactId=ascent-starter-archetype \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=<InsertYourGroupID> \
    -DartifactId=<InsertYourArtifactID> \
    -Dversion=<InsertYourVersion> \
    -DartifactName=<InsertYourArtifactName> \
    -DserviceName=<InsertYourServiceName> \
    -DservicePort=<InsertYourPort>  

Here is the example:

    mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=gov.va.ascent \
    -DarchetypeArtifactId=ascent-starter-archetype \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=gov.va.wss.intenttofile \
    -DartifactId=wss-intenttofile \
    -Dversion=0.0.1-SNAPSHOT \
    -DartifactName=WssIntenttoFile \
    -DserviceName=wss-intenttofile \
    -DservicePort=8082

Run the below commands. Replace the PathToApp with actual path.

    cd /PathToApp/wss-intenttofile/wss-intenttofile-inttest
    sed -i -- 's/__rootArtifactId__/wss-intenttofile/g' pom.xml
    rm pom.xml--

    cd /PathToApp/wss-intenttofile/wss-intenttofile-modelvalidators
    sed -i -- 's/__rootArtifactId__/wss-intenttofile/g' pom.xml
    rm pom.xml--

    cd /PathToApp/wss-intenttofile/wss-intenttofile-services
    sed -i -- 's/__rootArtifactId__/wss-intenttofile/g' pom.xml
    rm pom.xml--

 ## Notes

 - The project can now be imported into an IDE of your choosing by creating a new project from existing sources. 
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
