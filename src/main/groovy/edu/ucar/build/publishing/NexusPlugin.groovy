package edu.ucar.build.publishing

import edu.ucar.build.publishing.tasks.DeleteFromNexusTask
import edu.ucar.build.publishing.tasks.PublishToRawRepoTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

class NexusPlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.task('publishToRawRepo', type: PublishToRawRepoTask)
    project.task('deleteFromNexus', type: DeleteFromNexusTask)
  }
}
