import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class SaleRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Sale) {
            setText("Sale Code: " + ((Sale)value).getSaleCode() + " | Product: " + ((Sale)value).getSaleProduct().getModel()
            		+ " | Full Name: " + ((Sale)value).getCustomerName() + " " + ((Sale)value).getCustomerSurname());
        }
        return this;
    }
}