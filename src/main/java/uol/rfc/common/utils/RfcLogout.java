package uol.rfc.common.utils;

import uol.rfc.common.SeleniumCommand;

public class RfcLogout {

    
    public static void logout(SeleniumCommand command) {
        command.executeJs("javascript:top.detail.tpzShowThread('0');void(0);");
        command.executeJs("javascript:top.detail.tpzExecute('3',null,'detail');void(0);");
        command.executeJs("javascript:top.detail.tpzExecute('3',null,'detail');void(0);");
    }
}
