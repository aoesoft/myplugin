import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import aoesoft.ui.MyView;

public class ImageCapture {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SMP");
		Label label = new Label(shell, SWT.NONE);
		label.setImage(new Image(null, "icons/logo-product.png"));
		
		MyView mv = new MyView();
		//mv.createPartControl(shell);
		
		StyledText txt = new StyledText(shell, SWT.NONE);
		txt.setText("’‚ «¡¥Ω” <a href='http://www.asiainfo.com'>Home</a>");
		
		txt.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				Image img = getImage(shell, shell.getBounds().width, shell.getBounds().height, true);
				System.out.println(img);
				System.out.println(img.getImageData());
				ImageLoader loader = new ImageLoader();
				loader.data = new ImageData[]{img.getImageData()};
				loader.save("d:/z/mm.jpg", SWT.IMAGE_JPEG);
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//shell.setVisible(false);
		shell.open();
		
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		shell.dispose();
		display.dispose();
	}

    public static void drawOnImage(Image myImage, Control control, int maxWidth, int maxHeight, boolean includeChildren) {
        // We need to be able to handle right-to-left coordinates too. In that case the bounds rectangle will be reversed from what we
        // think. We think the origin is upper-left, but the origin is really upper-right. To get out of this thinking we will
        // instead convert all bounds to display bounds so that they will all be left-to-right.
        if (myImage != null) {
            // Get the images of all of the children
            if (includeChildren && control instanceof Composite) {
                Display display = control.getDisplay();
                Rectangle parentBounds = control.getParent() == null ? control.getBounds() : display.map(control.getParent(), null, control.getBounds());
                // Need to clip the bounds to the size of the image so we get just what we need.
                Rectangle imgBounds = myImage.getBounds();
                parentBounds.width = imgBounds.width;
                parentBounds.height = imgBounds.height;
                int parentRight = parentBounds.width+parentBounds.x;
                int parentBottom = parentBounds.height+parentBounds.y;
                Control[] children = ((Composite) control).getChildren();
                GC myImageGC = new GC(myImage);
                try {
                    int i = children.length;
                    while (--i >= 0) {
                        Control child = children[i];
                        // If the child is not visible then don't try and get its image
                        // An example of where this would cause a problem is TabFolder where all the controls
                        // for each page are children of the TabFolder, but only the visible one is being shown on the active page
                        if (!child.isVisible())
                            continue;
                        Rectangle childBounds = display.map(control, null, child.getBounds());
                        if (!parentBounds.intersects(childBounds))
                            continue; // Child is completely outside parent.
                        Image childImage = getImage(child, parentRight - childBounds.x, parentBottom - childBounds.y, true);
                        if (childImage != null) {
                            try {
                                // Paint the child image on top of our one
                                // Since the child bounds and parent bounds are both in display coors, the difference between
                                // the two is the offset of the child from the parent.
                                myImageGC.drawImage(childImage, childBounds.x-parentBounds.x, childBounds.y-parentBounds.y);
                            } finally {
                                childImage.dispose();
                            }
                        }
                    }
                } finally {
                    myImageGC.dispose();
                }
            }
        }
    }
    
    public static Image getImage(Control control, int maxWidth, int maxHeight, boolean includeChildren) {
        Image myImage = getImage(control, maxWidth, maxHeight);
        drawOnImage(myImage, control, maxWidth, maxHeight, includeChildren);
        return myImage;
    }

    /**
     * Return the image of the argument. This includes the client and non-client area, but does not include any child controls. To get child control
     * use {@link ImageCapture#getImage(Control, int, int, boolean)}.
     * 
     * @param aControl
     * @param maxWidth
     * @param maxHeight
     * @return image or <code>null</code> if not valid for some reason. (Like not yet sized).
     * 
     * @since 1.1.0
     */
    public static Image getImage(Control aControl, int maxWidth, int maxHeight) {

        Rectangle rect = aControl.getBounds();
        if (rect.width <= 0 || rect.height <= 0)
            return null;

        Image image = new Image(aControl.getDisplay(), Math.min(rect.width, maxWidth), Math.min(rect.height, maxHeight));
        GC gc = new GC(image);
        
        // Need to handle cases where the GC font isn't automatically set by the control's image (e.g. CLabel)
        // see bug 98830 (https://bugs.eclipse.org/bugs/show_bug.cgi?id=98830)
        Font f = aControl.getFont();
        if (f != null)
            gc.setFont(f);
        aControl.print(gc);
        
        gc.dispose();
        return image;
    }
}