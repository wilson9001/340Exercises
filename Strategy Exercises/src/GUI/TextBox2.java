package GUI;

public class TextBox2 implements TextBoxInterface
{
    private String text;
    private boolean validText;

    public TextBox2(String text)
    {
        updateText(text);
    }

    public TextBox2()
    {
        text = null;
        validText = false;
    }

    @Override
    public void updateText(String text)
    {
        this.text = text;
        validText = text == null;
    }

    @Override
    public boolean validText()
    {
        return validText;
    }
}
