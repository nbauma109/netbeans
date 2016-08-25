/**
 * *****************************************************************************
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************
 */
package org.jetbrains.kotlin.resolve.lang.java.structure;

import org.jetbrains.kotlin.load.java.structure.JavaClassObjectAnnotationArgument;
import org.jetbrains.kotlin.load.java.structure.JavaType;
import org.jetbrains.kotlin.name.Name;
import org.jetbrains.kotlin.resolve.lang.java.NBElementUtils;
import org.netbeans.api.java.source.TypeMirrorHandle;
import org.netbeans.api.project.Project;

/**
 *
 * @author Alexander.Baratynski
 */
public class NetBeansJavaClassObjectAnnotationArgument implements JavaClassObjectAnnotationArgument {

    private final Class<?> javaClass;
    private final Project project;
    private final Name name;
    
    public NetBeansJavaClassObjectAnnotationArgument(Class<?> javaClass,
            Name name, Project project){
        this.javaClass = javaClass;
        this.project = project;
        this.name = name;
    }
    
    @Override
    public JavaType getReferencedType() {
        TypeMirrorHandle handle = NBElementUtils.findTypeMirrorHandle(javaClass.getCanonicalName(), project);
        return NetBeansJavaType.create(handle, project);
    }

    @Override
    public Name getName() {
        return name;
    }
    
}
