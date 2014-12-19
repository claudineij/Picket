package br.com.waio.erp.ejb.security;

import br.com.waio.erp.ejb.entity.Article;
import br.com.waio.erp.ejb.entity.identity.Realm;
import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.PermissionManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.Partition;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Singleton
@Startup
public class PartitionInitializer {

    public static final String DEFAULT_PARTITION_NAME = "default";
    @Inject
    private PartitionManager partitionManager;
    private Realm defaultPartition;

    @PostConstruct
    public void onInit() {
        this.defaultPartition = this.partitionManager.getPartition(Realm.class, DEFAULT_PARTITION_NAME);

        if (this.defaultPartition == null) {
            this.defaultPartition = new Realm(DEFAULT_PARTITION_NAME);

            this.partitionManager.add(this.defaultPartition);

            br.com.waio.erp.ejb.entity.identity.User john = new br.com.waio.erp.ejb.entity.identity.User("john");

            IdentityManager identityManager = this.partitionManager.createIdentityManager(this.defaultPartition);

            identityManager.add(john);
            identityManager.updateCredential(john, new Password("demo"));

            // Create user mary
            br.com.waio.erp.ejb.entity.identity.User mary = new br.com.waio.erp.ejb.entity.identity.User("mary");

            identityManager.add(mary);
            identityManager.updateCredential(mary, new Password("demo"));

            PermissionManager permissionManager = this.partitionManager.createPermissionManager(this.defaultPartition);

            // Grant both john and mary permission to create new articles
            permissionManager.grantPermission(john, Article.class, "create");
            permissionManager.grantPermission(john, Article.class, "update");
            permissionManager.grantPermission(john, Article.class, "delete");
            permissionManager.grantPermission(mary, Article.class, "create");
        }
    }

    @Produces
    @PicketLink
    public Partition getDefaultPartition() {
        return this.defaultPartition;
    }
}
