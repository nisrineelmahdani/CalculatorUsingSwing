package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class calculator  extends JFrame implements ActionListener{

   
    JLabel nombreOne = new JLabel("Nombre1:");
    JTextField jT1 = new JTextField(20);
    JLabel nombreTwo = new JLabel("Nombre2:");
    JTextField jT2 = new JTextField(20);
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> liste1 = new JList<>(model);//pour l'affichage des résultats
    String[] operation = { "+", "*", "/", "%" };
    JComboBox<String> operationselection = new JComboBox<>(operation);
    JButton calculer = new JButton("Calculer");
  
    public calculator() {
        Calculer(); // Call the method to set up the UI
    }
    public void Calculer() {
        // Window settings
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Styling components
        nombreOne.setFont(new Font("Arial", Font.BOLD, 20));
        nombreOne.setForeground(new Color(30, 144, 255));
        jT2.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreTwo.setFont(new Font("Arial", Font.BOLD, 14));
        nombreTwo.setForeground(new Color(30, 144, 255));
        jT2.setFont(new Font("Arial", Font.PLAIN, 14));
        calculer.setFont(new Font("Arial", Font.BOLD, 14));
        calculer.setBackground(new Color(60, 179, 113));
        calculer.setForeground(Color.WHITE);
        liste1.setFont(new Font("Arial", Font.PLAIN, 14));

        // Panel 1 (Input and Button)
        JPanel jp1 = new JPanel(new FlowLayout());
        jp1.add(nombreOne);
        jp1.add(jT1);
        jp1.add(nombreTwo);
        jp1.add(jT2);
        jp1.add(operationselection);
        jp1.add(calculer);

        // Panel 2 (Display Results)
        JPanel jp2 = new JPanel(new BorderLayout());
        liste1.setBackground(new Color(245, 245, 245)); // Light gray background for list
        jp2.add(new JScrollPane(liste1), BorderLayout.CENTER);

        // Add panels to frame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jp2, BorderLayout.CENTER);

        // Action listener for button
        calculer.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculer) {
            String input = jT1.getText();
            String inputTwo = jT2.getText();
            String selectedOperation = (String) operationselection.getSelectedItem();
            try {
                double a = Double.parseDouble(input);
              double b = Double.parseDouble(inputTwo);
double result;
                // Choose the currency class based on selection
                switch (selectedOperation) {
                    case "+":
                       result = a+b;
                        break;
                        case "*":
                        result = a*b;
                         break;
                         case "-":
                         result = a-b;
                          break;
                          case "/":
                          result = a/b;
                           break;
                           case "%":
                           result = a%b;
                            break;
                            default: result=0;
                }

                // Display the conversion results
                String resultat = " le résulat est:";
                resultat += String.format( " "+result);
               
                model.addElement(resultat);  // Add result to list

                jT1.setText("");
                jT2.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}

    

