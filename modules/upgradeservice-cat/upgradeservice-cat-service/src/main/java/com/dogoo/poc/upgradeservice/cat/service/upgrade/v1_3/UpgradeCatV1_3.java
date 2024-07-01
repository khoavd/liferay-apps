package com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_3;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;


public class UpgradeCatV1_3 extends UpgradeProcess {

    private static Log _log = LogFactoryUtil.getLog(UpgradeCatV1_3.class.getName());

    @Override
    protected void doUpgrade() throws Exception {

        _log.info("Run Upgrade to 1.3");

        if (hasColumn("DG_UGS_CAT", "type")) {
            runSQLTemplateString("ALTER TABLE DG_UGS_CAT DROP COLUMN type;", true);
        }
    }

}
