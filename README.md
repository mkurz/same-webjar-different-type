In this branch we include three webjars, they have the same name and the **same versions** (but different groupid):

Again, run:

```sh
$ git checkout same-webjar_same-version
$ sbt "clean; assets"
$ tree -L 1 ./target/web/web-modules/main/webjars/lib/prelude-ls
./target/web/web-modules/main/webjars/lib/prelude-ls
├── browser                   <-- folder from bower webjar
├── CHANGELOG.md              <-- file from bower webjar
├── .gitignore                <-- file from bower webjar
├── lib                       <-- folder from npm or bower webjar (who knows?)
├── LICENSE                   <-- file from npm or bower webjar (who knows?)
├── Makefile                  <-- file from bower webjar
├── package.json              <-- file from npm or bower webjar (who knows?)
├── package.json.ls           <-- file from bower webjar
├── prelude-browser.js        <-- file from classic webjar
├── prelude-browser-min.js    <-- file from classic webjar
├── preroll.ls                <-- file from bower webjar
├── README.md                 <-- file from npm or bower webjar (who knows?)
├── src                       <-- folder from bower webjar
├── test                      <-- folder from bower webjar
└── .travis.yml               <-- file from bower webjar

5 directories, 11 files
```

Now no subfolders get created (of course, it would be the same subfolder because they all have the same version).
But now the files of all three webjars are merged directly into the `prelude-ls` folder (see notes above).

IMHO this is not a good idea, because who knows which webjar overrides which? Which file(s) get(s) overriden?
I think such a conflict should fail hard with an exception like

```
Version conflict: WebJar "prelude-ls" with version "1.1.1" is present multiple times but with different groupids.
```

The thing is if I write an application or a library and include for example

```sbt
"org.webjars" % "prelude-ls" % "1.1.1"`
```

I expect that this dependency (or better: the files from this WebJar) is immutable _if it is present_. Now maybe the files don't change for a while, but  maybe I add another dependency to my project which pulls in `prelude-ls` 1.1.1, but the npm one... Now maybe that would now override the files and suddenly things can get weird...
This is why I think such a case should be disallowed.
