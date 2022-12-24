package org.example.telegram.keyboard.button;

public enum ButtonId {
    MENU("MENU"),
    BACK_ACE("BACK_ACE"),
    HUNT("HUNT"),
    MORE_INFO("MORE_INFO"),
    BZ("BZ"),
    SPEED("SPEED"),
    DENSITY("DENSITY"),
    KP("KP");
    private String idButton;
    ButtonId(String idButton){
        this.idButton = idButton;
    }

    public String value(){
        return this.idButton;
    }

}
