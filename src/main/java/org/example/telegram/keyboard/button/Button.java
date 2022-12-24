package org.example.telegram.keyboard.button;

public class Button {
    private String text;
    private ButtonId idButton;

    private String buttonId;

    public Button(String text, ButtonId idButton) {
        this.text = text;
        this.idButton = idButton;
    }

    public Button(String text, String buttonId) {
        this.text = text;
        this.buttonId = String.valueOf(buttonId);
    }

    public String getText() {
        return text;
    }

    public ButtonId getIdButton() {
        return idButton;
    }

    public String getButtonId() {
        return buttonId;
    }
}
