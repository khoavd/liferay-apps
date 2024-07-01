package com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_2;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;



public class UpgradeCatV1_2 extends UpgradeProcess {

    private static Log _log = LogFactoryUtil.getLog(UpgradeCatV1_2.class.getName());

    @Override
    protected void doUpgrade() throws Exception {

        _log.info("Run Upgrade to 1.2");

        if (!hasColumn("DG_UGS_CAT", "dob")) {
            runSQLTemplateString("ALTER TABLE DG_UGS_CAT ADD DOB DATE null;", true);
        }
    }

}
