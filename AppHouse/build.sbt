name := "AppHouse"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
	"org.apache.logging.log4j" % "log4j-api" % "2.8.2",
	"org.apache.logging.log4j" % "log4j-core" % "2.8.2",
	"org.elasticsearch" % "elasticsearch" % "5.1.2",
	"org.elasticsearch.client" % "transport" % "5.1.2"
)	
