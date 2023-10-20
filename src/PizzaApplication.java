import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaApplication {

    public  static String title = "Welcome to Pizza Palace";
    public  static String pizzaSizeMessage="Please Choose a Pizza Size!!!";
    public  static String pizzaSizeMessageWindow="You Didn't Choose a Size!!!";
    public  static String noOfPizzasMessage="Please enter the number of Pizzas!!!";
    public  static String toppings="Toppings:";

    ArrayList<String> pizzaSizes = new ArrayList<String>();
    ArrayList<String> toppingsList = new ArrayList<String>();

    public PizzaApplication() {
        pizzaSizes.add("Number of Pizzas");
        pizzaSizes.add("Pizza Size");
        pizzaSizes.add("Regular");
        pizzaSizes.add("Small");
        pizzaSizes.add("Medium");
        pizzaSizes.add("Large");

        toppingsList.add("Black Olives");
        toppingsList.add("Mushroom");
        toppingsList.add("Extra Cheese");
        toppingsList.add("Pepperoni");
        toppingsList.add("GreenPepper");
    }

    public ArrayList<String> getToppingsList() {
        return toppingsList;
    }

    public ArrayList<String> getPizzaSizes() {
        return pizzaSizes;
    }

    public static void main (String[] args) {

        PizzaPage frame=new PizzaPage();

        frame.setTitle(title);
        frame.setSize(600,600);
        frame.setResizable(true);
        frame.setVisible(true);

        /*Center the window*/
        frame.setLocationRelativeTo(null);

    }
}

class PizzaPage extends JFrame
{
    private static final long serialVersionUID = 1L;

    /*Declare Components to be used in the PizzaPage*/

    private JButton CalcPrice, NextOrder,NewCust,Exit;
    private JLabel PizzaSizeLabel,Toppings;
    private JRadioButton Small, Medium, Large;
    private JCheckBox BlackOlives,Mushroom,ExtraCheese,Pepporoni,GreenPepper;
    private ButtonGroup group;

    private JLabel imageLabel,imageLabel2,imageLabel3;
    private JTextField NumberOfPizzasText;
    private JTextArea ta;
    private JScrollPane scrollPane;

    private JPanel pNorth, pSouth, pCenter, pSideText;

    private JPanel pSidePanel,pTopSide,pBotSide,pMidSide;

    /*Temporary Variables*/
    private double grandTotal=0;
    ImageIcon image;
    private double price;
    private int toppingsCount,pizzaCount;
    private double toppingsPrice;
    private String toppingsList;
    private String pizzaSize;

    public PizzaPage()
    {
        PizzaApplication papp = new PizzaApplication();

        ArrayList<String> sizes = papp.getPizzaSizes();

        ArrayList<String> tops = papp.getToppingsList();

        toppingsList=sizes.get(2);
        grandTotal=0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container window=getContentPane();

        window.setLayout(new BorderLayout(10,10));

        NumberOfPizzasText=new JTextField("0",2);
        NumberOfPizzasText.setEditable(true);
        NumberOfPizzasText.setToolTipText(sizes.get(0));

        ta=new JTextArea("",20,20);
        ta.setEditable(false);
        scrollPane=new JScrollPane(ta);

        pNorth=new JPanel();
        pNorth.setLayout(new GridLayout(1,3));

        pCenter=new JPanel();
        pCenter.setLayout(new GridLayout(1,2));

        pTopSide=new JPanel();
        pTopSide.setLayout(new GridLayout(1,4));
        pTopSide.setBorder(BorderFactory.createMatteBorder(
                0, 0, 5, 0, Color.gray));
        pMidSide=new JPanel();
        pMidSide.setLayout(new GridLayout(6,1));

        pBotSide=new JPanel();
        pBotSide.setLayout(new GridLayout(1,4));
        pBotSide.setBorder(BorderFactory.createMatteBorder(
                5, 0, 0, 0, Color.gray));

        pSouth=new JPanel();
        pSouth.setLayout(new GridLayout(1,4));

        Small =new JRadioButton(sizes.get(3));
        Medium =new JRadioButton(sizes.get(4));
        Large =new JRadioButton(sizes.get(5));

        group=new ButtonGroup();
        group.add(Small);
        group.add(Medium);
        group.add(Large);

        imageLabel=new JLabel();
        imageLabel2=new JLabel();
        imageLabel3=new JLabel();

        imageLabel.setIcon(image);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.WHITE);

