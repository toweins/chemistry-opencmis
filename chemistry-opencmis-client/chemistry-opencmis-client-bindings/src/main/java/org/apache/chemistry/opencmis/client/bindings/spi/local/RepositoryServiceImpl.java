/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.chemistry.opencmis.client.bindings.spi.local;

import java.math.BigInteger;
import java.util.List;

import org.apache.chemistry.opencmis.client.bindings.spi.BindingSession;
import org.apache.chemistry.opencmis.commons.data.ExtensionsData;
import org.apache.chemistry.opencmis.commons.data.RepositoryInfo;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinition;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinitionContainer;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinitionList;
import org.apache.chemistry.opencmis.commons.server.CmisService;
import org.apache.chemistry.opencmis.commons.server.CmisServiceFactory;
import org.apache.chemistry.opencmis.commons.spi.RepositoryService;

/**
 * Repository Service local client.
 */
public class RepositoryServiceImpl extends AbstractLocalService implements RepositoryService {

    /**
     * Constructor.
     */
    public RepositoryServiceImpl(BindingSession session, CmisServiceFactory factory) {
        setSession(session);
        setServiceFactory(factory);
    }

    public RepositoryInfo getRepositoryInfo(String repositoryId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getRepositoryInfo(repositoryId, extension);
        } finally {
            service.close();
        }
    }

    public List<RepositoryInfo> getRepositoryInfos(ExtensionsData extension) {
        CmisService service = getService(null);

        try {
            return service.getRepositoryInfos(extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinition getTypeDefinition(String repositoryId, String typeId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeDefinition(repositoryId, typeId, extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinitionList getTypeChildren(String repositoryId, String typeId, Boolean includePropertyDefinitions,
            BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeChildren(repositoryId, typeId, includePropertyDefinitions, maxItems, skipCount,
                    extension);
        } finally {
            service.close();
        }
    }

    public List<TypeDefinitionContainer> getTypeDescendants(String repositoryId, String typeId, BigInteger depth,
            Boolean includePropertyDefinitions, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeDescendants(repositoryId, typeId, depth, includePropertyDefinitions, extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinition createType(String repositoryId, TypeDefinition type, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.createType(repositoryId, type, extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinition updateType(String repositoryId, TypeDefinition type, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.updateType(repositoryId, type, extension);
        } finally {
            service.close();
        }
    }

    public void deleteType(String repositoryId, String typeId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            service.deleteType(repositoryId, typeId, extension);
        } finally {
            service.close();
        }
    }

}
