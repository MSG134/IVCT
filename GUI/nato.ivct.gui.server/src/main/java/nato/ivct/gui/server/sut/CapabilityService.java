package nato.ivct.gui.server.sut;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.server.clientnotification.ClientNotificationRegistry;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nato.ivct.commander.BadgeDescription;
import nato.ivct.commander.SutDescription;
import nato.ivct.gui.server.ServerSession;
import nato.ivct.gui.server.cb.CbService;
import nato.ivct.gui.shared.sut.CapabilityTablePageData;
import nato.ivct.gui.shared.sut.CapabilityTablePageData.CapabilityTableRowData;
import nato.ivct.gui.shared.sut.ICapabilityService;
import nato.ivct.gui.shared.sut.ISuTService;
import nato.ivct.gui.shared.sut.TestCaseNotification;

public class CapabilityService implements ICapabilityService {
	private static final Logger LOG = LoggerFactory.getLogger(ServerSession.class);

	@Override
	public CapabilityTablePageData getCapabilityTableData(SearchFilter filter) {
		CapabilityTablePageData pageData = new CapabilityTablePageData();
		// TODO [hzg] fill pageData.
		LOG.info("getCapabilityTableData");
		String[] searchText = filter.getDisplayTexts();
		SuTService sutService = (SuTService) BEANS.get(ISuTService.class);
		CbService cbService = (CbService) BEANS.get(CbService.class);
		SutDescription sutDesc = sutService.getSutDescription(searchText[0]);

		for (int i = 0; i < sutDesc.conformanceStatment.length; i++) {
			BadgeDescription badge = cbService.getBadgeDescription(sutDesc.conformanceStatment[i]);
			if (badge != null) {
				for (int j = 0; j < badge.requirements.length; j++) {
					CapabilityTableRowData row = pageData.addRow();
					row.setBadgeId(sutDesc.conformanceStatment[i]);
					row.setRequirementId(badge.requirements[j].ID);
					row.setRequirementDesc(badge.requirements[j].description);
					row.setAbstractTC(badge.requirements[j].TC);
					row.setTCresult("no result");
				}
				for (int k = 0; k < badge.dependency.length; k++) {
					BadgeDescription dependentBadge = cbService.getBadgeDescription(badge.dependency[k]);
					if (dependentBadge != null){
						for (int l = 0; l < dependentBadge.requirements.length; l++) {
							CapabilityTableRowData row = pageData.addRow();
							row.setBadgeId(dependentBadge.ID);
							row.setRequirementId(dependentBadge.requirements[l].ID);
							row.setRequirementDesc(dependentBadge.requirements[l].description);
							row.setAbstractTC(dependentBadge.requirements[l].TC);
							row.setTCresult("no result");	
						}
					}
				}
			}
		}

		return pageData;
	}
	
	public void executeTestCase(String sut, String tc, String badge) {
		BEANS.get(ClientNotificationRegistry.class).putForAllNodes(new TestCaseNotification());
		// execute the CmdStartTc commands
		CbService cbService = (CbService) BEANS.get(CbService.class);
		BadgeDescription b = cbService.getBadgeDescription(badge);
		ServerSession.get().execStartTc(sut, tc, badge, b.tsRunTimeFolder);
	}
}
