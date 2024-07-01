package com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_4;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;


public class UpgradeCatV1_4 extends UpgradeProcess {

    private static Log _log = LogFactoryUtil.getLog(UpgradeCatV1_4.class.getName());

    @Override
    protected void doUpgrade() throws Exception {

        _log.info("Run Upgrade to 1.4");

        if (!hasColumn("DG_UGS_CAT", "cate")) {
            runSQLTemplateString("ALTER TABLE DG_UGS_CAT ADD CATE LONG;", true);
            runSQLTemplateString("ALTER TABLE DG_UGS_CAT ADD FOREIGN KEY (CATE) REFERENCES DG_ANIMAL_CATE(ID);;", true);

        }

        if (hasColumn("DG_UGS_CAT", "cate")) {

            runSQLTemplateString("UPDATE DG_UGS_CAT SET CATE = 1;", true);
        }


    }





}
