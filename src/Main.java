import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.*;


class swing extends JFrame {
    int orderNumber = 1;
    static Customer[] c1 = new Customer[0];
    static int i = 0;
    static int status =-1;
    static int Delete=-1;
    static  double amount = 0;

    private static void extendsArray() {
        Customer[] tempCustomerArray = new Customer[c1.length + 5];
        for (int i = 0; i < c1.length; i++) {
            tempCustomerArray[i] = c1[i];
        }
        c1 = tempCustomerArray;
    }


    public static void main(String[] args) {
        homePage();
    }

    public swing() {
        setSize(750, 500);
        setDefaultCloseOperation(3);
        setTitle("Fashion Shop");
        setLocationRelativeTo(null);

    }

    public static void homePage() {
        swing s1 = new swing();
        s1.getContentPane().setBackground(Color.YELLOW);

        JLabel title = new JLabel("Fashion Shop", JLabel.CENTER);
        title.setFont(new Font("", 1, 40));
        title.setOpaque(true);
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(title);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1));

        JButton b1 = new JButton("Search");
        b1.setBackground(new Color(255, 99, 71));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("", Font.BOLD, 16));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s1.searchD();
            }
        });
        b1.setPreferredSize(new Dimension(180, 40));
        JPanel tp1 = new JPanel();
        tp1.add(b1);
        p2.add(tp1);

        JButton b2 = new JButton("Status");
        b2.setBackground(new Color(50, 205, 50));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("", Font.BOLD, 16));
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                s1.dispose();
                orderstatus();
            }
        });
        b2.setPreferredSize(new Dimension(180, 40));
        JPanel tp2 = new JPanel();
        tp2.add(b2);
        p2.add(tp2);

        JButton b3 = new JButton("Reports");
        b3.setBackground(new Color(70, 130, 180));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("", Font.BOLD, 16));
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s1.dispose();
                reports();
            }
        });
        b3.setPreferredSize(new Dimension(180, 40));
        JPanel tp3 = new JPanel();
        tp3.add(b3);
        p2.add(tp3);

        JButton b4 = new JButton("Delete");
        b4.setBackground(new Color(255, 69, 0));
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("", Font.BOLD, 16));
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                s1.dispose();
                Delete();
            }
        });
        b4.setPreferredSize(new Dimension(180, 40));
        JPanel tp4 = new JPanel();
        tp4.add(b4);
        p2.add(tp4);

        JButton b5 = new JButton("Place order");
        b5.setBackground(new Color(255, 223, 0));
        b5.setFont(new Font("", Font.BOLD, 20));
        b5.setForeground(Color.BLACK);
        b5.setPreferredSize(new Dimension(180, 50));
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s1.dispose();
                PlaceOrder();
            }
        });
        JPanel tp5 = new JPanel();
        tp5.add(b5);
        p2.add(tp5);

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("D:\\New folder (16)\\img01.jpg");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);
        imageLabel.setIcon(imageIcon);
        JPanel tpi = new JPanel();
        tpi.add(imageLabel);
        JPanel panel = new JPanel();
        panel.add(tpi);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p2, BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.EAST);

        s1.add("North", p1);
        s1.add("Center", mainPanel);

        s1.setVisible(true);
    }



    public static void PlaceOrder() {
        swing s2 = new swing();
        s2.setTitle("Place Order");
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s2.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 20));
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add("West", b1);
        s2.add("North", p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1));

        JLabel l1 = new JLabel("Order ID : ");
        l1.setFont(new Font("", 2, 18));
        p2.add(l1);

        JLabel l2 = new JLabel("Customer ID : ");
        l2.setFont(new Font("", 2, 18));
        p2.add(l2);

        JLabel l3 = new JLabel("Size : ");
        l3.setFont(new Font("", 2, 18));
        p2.add(l3);

        JLabel l4 = new JLabel("Qty : ");
        l4.setFont(new Font("", 2, 18));
        p2.add(l4);

        JLabel l5 = new JLabel("Amount : ");
        l5.setFont(new Font("", 2, 18));
        p2.add(l5);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(5, 1));
        p3.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel lid = new JLabel();
        lid.setFont(new Font("", 2, 18));
        JPanel tp1 = new JPanel();
        tp1.add("West", lid);
        p3.add(tp1);

        JTextField cid = new JTextField(10);
        cid.setFont(new Font("", 2, 18));
        JPanel tp2 = new JPanel();
        tp2.add(cid);
        p3.add(tp2);

        JTextField size = new JTextField(10);
        size.setFont(new Font("", 2, 18));
        JPanel tp3 = new JPanel();
        tp3.add(size);
        p3.add(tp3);

        JTextField qty = new JTextField(10);
        qty.setFont(new Font("", 2, 18));
        JPanel tp4 = new JPanel();
        tp4.add(qty);
        p3.add(tp4);

        JLabel Amount = new JLabel("");
        Amount.setFont(new Font("", 2, 18));
        JPanel tp5 = new JPanel();
        tp5.add("West", Amount);
        p3.add(tp5);
        lid.setText("ODR#00001");

        DocumentListener calculateAmount = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateAmount();
            }

            public void removeUpdate(DocumentEvent e) {
                updateAmount();
            }

            public void changedUpdate(DocumentEvent e) {
                updateAmount();
            }

            private void updateAmount() {
                try {
                    String Size = size.getText().trim();
                    String QTY = qty.getText().trim();
                    int Qty = QTY.isEmpty() ? 0 : Integer.parseInt(QTY);
                    double amount = 0.0;

                    switch (Size.toUpperCase()) {
                        case "XS":
                            amount = Qty * 600.0;
                            break;
                        case "S":
                            amount = Qty * 800.0;
                            break;
                        case "M":
                            amount = Qty * 900.0;
                            break;
                        case "L":
                            amount = Qty * 1000.0;
                            break;
                        case "XL":
                            amount = Qty * 1100.0;
                            break;
                        case "XXL":
                            amount = Qty * 1200.0;
                            break;
                        default:
                            amount = 0.0;
                            break;
                    }
                    Amount.setText(amount > 0 ? String.valueOf(amount) : "");
                } catch (NumberFormatException ex) {
                    Amount.setText("Invalid Quantity");
                }
            }
        };

        size.getDocument().addDocumentListener(calculateAmount);
        qty.getDocument().addDocumentListener(calculateAmount);

        JButton b2 = new JButton("Place");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Phone = cid.getText();
                String Size = size.getText();
                String QTY = qty.getText();

                try {
                    int Qty = Integer.parseInt(QTY);
                    double amount = Double.parseDouble(Amount.getText());

                    if (Phone.matches("\\d{10}") && (Size.equalsIgnoreCase("xs") || Size.equalsIgnoreCase("s") ||
                            Size.equalsIgnoreCase("m") || Size.equalsIgnoreCase("l") ||
                            Size.equalsIgnoreCase("xl") || Size.equalsIgnoreCase("xxl"))) {

                        String id = lid.getText();
                        String status = "PROCESSING";
                        extendsArray();
                        c1[i] = new Customer(id, Phone, Size, Qty, amount, status);

                        cid.setText("");
                        size.setText("");
                        qty.setText("");
                        Amount.setText("");
                        s2.orderNumber++;
                        id = "ODR#" + String.format("%05d", s2.orderNumber);
                        i++;
                        lid.setText(id);

                        JOptionPane.showMessageDialog(s2, "Order Placed Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(s2, "Invalid input!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(s2, "Quantity must be a number!");
                }
            }
        });

        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.white);
        b2.setFont(new Font("", 1, 20));
        JPanel p4 = new JPanel();
        p4.setBorder(new EmptyBorder(0, 0, 10, 10));
        p4.setLayout(new BorderLayout());
        p4.add("East", b2);
        s2.add("South", p4);

        s2.add("Center", p3);
        s2.add("West", p2);
        s2.setVisible(true);
    }

    public static void search() {
        swing s3 = new swing();
        s3.setVisible(true);
        s3.setTitle("Search Customer");

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s3.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);

        JLabel cust = new JLabel("Enter Customer ID : ");
        cust.setFont(new Font("", 1, 16));
        String[] cname = {"Size", "QTY", "Amount"};
        DefaultTableModel dtm = new DefaultTableModel(cname, 0);
        JTable t01 = new JTable(dtm);
        JScrollPane tpane = new JScrollPane(t01);
        s3.add(tpane, BorderLayout.CENTER);
        JLabel l2 = new JLabel("0.0");

        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("", 2, 16));
        JButton b2 = new JButton("Search");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String phone = t1.getText();
                for (int j = 0; j < c1.length; j++) {

                    if (c1[j] != null && phone.equals(c1[j].getPhone())) {
                        if(c1[j]!=null) {
                            Object[] data = {c1[j].getSize(), c1[j].getQty(), c1[j].getAmount()};
                            dtm.addRow(data);
                            double a = c1[j].getAmount();
                            l2.setText(String.valueOf(a));
                        }
                    }
                }
            }
        });
        b2.setForeground(Color.white);
        b2.setBackground(Color.CYAN);
        b2.setFont(new Font("", 1, 16));

        JPanel p2 = new JPanel();
        p2.add(cust);
        p2.add(t1);
        p2.add(b2);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(p1, BorderLayout.WEST);
        northPanel.add(p2, BorderLayout.CENTER);
        s3.add(northPanel, BorderLayout.NORTH);

        JLabel l1 = new JLabel("Total  : ");
        l1.setFont(new Font("", 1, 16));
        l2.setFont(new Font("", 1, 16));
        JPanel p3 = new JPanel();
        p3.add(l1);
        p3.add(l2);
        s3.add(p3, BorderLayout.SOUTH);

    }

    public void searchD() {
        JDialog d1 = new JDialog(this, "Please select the option", true);
        d1.setSize(300, 150);
        d1.setLocationRelativeTo(this);

        d1.setLayout(new GridLayout(2, 1));
        JLabel l1 = new JLabel("Please select an option :");
        d1.add(l1);
        JButton b1 = new JButton("Search Customer");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d1.dispose();
                search();

            }
        });
        JButton b2 = new JButton("Search Order");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                d1.dispose();
                searchOrder();
            }
        });
        JButton b3 = new JButton("Cancel");
        JPanel p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        d1.add(p1);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d1.dispose();
            }
        });

        d1.setVisible(true);
    }

    public static void searchOrder() {
        swing s3 = new swing();
        s3.setVisible(true);
        s3.setTitle("Search Order");

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s3.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);

        JLabel cust = new JLabel("Enter Order ID : ");
        cust.setFont(new Font("", 1, 16));


        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("", 2, 16));
        JButton b2 = new JButton("Search");

        JPanel pl=new JPanel();
        pl.setLayout(new GridLayout(5,0));
        pl.setBorder(new EmptyBorder(40,30,0,0));
        JLabel l1=new JLabel("Customer ID    : ");
        l1.setFont(new Font("",1,16));
        pl.add(l1);

        JPanel pl2=new JPanel();
        pl2.setBorder(new EmptyBorder(40,20,0,0));
        pl2.setLayout(new GridLayout(5,0));
        JLabel lt1=new JLabel("");
        lt1.setFont(new Font("",1,16));
        pl2.add(lt1);

        JLabel l2=new JLabel("Size      : ");
        l2.setFont(new Font("",1,16));
        pl.add(l2);
        JLabel lt2=new JLabel("");
        lt2.setFont(new Font("",1,16));
        pl2.add(lt2);

        JLabel l3=new JLabel("QTY      : ");
        l3.setFont(new Font("",1,16));
        pl.add(l3);
        JLabel lt3=new JLabel("");
        lt3.setFont(new Font("",1,16));
        pl2.add(lt3);

        JLabel l4=new JLabel("Amount     : ");
        l4.setFont(new Font("",1,16));
        pl.add(l4);
        JLabel lt4=new JLabel("");
        lt4.setFont(new Font("",1,16));
        pl2.add(lt4);

        JLabel l5=new JLabel("Status      : ");
        l5.setFont(new Font("",1,16));
        pl.add(l5);
        JLabel lt5=new JLabel("");
        lt5.setFont(new Font("",1,16));
        pl2.add(lt5);

        s3.add("West",pl);
        s3.add("Center",pl2);


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String id = t1.getText();
                for (int j = 0; j < c1.length; j++) {

                    if (c1[j] != null && id.equals(c1[j].getOid())) {
                        String phone =c1[j].getPhone();
                        String size=c1[j].getSize();
                        String qty=c1[j].getQty()+"";
                        String Amount=c1[j].getAmount()+"";
                        String status=c1[j].getStatus();
                        lt1.setText(phone);
                        lt2.setText(size);
                        lt3.setText(qty);
                        lt4.setText(Amount);
                        lt5.setText(status);
                    }
                }
            }
        });
        b2.setForeground(Color.white);
        b2.setBackground(Color.CYAN);
        b2.setFont(new Font("", 1, 16));

        JPanel p2 = new JPanel();
        p2.add(cust);
        p2.add(t1);
        p2.add(b2);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(p1, BorderLayout.WEST);
        northPanel.add(p2, BorderLayout.CENTER);
        s3.add(northPanel, BorderLayout.NORTH);


    }
    public static void orderstatus(){
        swing s3 = new swing();
        s3.setVisible(true);
        s3.setTitle("Status Form");

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s3.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);

        JLabel cust = new JLabel("Enter Order ID : ");
        cust.setFont(new Font("", 1, 16));


        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("", 2, 16));
        JButton b2 = new JButton("Search");

        JPanel pl=new JPanel();
        pl.setLayout(new GridLayout(5,0));
        pl.setBorder(new EmptyBorder(40,30,0,0));
        JLabel l1=new JLabel("Customer ID    : ");
        l1.setFont(new Font("",1,16));
        pl.add(l1);

        JPanel pl2=new JPanel();
        pl2.setBorder(new EmptyBorder(40,20,0,0));
        pl2.setLayout(new GridLayout(5,0));
        JLabel lt1=new JLabel("");
        lt1.setFont(new Font("",1,16));
        pl2.add(lt1);

        JLabel l2=new JLabel("Size      : ");
        l2.setFont(new Font("",1,16));
        pl.add(l2);
        JLabel lt2=new JLabel("");
        lt2.setFont(new Font("",1,16));
        pl2.add(lt2);

        JLabel l3=new JLabel("QTY      : ");
        l3.setFont(new Font("",1,16));
        pl.add(l3);
        JLabel lt3=new JLabel("");
        lt3.setFont(new Font("",1,16));
        pl2.add(lt3);

        JLabel l4=new JLabel("Amount     : ");
        l4.setFont(new Font("",1,16));
        pl.add(l4);
        JLabel lt4=new JLabel("");
        lt4.setFont(new Font("",1,16));
        pl2.add(lt4);

        JLabel l5=new JLabel("Status      : ");
        l5.setFont(new Font("",1,16));
        pl.add(l5);
        JLabel lt5=new JLabel("");
        lt5.setFont(new Font("",1,16));
        pl2.add(lt5);

        s3.add("West",pl);
        s3.add("Center",pl2);


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String id = t1.getText();
                for (int j = 0; j < c1.length; j++) {

                    if (c1[j] != null &&id.equals(c1[j].getOid()) ) {
                        status=j;
                        String phone =c1[j].getPhone();
                        String size=c1[j].getSize();
                        String qty=c1[j].getQty()+"";
                        String Amount=c1[j].getAmount()+"";
                        String status=c1[j].getStatus();
                        lt1.setText(phone);
                        lt2.setText(size);
                        lt3.setText(qty);
                        lt4.setText(Amount);
                        lt5.setText(status);
                    }
                }
            }
        });
        b2.setForeground(Color.white);
        b2.setBackground(Color.CYAN);
        b2.setFont(new Font("", 1, 16));

        JPanel p2 = new JPanel();
        p2.add(cust);
        p2.add(t1);
        p2.add(b2);
        JButton bcs=new JButton("Change Status");
        bcs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                s3.JD2();
            }
        });
        bcs.setBackground(Color.BLUE);
        bcs.setForeground(Color.white);
        bcs.setOpaque(true);
        bcs.setFont(new Font("",1,16));
        JPanel pc=new JPanel();
        pc.add(bcs);
        s3.add("South",pc);
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(p1, BorderLayout.WEST);
        northPanel.add(p2, BorderLayout.CENTER);
        s3.add(northPanel, BorderLayout.NORTH);


    }
    public void JD2(){
        JDialog d1=new JDialog(this,"Status",true);
        d1.setSize(300,150);
        d1.setLocationRelativeTo(this);
        JLabel l1=new JLabel("Please Select the Status  : ");
        d1.add("Center",l1);

        JButton b1=new JButton("Delivering");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                c1[status].setStatus("DELIVERING");
            }
        });
        JButton b2=new JButton("Delivered");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                c1[status].setStatus("DELIVERED");
            }
        });
        JPanel p1=new JPanel(new GridLayout(1,2));
        p1.add(b1);
        p1.add(b2);
        d1.add("South",p1);

        d1.setVisible(true);
    }

    public static void Delete(){
        swing s3 = new swing();
        s3.setVisible(true);
        s3.setTitle("Status Form");

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s3.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);

        JLabel cust = new JLabel("Enter Order ID : ");
        cust.setFont(new Font("", 1, 16));


        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("", 2, 16));
        JButton b2 = new JButton("Search");

        JPanel pl=new JPanel();
        pl.setLayout(new GridLayout(5,0));
        pl.setBorder(new EmptyBorder(40,30,0,0));
        JLabel l1=new JLabel("Customer ID    : ");
        l1.setFont(new Font("",1,16));
        pl.add(l1);

        JPanel pl2=new JPanel();
        pl2.setBorder(new EmptyBorder(40,20,0,0));
        pl2.setLayout(new GridLayout(5,0));
        JLabel lt1=new JLabel("");
        lt1.setFont(new Font("",1,16));
        pl2.add(lt1);

        JLabel l2=new JLabel("Size      : ");
        l2.setFont(new Font("",1,16));
        pl.add(l2);
        JLabel lt2=new JLabel("");
        lt2.setFont(new Font("",1,16));
        pl2.add(lt2);

        JLabel l3=new JLabel("QTY      : ");
        l3.setFont(new Font("",1,16));
        pl.add(l3);
        JLabel lt3=new JLabel("");
        lt3.setFont(new Font("",1,16));
        pl2.add(lt3);

        JLabel l4=new JLabel("Amount     : ");
        l4.setFont(new Font("",1,16));
        pl.add(l4);
        JLabel lt4=new JLabel("");
        lt4.setFont(new Font("",1,16));
        pl2.add(lt4);

        JLabel l5=new JLabel("Status      : ");
        l5.setFont(new Font("",1,16));
        pl.add(l5);
        JLabel lt5=new JLabel("");
        lt5.setFont(new Font("",1,16));
        pl2.add(lt5);

        s3.add("West",pl);
        s3.add("Center",pl2);


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String id = t1.getText();
                for (int j = 0; j < c1.length; j++) {

                    if ( c1[j] != null&&id.equals(c1[j].getOid()) ) {
                        Delete=j;
                        String phone =c1[j].getPhone();
                        String size=c1[j].getSize();
                        String qty=c1[j].getQty()+"";
                        String Amount=c1[j].getAmount()+"";
                        String status=c1[j].getStatus();
                        lt1.setText(phone);
                        lt2.setText(size);
                        lt3.setText(qty);
                        lt4.setText(Amount);
                        lt5.setText(status);
                    }
                }
            }
        });
        b2.setForeground(Color.white);
        b2.setBackground(Color.CYAN);
        b2.setFont(new Font("", 1, 16));

        JPanel p2 = new JPanel();
        p2.add(cust);
        p2.add(t1);
        p2.add(b2);
        JButton bcs=new JButton("Delete Order");
        bcs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                c1[Delete]=null;
                JOptionPane.showMessageDialog(s3, "Order Deleted!");

            }
        });
        bcs.setBackground(Color.red);
        bcs.setForeground(Color.white);
        bcs.setOpaque(true);
        bcs.setFont(new Font("",1,16));
        JPanel pc=new JPanel();
        pc.add(bcs);
        s3.add("South",pc);
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(p1, BorderLayout.WEST);
        northPanel.add(p2, BorderLayout.CENTER);
        s3.add(northPanel, BorderLayout.NORTH);

    }

    public static void reports(){
        swing s5=new swing();
        s5.setVisible(true);
        s5.setTitle("Reports");
        s5.setSize(750,400);
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s5.dispose();
                homePage();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s5.add(p1, BorderLayout.NORTH);


        JButton b2 = new JButton("View Customers");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.Viewcust();
            }
        });
        b2.setFont(new Font("",1,13));
        b2.setPreferredSize(new Dimension(160, 40));
        JPanel p2=new JPanel();
        p2.setBorder(new EmptyBorder(50,10,30,0));
        JPanel t1=new JPanel();
        t1.add(b2);
        p2.setLayout(new GridLayout(3,0,5,5));
        p2.add(t1);
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.WHITE);
        s5.add(p2,"West");

        JButton b3 = new JButton("Best In Customers");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.bestCust();
            }
        });
        b3.setFont(new Font("",1,13));
        b3.setPreferredSize(new Dimension(160, 40));
        b3.setBackground(Color.GREEN);
        b3.setForeground(Color.WHITE);
        JPanel t2=new JPanel();
        t2.add(b3);
        p2.add(t2);

        JButton b4 = new JButton("All Customers");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.allcust();
            }
        });
        b4.setFont(new Font("",1,13));
        b4.setPreferredSize(new Dimension(160, 40));
        b4.setBackground(Color.GREEN);
        b4.setForeground(Color.WHITE);
        JPanel t3=new JPanel();
        t3.add(b4);
        p2.add(t3);

        JPanel p3=new JPanel();
        p3.setLayout(new GridLayout(2,0));
        p3.setBorder(new EmptyBorder(70,10,30,0));
        JButton b5 = new JButton("Categorized By QTY");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.categorizedByQty();
            }
        });
        b5.setFont(new Font("",1,13));
        b5.setPreferredSize(new Dimension(180, 40));
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);
        JPanel tp3=new JPanel();
        tp3.add(b5);
        p3.add("West",tp3);
        s5.add("Center",p3);


        JButton b6 = new JButton("Categorized By Amount");
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.categorizedByAmount();
            }
        });
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("",1,13));
        b6.setPreferredSize(new Dimension(180, 40));
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        JPanel tp4=new JPanel();
        tp4.add(b6);
        p3.add("West",tp4);

        JPanel p4 =new JPanel();
        p4.setBorder(new EmptyBorder(70,10,30,0));

        p4.setLayout(new GridLayout(2,0,5,5));
        JButton b7 = new JButton("Orders By Amount");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.Orderbyamo();
            }
        });
        b7.setFont(new Font("",1,13));
        b7.setPreferredSize(new Dimension(160, 40));
        JPanel tp5=new JPanel();
        tp5.add(b7);
        p4.add(tp5);
        b7.setBackground(Color.GRAY);
        b7.setForeground(Color.WHITE);
        s5.add("East",p4);

        JButton b8 = new JButton("All Orders");
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s5.dispose();
                s5.allcust();
            }
        });
        b8.setFont(new Font("",1,13));
        b8.setPreferredSize(new Dimension(160, 40));
        JPanel tp6=new JPanel();
        tp6.add(b8);
        p4.add(tp6);
        b8.setBackground(Color.GRAY);
        b8.setForeground(Color.WHITE);

    }

    public void Viewcust(){
        swing s3 = new swing();
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s3.dispose();
                reports();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s3.add(p1, BorderLayout.NORTH);

        String[] cname = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(cname, 0);
        JTable t01 = new JTable(dtm);
        JScrollPane tpane = new JScrollPane(t01);

        for (int j = 0; j < c1.length; j++) {
            if (c1[j] != null) {
                dtm.addRow(new Object[]{c1[j].getPhone(), c1[j].getQty(), c1[j].getAmount()});
            }
        }
        s3.setTitle("View Customer");
        s3.add(tpane, BorderLayout.CENTER);
        s3.setVisible(true);

    }
    public  void bestCust() {
        swing s6 = new swing();
        s6.setVisible(true);
        s6.setTitle("Best in Customers");
        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s6.dispose();
                reports();
            }
        });
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.setFont(new Font("", 1, 18));
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s6.add(p1, BorderLayout.NORTH);

        String[] cname = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(cname, 0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(t1);
        s6.add(jsp);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == null) continue;
            int index = i;
            for (int j = i + 1; j < c1.length; j++) {
                if (c1[j] != null && c1[index].getAmount() < c1[j].getAmount()) {
                    index = j;
                }
            }
            if (c1[i] != null && c1[index] != null) {

                Customer temp = c1[index];
                c1[index] = c1[i];
                c1[i] = temp;
            }
        }

        for (int j = 0; j < c1.length; j++) {
            if (c1[j] != null) {
                dtm.addRow(new Object[]{c1[j].getPhone(), c1[j].getQty(), c1[j].getAmount()});
            }
        }
    }
    public void allcust() {
        swing s7 = new swing();
        s7.setTitle("All Customer Reports");
        s7.setLayout(new BorderLayout());

        JButton b1 = new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("", Font.BOLD, 18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s7.add(p1, BorderLayout.NORTH);

        String[] columnNames = {"Customer ID", "XS", "S", "M", "L", "XL", "XXL", "Amount"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(t1);
        s7.add(jsp, BorderLayout.CENTER);

        for (int j = 0; j < c1.length; j++) {
            if (c1[j] != null) {
                int xsCount = 0, sCount = 0, mCount = 0, lCount = 0, xlCount = 0, xxlCount = 0;
                double totalAmount = 0;

                // Iterate over all customer orders to calculate the size counts and total amount
                for (int k = 0; k < c1.length; k++) {
                    if (c1[k] != null && c1[k].getPhone().equals(c1[j].getPhone())) {
                        switch (c1[k].getSize().toUpperCase()) {
                            case "XS":
                                xsCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                            case "S":
                                sCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                            case "M":
                                mCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                            case "L":
                                lCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                            case "XL":
                                xlCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                            case "XXL":
                                xxlCount++;
                                totalAmount += c1[k].getAmount();
                                break;
                        }
                    }
                }

                dtm.addRow(new Object[]{
                        c1[j].getPhone(),
                        xsCount,
                        sCount,
                        mCount,
                        lCount,
                        xlCount,
                        xxlCount,
                        totalAmount
                });
            }
        }

        s7.setVisible(true);
    }
    public void categorizedByQty() {
        swing s7 = new swing();
        s7.setTitle("Items Categorized By QTY");
        s7.setLayout(new BorderLayout());

        JButton b1 = new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("", Font.BOLD, 18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s7.add(p1, BorderLayout.NORTH);

        String[] columnNames = {"Size", "QTY", "Amount"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(t1);
        s7.add(jsp, BorderLayout.CENTER);

        int xsCount = 0, sCount = 0, mCount = 0, lCount = 0, xlCount = 0, xxlCount = 0;
        double totalAmountXS = 0, totalAmountS = 0, totalAmountM = 0, totalAmountL = 0, totalAmountXL = 0, totalAmountXXL = 0;

        for (int k = 0; k < c1.length; k++) {
            if (c1[k] != null) {
                switch (c1[k].getSize().toUpperCase()) {
                    case "XS":
                        xsCount++;
                        totalAmountXS += c1[k].getAmount();
                        break;
                    case "S":
                        sCount++;
                        totalAmountS += c1[k].getAmount();
                        break;
                    case "M":
                        mCount++;
                        totalAmountM += c1[k].getAmount();
                        break;
                    case "L":
                        lCount++;
                        totalAmountL += c1[k].getAmount();
                        break;
                    case "XL":
                        xlCount++;
                        totalAmountXL += c1[k].getAmount();
                        break;
                    case "XXL":
                        xxlCount++;
                        totalAmountXXL += c1[k].getAmount();
                        break;
                }
            }
        }

        dtm.addRow(new Object[]{"S", sCount, totalAmountS});
        dtm.addRow(new Object[]{"M", mCount, totalAmountM});
        dtm.addRow(new Object[]{"XS", xsCount, totalAmountXS});
        dtm.addRow(new Object[]{"L", lCount, totalAmountL});
        dtm.addRow(new Object[]{"XL", xlCount, totalAmountXL});
        dtm.addRow(new Object[]{"XXL", xxlCount, totalAmountXXL});

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
        t1.setRowSorter(sorter);
        sorter.setComparator(1, (q1, q2) -> Integer.compare((int) q2, (int) q1));

        s7.setVisible(true);
    }


    public void allorders(){
        swing s7=new swing();
        s7.setTitle("All Order");
        s7.setLayout(new BorderLayout());

        JButton b1 =new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("",Font.BOLD,18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1,BorderLayout.WEST);
        s7.add(p1,BorderLayout.NORTH);

        String[] columnNames ={"Order Id","Customer ID","T-Shirt Size","QTY","Amount","Status"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp =new JScrollPane(t1);
        s7.add(jsp,BorderLayout.CENTER);
        for (int j = 0; j < c1.length; j++) {
            if (c1[j] !=null) {
                dtm.addRow(new Object[]{ c1[j].getOid(),c1[j].getPhone(),c1[j].getSize(),c1[j].getQty(),c1[j].getAmount(),c1[j].getStatus()});
            }
        }
        s7.setVisible(true);
    }
    public void Orderbyamo(){
        swing s7=new swing();
        s7.setTitle("All Order");
        s7.setLayout(new BorderLayout());

        JButton b1 =new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("",Font.BOLD,18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1,BorderLayout.WEST);
        s7.add(p1,BorderLayout.NORTH);

        String[] columnNames ={"Order Id","Customer ID","T-Shirt Size","QTY","Amount","Status"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp =new JScrollPane(t1);
        s7.add(jsp,BorderLayout.CENTER);
        for (int j = 0; j < c1.length; j++) {
            if (c1[j] !=null) {
                dtm.addRow(new Object[]{ c1[j].getOid(),c1[j].getPhone(),c1[j].getSize(),c1[j].getQty(),c1[j].getAmount(),c1[j].getStatus()});
            }
        }
        s7.setVisible(true);
    }
    public void obyqty(){

        swing s7=new swing();
        s7.setTitle("All Customer Reports");
        s7.setLayout(new BorderLayout());

        JButton b1 =new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("",Font.BOLD,18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1,BorderLayout.WEST);
        s7.add(p1,BorderLayout.NORTH);

        String[] columnNames ={"Customer ID","T-Shirt Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp =new JScrollPane(t1);
        s7.add(jsp,BorderLayout.CENTER);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == null) continue;
            int index = i;
            for (int j = i + 1; j < c1.length; j++) {
                if (c1[j] != null && c1[index].getQty() < c1[j].getQty()) {
                    index = j;
                }
            }
            if (c1[i] != null && c1[index] != null) {

                Customer temp = c1[index];
                c1[index] = c1[i];
                c1[i] = temp;
            }
        }
        for (int j = 0; j < c1.length; j++) {
            if (c1[j] !=null) {
                dtm.addRow(new Object[]{c1[j].getPhone(),c1[j].getSize(),c1[j].getQty(),c1[j].getAmount()});
            }
        }
        s7.setVisible(true);

    }
    public void categorizedByAmount() {
        swing s7 = new swing();
        s7.setTitle("Items Categorized By Amount");
        s7.setLayout(new BorderLayout());

        JButton b1 = new JButton("Back");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("", Font.BOLD, 18));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s7.dispose();
                reports();
            }
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(b1, BorderLayout.WEST);
        s7.add(p1, BorderLayout.NORTH);

        String[] columnNames = {"Size", "QTY", "Amount"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        JTable t1 = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(t1);
        s7.add(jsp, BorderLayout.CENTER);

        int xsCount = 0, sCount = 0, mCount = 0, lCount = 0, xlCount = 0, xxlCount = 0;
        double totalAmountXS = 0, totalAmountS = 0, totalAmountM = 0, totalAmountL = 0, totalAmountXL = 0, totalAmountXXL = 0;

        for (int k = 0; k < c1.length; k++) {
            if (c1[k] != null) {
                switch (c1[k].getSize().toUpperCase()) {
                    case "XS":
                        xsCount++;
                        totalAmountXS += c1[k].getAmount();
                        break;
                    case "S":
                        sCount++;
                        totalAmountS += c1[k].getAmount();
                        break;
                    case "M":
                        mCount++;
                        totalAmountM += c1[k].getAmount();
                        break;
                    case "L":
                        lCount++;
                        totalAmountL += c1[k].getAmount();
                        break;
                    case "XL":
                        xlCount++;
                        totalAmountXL += c1[k].getAmount();
                        break;
                    case "XXL":
                        xxlCount++;
                        totalAmountXXL += c1[k].getAmount();
                        break;
                }
            }
        }

        Object[][] sizeData = {
                {"S", sCount, totalAmountS},
                {"M", mCount, totalAmountM},
                {"XS", xsCount, totalAmountXS},
                {"L", lCount, totalAmountL},
                {"XL", xlCount, totalAmountXL},
                {"XXL", xxlCount, totalAmountXXL}
        };

        Arrays.sort(sizeData, (a, b) -> Double.compare((double) b[2], (double) a[2]));

        for (Object[] row : sizeData) {
            dtm.addRow(row);
        }

        s7.setVisible(true);
    }

}