package aoesoft.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

public class MyViewAction implements IWorkbenchWindowActionDelegate {
	public MyViewAction(){
		super();
	}
	
	private IWorkbenchWindow window;

	public void run(IAction action) {
		if(window == null)
			return;
		
		IWorkbenchPage page = window.getActivePage();
		if(page == null)
			return;
		
		System.out.println(action);
		System.out.println(action.getText());
		System.out.println(action.getToolTipText());
		System.out.println(action.getId());
		try {
			page.showView("aoesoft.ui.MyView");
		} catch (PartInitException e) {
			System.out.println("ERRR!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("Trigger selection change "+ selection);
		//action.setEnabled(false);
	}

	public void dispose() {

	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

}
