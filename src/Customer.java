class Customer{

    private String OID;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String Tsize;

    public void setQty(int qty) {
        this.qty = qty;
    }

    private int qty;
    private double amount;


    private String status;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer(String OID, String phone, String Tsize, int qty, double amount, String status ){

        this.OID=OID;
        this.phone=phone;
        this.Tsize=Tsize;
        this.qty=qty;
        this.amount=amount;
        this.status=status;
    }

    public String getOid(){
        return OID;
    }
    public String getPhone(){
        return phone;
    }
    public String getSize(){
        return Tsize;
    }
    public int getQty(){
        return qty;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public double getAmount() {
        return amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setTsize(String tsize) {
        this.Tsize= tsize;
    }
}

