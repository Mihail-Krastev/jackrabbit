/*
 * Copyright 2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.core;

import javax.jcr.AccessDeniedException;
import javax.jcr.RepositoryException;
import javax.jcr.ItemNotFoundException;

/**
 * The <code>AccessManager</code> can be queried to determines whether permission
 * is granted to perform a specific action on a specific item.
 */
public interface AccessManager {

    /** READ permission constant */
    public static final int READ = 1;
    /** WRITE permission constant */
    public static final int WRITE = 2;

    /**
     * Determines whether the specified <code>permissions</code> are granted
     * on the item with the specified <code>id</code> (i.e. the <i>target</i> item).
     *
     * @param id the id of the target item
     * @param permissions A combination of one or more of the following constants
     * encoded as a bitmask value:
     * <ul>
     * <li><code>READ</code></li>
     * <li><code>WRITE</code></li>
     * </ul>
     *
     * @throws AccessDeniedException if permission is denied
     * @throws ItemNotFoundException if the target item does not exist
     * @throws RepositoryException it an error occurs
     */
    public void checkPermission(ItemId id, int permissions)
            throws AccessDeniedException, ItemNotFoundException, RepositoryException;

    /**
     * Determines whether the specified <code>permissions</code> are granted
     * on the item with the specified <code>id</code> (i.e. the <i>target</i> item).
     *
     * @param id the id of the target item
     * @param permissions A combination of one or more of the following constants
     * @return <code>true</code> if permission is granted; otherwise <code>false</code>
     * @throws ItemNotFoundException if the target item does not exist
     * @throws RepositoryException it an error occurs
     */
    public boolean isGranted(ItemId id, int permissions)
            throws ItemNotFoundException, RepositoryException;
}
