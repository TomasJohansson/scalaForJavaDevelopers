name := "scalaForJavaDevelopers"

version := "0.1"

scalaVersion := "2.10.1"

resolvers += "SonaType" at "https://oss.sonatype.org/content/groups/public"

resolvers += "SourceForge" at "http://csvjdbc.sourceforge.net/maven2"

libraryDependencies += "junit" % "junit" % "4.11"

libraryDependencies += "com.novocode" % "junit-interface" % "0.9"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1"

libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5"

libraryDependencies += "org.springframework" % "spring-jdbc" % "3.2.2.RELEASE"

libraryDependencies += "net.sourceforge.csvjdbc" % "csvjdbc" % "1.0.13"

libraryDependencies += "org.scalaj" % "scalaj-collection_2.9.1" % "1.2"

libraryDependencies += "commons-io" % "commons-io" % "2.4"
