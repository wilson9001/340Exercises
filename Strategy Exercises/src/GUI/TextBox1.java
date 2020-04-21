package GUI;

public class TextBox1 implements TextBoxInterface
{
    private String text;
    private boolean validText;

    public TextBox1(String text)
    {
        updateText(text);
    }

    public TextBox1()
    {
        text = null;
        validText = false;
    }

    public void updateText(String text)
    {
        this.text = text;
        validText = true;
    }

    public boolean validText()
    {
        return validText;
    }
}
