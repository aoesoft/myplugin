package aoesoft.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;

public class MyView extends ViewPart{
	public MyView() {
	}
	private TabFolder folder = null;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(new FormLayout());
		parent.setBounds(10, 10, 850, 800);
		parent.getShell().setMaximized(false);
		
		Composite composite = new Composite(parent, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 660);
		fd_composite.right = new FormAttachment(0, 850);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(ResourceManager.getPluginImage("aoesoft", "icons/logo-product.png"));
		StyledText styledText = new StyledText(composite, SWT.BORDER);
		styledText.setAlignment(SWT.CENTER);
		styledText.setEnabled(false);
		styledText.setEditable(false);
		styledText.setIndent(450);
		styledText.setText("Version: 1.0.0 \r\n (C)Copyright AOE Software ");
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		/*Image img = ImageCapture.getImage(parent.getShell(), 1024, 768, true); //(shell, "icons/a.ico");//
		System.out.println(img);
		System.out.println(img.getImageData());
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[]{img.getImageData()};
		loader.save("d:/z/mm.jpg", SWT.IMAGE_JPEG);*/
		
		/*String actionName = PlatformUI.getPreferenceStore().getString("actionName");
		if("aoesoft.DevHost".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "主机");
		}else if("aoesoft.devDB".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "数据库");
		}else if("aoesoft.devTools".equals(actionName)){
			MessageDialog.openConfirm(parent.getShell(), actionName, "工具");
		}*/
		
	}

	public void setFocus() {
		if(folder != null)
			folder.setFocus();
	}
}
