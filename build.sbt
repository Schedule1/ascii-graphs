name := "ascii-graphs"

organization := "com.github.mdr"

version := "0.0.6-SNAPSHOT"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.1")

scalacOptions ++= Seq("-deprecation")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

// Screen-sized dependency graph:
// libraryDependencies += "org.vert-x" % "vertx-core" % "1.3.1.final"

EclipseKeys.withSource := true

EclipseKeys.eclipseOutput := Some("bin")

//net.virtualvoid.sbt.graph.Plugin.graphSettings

import com.typesafe.sbt.SbtScalariform.ScalariformKeys

ScalariformKeys.preferences <<= baseDirectory.apply { dir => 
  scalariform.formatter.preferences.PreferencesImporterExporter.loadPreferences((dir / "formatterPreferences.properties").getPath)
}

publishMavenStyle := true

publishArtifact in Test := false

publishTo := Some("Artifactory Realm" at "http://34.218.183.193:8081/artifactory/maven-staging-local;build.timestamp=" + new java.util.Date().getTime)
credentials += Credentials(Path.userHome / ".sbt" / "s1_artifactory.credentials")

resolvers +=
"Artifactory" at "http://34.218.183.193:8081/artifactory/maven-staging-local/"

pomExtra := {
    <inceptionYear>2012</inceptionYear>
    <url>http://github.com/mdr/ascii-graphs</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:mdr/ascii-graphs.git</url>
      <connection>scm:git:git@github.com:mdr/ascii-graphs</connection>
    </scm>
    <developers>
      <developer>
        <id>mdr</id>
        <name>Matt Russell</name>
        <url>https://github.com/mdr/</url>
      </developer>
    </developers>
  }

// scalacOptions in (Compile, doc) += "-diagrams"
