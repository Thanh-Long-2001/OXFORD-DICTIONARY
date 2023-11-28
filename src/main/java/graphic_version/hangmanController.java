package graphic_version;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class hangmanController extends hangmanData implements Initializable {
    @FXML
    private ImageView iv;
    Image img1 = new Image("file:src/main/resources/src/images/img1.png");
    Image img2 = new Image("file:src/main/resources/src/images/img2.png");
    Image img3 = new Image("file:src/main/resources/src/images/img3.png");
    Image img4 = new Image("file:src/main/resources/src/images/img4.png");
    Image img5 = new Image("file:src/main/resources/src/images/img5.png");
    Image img6 = new Image("file:src/main/resources/src/images/img6.png");
    Image img7 = new Image("file:src/main/resources/src/images/img7.png");
    @FXML
    private Label w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11;
    @FXML
    private Label centre;
    @FXML
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10,
            b11, b12, b13, b14, b15, b16, b17, b18, b19,
            b20, b21, b22, b23, b24, b25, b26;
    @FXML
    private Button sb;
    String word;
    int sizee;
    int life = 6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            super.readData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setDis();
    }

    public int randomW() {
        Random r = new Random();
        return r.nextInt(words.size());
    }

    public void setup() {
        setVi();
        correct_ans = 0;
        life = 6;
    }

    public void start() {
        int r = randomW();
        word = words.get(r);
        sizee = word.length();
        iv.setImage(img1);
        sb.setVisible(false);
        setNotDis();
        centre.setText("Guess Word");
        switch (sizee) {
            case 4:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(false);
                w6.setVisible(false);
                w7.setVisible(false);
                w8.setVisible(false);
                w9.setVisible(false);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 5:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(false);
                w7.setVisible(false);
                w8.setVisible(false);
                w9.setVisible(false);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 6:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(false);
                w8.setVisible(false);
                w9.setVisible(false);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 7:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(true);
                w8.setVisible(false);
                w9.setVisible(false);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 8:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(true);
                w8.setVisible(true);
                w9.setVisible(false);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 9:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(true);
                w8.setVisible(true);
                w9.setVisible(true);
                w10.setVisible(false);
                w11.setVisible(false);
                setT();
                break;
            case 10:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(true);
                w8.setVisible(true);
                w9.setVisible(true);
                w10.setVisible(true);
                w11.setVisible(false);
                setT();
                break;
            case 11:
                w1.setVisible(true);
                w2.setVisible(true);
                w3.setVisible(true);
                w4.setVisible(true);
                w5.setVisible(true);
                w6.setVisible(true);
                w7.setVisible(true);
                w8.setVisible(true);
                w9.setVisible(true);
                w10.setVisible(true);
                w11.setVisible(true);
                setT();
                break;
            default:
                break;
        }
    }

    int correct_ans = 0;

    public void checkAnswer(String str) {
        if (word.contains(str)) {
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    showAnswer(index, Character.toString(c));
                    correct_ans++;
                }
                index++;
            }
        } else showImage();

        if (correct_ans == word.length()) {
            centre.setText("YOU WON!!");
            setDis();
            setup();
            sb.setVisible(true);
            sb.setText("TRY AGAIN");
        }
    }

    public void showAnswer(int index, String str) {
        switch (index) {
            case 0:
                w1.setText(str);
                break;
            case 1:
                w2.setText(str);
                break;
            case 2:
                w3.setText(str);
                break;
            case 3:
                w4.setText(str);
                break;
            case 4:
                w5.setText(str);
                break;
            case 5:
                w6.setText(str);
                break;
            case 6:
                w7.setText(str);
                break;
            case 7:
                w8.setText(str);
                break;
            case 8:
                w9.setText(str);
                break;
            case 9:
                w10.setText(str);
                break;
            case 10:
                w11.setText(str);
                break;
        }
    }

    public void showImage() {
        life--;
        switch (life) {
            case 5:
                iv.setImage(img2);
                break;
            case 4:
                iv.setImage(img3);
                break;
            case 3:
                iv.setImage(img4);
                break;
            case 2:
                iv.setImage(img5);
                break;
            case 1:
                iv.setImage(img6);
                break;
            case 0:
                iv.setImage(img7);
                centre.setText("GAME OVER!!");
                setDis();
                setup();
                int index = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    showAnswer(index, Character.toString(c));
                    index++;
                }
                sb.setVisible(true);
                sb.setText("TRY AGAIN");
                break;
        }
    }

    public void clicked1(ActionEvent e) {
        b1.setVisible(false);
        checkAnswer("a");
    }

    public void clicked2(ActionEvent e) {
        b2.setVisible(false);
        checkAnswer("b");
    }

    public void clicked3(ActionEvent e) {
        b3.setVisible(false);
        checkAnswer("c");
    }

    public void clicked4(ActionEvent e) {
        b4.setVisible(false);
        checkAnswer("d");
    }

    public void clicked5(ActionEvent e) {
        b5.setVisible(false);
        checkAnswer("e");
    }

    public void clicked6(ActionEvent e) {
        b6.setVisible(false);
        checkAnswer("f");
    }

    public void clicked7(ActionEvent e) {
        b7.setVisible(false);
        checkAnswer("g");
    }

    public void clicked8(ActionEvent e) {
        b8.setVisible(false);
        checkAnswer("h");
    }

    public void clicked9(ActionEvent e) {
        b9.setVisible(false);
        checkAnswer("i");
    }

    public void clicked10(ActionEvent e) {
        b10.setVisible(false);
        checkAnswer("j");
    }

    public void clicked11(ActionEvent e) {
        b11.setVisible(false);
        checkAnswer("k");
    }

    public void clicked12(ActionEvent e) {
        b12.setVisible(false);
        checkAnswer("l");
    }

    public void clicked13(ActionEvent e) {
        b13.setVisible(false);
        checkAnswer("m");
    }

    public void clicked14(ActionEvent e) {
        b14.setVisible(false);
        checkAnswer("n");
    }

    public void clicked15(ActionEvent e) {
        b15.setVisible(false);
        checkAnswer("o");
    }

    public void clicked16(ActionEvent e) {
        b16.setVisible(false);
        checkAnswer("p");
    }

    public void clicked17(ActionEvent e) {
        b17.setVisible(false);
        checkAnswer("q");
    }

    public void clicked18(ActionEvent e) {
        b18.setVisible(false);
        checkAnswer("r");
    }

    public void clicked19(ActionEvent e) {
        b19.setVisible(false);
        checkAnswer("s");
    }

    public void clicked20(ActionEvent e) {
        b20.setVisible(false);
        checkAnswer("t");
    }

    public void clicked21(ActionEvent e) {
        b21.setVisible(false);
        checkAnswer("y");
    }

    public void clicked22(ActionEvent e) {
        b22.setVisible(false);
        checkAnswer("x");
    }

    public void clicked23(ActionEvent e) {
        b23.setVisible(false);
        checkAnswer("u");
    }

    public void clicked24(ActionEvent e) {
        b24.setVisible(false);
        checkAnswer("v");
    }

    public void clicked25(ActionEvent e) {
        b25.setVisible(false);
        checkAnswer("w");
    }

    public void clicked26(ActionEvent e) {
        b26.setVisible(false);
        checkAnswer("z");
    }

    public void setDis() {
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);
        b6.setDisable(true);
        b7.setDisable(true);
        b8.setDisable(true);
        b9.setDisable(true);
        b10.setDisable(true);
        b11.setDisable(true);
        b12.setDisable(true);
        b13.setDisable(true);
        b14.setDisable(true);
        b15.setDisable(true);
        b16.setDisable(true);
        b17.setDisable(true);
        b18.setDisable(true);
        b19.setDisable(true);
        b20.setDisable(true);
        b21.setDisable(true);
        b22.setDisable(true);
        b23.setDisable(true);
        b24.setDisable(true);
        b25.setDisable(true);
        b26.setDisable(true);
    }

    public void setNotDis() {
        b1.setDisable(false);
        b2.setDisable(false);
        b3.setDisable(false);
        b4.setDisable(false);
        b5.setDisable(false);
        b6.setDisable(false);
        b7.setDisable(false);
        b8.setDisable(false);
        b9.setDisable(false);
        b10.setDisable(false);
        b11.setDisable(false);
        b12.setDisable(false);
        b13.setDisable(false);
        b14.setDisable(false);
        b15.setDisable(false);
        b16.setDisable(false);
        b17.setDisable(false);
        b18.setDisable(false);
        b19.setDisable(false);
        b20.setDisable(false);
        b21.setDisable(false);
        b22.setDisable(false);
        b23.setDisable(false);
        b24.setDisable(false);
        b25.setDisable(false);
        b26.setDisable(false);
    }

    public void setVi() {
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        b6.setVisible(true);
        b7.setVisible(true);
        b8.setVisible(true);
        b9.setVisible(true);
        b10.setVisible(true);
        b11.setVisible(true);
        b12.setVisible(true);
        b13.setVisible(true);
        b14.setVisible(true);
        b15.setVisible(true);
        b16.setVisible(true);
        b17.setVisible(true);
        b18.setVisible(true);
        b19.setVisible(true);
        b20.setVisible(true);
        b21.setVisible(true);
        b22.setVisible(true);
        b23.setVisible(true);
        b24.setVisible(true);
        b25.setVisible(true);
        b26.setVisible(true);
    }

    public void setT() {
        w11.setText("_");
        w10.setText("_");
        w9.setText("_");
        w8.setText("_");
        w7.setText("_");
        w6.setText("_");
        w5.setText("_");
        w4.setText("_");
        w3.setText("_");
        w2.setText("_");
        w1.setText("_");
    }
}
