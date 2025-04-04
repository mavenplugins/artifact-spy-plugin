# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

<!-- Format restrictions - see https://common-changelog.org and https://keepachangelog.com/ for details -->
<!-- Each Release must start with a line for the release version of exactly this format: ## [version] -->
<!-- The subsequent comment lines start with a space - not to irritate the release scripts parser!
 ## [major.minor.micro]
 <empty line> - optional sub sections may follow like:
 ### Added:
 - This feature was added
 <empty line>
 ### Changed:
 - This feature was changed
 <empty line>
 ### Removed:
 - This feature was removed
 <empty line>
 ### Fixed:
 - This issue was fixed
 <empty line>
 <empty line> - next line is the starting of the previous release
 ## [major.minor.micro]
 <empty line>
 <...>
 !!! In addition the compare URL links are to be maintained at the end of this CHANGELOG.md as follows.
     These links provide direct access to the GitHub compare vs. the previous release.
     The particular link of a released version will be copied to the release notes of a release accordingly.
     At the end of this file appropriate compare links have to be maintained for each release version in format:
 
  +-current release version
  |
  |                   +-URL to this repo              revious release version tag-+       +-current release version tag
  |                   |                                                           |       |
 [major.minor.micro]: https://github.com/mavenplugins/artifact-spy-plugin/compare/vM.N.u..vM.N.u
-->
<!--
## [Unreleased]

### 🚨 Removed
- TBD

### 💥 Breaking
- TBD

### 📢 Deprecated
- TBD

### 🚀 New Features
- TBD

### 🐛 Fixes
- TBD

### ✨ Improvements
- TBD

### 🔧 Internal Changes
- TBD

### 🚦 Tests
- TBD

### 📦 Updates
- TBD

### 🔒 Security
- TBD

### 📝 Documentation Updates
- TBD
-->

## [Unreleased]

### 📦 Updates
- TBD


## [1.1.0]
<!-- !!! Align version in badge URLs as well !!! -->
[![1.1.0 Badge](https://img.shields.io/nexus/r/io.github.mavenplugins/artifact-spy-plugin?server=https://s01.oss.sonatype.org&label=Maven%20Central&queryOpt=:v=1.1.0)](https://central.sonatype.com/artifact/io.github.mavenplugins/artifact-spy-plugin/1.1.0)

### Summary
- Fix overriding POM artifact with a file built in a POM type project
- Add logging of any artifact added

### 💥 Breaking
- Require Java 8 as a minimum
- Maven core dependency updated 3.3.9 -> 3.8.1
- Maven core dependency scope changed to `provided`

### 🐛 Fixes
- Fix overriding POM artifact with a file built in a POM type project

### ✨ Improvements
- Add logging of any artifact being added
- Log warning in case of POM type project adding a built artifact as a not explicitly attached project artifact

### 📦 Updates
- pom.xml:
  - fix developer node contributors URL
  - refer to recent parent pom
  - improve maven-core dependency definition
  - bump dependencies:
    - `org.apache.maven:maven-core:3.3.9` -> `org.apache.maven:maven-core:3.8.1`, scope `provided`
    - `org.apache.maven.plugin-tools:maven-plugin-annotations:3.4` -> `org.apache.maven.plugin-tools:maven-plugin-annotations:3.13.1`


## [1.0.7]
<!-- !!! Align version in badge URLs as well !!! -->
[![1.0.7 Badge](https://img.shields.io/nexus/r/io.github.mavenplugins/artifact-spy-plugin?server=https://s01.oss.sonatype.org&label=Maven%20Central&queryOpt=:v=1.0.7)](https://central.sonatype.com/artifact/io.github.mavenplugins/artifact-spy-plugin/1.0.7)

### Summary
- No functional changes
- Fix project URL and improve developer node in POM only

### Updates
- pom.xml:
  - improve developer node
  - fix project URL


## [1.0.6]
<!-- !!! Align version in badge URLs as well !!! -->
[![1.0.6 Badge](https://img.shields.io/nexus/r/io.github.mavenplugins/artifact-spy-plugin?server=https://s01.oss.sonatype.org&label=Maven%20Central&queryOpt=:v=1.0.6)](https://central.sonatype.com/artifact/io.github.mavenplugins/artifact-spy-plugin/1.0.6)

### Summary
- Initial release of this artifact with new groupId `io.github.mavenplugins`
- Codewise identical with `com.itemis.maven.plugins:artifact-spy-plugin:1.0.6`<br>No more features nor changes
- Released to Maven Central

### Updates
- pom.xml:
  - update parent pom reference
  - update groupId to io.github.mavenplugins
  - update URLs to fit with new repo location
  - remove obsolete profile disable-java8-doclint

- README.md:
  - update URLs for build tags
  - update URLs of lookup references


<!--
## []

### NeverReleased
- This is just a dummy placeholder to make the parser of GHCICD/release-notes-from-changelog@v1 happy!
-->

[Unreleased]: https://github.com/mavenplugins/artifact-spy-plugin/compare/v1.1.0..HEAD
[1.1.0]: https://github.com/mavenplugins/artifact-spy-plugin/compare/v1.0.7..v1.1.0
[1.0.7]: https://github.com/mavenplugins/artifact-spy-plugin/compare/v1.0.6..v1.0.7
[1.0.6]: https://github.com/mavenplugins/artifact-spy-plugin/releases/tag/v1.0.6
