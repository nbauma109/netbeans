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

import org.jetbrains.kotlin.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.kotlin.load.java.structure.JavaField;
import org.jetbrains.kotlin.name.FqName;
import org.jetbrains.kotlin.resolve.lang.java.NBElementUtils;
import org.jetbrains.kotlin.resolve.lang.java.NBMemberUtils;
import org.netbeans.api.java.source.ElementHandle;
import org.netbeans.api.project.Project;

/**
 *
 * @author Alexander.Baratynski
 */
public class NetBeansJavaReferenceAnnotationArgument extends NetBeansJavaAnnotationArgument 
        implements JavaEnumValueAnnotationArgument {

    private final ElementHandle handle;
    private final Project project;
    
    public NetBeansJavaReferenceAnnotationArgument(ElementHandle handle, Project project) {
        super(new FqName(NBElementUtils.getSimpleName(handle, project)));
        this.handle = handle;
        this.project = project;
    }
    
    @Override
    public JavaField resolve() {
        ElementHandle containingClass = NBMemberUtils.getContainingClass(handle, project);
        return new NetBeansJavaField(handle, new NetBeansJavaClass(containingClass, project), project);
    }
    
}
