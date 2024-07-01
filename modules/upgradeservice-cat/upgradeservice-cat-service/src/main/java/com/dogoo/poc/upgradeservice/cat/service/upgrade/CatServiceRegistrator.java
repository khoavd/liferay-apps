package com.dogoo.poc.upgradeservice.cat.service.upgrade;

import com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_1.UpgradeCatV1_1;
import com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_2.UpgradeCatV1_2;
import com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_3.UpgradeCatV1_3;
import com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_3.UpgradeCatV1_3_dev;
import com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_4.UpgradeCatV1_4;
import com.liferay.portal.kernel.cluster.ClusterExecutor;
import com.liferay.portal.kernel.cluster.ClusterMasterExecutor;
import com.liferay.portal.kernel.upgrade.DummyUpgradeProcess;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class CatServiceRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        if (isClusterLeader()) {
            registry.register("1.0.0", "1.1.0", new DummyUpgradeProcess());

            registry.register("1.1.0", "1.2.0", new DummyUpgradeProcess());
        }
    }

    private boolean isClusterLeader() {
        boolean clusterLeader;

        if (_clusterExecutor.isEnabled()) {
            clusterLeader = _clusterMasterExecutor.isMaster();
        } else {
            // not in a cluster, so this is the leader
            clusterLeader = true;
        }

        return clusterLeader;
    }

    @Reference
    private volatile ClusterMasterExecutor _clusterMasterExecutor;

    @Reference
    private volatile ClusterExecutor _clusterExecutor;
}
