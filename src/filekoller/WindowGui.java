package filekoller;

import java.awt.event.*;

public class WindowGui extends javax.swing.JFrame {

    /**
     * Creates new form StarterGUI
     */
    public WindowGui() {
        initComponents();
        starter = new Window(this);
        register();
    }

    private void register()
    {
        goButton.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae )
            {
                starter.openPath( pathComboBox.getSelectedItem().toString() );
            }
        });

        testButton.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae )
            {
                starter.printTestMessage();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowGui().setVisible(true);
            }
        });
    }

    private Window starter;

   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pathComboBox = new javax.swing.JComboBox<>();
        goButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();
        mainSplitPane = new javax.swing.JSplitPane();
        leftScrollPane = new javax.swing.JScrollPane();
        filesystemTree = new javax.swing.JTree();
        rightScrollPane = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        toolsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pathComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<html><i>My Computer</i></html>", "C:\\", "C:\\Users\\Chrille", "<html><i>My Documents</i></html>", "<html><i>Downloads</i></html>", " " }));

            goButton.setText("Go");

            testButton.setText("Ts");

            mainSplitPane.setDividerLocation(200);
            mainSplitPane.setDividerSize(4);
            mainSplitPane.setContinuousLayout(true);
            mainSplitPane.setLastDividerLocation(165);
            mainSplitPane.setName(""); // NOI18N

            javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("My Computer");
            javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Favorites");
            javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Downloads");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Documents");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Pictures");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Videos");
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Documents");
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Offerter");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Läxor");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Arbetet");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Samfälligheten");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Minneslistor");
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("C: (System)");
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Drivers");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PerfLogs");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Program Files");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Program Files (x86)");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ProgramData");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Temp");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Users");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Windows");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Work");
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("D: (SD Card)");
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Camera");
            javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0100");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0110");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0120");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0130");
            treeNode3.add(treeNode4);
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("E: (Ericsson Xperia)");
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sync");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Contacts");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Album");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Camera");
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0100");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0110");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0120");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0130");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0140");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("DSL_0150");
            treeNode3.add(treeNode4);
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            filesystemTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            filesystemTree.setExpandsSelectedPaths(false);
            leftScrollPane.setViewportView(filesystemTree);

            mainSplitPane.setLeftComponent(leftScrollPane);

            fileList.setModel(new javax.swing.AbstractListModel<String>()
            {
                String[] strings = { "FrameList.java", "README.txt", "SerializableTest.java", "<html><b>SETUP.EXE</b></html>", "Test.java", "TestGui.java", " " };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            rightScrollPane.setViewportView(fileList);

            mainSplitPane.setRightComponent(rightScrollPane);

            fileMenu.setText("File");
            fileMenu.setToolTipText("File system operations");
            fileMenu.setActionCommand("&File");
            menuBar.add(fileMenu);

            editMenu.setText("Edit");
            editMenu.setToolTipText("Editing of objects and metadata");
            menuBar.add(editMenu);

            viewMenu.setText("View");
            viewMenu.setToolTipText("Visual options");
            menuBar.add(viewMenu);

            toolsMenu.setText("Tools");
            toolsMenu.setToolTipText("Advanced tools");
            menuBar.add(toolsMenu);

            setJMenuBar(menuBar);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pathComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goButton)
                        .addComponent(testButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JList<String> fileList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTree filesystemTree;
    private javax.swing.JButton goButton;
    private javax.swing.JScrollPane leftScrollPane;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox<String> pathComboBox;
    private javax.swing.JScrollPane rightScrollPane;
    private javax.swing.JButton testButton;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}
