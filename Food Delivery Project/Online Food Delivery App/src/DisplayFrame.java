import javax.swing.DefaultComboBoxModel;

public class DisplayFrame extends javax.swing.JFrame {

    public DisplayFrame(Order o) {
        initComponents();
        jTextField1.setText(String.valueOf(o.getId()));
        jComboBox1.setSelectedItem(o.getBrand());
        jComboBox4.setSelectedItem(o.getBread());
        jCheckBox1.setSelected(o.isSpicy());
        jComboBox5.setSelectedItem(o.getDrink());
        jComboBox6.setSelectedItem(o.getSize());
        jCheckBox2.setSelected(o.isExtraCheese());
        jTextField8.setText(o.getDate());
        jComboBox2.setSelectedItem(o.getMenu());
        jComboBox3.setSelectedItem(o.getOrderway().getPaymentMethod());
        jTextField2.setText(String.valueOf(o.getOrderway().getDeliveryFee()));
        jSlider1.setValue(Integer.parseInt(o.getOrderway().getDeliveryTime()));

        if (jSlider1.getValue() == 0)
            jLabel15.setText("now");
        else
            jLabel15.setText(String.valueOf(jSlider1.getValue()) + " minutes later");

        BurgerKing bSelector;
        Arbys aSelector;
        McDonalds mSelector;

        switch (jComboBox1.getSelectedItem().toString()) {
            case "Burger King":
                bSelector = (BurgerKing) o;
                burgerKingUpdate();
                jComboBox7.setSelectedItem(bSelector.getAppetizer());
                jComboBox8.setSelectedItem(bSelector.getAdditionalChoice());
                jComboBox9.setSelectedItem(bSelector.getDessert());
                jComboBox2.setSelectedItem(o.getMenu());
                break;
            case "Arbys":
                aSelector = (Arbys) o;
                arbysUpdate();
                jComboBox7.setSelectedItem(aSelector.getSouce());
                jComboBox8.setSelectedItem(aSelector.getMeatType());
                jComboBox9.setSelectedItem(aSelector.getAdditionalChoice());
                jComboBox2.setSelectedItem(o.getMenu());
                break;
            case "McDonalds":
                mSelector = (McDonalds) o;
                mcDonaldsUpdate();
                jComboBox7.setSelectedItem(mSelector.getSouce());
                jComboBox8.setSelectedItem(mSelector.getDessert());
                jComboBox9.setSelectedItem(mSelector.getToysChoice());
                jComboBox2.setSelectedItem(o.getMenu());
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // ... Diğer kodlar

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Order");

        // ... Diğer kodlar

        jLabel18.setText("Promo Code:");

        jTextField3.setEnabled(false);

        // ... Diğer kodlar
    }// </editor-fold>//GEN-END:initComponents

    // Diğer metodlar

    public void burgerKingUpdate() {
        jLabel18.setVisible(true);
        jTextField3.setVisible(true);
        jLabel16.setText("Appetizer");
        jLabel17.setText("Additional Choice");
        jLabel19.setText("Dessert");
        jComboBox2.setModel(new DefaultComboBoxModel<>(BurgerKing.menuData));
        jComboBox7.setModel(new DefaultComboBoxModel<>(BurgerKing.appetizerData));
        jComboBox9.setModel(new DefaultComboBoxModel<>(BurgerKing.dessertData));
        jComboBox8.setModel(new DefaultComboBoxModel<>(BurgerKing.additionalChoiceData));
    }

    public void arbysUpdate() {
        jLabel18.setVisible(false);
        jTextField3.setVisible(false);
        jLabel16.setText("Souce");
        jLabel17.setText("Meat Type:");
        jLabel19.setText("Additional Choice");
        jComboBox2.setModel(new DefaultComboBoxModel<>(Arbys.menuData));
        jComboBox7.setModel(new DefaultComboBoxModel<>(Arbys.souceData));
        jComboBox9.setModel(new DefaultComboBoxModel<>(Arbys.additionalChoiceData));
        jComboBox8.setModel(new DefaultComboBoxModel<>(Arbys.meatTypeData));
    }

    public void mcDonaldsUpdate() {
        jLabel18.setVisible(false);
        jTextField3.setVisible(false);
        jLabel16.setText("Souce");
        jLabel17.setText("Dessert");
        jLabel19.setText("Toys Choice");
        jComboBox2.setModel(new DefaultComboBoxModel<>(McDonalds.menuData));
        jComboBox7.setModel(new DefaultComboBoxModel<>(McDonalds.souceData));
        jComboBox9.setModel(new DefaultComboBoxModel<>(McDonalds.toysChoiceData));
        jComboBox8.setModel(new DefaultComboBoxModel<>(McDonalds.dessertData));
    }

    // ... Diğer kodlar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirm;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}