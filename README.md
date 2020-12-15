# Unidata Nexus Gradle Plugin

The `unidata-nexus-gradle` project is a Gradle plugin and associated tasks used to manage publishing to Raw Repositories on the Unidata Nexus server.
The plugin can be applied using:

~~~gradle
plugins {
  id 'edu.ucar.unidata.nexus'
}
~~~

or:

~~~gradle
apply plugin: 'edu.ucar.unidata.nexus'
~~~

Doing so will add the `publishToRawRepo` and `deleteFromNexus` tasks to the project.
The `publishToRawRepo` task is of type `edu.ucar.unidata.tasks.PublishToRawRepoTask`, and the `deleteFromNexus` task is of type `edu.ucar.unidata.tasks.DeleteFromNexusTask`

Each tasks must be configured with the following:
  * `host` host of nexus server (e.g. `host = 'https://artifacts.unidata.ucar.edu/'`)
  * `username` = nexus_username (must have the appropriate permissions)
  * `password` = (DO NOT HARD CODE YOUR PASSWORD)

In addition, the `PublishToRawRepo` tasks need:
  * `repoName`: name of the raw repository (e.g. `repoName= 'netcdf-java-docs'`)
  * `publishSrc`: top-level of the directory to publish to the repository (e.g. `publishSrc = site/documentation_build/`)
  * `destPath`: location in the repository to publish(e.g. `destPath = 'netcdf-java/5.4/userguide/`)

and the `DeleteFromNexusTask` tasks need:
 * `searchQueryParameters.repository`: name of the raw repository (e.g. `searchQueryParameters.repository = 'netcdf-java-docs'`)
 * `searchQueryParameters.group`: wildcard expression of matching files to remove (e.g. `searchQueryParameters.group = '/netcdf-java/5.4/*'`)

A full example using both tasks can be found in the netcdf-java [documentation subproject](https://github.com/Unidata/netcdf-java/blob/maint-5.x/docs/build.gradle).

## Debugging

Setup a Remote task (which is a debug task) in IntelliJ (default settings are fine).
Then, from the command line, run:

~~~
./gradlew check -Dorg.gradle.debug=true --no-daemon
~~~

The `check` task is just to trigger the `compile` and `test` tasks of project.
Once gradle is listening for a remote debugger, return to intellij and run (debug) the Remote task.
For more information, see the [gradle troubleshooting guide](https://docs.gradle.org/current/userguide/troubleshooting.html#_attaching_a_debugger_to_your_build).
