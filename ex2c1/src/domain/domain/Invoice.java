package domain.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Invoice {
    private int invoiceId;
    private int status;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    private Apartment apartment = null;
    private Invoice[] apartments;

    /**
     *
     * @param status
     * @param invoiceDate
     * @param dueDate
     */
    public Invoice(int status, LocalDateTime invoiceDate, LocalDateTime dueDate, Apartment apartment) {
        this.invoiceId = DbContext.getNextLineItemId();
        this.status = status;
        this.invoiceDate = invoiceDate;
        this.dueDate =  dueDate;
        this.apartment = apartment;
    }

    public Invoice(Invoice invoice) {
        this.invoiceId = invoice.invoiceId;
        this.status = invoice.status;
        this.invoiceDate = invoice.invoiceDate;
        this.dueDate = invoice.dueDate;
        this.apartment = invoice.apartment;
        for (LineItem lineItem : invoice.lineItems) {
            this.lineItems.add(lineItem.copy());
        }
    }

    public Invoice copy() {
//        Invoice invoice = new Invoice(this.status, this.invoiceDate, this.dueDate);
//        invoice.invoiceId = this.invoiceId;
//        return invoice;
        return new Invoice(this);
    }

    /**
     *
     * @param lineItem
     */
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(new LineItem(lineItem));

    }
    public void addLineItem(int index, LineItem lineItem) {
        this.lineItems.add(index, new LineItem(lineItem));
    }

    /**
     *
     * @param index
     */
    public LineItem removeLineItem(int index) {
        LineItem lineItem = null;
        if (index >=0 && index < this.lineItems.size()) {
            lineItem = this.lineItems.get(index).copy();
            this.lineItems.remove(index);
        }
       return lineItem;
    }

    /**
     *
     * @param lineItem
     */
    public LineItem removeLineItem(LineItem lineItem) {
        LineItem removedLineItem = null;
        int index = this.lineItems.indexOf(lineItem);
        if (index != -1) {
            removedLineItem = this.lineItems.get(index).copy();
            this.lineItems.remove(index);
        }
        return removedLineItem;
    }

    public double total() {
        double total = 0.0;
        for (LineItem lineItem : this.lineItems) {
            total += lineItem.getAmount();
        }
    return total;
    }





    public int getInvoiceId() {
        return invoiceId;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getInvoiceDate() {

        return invoiceDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate.format(formatter) +
                ", dueDate=" + dueDate.format(formatter) +
                '}';
    }
    public String toShortString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return Integer.toString(invoiceId) +
                ", status=" + status +
                ", " + invoiceDate.format(formatter);
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }


    public LineItem getLineItem(int index) {
        LineItem lineItem = null;
        if (index <this.lineItems.size())
            lineItem = lineItems.get(index).copy();

        return lineItem;
    }

    public ArrayList<LineItem> getLineItems() {
        ArrayList<LineItem> lineItems = new ArrayList <>();
        for (LineItem lineItem : this.lineItems) {
            lineItems.add(lineItem.copy());
        }
        return lineItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getStatus() == invoice.getStatus() &&
                this.invoiceDate.equals(invoice.invoiceDate) &&
                this.dueDate.equals(invoice.dueDate);
    }


    public ArrayList<Apartment> getApartment() {
        ArrayList<Apartment> apartments = new ArrayList <>();
        for (Invoice invoice : this.apartments) {
            apartments.add(apartment.copy());
        }
        return apartments;
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(getInvoiceId(), getStatus(), getInvoiceDate(), getDueDate());
//    }
}