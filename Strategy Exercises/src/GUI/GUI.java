package GUI;

public class GUI
{
    private TextBoxInterface textBox;

    public GUI(TextBoxInterface textBox)
    {
        this.textBox = textBox;
    }

    public void updateText(String text)
    {
        textBox.updateText(text);

        if (textBox.validText())
            //display text with valid styling
            return;
        else
            //display text with invalid styling
            return;
    }
}