        imageLabel2.setText("<html><FONT SIZE=10>"+PizzaApplication.title+"</FONT></html>");
        imageLabel2.setOpaque(true);
        imageLabel2.setBackground(Color.WHITE);

        imageLabel3.setIcon(image);
        imageLabel3.setOpaque(true);
        imageLabel3.setBackground(Color.WHITE);

        pNorth.add(imageLabel);
        pNorth.add(imageLabel2);
        pNorth.add(imageLabel3);

        pSideText=new JPanel();
        pSideText.setLayout(new GridLayout(1,1));
        pSideText.add(scrollPane);

        Toppings=new JLabel(PizzaApplication.toppings);
        BlackOlives=new JCheckBox(tops.get(0));
        Mushroom=new JCheckBox(tops.get(1));
        ExtraCheese=new JCheckBox(tops.get(2));
        Pepporoni=new JCheckBox(tops.get(3));
        GreenPepper=new JCheckBox(tops.get(4));

        pMidSide.add(Toppings);
        pMidSide.add(BlackOlives);
        pMidSide.add(Mushroom);
        pMidSide.add(ExtraCheese);
        pMidSide.add(Pepporoni);
        pMidSide.add(GreenPepper);

        pBotSide.add(new JLabel(sizes.get(0)));
        pBotSide.add(NumberOfPizzasText);

        PizzaSizeLabel=new JLabel(sizes.get(1));

        pTopSide.add(PizzaSizeLabel);
        pTopSide.add(Small);
        pTopSide.add(Medium);
        pTopSide.add(Large);

        pSidePanel=new JPanel();
        pSidePanel.setLayout(new BorderLayout(10,10));
        pSidePanel.add("North",pTopSide);
        pSidePanel.add("Center",pMidSide);
        pSidePanel.add("South",pBotSide);

        CalcPrice = new JButton("Calculate Price");
        NextOrder =new JButton("Another Order");
        NewCust=new JButton("New Customer");
        Exit=new JButton("Exit");

        pSouth.add(CalcPrice);
        pSouth.add(NextOrder);
        pSouth.add(NewCust);
        pSouth.add(Exit);

        ClickAction handler=new ClickAction();
        CalcPrice.addActionListener(handler);
        NewCust.addActionListener(handler);
        NextOrder.addActionListener(handler);
        Exit.addActionListener(handler);


        pCenter.add(pSidePanel);
        pCenter.add(pSideText);

