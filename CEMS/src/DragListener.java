import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DragListener implements DropTargetListener {
	
	JLabel imgLabel;
	String imgPath;
	

	public DragListener(JLabel img) {
		
		this.imgLabel = img;
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub

	}

	// Get dropped image
	@Override
	public void drop(DropTargetDropEvent dtde) {

		// Accept dropped items
		dtde.acceptDrop(DnDConstants.ACTION_COPY);

		// We want dropped item
		Transferable t = dtde.getTransferable();

		// Get Data format of the items

		DataFlavor[] df = t.getTransferDataFlavors();

		// loop through flavors

		for (DataFlavor f : df) {

			try {
				
				//Check if items are file type

				if (f.isFlavorJavaFileListType()) {

					//get list of them
					
					List<File> files = (List<File>) t.getTransferData(f);
					
					//loop through them
					for(File file : files) {
						
						displayImage(file.getPath());
						
						
					}	
				}

			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Makesure it is an image file!");
				
			}
		}
	}
	
	public void displayImage(String path) {
		
		BufferedImage img = null;
		
		try {
			
			img = ImageIO.read(new File(path));
			
		} catch (Exception e) {
			
			
		}
		
		
		if(path != null) this.imgPath = path;
		ImageIcon icon = new ImageIcon(img);
		this.imgLabel.setIcon(icon);
		System.out.println(this.imgPath);
		
	}
	

}
