package filekoller;

import static java.lang.System.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class ExplorerGui extends javax.swing.JFrame
{
    public ExplorerGui()
    {
        initComponents();
        explorerModel = new Explorer(this);
        register();
    }

    private void register()
    {
        expandDeepButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent ae )
                    {
                        expandDeep( "C:\\Projects\\Java\\FileKoller" );
                    }
                }
        );

        goButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent ae )
                    {
                        // if directory:
                        expand( "C:\\Projects\\Java\\FileKoller" );

                        // if file:
                        //explorerModel.openPath( pathComboBox.getSelectedItem().toString() );
                    }
                }
        );
    }

    private void expand( String path ) // tell GUI to retrieve new data for a certain (sub) path and expand itself in 1 level
    {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode( path );

        ArrayList<FileEntry> entries = explorerModel.buildTree( path );

        for (FileEntry entry : entries)
        {
            DefaultMutableTreeNode subNode = new DefaultMutableTreeNode( entry.getFile().getName() );
            node.add( subNode );
        }

        filesystemTree = new JTree();
        filesystemTree.setModel(new DefaultTreeModel(node));
        filesystemTree.setExpandsSelectedPaths(false);
        leftScrollPane.setViewportView(filesystemTree);
    }

    private void expandDeep( String path ) // tell GUI to retrieve new data for a certain (sub) path and expand itself recursively
    {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode( path );
        expandDeep( path, node );

        filesystemTree = new JTree();
        filesystemTree.setModel(new DefaultTreeModel(node));
        filesystemTree.setExpandsSelectedPaths(false);
        leftScrollPane.setViewportView(filesystemTree);
    }

    private void expandDeep( String path, DefaultMutableTreeNode node )
    {
        ArrayList<FileEntry> entries = explorerModel.buildTree( path );

        for (FileEntry entry : entries)
        {
            DefaultMutableTreeNode subNode = new DefaultMutableTreeNode( entry.getFile().getName() );
            node.add( subNode );
            expandDeep( entry.getFile().getPath(), subNode );
        }
    }

    public void updateFake() // tell GUI to retrieve new data and expandDeep itself
    {
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("C:");
        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("Windows");
        DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("Drivers");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        filesystemTree = new JTree();
        filesystemTree.setModel(new DefaultTreeModel(treeNode1));
        filesystemTree.setExpandsSelectedPaths(false);
        leftScrollPane.setViewportView(filesystemTree);
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
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                System.out.println( " * " + info.getName() );

                if ("Windows Classic".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExplorerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExplorerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExplorerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExplorerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ExplorerGui().setVisible(true);
                    }
                }
        );
    }

    private Explorer explorerModel;
    private javax.swing.JTree filesystemTree;

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
        expandDeepButton = new javax.swing.JButton();
        mainSplitPane = new javax.swing.JSplitPane();
        leftScrollPane = new javax.swing.JScrollPane();
        demoFilesystemTree = new javax.swing.JTree();
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

            expandDeepButton.setText("Exp");
            expandDeepButton.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    expandDeepButtonActionPerformed(evt);
                }
            });

            mainSplitPane.setDividerLocation(200);
            mainSplitPane.setDividerSize(4);
            mainSplitPane.setContinuousLayout(true);
            mainSplitPane.setLastDividerLocation(165);
            mainSplitPane.setName(""); // NOI18N

            javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("My Computer");
            javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("C:");
            treeNode1.add(treeNode2);
            demoFilesystemTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            demoFilesystemTree.setToolTipText("");
            demoFilesystemTree.setExpandsSelectedPaths(false);
            leftScrollPane.setViewportView(demoFilesystemTree);

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
                    .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(expandDeepButton)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(mainSplitPane)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goButton)
                        .addComponent(expandDeepButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void expandDeepButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_expandDeepButtonActionPerformed
    {//GEN-HEADEREND:event_expandDeepButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expandDeepButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree demoFilesystemTree;
    private javax.swing.JMenu editMenu;
    private javax.swing.JButton expandDeepButton;
    private javax.swing.JList<String> fileList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton goButton;
    private javax.swing.JScrollPane leftScrollPane;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox<String> pathComboBox;
    private javax.swing.JScrollPane rightScrollPane;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}
