
import java.io.*;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18077
 */
public class SecondForm extends javax.swing.JFrame {
    
    /**
     * Creates new form SecondForm
     */
    public String word;
    
    private String[] Surah;
    private Tree[] bst;
            
    public SecondForm() {
        initComponents();
        loadSurah();
    }
    
    public SecondForm(String word, Tree[] bst) {
        this.word = word;
        this.bst = bst;
        loadSurah();
        initComponents();
        displayAyats();
    }
    
    protected void loadSurah(){
        Surah = new String[115];
        BufferedReader reader;
        int i = 0;
	try {
            reader = new BufferedReader(new FileReader(Main.FilePath+"\\SurahNames.txt"));
            for(i = 1 ; i < 115; i++){
                Surah[i] = reader.readLine();
            }
            reader.close();
	} catch (IOException e) {
            System.out.println("Surah names file not found");
	}
    }
    
    public void displayAyats(){
        DefaultListModel m1 = new DefaultListModel();
        LinkedList<Integer> tag = bst[word.charAt(0) - 97].find(word).getAyats();
        for(int i = 0 ; i < tag.size(); i++){
            int an = tag.get(i);
            int sn = an/1000;
            an = an % 1000;
            m1.addElement(Surah[sn] + "(" + sn + ":" + an + ")");
        }
        DisplayList.setModel(m1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayList = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("الم - Ayats with '" + word + "'");
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 102, 0));

        Name.setBackground(new java.awt.Color(255, 204, 0));
        Name.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 204, 0));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("الم");

        DisplayList.setBackground(new java.awt.Color(153, 255, 153));
        DisplayList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DisplayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DisplayListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DisplayList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ayat(s) Linked with '" + word + "'");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DisplayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DisplayListValueChanged
        ThirdForm form = new ThirdForm(word,DisplayList.getSelectedIndex(),bst);
        form.setLocationRelativeTo(this);
        form.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_DisplayListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DisplayList;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
