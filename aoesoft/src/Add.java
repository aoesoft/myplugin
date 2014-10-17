import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Add {
	private static Text txtName;
	private static Text txtTel;
	private static Text txtEmail;
	private static Text txtQQ;
	private static Text txtCName;
	private static Text txtCAddress;
	private static Text txtCTel;
	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setSize (513, 468);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 477, 313);
		
		Group group = new Group(composite, SWT.NONE);
		group.setText("公司信息");
		group.setBounds(10, 175, 457, 128);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("公司名称");
		label_3.setBounds(40, 30, 61, 17);
		
		txtCName = new Text(group, SWT.BORDER);
		txtCName.setBounds(107, 27, 184, 23);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setText("公司地址");
		label_4.setBounds(40, 57, 61, 17);
		
		txtCAddress = new Text(group, SWT.BORDER);
		txtCAddress.setBounds(107, 53, 184, 23);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setText("公司电话");
		label_5.setBounds(40, 86, 61, 17);
		
		txtCTel = new Text(group, SWT.BORDER);
		txtCTel.setBounds(107, 82, 184, 23);
		
		Button btnNewButton = new Button(group, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(307, 24, 129, 27);
		btnNewButton.setText("...选择公司");
		
		Label label = new Label(composite, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setBounds(18, 8, 40, 17);
		label.setText("姓名");
		
		txtName = new Text(composite, SWT.BORDER);
		txtName.setBounds(72, 6, 176, 23);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(18, 36, 40, 17);
		label_1.setText("手机号");
		
		txtTel = new Text(composite, SWT.BORDER);
		txtTel.setBounds(72, 35, 176, 23);
		
		txtEmail = new Text(composite, SWT.BORDER);
		txtEmail.setBounds(72, 67, 176, 23);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("邮箱");
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(18, 68, 40, 17);
		
		Label lblQq = new Label(composite, SWT.NONE);
		lblQq.setAlignment(SWT.RIGHT);
		lblQq.setBounds(18, 103, 40, 17);
		lblQq.setText("QQ");
		
		txtQQ = new Text(composite, SWT.BORDER);
		txtQQ.setBounds(72, 101, 176, 23);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setText("头像");
		btnNewButton_1.setBounds(273, 10, 173, 112);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(178, 365, 80, 27);
		btnNewButton_2.setText("确定");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setBounds(286, 365, 80, 27);
		btnNewButton_3.setText("取消");
		
		
		
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
