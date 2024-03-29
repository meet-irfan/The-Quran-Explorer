
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18077
 */
public class FirstForm extends javax.swing.JFrame {

    /**
     * Creates new form FirstForm
     */
    Tree[] bst = new Tree[26];
    public FirstForm() {
        initComponents();
        loadBST();
    }
    
    public void loadBST(){
        for(int i = 0 ; i < 26; i++){
            bst[i] = new Tree();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Main.FilePath + "\\wordList.txt"));
            String line = reader.readLine();
            while(line != null){
                //separating word and ayat numbers
                int id = line.indexOf("   ");
                String word = line.substring(0, id);
                String ayats = line.substring(id+3);
                //inserting ayat numbers in linkedlist of word Tags
                while(ayats != null){
                    int ayat = Integer.parseInt(ayats.substring(0,5));
                    bst[word.charAt(0) - 97].insert(word, ayat);
                    if(ayats.length() > 6){
                        ayats = ayats.substring(6);
                    } else {
                        ayats = null;
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("File Not Found Exeption (wordlist.txt)");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayList = new javax.swing.JList<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("الم - Search");
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 102, 0));

        Name.setBackground(new java.awt.Color(255, 204, 0));
        Name.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 153, 0));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("الم");

        SearchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        DisplayList.setBackground(new java.awt.Color(153, 255, 153));
        DisplayList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DisplayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DisplayListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DisplayList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DisplayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DisplayListValueChanged
        String selectedText = DisplayList.getSelectedValue();
        SearchField.setText(selectedText);
    }//GEN-LAST:event_DisplayListValueChanged

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        DefaultListModel m1 = new DefaultListModel();
        String search = SearchField.getText().toLowerCase();
        if(!search.equals("")){
            if(!Character.isDigit(search.charAt(0))){
                search = bst[(int)search.charAt(0) - 97].toString();
                while(search != null){
                    int id = search.indexOf(" ");
                    m1.addElement(search.substring(0,id));
                    if(id != search.length() - 1){
                        search = search.substring(id+1);
                    } else {
                        search = null;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Search Ayat without using english characters only");
                SearchField.setText("");
            }
        } else {
            m1.clear();
        }
        DisplayList.setModel(m1);
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String text = SearchField.getText();
        if(!Character.isDigit(text.charAt(0))){
            if(bst[text.charAt(0) - 97].find(text) == null){
                JOptionPane.showMessageDialog(null, "Select word from Search List");
            } else {
                if(text != null){
                    SecondForm form = new SecondForm(text,bst);
                    form.setLocationRelativeTo(this);
                    form.setVisible(true); 
                    this.setVisible(false);
                    this.dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Search Ayat without using english characters only");
            SearchField.setText("");
        }
        
    }//GEN-LAST:event_SearchButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DisplayList;
    private javax.swing.JLabel Name;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
