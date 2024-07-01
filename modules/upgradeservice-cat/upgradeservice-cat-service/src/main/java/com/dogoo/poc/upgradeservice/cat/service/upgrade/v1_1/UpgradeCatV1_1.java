package com.dogoo.poc.upgradeservice.cat.service.upgrade.v1_1;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpgradeCatV1_1 extends UpgradeProcess {

    private static Log _log = LogFactoryUtil.getLog(UpgradeCatV1_1.class.getName());

    @Override
    protected void doUpgrade() throws Exception {

        String template = StringUtil.read(
                UpgradeCatV1_1.class.getResourceAsStream("dependencies/update.sql"));

        _log.info(template);

        _log.info("Run Upgrade to 1.1");

        if (!hasColumn("DG_UGS_CAT", "expando")) {
            runSQLTemplateString(template, true);

        }

        updateContentTable();

    }

    private void updateContentTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select id, name, type from DG_UGS_CAT");

             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong(
                        "id");
                String name = resultSet.getString(
                        "name");


                StringBuilder sb = new StringBuilder();

                sb.append("UPDATE DG_UGS_CAT ");
                sb.append("SET name = \'");
                sb.append(name);
                sb.append("-dogoo\', ");
                sb.append("type = 1 ");
                sb.append("where id = ");
                sb.append(id);
                sb.append(";");

                _log.info(sb.toString());

                runSQLTemplateString(sb.toString(), true);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
