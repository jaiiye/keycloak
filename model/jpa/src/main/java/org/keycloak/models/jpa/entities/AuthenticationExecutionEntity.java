package org.keycloak.models.jpa.entities;

import org.keycloak.models.AuthenticationExecutionModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@Table(name="AUTHENTICATION_EXECUTION")
@Entity
@NamedQueries({
        @NamedQuery(name="getAuthenticationExecutionsByFlow", query="select authenticator from AuthenticationExecutionEntity authenticator where authenticator.realm = :realm and authenticator.flow = :flow"),
        @NamedQuery(name="deleteAuthenticationExecutionsByRealm", query="delete from AuthenticationExecutionEntity authenticator where authenticator.realm = :realm"),
        @NamedQuery(name="deleteAuthenticationExecutionsByRealmAndFlow", query="delete from AuthenticationExecutionEntity authenticator where authenticator.realm = :realm and authenticator.flow = :flow"),
})
public class AuthenticationExecutionEntity {
    @Id
    @Column(name="ID", length = 36)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REALM_ID")
    protected RealmEntity realm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLOW_ID")
    protected AuthenticationFlowEntity flow;

    @Column(name="AUTHENTICATOR")
    protected String authenticator;

    @Column(name="REQUIREMENT")
    protected AuthenticationExecutionModel.Requirement requirement;

    @Column(name="PRIORITY")
    protected int priority;

    @Column(name="USER_SETUP_ALLOWED")
    private boolean userSetupAllowed;

    @Column(name="AUTHENTICATOR_FLOW")
    private boolean autheticatorFlow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmEntity getRealm() {
        return realm;
    }

    public void setRealm(RealmEntity realm) {
        this.realm = realm;
    }

    public String getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator;
    }

    public AuthenticationExecutionModel.Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(AuthenticationExecutionModel.Requirement requirement) {
        this.requirement = requirement;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isUserSetupAllowed() {
        return userSetupAllowed;
    }

    public void setUserSetupAllowed(boolean userSetupAllowed) {
        this.userSetupAllowed = userSetupAllowed;
    }

    public boolean isAutheticatorFlow() {
        return autheticatorFlow;
    }

    public void setAutheticatorFlow(boolean autheticatorFlow) {
        this.autheticatorFlow = autheticatorFlow;
    }

    public AuthenticationFlowEntity getFlow() {
        return flow;
    }

    public void setFlow(AuthenticationFlowEntity flow) {
        this.flow = flow;
    }
}
