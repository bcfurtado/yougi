/* Jug Management is a web application conceived to manage user groups or 
 * communities focused on a certain domain of knowledge, whose members are 
 * constantly sharing information and participating in social and educational 
 * events. Copyright (C) 2011 Ceara Java User Group - CEJUG.
 * 
 * This application is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation; either version 2.1 of the License, or (at your 
 * option) any later version.
 * 
 * This application is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 * 
 * There is a full copy of the GNU Lesser General Public License along with 
 * this library. Look for the file license.txt at the root level. If you do not
 * find it, write to the Free Software Foundation, Inc., 59 Temple Place, 
 * Suite 330, Boston, MA 02111-1307 USA.
 * */
package org.cejug.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a group of users.
 * @author Hildeberto Mendonca
 */
@Entity
@Table(name="access_group")
public class AccessGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private Boolean userDefault = false;

    public AccessGroup() {}

    public AccessGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="user_default")
    public Boolean getUserDefault() {
        return userDefault;
    }

    public void setUserDefault(Boolean userDefault) {
        this.userDefault = userDefault;
    }

    @Transient
    public boolean getDefault() {
        if(userDefault == null)
            return false;
        else
            return userDefault.booleanValue();
    }

    @Override
    public String toString() {
        return name;
    }
}