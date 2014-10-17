package aoesoft.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
		
		
		
		try {
			window.getWorkbench().getProgressService().run(true, true,
					   new IRunnableWithProgress() {
					      public void run(IProgressMonitor monitor)
					         throws InvocationTargetException, InterruptedException
					       {
					         monitor.beginTask("Simulated long running task #1", 5);
					         for (int i = 5; i > 0; --i) {
					            monitor.subTask("seconds left = " + i);
					            if (monitor.isCanceled()) break;
					            Thread.sleep(1000);
					            monitor.worked(1);
					         }
					         monitor.done();
					       }
					   });
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
