package Vendors;

import java.util.ArrayList;

/** vendor object not used */
public class VendorObject {

    public ArrayList<VendorObject> Vendors = new ArrayList<>();
    private String name;
    private int number;
    private String email;
    private  String business_type;
    private String vendor_sponsor;

    public VendorObject() {
        name = "you";
        number = 0;
        email = "you";
        business_type = "you";
        vendor_sponsor = "you";
    }

    public VendorObject (String name, int number, String email, String business_type, String vendor_sponsor) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.business_type = business_type;
        this.vendor_sponsor = vendor_sponsor;
    }

    public void addVendors(VendorObject vendors) {
       Vendors.add(vendors);
    }

    public ArrayList<VendorObject> getVendors() {
        return Vendors;
    }
}
