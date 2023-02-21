package thiagoanjos.appminhaideia.controller;

import android.nfc.Tag;
import android.util.Log;

import thiagoanjos.appminhaideia.core.AppUtil;

public class ClienteController {
    String appVersion;
    public ClienteController(){
        appVersion = AppUtil.appVersion();
        Log.i(AppUtil.TAG, "Versão do aplicativo " + appVersion);
    }
}
