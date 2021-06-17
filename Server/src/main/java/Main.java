
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Main extends javax.swing.JFrame {

    ServerSocket serverSocket;
    Socket socket;
    File[] files;
    static ArrayList<String> sendFileList = new ArrayList<>();
    String operation = "";

    DefaultListModel fileListModel = new DefaultListModel();
    String storageFolder = Helper.serverStorageDir();

    public Main() {
        initComponents();
        String currentDirectory = Path.of("").toAbsolutePath().toString();
        System.out.println(currentDirectory);
        jLabel2.setIcon(new ImageIcon(currentDirectory + "\\src\\main\\java\\Assets\\cloud.png"));
        String ip;
        loadStorageFiles();
        fileList.setModel(fileListModel);
        serverStatus.setText("");
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            ipAddress.setText(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    void loadStorageFiles() {
        sendFileList.clear();
        fileListModel.clear();
        File folder = new File(storageFolder);
//        ffiles
        files = folder.listFiles();
        System.out.println(storageFolder);
        System.out.println(files);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                sendFileList.add(files[i].getName());
                fileListModel.addElement(files[i].getName());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ipAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        portNum = new javax.swing.JTextField();
        createServer = new javax.swing.JButton();
        serverStatus = new javax.swing.JLabel();
        terminateServer = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(248, 245, 245));
        jPanel1.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 242, 242)));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 156, 162));
        jLabel2.setText("Server");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 119, 112));
        jLabel3.setText("Port Number");

        ipAddress.setEditable(false);
        ipAddress.setBackground(new java.awt.Color(241, 241, 241));
        ipAddress.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        ipAddress.setForeground(new java.awt.Color(127, 119, 112));
        ipAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 242, 242)));
        ipAddress.setDisabledTextColor(new java.awt.Color(121, 121, 121));
        ipAddress.setEnabled(false);
        ipAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipAddressActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 119, 112));
        jLabel4.setText("IP Address");

        portNum.setBackground(new java.awt.Color(241, 241, 241));
        portNum.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        portNum.setForeground(new java.awt.Color(127, 119, 112));
        portNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 242, 242)));
        portNum.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        createServer.setBackground(new java.awt.Color(0, 156, 162));
        createServer.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        createServer.setForeground(new java.awt.Color(255, 255, 255));
        createServer.setText("Create Server");
        createServer.setBorder(null);
        createServer.setBorderPainted(false);
        createServer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createServer.setFocusPainted(false);
        createServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createServerActionPerformed(evt);
            }
        });

        serverStatus.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        serverStatus.setForeground(new java.awt.Color(0, 174, 0));
        serverStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serverStatus.setText("Server Created");

        terminateServer.setBackground(new java.awt.Color(255, 255, 255));
        terminateServer.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        terminateServer.setForeground(new java.awt.Color(255, 0, 51));
        terminateServer.setText("Terminate Server");
        terminateServer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
        terminateServer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        terminateServer.setFocusPainted(false);
        terminateServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminateServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terminateServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(serverStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipAddress)
                                    .addComponent(portNum))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(portNum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(serverStatus)
                .addGap(42, 42, 42)
                .addComponent(createServer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terminateServer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jTextField3.setBackground(new java.awt.Color(248, 245, 245));
        jTextField3.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(127, 119, 112));
        jTextField3.setText("Storage");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(127, 119, 112));
        jSeparator1.setOpaque(true);

        fileList.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        fileList.setForeground(new java.awt.Color(51, 51, 51));
        fileList.setSelectionBackground(new java.awt.Color(203, 223, 238));
        fileList.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(fileList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void createServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createServerActionPerformed

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int port;
                    port = Integer.parseInt(portNum.getText());
                    serverSocket = new ServerSocket(port);
                    serverStatus.setText("Server Created");
                    createServer.setEnabled(false);
                    System.out.println("server created");
                    socket = serverSocket.accept();

                    ObjectOutputStream sendFile = new ObjectOutputStream(socket.getOutputStream());
                    sendFile.writeObject(sendFileList);

                    while (true) {
                        try {
                            System.out.println("client connected");
                            //get action type
                            ObjectInputStream receivedOperation = new ObjectInputStream(socket.getInputStream());
                            operation = (String) receivedOperation.readObject();

                            if (operation.equalsIgnoreCase("upload")) {
                                // get file
                                DataInputStream readFile = new DataInputStream(socket.getInputStream());

                                int fileNameLength = readFile.readInt();
                                System.out.println("filename length is " + fileNameLength);
                                if (fileNameLength > 0) {
                                    System.out.println("file name length from intside" + fileNameLength);
                                    byte[] byteFileName = new byte[fileNameLength];
                                    readFile.readFully(byteFileName, 0, byteFileName.length);
                                    String fileName = new String(byteFileName);

                                    int fileContentLength = readFile.readInt();

                                    if (fileContentLength > 0) {
                                        System.out.println("content length" + fileContentLength);
                                        byte[] byteFileContent = new byte[fileContentLength];
                                        readFile.readFully(byteFileContent, 0, byteFileContent.length);

                                        // save file
                                        File saveFile = new File(storageFolder + '/' + fileName);
                                        Path path = Paths.get(saveFile.getAbsolutePath());

                                        Files.write(path, byteFileContent);

                                        // send latest file names
                                        loadStorageFiles();
                                        ObjectOutputStream sendFileObj = new ObjectOutputStream(socket.getOutputStream());
                                        sendFileObj.writeObject(sendFileList);

                                        // reload screen
                                        fileList.revalidate();
                                        fileList.repaint();
                                        // 127.0.1.1
                                    }
                                }

                            } else if (operation.equalsIgnoreCase("download")) {
                                System.out.println(operation);

                                // get file name
                                DataInputStream readFile = new DataInputStream(socket.getInputStream());

                                int fileNameLength = readFile.readInt();
                                System.out.println("filename length is " + fileNameLength);

                                if (fileNameLength > 0) {

                                    byte[] fileNameBytesx = new byte[fileNameLength];

                                    readFile.readFully(fileNameBytesx, 0, fileNameBytesx.length);

                                    String fileNamex = new String(fileNameBytesx);

                                    System.out.println(fileNamex);

                                    // find file
                                    final File[] fileToSend = new File[1];

                                    for (int i = 0; i < files.length; i++) {
                                        if (files[i].getName().equals(fileNamex)) {
                                            fileToSend[0] = files[i];
                                            break;
                                        }
                                    }

                                    // send file to server
                                    FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());

                                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                                    String fileName = fileToSend[0].getName();

                                    byte[] fileNameBytes = fileName.getBytes();

                                    byte[] fileBytes = new byte[(int) fileToSend[0].length()];

                                    fileInputStream.read(fileBytes);

                                    dataOutputStream.writeInt(fileNameBytes.length);

                                    dataOutputStream.write(fileNameBytes);

                                    dataOutputStream.writeInt(fileBytes.length);

                                    dataOutputStream.write(fileBytes);

                                }
                            } else if (operation.equalsIgnoreCase("delete")) {

                                // receive file name
                                System.out.println(operation);
                                DataInputStream readFile = new DataInputStream(socket.getInputStream());

                                int fileNameLength = readFile.readInt();
                                System.out.println("filename length is " + fileNameLength);

                                if (fileNameLength > 0) {

                                    byte[] fileNameBytesx = new byte[fileNameLength];

                                    readFile.readFully(fileNameBytesx, 0, fileNameBytesx.length);

                                    String fileNamex = new String(fileNameBytesx);

                                    System.out.println(fileNamex);

                                    final File[] fileToDelete = new File[1];

                                    // finad the file 
                                    for (int i = 0; i < files.length; i++) {
                                        if (files[i].getName().equals(fileNamex)) {
                                            fileToDelete[0] = files[i];
                                            break;
                                        }
                                    }

                                    // delete file
                                    fileToDelete[0].delete();

                                    System.out.println("");

                                    // send latest filelist name
                                    loadStorageFiles();
                                    ObjectOutputStream sendFileObj = new ObjectOutputStream(socket.getOutputStream());
                                    sendFileObj.writeObject(sendFileList);

                                    // reload screen
                                    fileList.revalidate();
                                    fileList.repaint();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//GEN-LAST:event_createServerActionPerformed

    private void ipAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipAddressActionPerformed

    }//GEN-LAST:event_ipAddressActionPerformed

    private void terminateServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminateServerActionPerformed

        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_terminateServerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createServer;
    private javax.swing.JList<String> fileList;
    private javax.swing.JTextField ipAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField portNum;
    private javax.swing.JLabel serverStatus;
    private javax.swing.JButton terminateServer;
    // End of variables declaration//GEN-END:variables
}
