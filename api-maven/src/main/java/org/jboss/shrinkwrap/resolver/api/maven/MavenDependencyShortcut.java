/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.shrinkwrap.resolver.api.maven;

import org.jboss.shrinkwrap.resolver.api.ResolverEntryPoint;

/**
 * An artifact builder is object which holds and construct dependencies and it is able to resolve them into an array of
 * ShrinkWrap archives.
 *
 * Artifact builder allows chaining of artifacts, that is specifying a new artifact. In this case, currently constructed
 * artifact is stored as a dependency and user is allowed to specify parameters for another artifact.
 *
 * @author <a href="http://community.jboss.org/people/silenius">Samuel Santos</a>
 */
public interface MavenDependencyShortcut extends ResolverEntryPoint<MavenDependencyShortcut>, EffectivePomMavenDependencyShortcut {

    /**
     * Loads remote repositories for a POM file. If repositories are defined in the parent of the POM file and there are
     * accessible via local file system, they are set as well.
     *
     * These remote repositories are used to resolve the artifacts during dependency resolution.
     *
     * Additionally, it loads dependencies defined in the POM file model in an internal cache, which can be later used to
     * resolve an artifact without explicitly specifying its version.
     *
     * @param path A path to the POM file, must not be {@code null} or empty
     * @return A dependency builder with remote repositories set according to the content of POM file.
     */
    EffectivePomMavenDependencyShortcut withPom(String path);
}
