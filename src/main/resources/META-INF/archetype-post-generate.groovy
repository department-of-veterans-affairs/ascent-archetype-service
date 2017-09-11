def startFile = new File( request.getOutputDirectory(), request.getArtifactId()+"/start-all.sh" );
startFile.setExecutable(true, false);

def stopFile = new File( request.getOutputDirectory(), request.getArtifactId()+"/stop-all.sh" );
stopFile.setExecutable(true, false);