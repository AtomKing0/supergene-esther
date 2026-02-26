package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f7743a = new AtomicReference();

    public static String a() {
        return "iabtechlab-Applovin";
    }

    public static URL b() {
        try {
            return new URL("https://compliance.iabtechnologylab.com/compliance-js/omid-validation-verification-script-v1-APPLOVIN-01102024.js");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        return "iabtechlab.com-omid";
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        String str = (String) f7743a.get();
        if (StringUtils.isValidString(str)) {
            return str;
        }
        URL urlB = b();
        if (urlB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStreamA = jVar.C().a(urlB.toString(), (List) null, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } finally {
                    }
                }
                bufferedReader.close();
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            jVar.I().a("OpenMeasurementTestParameters", th);
            jVar.A().a("OpenMeasurementTestParameters", "getTestValidationJavaScriptContent", th);
        }
        String string = sb.toString();
        f7743a.set(string);
        return string;
    }
}
