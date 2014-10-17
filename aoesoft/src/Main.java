import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;


public class Main {
	static OleClientSite clientSite;
	static OleFrame frame;
	
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Word Example");
		shell.setLayout(new FillLayout());
		try {
			frame = new OleFrame(shell, SWT.NONE);
			clientSite = new OleClientSite(frame, SWT.NONE, "Word.Document");
			addFileMenu(frame);
		} catch (SWTError e) {
			System.out.println("Unable to open activeX control");
			display.dispose();
			return;
		}
		shell.setSize(800, 600);
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	static void addFileMenu(OleFrame frame) {
		final Shell shell = frame.getShell();
		Menu menuBar = shell.getMenuBar();
		if (menuBar == null) {
			menuBar = new Menu(shell, SWT.BAR);
			shell.setMenuBar(menuBar);
		}
		MenuItem fileMenu = new MenuItem(menuBar, SWT.CASCADE);
		fileMenu.setText("&File");
		Menu menuFile = new Menu(fileMenu);
		fileMenu.setMenu(menuFile);
		frame.setFileMenus(new MenuItem[] { fileMenu });

		MenuItem menuFileOpen = new MenuItem(menuFile, SWT.CASCADE);
		menuFileOpen.setText("Open...");
		menuFileOpen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fileOpen();
			}
		});
		MenuItem menuFileExit = new MenuItem(menuFile, SWT.CASCADE);
		menuFileExit.setText("Exit");
		menuFileExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
	}

	static void fileOpen() {
		FileDialog dialog = new FileDialog(clientSite.getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String[] { "*.doc" });
		String fileName = dialog.open();
		if (fileName != null) {
			clientSite.dispose();
			clientSite = new OleClientSite(frame, SWT.NONE, "Word.Document", new File(fileName));
			clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
		}
	}
	
	public static void main1(String[] args) {
		//SwtDemo.main(args);
		// com.miginfocom.demo.demoapp.Demo.main(args);
		
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setSize (200, 200);
		Monitor primary = display.getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();
		Rectangle rect = shell.getBounds ();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation (x, y);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
