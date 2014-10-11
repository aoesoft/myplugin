package aoesoft.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class MyView extends ViewPart{
	private TabFolder folder = null;
	public void createPartControl(Composite parent) {
		String actionName = PlatformUI.getPreferenceStore().getString("actionName");
		if("aoesoft.DevHost".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "主机");
		}else if("aoesoft.devDB".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "数据库");
		}else if("aoesoft.devTools".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "工具");
		}
		folder = new TabFolder(parent, SWT.BOTTOM);
		TabItem item1 = new TabItem(folder, SWT.NONE);
		item1.setText("Info1");
		
		TabItem item2 = new TabItem(folder, SWT.NONE);
		item2.setText("Info2");
	}

	public void setFocus() {
		if(folder != null)
			folder.setFocus();
	}
}
