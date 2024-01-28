lazy val root = (project in file(".")).enablePlugins(SbtWeb)

// When the same webjar (= same name) from different groupids (org.webjars[.npm|bower]?)
// are present, those webjars get extracted into subfolders which are named by the version of the webjar.
// However, if there is just one type (npm, bower, classic) of a webjar on the classpath, NO subfolders gets created.

// BUT:
// When the same webjar (= same name) from different groupids (org.webjars[.npm|bower]?) with the SAME version
// is present, NO subfolders get created (of course, like for which mulitple versions?) but now
// the webjar content's get merged!
// IMHO this is not such a good idea to do, but may be this should fail with an exception, like "version conflict"?
libraryDependencies ++= Seq(
  "org.webjars.npm" % "prelude-ls" % "1.1.1",
  "org.webjars.bower" % "prelude-ls" % "1.1.1",
  "org.webjars" % "prelude-ls" % "1.1.1",
)
