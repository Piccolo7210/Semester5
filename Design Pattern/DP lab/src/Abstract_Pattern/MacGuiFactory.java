package Abstract_Pattern;

public class MacGuiFactory implements GuiInterface{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public checkBox createCheckBox() {
        return new MacCheckBox();
    }
}
