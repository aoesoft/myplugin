package aoesoft.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class MyViewPopupAction implements IViewActionDelegate {
	private IViewPart part;

	public MyViewPopupAction() {
	}

	public void run(IAction action) {
		MessageDialog.openWarning(part.getSite().getShell(), part.getTitle(), "’‚ ¬ ”Õº");
	}

	public void selectionChanged(IAction action, ISelection selection) {

	}

	public void init(IViewPart view) {
		this.part = view;
	}

}
