package nato.ivct.gui.client.sut;

import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.shared.TEXTS;

public class SuTCbNodePage extends AbstractPageWithNodes {

	private String sutCapabilityId;

	@Override
	protected String getConfiguredTitle() {
		// TODO [the] verify translation
		return TEXTS.get("SuTCbNodePage");
	}
	
	@Override
	protected boolean getConfiguredLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

//	@Override
//	protected void execCreateChildPages(List<IPage<?>> pageList) {
//		// TODO [the] Auto-generated method stub.
//		super.execCreateChildPages(pageList);
//	}

	public String getSuTCapabilityId() {
		return sutCapabilityId;
	}	
	public void setSuTCapabilityId(String Id) {
		this.sutCapabilityId = Id;
	}
}
