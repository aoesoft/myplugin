package aoesoft;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class MyPopupAction implements IObjectActionDelegate {
	private IWorkbenchPart part;

	public MyPopupAction() {
	}

	public void run(IAction action) {
		MessageDialog.openInformation(part.getSite().getShell(), part.getTitle(), part.getSite().toString());
	}

	public void selectionChanged(IAction action, ISelection selection) {

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.part = targetPart;
	}

}