        window.add("North",pNorth);
        window.add("Center",pCenter);
        window.add("South",pSouth);

    }

    private class ClickAction implements ActionListener
    {
        PizzaApplication papp = new PizzaApplication();

        ArrayList<String> sizes = papp.getPizzaSizes();
        ArrayList<String> toppingsList1 = papp.getToppingsList();

        boolean clearFields=false;
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==CalcPrice)
            {
                getRadioButton();
                getCheckedBoxes();
                try
                {
                    pizzaCount=Integer.valueOf(NumberOfPizzasText.getText());

                    if(pizzaCount<1){
                        noOfPizzaException();
                        clearFields=true;
                    }
                    else if(pizzaCount>0)
                    {

                        ta.append(sizes.get(1)+": ");
                        ta.append(pizzaSize+"($"+price+")"+"\n");
                        ta.append("Price of each Pizza without Tax: ");
                        if(toppingsCount>=1)
                        {
                            toppingsPrice = toppingsCount * 0.6;
                            price+=toppingsPrice;
                        }
                        ta.append(price+"\n");
                        ta.append("Number of Toppings: ");
                        ta.append(toppingsCount+"\n");
                        ta.append("Toppings: ");
                        ta.append(toppingsList+"\n");
                        ta.append("NumberOfPizzas: ");
                        ta.append(pizzaCount+"\n");
                        ta.append("SalesTax: ");
                        ta.append(((0.08*price*pizzaCount))+"\n");
                        ta.append("Total: ");

                        price=((0.08*price*pizzaCount)+price*pizzaCount);
                        ta.append(price+"\n\n");

                        grandTotal+=price;
                        ta.append("Grand Total: $");
                        ta.append(grandTotal+"\n\n");
                    }
                }
                catch(Exception e)
                {
                    JPanel warning=new JPanel();
                    JOptionPane.showMessageDialog
                            (warning,
                                    "Please Enter a Positive Integer more than 0 in the Number of Pizzas Field!!!",
                                    "Not a Integer Problem!!!",
                                    JOptionPane.ERROR_MESSAGE
                            );

                    clearFields= true;
                }

                if(!clearFields) {
                    group.clearSelection();
                    BlackOlives.setSelected(false);
                    Mushroom.setSelected(false);
                    ExtraCheese.setSelected(false);
                    Pepporoni.setSelected(false);
                    GreenPepper.setSelected(false);
                    NumberOfPizzasText.setText("");
                }

            }

            if(event.getSource()==Exit)
            {
                System.exit(0);
            }

            if(event.getSource()== NextOrder)
            {
                group.clearSelection();
                BlackOlives.setSelected(false);
                Mushroom.setSelected(false);
                ExtraCheese.setSelected(false);
                Pepporoni.setSelected(false);
                GreenPepper.setSelected(false);
                NumberOfPizzasText.setText("");
            }

            if(event.getSource()==NewCust)
            {
                ta.setText("");
                grandTotal=0;
                group.clearSelection();
                BlackOlives.setSelected(false);
                Mushroom.setSelected(false);
                ExtraCheese.setSelected(false);
                Pepporoni.setSelected(false);
                GreenPepper.setSelected(false);
                NumberOfPizzasText.setText("");
            }
        }
    }

    private void getRadioButton()
    {

        price = 0.0;
        if(Small.isSelected())
        {
            pizzaSize="Small";
            price = 12.0;
        }
        else if(Medium.isSelected())
        {
            pizzaSize="Medium";
            price = 14.0;
        }
        else if(Large.isSelected())
        {
            pizzaSize="Large";
            price = 16.0;
        }
    }

    private void noOfPizzaException(){

        PizzaApplication papp = new PizzaApplication();

        ArrayList<String> sizes = papp.getPizzaSizes();

        JPanel warning=new JPanel();
        JOptionPane.showMessageDialog
                (warning,
                        PizzaApplication.noOfPizzasMessage,
                        sizes.get(0),
                        JOptionPane.ERROR_MESSAGE
                );

    }

    private void getCheckedBoxes()
    {

        PizzaApplication papp = new PizzaApplication();

        ArrayList<String> toppingsList1 = papp.getToppingsList();

        toppingsCount=0;
        toppingsList="Regular";
        if(price==0.0)
        {
            JPanel warning=new JPanel();
            JOptionPane.showMessageDialog
                    (warning,
                            PizzaApplication.pizzaSizeMessage,
                            PizzaApplication.pizzaSizeMessageWindow,
                            JOptionPane.ERROR_MESSAGE
                    );
        }
        else
        {
            if(BlackOlives.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", "+toppingsList1.get(0);
            }
            if(Mushroom.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", "+toppingsList1.get(1);
            }
            if(ExtraCheese.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", "+toppingsList1.get(2);
            }
            if(Pepporoni.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", "+toppingsList1.get(3);
            }
            if(GreenPepper.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", "+toppingsList1.get(4);
            }

        }
    }
}
