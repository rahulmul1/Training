/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  javax.inject.Inject
 *  org.apache.sling.api.resource.Resource
 *  org.apache.sling.models.annotations.Model
 */
package mypackage.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables={Resource.class})
public class UserInfo {
    @Inject
    private String firstName;
    @Inject
    private String lastName;
    @Inject
    private String technology;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTechnology() {
        return this.technology;
    }
}

