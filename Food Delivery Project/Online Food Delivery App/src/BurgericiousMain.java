public class BurgericiousMain {
    public static void main(String[] args) {
        // Initial rates
        Arbys.rating = 4.9;
        McDonalds.rating = 4.1;
        BurgerKing.rating = 2.3;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewOrderFrame newOrder = new NewOrderFrame();
                MainFrame mainFrame = new MainFrame(newOrder);
                mainFrame.setVisible(true);
            }
        });
    }
}