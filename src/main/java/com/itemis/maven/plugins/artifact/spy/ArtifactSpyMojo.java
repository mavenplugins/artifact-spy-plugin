package com.itemis.maven.plugins.artifact.spy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.maven.RepositoryUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.eclipse.aether.artifact.DefaultArtifact;

/**
 * A small Mojo that only detects the artifacts produced by the build of the current project and writes them out to a
 * properties file.<br>
 * The Mojo should be bound to a late build phase in order to detect all artifacts produced by the build. By default it
 * is bound to the verify phase.<br>
 * <br>
 * The properties will have the following format:
 * <ul>
 * <li><b>key: </b>artifact coordinates</li>
 * <li><b>value: </b>filepath of the artifact (relative to the project's base directory)</li>
 * </ul>
 *
 * @author <a href="mailto:stanley.hillner@itemis.de">Stanley Hillner</a>
 * @since 1.0.0
 */
@Mojo(name = "spy", defaultPhase = LifecyclePhase.VERIFY)
public class ArtifactSpyMojo extends AbstractMojo {

  private static final String LOG_PREFIX = "=== ArtifactSpy: ";

  @Parameter(readonly = true, defaultValue = "${project}")
  private MavenProject project;

  /**
   * The path of the properties file which will then contain all artifacts that have been produced by the build of the
   * current project.
   */
  @Parameter(required = true, defaultValue = "${project.build.directory}/artifact-spy/artifacts.properties")
  private File outputFile;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    Properties props = new Properties();
    addPomArtifact(props);
    addProjectArtifact(props);
    addAttachedArtifacts(props);

    FileOutputStream fos = null;
    try {
      this.outputFile.getParentFile().mkdirs();
      fos = new FileOutputStream(this.outputFile);
      props.store(fos, "");
    } catch (IOException e) {
      throw new MojoFailureException(
          "Error serializing the project artifacts to file: " + this.outputFile.getAbsolutePath(), e);
    } finally {
      try {
        fos.close();
      } catch (IOException e) {
        throw new MojoExecutionException("Could not close output stream after writing project artifacts to file: "
            + this.outputFile.getAbsolutePath(), e);
      }
    }
  }

  private void addPomArtifact(Properties props) {
    String key = new DefaultArtifact(this.project.getGroupId(), this.project.getArtifactId(), "pom",
        this.project.getVersion()).toString();
    String relativeFilePath = getProjectRelativePath(this.project.getFile());
    props.setProperty(key, relativeFilePath);
    getLog().info(LOG_PREFIX + "addPomArtifact: " + key + ", file=" + relativeFilePath);
  }

  private void addProjectArtifact(Properties props) {
    boolean isPOMPackagingProject = "pom".equalsIgnoreCase(this.project.getPackaging());
    Artifact projectArtifact = this.project.getArtifact();
    String key = RepositoryUtils.toArtifact(projectArtifact).toString();
    if (projectArtifact.getFile() != null && projectArtifact.getFile().isFile()) {
      String relativeFilePath = getProjectRelativePath(projectArtifact.getFile());
      if (isPOMPackagingProject) {
        getLog().warn(LOG_PREFIX + "addProjectArtifact: IGNORED POM project artifact file=" + relativeFilePath);
        getLog().warn(LOG_PREFIX
            + "!!! Please check this POM or its parent POM(s) for a misconfiguration building this project artifact within a POM type project !!!");
      } else {
        props.setProperty(key, relativeFilePath);
        getLog().info(LOG_PREFIX + "addProjectArtifact: " + key + ", file=" + relativeFilePath);
      }
    } else if (!isPOMPackagingProject) {
      getLog().warn(LOG_PREFIX + "addProjectArtifact: " + key + " - NO file");
    }
  }

  private void addAttachedArtifacts(Properties props) {
    for (Artifact a : this.project.getAttachedArtifacts()) {
      String key = RepositoryUtils.toArtifact(a).toString();
      String relativeFilePath = getProjectRelativePath(a.getFile());
      props.setProperty(key, relativeFilePath);
      getLog().info(LOG_PREFIX + "addAttachedArtifacts: " + key + ", file=" + relativeFilePath);
    }
  }

  private String getProjectRelativePath(File f) {
    return this.project.getBasedir().toURI().relativize(f.toURI()).getPath();
  }
}
