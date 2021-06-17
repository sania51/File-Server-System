package com.io;

import static com.io.Helper.clientStorageDir;
import java.awt.event.MouseEvent;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    String operation = "";
    int selectedFileIndex;
    Socket socket;
    DefaultListModel fileListModel;
    static ArrayList<String> sendFileList = new ArrayList<>();
    int fileSelectedIndex;
    int fileDeleteIndex;
    String storageFolder = clientStorageDir();
    File[] downloadFileDirectory = new File[1];

    public Main() {
        initComponents();
        String currentDirectory = Path.of("").toAbsolutePath().toString();
        System.out.println(currentDirectory);
        jLabel2.setIcon(new ImageIcon(currentDirectory + "\\src\\main\\java\\Assets\\cloud.png"));
        uploadFile.setIcon(new ImageIcon(currentDirectory + "\\src\\main\\java\\Assets\\upload.png"));
        fileListModel = new DefaultListModel();
        connectionStatus.setText("");
    }

    void uploadedFiles() {
        fileListModel.clear();
        for (int i = 0; i < sendFileList.size(); i++) {
            fileListModel.addElement(sendFileList.get(i));
        }
    }

    void showContextMenu(MouseEvent evt) {
        contextMenu.show(fileList, evt.getX(), evt.getY());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contextMenu = new javax.swing.JPopupMenu();
        Download = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        connectionStatus = new javax.swing.JLabel();
        connectServer = new javax.swing.JButton();
        disconnect = new javax.swing.JButton();
        portNum = new javax.swing.JTextField();
        ipAddress = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        uploadFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();

        contextMenu.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        contextMenu.setForeground(new java.awt.Color(51, 51, 51));

        Download.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Download.setForeground(new java.awt.Color(51, 51, 51));
        Download.setText("Download");
        Download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadActionPerformed(evt);
            }
        });
        contextMenu.add(Download);

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        contextMenu.add(Delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 242, 242)));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 156, 162));
        jLabel2.setText("Client");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 119, 112));
        jLabel4.setText("Server IP");

        jTextField2.setBackground(new java.awt.Color(241, 241, 241));
        jTextField2.setForeground(new java.awt.Color(127, 119, 112));
        jTextField2.setBorder(null);

        jTextField1.setBackground(new java.awt.Color(241, 241, 241));
        jTextField1.setForeground(new java.awt.Color(127, 119, 112));
        jTextField1.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 119, 112));
        jLabel3.setText("Port Number");

        connectionStatus.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        connectionStatus.setForeground(new java.awt.Color(0, 174, 0));
        connectionStatus.setText("Server Connected");

        connectServer.setBackground(new java.awt.Color(0, 156, 162));
        connectServer.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        connectServer.setForeground(new java.awt.Color(255, 255, 255));
        connectServer.setText("Connect Server");
        connectServer.setBorder(null);
        connectServer.setBorderPainted(false);
        connectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectServerActionPerformed(evt);
            }
        });

        disconnect.setBackground(new java.awt.Color(255, 255, 255));
        disconnect.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        disconnect.setForeground(new java.awt.Color(255, 0, 51));
        disconnect.setText("Disconnect");
        disconnect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        portNum.setBackground(new java.awt.Color(241, 241, 241));
        portNum.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        portNum.setForeground(new java.awt.Color(127, 119, 112));
        portNum.setBorder(null);

        ipAddress.setBackground(new java.awt.Color(241, 241, 241));
        ipAddress.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        ipAddress.setForeground(new java.awt.Color(127, 119, 112));
        ipAddress.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connectServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(portNum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(connectionStatus))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(102, 102, 102)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(portNum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(connectionStatus)
                .addGap(42, 42, 42)
                .addComponent(connectServer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jLabel8.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 119, 112));
        jLabel8.setText("Files");

        jSeparator2.setBackground(new java.awt.Color(127, 119, 112));
        jSeparator2.setOpaque(true);

        uploadFile.setBackground(new java.awt.Color(255, 255, 255));
        uploadFile.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        uploadFile.setForeground(new java.awt.Color(0, 156, 162));
        uploadFile.setText("Upload");
        uploadFile.setBorder(null);
        uploadFile.setBorderPainted(false);
        uploadFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadFile.setOpaque(false);
        uploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileActionPerformed(evt);
            }
        });

        fileList.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        fileList.setForeground(new java.awt.Color(51, 51, 51));
        fileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fileList.setSelectionBackground(new java.awt.Color(203, 223, 238));
        fileList.setSelectionForeground(new java.awt.Color(102, 102, 102));
        fileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileListMouseClicked(evt);
            }
        });
        fileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                fileListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(fileList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(uploadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Upload File");
        fileChooser.setMultiSelectionEnabled(true);
        int returnVal = fileChooser.showDialog(null, "Upload");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] uploadFiles = fileChooser.getSelectedFiles();
            if (uploadFiles.length <= 0) {
                JOptionPane.showMessageDialog(fileChooser, "Select file first", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    operation = "upload";
                    //send file
                    FileInputStream readFile = new FileInputStream(uploadFiles[0].getAbsolutePath());
                    DataOutputStream writeFile = new DataOutputStream(socket.getOutputStream());
                    ObjectOutputStream sendOperation = new ObjectOutputStream(socket.getOutputStream());

                    sendOperation.writeObject(operation);

                    byte[] byteFileName = uploadFiles[0].getName().getBytes();
                    writeFile.writeInt(byteFileName.length);
                    writeFile.write(byteFileName);

                    byte[] byteFileContent = new byte[(int) uploadFiles[0].length()];
                    readFile.read(byteFileContent);
                    writeFile.writeInt(byteFileContent.length);
                    writeFile.write(byteFileContent);

                    System.out.println("file sent");

                    // get file lists
                    ObjectInputStream receivedFileList = new ObjectInputStream(socket.getInputStream());
                    Object fileListObject = receivedFileList.readObject();
                    sendFileList = (ArrayList<String>) fileListObject;

                    System.out.println(fileList);

                    // reload screen
                    uploadedFiles();
                    fileList.revalidate();
                    fileList.repaint();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }//GEN-LAST:event_uploadFileActionPerformed

    private void fileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileListMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            selectedFileIndex = fileList.getSelectedIndex();

            if (selectedFileIndex >= 0) {
                showContextMenu(evt);
                fileSelectedIndex = fileList.locationToIndex(evt.getPoint());
                fileDeleteIndex = fileList.locationToIndex(evt.getPoint());
            } else {
                fileList.clearSelection();
            }

            System.out.println(selectedFileIndex);
        }
    }//GEN-LAST:event_fileListMouseClicked

    private void fileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fileListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fileListValueChanged

    private void DownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadActionPerformed

        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setDialogTitle("Choose Destination");

        int returnVal = folderChooser.showDialog(null, "Select");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            downloadFileDirectory[0] = folderChooser.getSelectedFile();
            try {
                operation = "download";
                
                // get action type

                ObjectOutputStream sendOperation = new ObjectOutputStream(socket.getOutputStream());

                sendOperation.writeObject(operation);

                //send file name
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String fileName = sendFileList.get(selectedFileIndex);
                byte[] byteFileName = fileName.getBytes();
                dataOutputStream.writeInt(byteFileName.length);
                dataOutputStream.write(byteFileName);

                DataInputStream din = new DataInputStream(socket.getInputStream());
      
                int fileNameLength = din.readInt();
    
                if (fileNameLength > 0) {
      
                    byte[] fileNameBytesx = new byte[fileNameLength];
                  
                    din.readFully(fileNameBytesx, 0, fileNameBytesx.length);

                    String fileNamex = new String(fileNameBytesx);
                    int fileContentLength = din.readInt();
                    if (fileContentLength > 0) {
                        byte[] fileContentBytes = new byte[fileContentLength];
   
                        din.readFully(fileContentBytes, 0, fileContentBytes.length);
                        System.out.println("File Downloaded");

                        //save file in storage
                        File file = new File(downloadFileDirectory[0].getAbsolutePath() + '/' + fileNamex);
                        Path path = Paths.get(file.getAbsolutePath());
                        try {
                            Files.write(path, fileContentBytes);
                            System.out.println("File saved");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(Main.this, ex, "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_DownloadActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        operation = "delete";

        ObjectOutputStream sendOperation;
        try {
            //sent action type
            sendOperation = new ObjectOutputStream(socket.getOutputStream());
            sendOperation.writeObject(operation);

            // send file name
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String fileName = sendFileList.get(selectedFileIndex);
            byte[] byteFileName = fileName.getBytes();
            dataOutputStream.writeInt(byteFileName.length);
            dataOutputStream.write(byteFileName);

            System.out.println("File nme send to server");

            /// get latest file name lists
            ObjectInputStream receivedFileList = new ObjectInputStream(socket.getInputStream());
            Object fileListObject = receivedFileList.readObject();
            sendFileList = (ArrayList<String>) fileListObject;
            System.out.println(fileList);

//              reload files 
            uploadedFiles();

            fileList.revalidate();
            fileList.repaint();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_DeleteActionPerformed

    private void connectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectServerActionPerformed
        String ip = ipAddress.getText();
        if (ip == null || ip == "") {
            JOptionPane.showMessageDialog(rootPane, "IP should not be empty");
        }
        int port = Integer.parseInt(portNum.getText());
        if (portNum.getText() == null || portNum.getText() == "") {
            JOptionPane.showMessageDialog(rootPane, "Port should not be empty");
        }
        try {
            socket = new Socket(ip, port);
            //            socket = new Socket("127.0.1.1", 5000);
            connectionStatus.setText("Server Connected");

            ObjectInputStream receivedFileList = new ObjectInputStream(socket.getInputStream());
            Object fileListObject = receivedFileList.readObject();
            sendFileList = (ArrayList<String>) fileListObject;
            uploadedFiles();
            fileList.setModel(fileListModel);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Wrong Port Number/IP Address");
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectServerActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Download;
    private javax.swing.JButton connectServer;
    private javax.swing.JLabel connectionStatus;
    private javax.swing.JPopupMenu contextMenu;
    private javax.swing.JButton disconnect;
    private javax.swing.JList<String> fileList;
    private javax.swing.JTextField ipAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField portNum;
    private javax.swing.JButton uploadFile;
    // End of variables declaration//GEN-END:variables
}
