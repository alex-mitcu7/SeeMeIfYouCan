import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;

public class SeeMeIfYouCan {

	private JFrame mainFrame;
  private FileDialog fileDialog;
	private Label lblInsertPhoto;
	private Label lblMessage;
	private JLabel lblSavedImage;
	private JLabel orgImage;
	private JLabel reviewImage;

	private JButton btnSelectPhoto;
	private JButton btnEncrypt;
	private JButton btnDecrypt;

	private JTextField tfPhoto;
	private TextArea taMessage;

	private JPanel controlPanel;
	private JPanel imagePanel;
	private JPanel reviewPanel;

	//Constructor
	public SeeMeIfYouCan()
	{
		//Main Frame
		mainFrame = new JFrame("See Me If You Can");
		//mainFrame.setSize(1920, 1080);
		mainFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		mainFrame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent windowEvent)
				{
					System.exit(0);
				}//windowClosing
			}//WindowAdapter
		);

		//Photo Label
		lblInsertPhoto = new Label("Select Image");
		lblInsertPhoto.setFont(new Font("Serif", Font.PLAIN, 30));
		lblInsertPhoto.setAlignment(Label.CENTER);
		//c.weightx = 0.2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainFrame.add(lblInsertPhoto, c);

		//Original photo panel
		imagePanel = new JPanel();
		imagePanel.setLayout(new GridLayout(1, 1));

		//ImageContainer
		ImageIcon defaultImage = new ImageIcon("default-image.jpg");
		Image tempDefaultImg = defaultImage.getImage();
        Image newDefImg = tempDefaultImg.getScaledInstance(512, 512, java.awt.Image.SCALE_SMOOTH);
        defaultImage = new ImageIcon(newDefImg);
		orgImage = new JLabel(defaultImage);
		//imagePanel.add(originalPhoto);
		imagePanel.add(orgImage);



		//c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 50;
		c.ipadx = 50;
		c.gridx = 1;
		c.gridy = 0;
		mainFrame.add(imagePanel, c);
		//Photo Browser
		btnSelectPhoto = new JButton("Browse");
		btnSelectPhoto.setFont(new Font("Serif", Font.PLAIN, 20));
		btnSelectPhoto.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					choosePhotoDialog();
				}
			}//ActionListener
		);
		c.weightx = 0.2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		mainFrame.add(btnSelectPhoto, c);


		//Review Panel
		// reviewPanel = new JPanel();
		// reviewPanel.setLayout(new GridLayout(1, 1));

		// //ImageContainer
		// reviewImage = new JLabel(defaultImage);
		// reviewPanel.add(reviewImage);

		// c.weightx = 0.5;
		// c.fill = GridBagConstraints.BOTH;
		// c.ipady = 50;
		// c.ipadx = 50;
		// c.gridx = 3;
		// c.gridy = 0;
		// mainFrame.add(reviewPanel);


		//Message label
		lblMessage = new Label("Message inside Image");
		lblMessage.setFont(new Font("Serif", Font.PLAIN, 30));
		lblMessage.setAlignment(Label.CENTER);
		c.weightx = 0.2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		mainFrame.add(lblMessage, c);

		//TextArea
		taMessage = new TextArea("Message");
		taMessage.setEditable(true);
		taMessage.setFont(new Font("Serif", Font.PLAIN, 20));
		c.weightx = 0.5;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		mainFrame.add(taMessage, c);

		//Panel for buttons
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 1));

		//Button for Encryption
		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setFont(new Font("Serif", Font.PLAIN, 20));
		btnEncrypt.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					encryptMessage();
				}
			}//ActionListener
		);
		controlPanel.add(btnEncrypt);
		//Button for Decryption
		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setFont(new Font("Serif", Font.PLAIN, 20));
		btnDecrypt.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					decryptMessage();
				}
			}//ActionListener
		);
		controlPanel.add(btnDecrypt);

		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		mainFrame.add(controlPanel, c);


		//The saved image label
		// lblSavedImage = new JLabel("<html>The image with the encrypted message was saved in the app's folder.</html>", SwingConstants.CENTER);
		// lblSavedImage.setVisible(false);
		//lblSavedImage.setAlignment(Label.CENTER);
		//lblSavedImage.setFont(new Font("Serif", Font.PLAIN, 20));
		//c.weightx = 0.5;
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 50;
		//c.ipadx = 50;
		//c.gridx = 3;
		//c.gridy = 1;
		//mainFrame.add(lblSavedImage, c);
		mainFrame.pack();
		mainFrame.setVisible(true);


	}//SeeMeIfYouCan

	public static void main(String[] args)
	{
		SeeMeIfYouCan app = new SeeMeIfYouCan();
	}//main

	private void choosePhotoDialog()
	{
		fileDialog = new FileDialog(mainFrame,"Select file");
        fileDialog.setVisible(true);
        imagePanel.remove(orgImage);
        ImageIcon tempImage = new ImageIcon("" + fileDialog.getDirectory() + fileDialog.getFile());
        Image tempImg = tempImage.getImage();
        Image newImg = tempImg.getScaledInstance(512, 512, java.awt.Image.SCALE_SMOOTH);
        tempImage = new ImageIcon(newImg);
        orgImage = new JLabel(tempImage);
        imagePanel.add(orgImage);
        System.out.println("" + fileDialog.getDirectory());
        System.out.println("" + fileDialog.getFile());
        imagePanel.revalidate();
        mainFrame.setVisible(true);
	}//choosePhotoDialog


	private void encryptMessage()
	{
		//String pathToOriginalImage = "" + fileDialog.getDirectory() + fileDialog.getFile();
		String pathToOriginalImage = "" + fileDialog.getFile();
		String message = taMessage.getText();
    try {
		    EncryptImage.fire(pathToOriginalImage, message);
    }
    catch (IOException e) {
      return;
    }
		// reviewPanel.remove(reviewImage);
		// ImageIcon tempImage2 = new ImageIcon("reconstructedImage.png");
  //       Image tempImg2 = tempImage2.getImage();
  //       Image newImg2 = tempImg2.getScaledInstance(512, 512, java.awt.Image.SCALE_SMOOTH);
  //       tempImage2 = new ImageIcon(newImg2);
        //JLabel label = new JLabel(tempImage2);
        // reviewImage = new JLabel(tempImage2);
        // reviewPanel.add(reviewImage);
        // reviewPanel.revalidate();
		//lblSavedImage.setVisible(true);
		taMessage.setText("The image with the encrypted message was saved in the app's folder.");
		mainFrame.setVisible(true);
	}

	private void decryptMessage()
	{
    try {
		    //String pathToImage = "" + fileDialog.getDirectory() + fileDialog.getFile();
        String pathToImage = "" + fileDialog.getFile();
        String decryptedMsg = "Nemodificat";
		    decryptedMsg = DecryptImage.fire(pathToImage);
        //System.out.println(decryptedMsg);
		    taMessage.setText(decryptedMsg);
    }
    catch(IOException e) {
      return;
    }
	}
}
