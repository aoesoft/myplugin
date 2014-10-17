import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;


public class List {
	private Composite container;
	
	public List(Composite container){
		this.container = container;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void draw(){
		TableViewer viewer = new TableViewer(container);
		viewer.setLabelProvider(new ContactTableLabelProvider());
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(new ContactManager.getContact());
	}
	
	private static class ContactTableLabelProvider extends LabelProvider implements ITableLabelProvider{
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int index) {
			return null;
		}
	}
}
