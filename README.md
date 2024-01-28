We include three webjars, they have the same name, but different groupid and **different versions**:

If you run:

```sh
$ sbt "clean; assets"
$ tree -L 1 ./target/web/web-modules/main/webjars/lib/prelude-ls
./target/web/web-modules/main/webjars/lib/prelude-ls
├── 1.1.1
├── 1.1.2
└── 1.2.1

4 directories, 0 files
```

You can see for each version a subfolder gets created.

This wasn't the case before [webjars-locator-core#28](https://github.com/webjars/webjars-locator-core/pull/28) was merged.
Before that pull request, **no** subfolders got created, but all three webjars were merged directly into the `prelude-ls` folder.
So IMHO creating subfolders is the better approach now.

If you comment out two of the three webjars, so that only one webjars remains, then also **no** subfolders will be created, but the content of the one webjar will be put directly into the `prelude-ls` folder. This behaviour also seems reasonable, given the history of how it was done before.

But what if the _exact same version_ is used for the above three webjars?
Lets find out in the [same-webjar_same-version](https://github.com/mkurz/same-webjar-different-type/blob/same-webjar_same-version/README.md) branch, take a look at its README!
