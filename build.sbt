lazy val root = (project in file(".")).enablePlugins(SbtWeb)

// When the same webjar (= same name) from different groupids (org.webjars[.npm|bower]?)
// are present, those webjars get extracted into subfolders which are named by the version of the webjar.
// However, if there is just one type (npm, bower, classic) of a webjar on the classpath, NO subfolders gets created.
libraryDependencies ++= Seq(
  "org.webjars.npm" % "prelude-ls" % "1.2.1",
  "org.webjars.bower" % "prelude-ls" % "1.1.2",
  "org.webjars" % "prelude-ls" % "1.1.1",
)
